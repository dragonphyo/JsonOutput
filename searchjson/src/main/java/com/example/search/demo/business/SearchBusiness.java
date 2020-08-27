package com.example.search.demo.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.search.demo.business.model.FilterTargetModel;
import com.example.search.demo.business.model.SearchFilterConditionModel;
import com.example.search.demo.entity.FilterExecution;
import com.example.search.demo.entity.FilterTarget;
import com.example.search.demo.entity.SearchFilter;
import com.example.search.demo.entity.SearchFilterCondition;
import com.example.search.demo.entity.repository.FilterExecutionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SearchBusiness {

	@Autowired
	private FilterExecutionRepository repo;

	@Autowired
	private FilterTargetBusiness filterTargetBusiness;

	@Autowired
	private SearchFilterBusiness searchFilterBusiness;

	private List<SearchFilterConditionModel> searchConditions;

	public String getSearchFilters(String functionId) {
		ObjectMapper mapper = new ObjectMapper();
		String outputResult = null;
		List<FilterTargetModel> result = new ArrayList<>();
		FilterExecution filterExecution = repo.findById(functionId).orElse(null);
		if (null == filterExecution) {
			return "Error ";
		}
		List<FilterTarget> filterTargets = filterTargetBusiness.getFilterTargetById(filterExecution.getFunctionId());
		List<String> targetIds = filterTargets.stream().map(FilterTarget::getTargetID).collect(Collectors.toList());
		List<SearchFilter> searchFilters = searchFilterBusiness.getSearchFilterById(targetIds);
		List<SearchFilterCondition> searchFilterConditions = searchFilters.stream()
				.map(SearchFilter::getSearchFilterConditions).flatMap(Collection::stream).collect(Collectors.toList());
		searchFilterConditions.forEach(x -> System.out.println(x.getSearchConditionId()));
		filterTargets.forEach(filterTarget -> {
			FilterTargetModel filterTargetModel = new FilterTargetModel();
			filterTargetModel.setFilterTargetFieldId(filterTarget.getTargetID());
			filterTargetModel.setTargetName(filterTarget.getTargetName());
			searchFilters.forEach(searchFilter -> {
				searchConditions = new ArrayList<>();
				if (filterTarget.getTargetID().equals(searchFilter.getFilterTarget().getTargetID())) {

					searchFilterConditions.forEach(searchFilterCondition -> {
						if (searchFilter.getSearchFilterId()
								.equals(searchFilterCondition.getSearchFilter().getSearchFilterId())) {
							SearchFilterConditionModel searchFilterConditionModel = new SearchFilterConditionModel();
							searchFilterConditionModel
									.setSearchFilterConditionId(searchFilterCondition.getSearchConditionId());
							searchFilterConditionModel.setFilterCondition(searchFilterCondition.getSearchCondition());
							searchConditions.add(searchFilterConditionModel);
						}
					});
				}

			});
			filterTargetModel.setSearchFilterConditionModels(searchConditions);
			result.add(filterTargetModel);
		});

		try {
			Map<String, List<FilterTargetModel>> output = new HashMap<>();
			output.put("Search Filter", result);
			outputResult = mapper.writeValueAsString(output);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outputResult;
	}

}
