package com.example.search.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "SEARCH_FILTER_CONDITION")
@Data
public class SearchFilterCondition implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "SEARCH_CONDITION_ID")
	private String SearchConditionId;
	
	@ManyToOne
	@JoinColumn(name = "SEARCH_FILTER_ID")
	private SearchFilter searchFilter;
	
	@Column(name = "SEARCH_CONDITON")
	private String SearchCondition;
	


	

}
