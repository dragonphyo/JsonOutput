package com.example.search.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@Entity
@Table(name = "SEARCH_FILTER",uniqueConstraints = @UniqueConstraint(columnNames = "TARGET_ID"))
@Data
public class SearchFilter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SEARCH_FILTER_ID")
	private String searchFilterId;
	
	@OneToOne
	@JoinColumn(name = "TARGET_ID")
	private FilterTarget filterTarget;
	
	@OneToMany(mappedBy = "searchFilter")
	private List<SearchFilterCondition> searchFilterConditions;
	

}
