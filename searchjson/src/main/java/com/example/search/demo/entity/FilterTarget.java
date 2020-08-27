package com.example.search.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Table(name = "FILTER_TARGET")
@Data
@Entity
public class FilterTarget {
	
	@Id
	@Column(name = "TARGET_ID")
	private String targetID;
	@Column(name = "TARGET_FIELD_TYPE")
	private String targetFieldType;
	@Column(name = "TARGET_FIELD_KEY")
	private String targetFieldKey;
	@Column(name = "TARGET_NAME")
	private String targetName;
	
	@ManyToOne
	@JoinColumn(name = "FUNCTION_ID")
	private FilterExecution filterExecution ;
	
	@OneToOne(mappedBy = "filterTarget")
	private SearchFilter searchFilter;

}
