package com.wipro.office2.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.office2.entity.Employee;
import com.wipro.office2.model.EmployeeModel;
import com.wipro.office2.repository.EmployeeRepository;
import com.wipro.office2.response.ApiResponse;
import com.wipro.office2.service.AddressService;
import com.wipro.office2.service.EmployeeService;

@RestController
@RequestMapping("/api/address")
public class AddressController 
{
	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/")
	public ApiResponse listAdress()
	{
		ApiResponse response = addressService.listAdress();
		return response;
	}
	
	// PathVariable
	@GetMapping("/get/{addid}")
	public ApiResponse getAddress(@PathVariable(name = "addid") Integer addId) 
	{
		ApiResponse response = addressService.get(addId);
		return response;
	}	
}


