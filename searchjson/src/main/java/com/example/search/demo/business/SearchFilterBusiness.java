package com.example.search.demo.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.search.demo.entity.SearchFilter;

@Service
public class SearchFilterBusiness {

	@Autowired
	private EntityManager em;

	public List<SearchFilter> getSearchFilterById(List<String> targetIds) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<SearchFilter> query = builder.createQuery(SearchFilter.class);
		Root<SearchFilter> searchFilter = query.from(SearchFilter.class);
		query.select(searchFilter).where(searchFilter.get("filterTarget").get("targetID").in(targetIds));
		return em.createQuery(query).getResultList();
	}

}
