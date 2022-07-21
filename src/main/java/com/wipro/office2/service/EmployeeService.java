package com.wipro.office2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.office2.entity.Employee;
import com.wipro.office2.model.EmployeeModel;
import com.wipro.office2.repository.AddressRepository;
import com.wipro.office2.repository.EmployeeRepository;
import com.wipro.office2.response.ApiResponse;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private AddressRepository addressRepo;
	
	public ApiResponse saveEmployee(Employee emp) 
	{
		try {			
			addressRepo.save(emp.getAddress());
			empRepo.save(emp);
			return new ApiResponse(true, "Employee Saved Successfully !");			
			
		}catch(Exception ex) {
			System.err.print("Save Employee Error : " + ex.getMessage());
			return new ApiResponse(false, "Employee Not Saved !");
		}
	}
	
	public ApiResponse updateEmployee(Integer empId,EmployeeModel emp) 
	{
		try {
			Optional<Employee> op = empRepo.findById(empId);
			if(op.isPresent())
			{
				Employee empObj = new Employee(emp);
				empObj.setEmpId(empId);
				empObj.getAddress().setAddressId(op.get().getAddress().getAddressId());
				
				empRepo.save(empObj);
				return new ApiResponse(true, "Employee Updated Successfully !");
			}else {
				return new ApiResponse(false, "Employee Not Exist !");
			}
		}catch(Exception ex) {
			System.err.print("Update Employee Error : " + ex.getMessage());
			return new ApiResponse(false, "Employee Not Updated !");
		}
	}

	public ApiResponse listEmployees() 
	{
		return new ApiResponse(true, empRepo.findAll());
	}

	public ApiResponse get(Integer empId) 
	{
		Optional<Employee> op = empRepo.findById(empId);
		if(op.isPresent()) {
			return new ApiResponse(true, op.get());
		}else {
			return new ApiResponse(false, "No Employee Found !");
		}
	}

	public ApiResponse deleteEmployee(Integer empId) 
	{
		try {
			Optional<Employee> op = empRepo.findById(empId);
			if(op.isPresent())
			{
				empRepo.delete(op.get());
				return new ApiResponse(true, "Employee Deleted Successfully !");
			}else {
				return new ApiResponse(false, "Employee Not Exist !");
			}
		}catch(Exception ex) {
			System.err.print("Delete Employee Error : " + ex.getMessage());
			return new ApiResponse(false, "Employee Not Deleted !");
		}
	}
}
