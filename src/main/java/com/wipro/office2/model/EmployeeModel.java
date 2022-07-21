package com.wipro.office2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeModel 
{
	private String empName;	
	private String empEmail;
	private String empPassword;	
	private Float empSalary;	
	private AddressModel address;	
}