package com.wipro.office2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.office2.response.TokenResponse;

@RestController
@RequestMapping("/web")
public class WebController
{
	@GetMapping("/")
	public String home() {
		return "Welcome Wipro Office";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "Access Denied ";
	}
	
	@GetMapping("/expireToken")
	public ResponseEntity<TokenResponse> expireToken()
	{
		TokenResponse response = new TokenResponse(true, true, "Token Expire !");
		return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping("/noToken")
	public ResponseEntity<TokenResponse> noToken()
	{
		TokenResponse response = new TokenResponse(false, false, "Token Not Found !");
		return ResponseEntity.badRequest().body(response);
	}
	
	@GetMapping("/invalidToken")
	public ResponseEntity<TokenResponse> invalidToken()
	{
		TokenResponse response = new TokenResponse(true, false, "Invalid Token !");
		return ResponseEntity.badRequest().body(response);
	}
}
