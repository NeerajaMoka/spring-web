package com.wipro.office2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.office2.config.TokenProvider;
import com.wipro.office2.model.LoginUserModel;
import com.wipro.office2.response.ApiResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenProvider jwtTokenUtil;
		
	@PostMapping("/authenticate")
	public ApiResponse authenticate(@RequestBody LoginUserModel loginUser)
	{
		System.out.println(loginUser);
		try {
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginUser.getUsername(),
						loginUser.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);		
		return new ApiResponse(true,"Login Success",token);
		}catch(BadCredentialsException ex) {
			return new ApiResponse(false, "Login Failed");
		}
	}
}