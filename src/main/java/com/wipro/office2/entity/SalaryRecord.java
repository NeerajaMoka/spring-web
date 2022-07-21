package com.wipro.office2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wipro.office2.model.SalaryRecordModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_salary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "salId")
public class SalaryRecord 
{
	public SalaryRecord(SalaryRecordModel salModel, Employee emp) 
	{
		this.basicSalary = salModel.getBasicSalary();
		this.bonus = salModel.getBonus();
		this.month = salModel.getMonth();
		this.employee = emp;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salId;
	
	private Float basicSalary;
	private Float bonus;
	private String month;
	
	@ManyToOne
	@JoinColumn(name = "employee")
	private Employee employee;
	
}
