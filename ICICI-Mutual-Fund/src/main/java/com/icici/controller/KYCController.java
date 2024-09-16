package com.icici.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icici.dto.KYCDto;
import com.icici.repositories.KYCRepo;
import com.icici.services.KYCService;
import java.util.*;

import lombok.RequiredArgsConstructor;


@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/kyc")
public class KYCController {
	
	private final KYCService kycService;
	
	@PostMapping("/users/{userId}")
	public ResponseEntity<KYCDto> createVerifiedKycDetails(@PathVariable Long userId,@RequestBody KYCDto kycDto){
		KYCDto newKyc = kycService.createNewKyc(userId, kycDto);
		return new ResponseEntity<KYCDto>(newKyc,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<KYCDto>> getAllKycData(){
	List<KYCDto> all = kycService.getAll();
	return new ResponseEntity<List<KYCDto>>(all,HttpStatus.OK);
	}

}
