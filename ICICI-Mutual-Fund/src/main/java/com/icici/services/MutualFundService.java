package com.icici.services;

import java.util.List;

import com.icici.dto.MutualFundDto;

public interface MutualFundService {
	
		MutualFundDto createNewMutualFund(MutualFundDto mutualFundDto);
		List<MutualFundDto>getAllDetails();
	

}
