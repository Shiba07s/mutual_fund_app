package com.icici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icici.dto.InvestmentDto;
import com.icici.services.InvestmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/investments")
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@PostMapping("/users/{userId}")
	public ResponseEntity<InvestmentDto>createNewInvestments(@PathVariable Long userId,@RequestBody InvestmentDto investmentDto){
		InvestmentDto newInevestment = investmentService.createNewInevestment(userId, investmentDto);
		return new ResponseEntity<InvestmentDto>(newInevestment,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<InvestmentDto>> getAllInvestmentDetails(){
		List<InvestmentDto> allDetails = investmentService.getAllDetails();
		return new ResponseEntity<List<InvestmentDto>>(allDetails,HttpStatus.OK);
	}

}
