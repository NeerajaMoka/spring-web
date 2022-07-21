package com.wipro.office2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.office2.entity.Address;
import com.wipro.office2.entity.Employee;
import com.wipro.office2.repository.AddressRepository;
import com.wipro.office2.repository.EmployeeRepository;
import com.wipro.office2.response.ApiResponse;

@Service
public class AddressService 
{	
	@Autowired
	private AddressRepository addressRepo;
	
	public ApiResponse listAdress() 
	{
		return new ApiResponse(true, addressRepo.findAll());
	}

	public ApiResponse get(Integer empId) 
	{
		Optional<Address> op = addressRepo.findById(empId);
		if(op.isPresent()) {
			return new ApiResponse(true, op.get());
		}else {
			return new ApiResponse(false, "No Employee Found !");
		}
	}
}