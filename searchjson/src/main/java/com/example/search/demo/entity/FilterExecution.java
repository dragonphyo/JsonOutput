package com.example.search.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "FILTER_EXECUTION")
@Entity
@Data
public class FilterExecution implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "FUNCTION_ID")
	private String functionId;
	@OneToMany(mappedBy = "filterExecution")
	private List<FilterTarget> filterTargets;

}
