package com.wipro.office2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel 
{	
	private String street;
	private String city;
	private String pincode;
}
