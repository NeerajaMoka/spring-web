package com.wipro.office2.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wipro.office2.model.EmployeeModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "emp_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "empId")
public class Employee 
{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	
	private String empName;
	
	private String empEmail;	

	private String empPassword;	
	
	private Float empSalary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private Address address;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private List<SalaryRecord> salaryRecords;

	public Employee(EmployeeModel emp) {
		this.empName = emp.getEmpName();
		this.empEmail = emp.getEmpEmail();
		this.empPassword = emp.getEmpPassword();
		this.empSalary = emp.getEmpSalary();
		
		Address address = new Address(emp.getAddress());
		this.address = address;
	}
}