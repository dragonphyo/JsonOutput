package com.example.search.demo.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.search.demo.entity.FilterTarget;

@Service
public class FilterTargetBusiness {

	@Autowired
	private EntityManager em;

	public List<FilterTarget> getFilterTargetById(String functionId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<FilterTarget> query = builder.createQuery(FilterTarget.class);
		Root<FilterTarget> filterTarget = query.from(FilterTarget.class);
		query.select(filterTarget)
				.where(builder.equal(filterTarget.get("filterExecution").get("functionId"), functionId));
		return em.createQuery(query).getResultList();
	}

}
