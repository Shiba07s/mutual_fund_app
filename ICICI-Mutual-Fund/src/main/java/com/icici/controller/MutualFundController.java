package com.icici.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icici.dto.MutualFundDto;
import com.icici.services.MutualFundService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/mutual-funds")
public class MutualFundController {
	
	@Autowired
	private MutualFundService mutualFundService;
	
	@PostMapping("/create")
	public ResponseEntity<MutualFundDto>createNewMutualFund(@RequestBody MutualFundDto mutualFundDto){
		MutualFundDto newMutualFund = mutualFundService.createNewMutualFund(mutualFundDto);
		return new ResponseEntity<MutualFundDto>(newMutualFund,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<MutualFundDto>> getAllMutualFundDetails(){
		List<MutualFundDto> allDetails = mutualFundService.getAllDetails();
		return new ResponseEntity<List<MutualFundDto>>(allDetails,HttpStatus.OK);
	}

}
