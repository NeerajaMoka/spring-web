package com.wipro.office2.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse 
{
	private boolean isTokenFound;
	private boolean isTokenExpire;
	private String message;
}