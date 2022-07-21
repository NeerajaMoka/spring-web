package com.wipro.office2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.office2.entity.Role;
import com.wipro.office2.repository.RoleRepository;


@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	public boolean saveRole(Role role) 
	{
		try{
			roleRepo.save(role);			
			return true;
		}catch(Exception ex) {
			System.err.println("Role Save Error : "+ex.getMessage());
			return false;
		}
	}
}