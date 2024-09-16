package com.icici.services;

import java.util.List;

import com.icici.dto.InvestmentDto;

public interface InvestmentService {
	
	InvestmentDto createNewInevestment(Long userId,InvestmentDto investmentDto);
	List<InvestmentDto>getAllDetails();

}
