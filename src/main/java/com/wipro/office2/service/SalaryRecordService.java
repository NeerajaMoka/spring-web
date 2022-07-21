package com.wipro.office2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.office2.entity.Employee;
import com.wipro.office2.entity.SalaryRecord;
import com.wipro.office2.model.SalaryRecordModel;
import com.wipro.office2.repository.EmployeeRepository;
import com.wipro.office2.repository.SalaryRecordRepository;
import com.wipro.office2.response.ApiResponse;

@Service
public class SalaryRecordService 
{
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private SalaryRecordRepository salRepo;
	
	public ApiResponse saveRecord(SalaryRecordModel salModel) 
	{
		try {			
			Optional<Employee> op =  empRepo.findById(salModel.getEmployeeId());
			if(op.isPresent())
			{
				SalaryRecord sr = new SalaryRecord(salModel,op.get());
				salRepo.save(sr);
				return new ApiResponse(true, "Employee Salary Saved Successfully !");			
				
			}else {
				return new ApiResponse(false, "Employee ID not Found ! !");	
			}
			
		}catch(Exception ex) {
			System.err.print("Save SalaryRecord Error : " + ex.getMessage());
			return new ApiResponse(false, "Employee Salary Not Saved !");
		}
	}

	public ApiResponse list() 
	{
		return new ApiResponse(true, salRepo.findAll());
	}

	public ApiResponse get(Integer salId) {
		Optional<SalaryRecord> op = salRepo.findById(salId);
		if(op.isPresent()) {
			return new ApiResponse(true, op.get());
		}else {
			return new ApiResponse(false, "No Salary Record Found !");
		}
	}

}
