package com.icici.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.icici.dto.InvestmentDto;
import com.icici.entities.Investment;
import com.icici.entities.MutualFund;
import com.icici.entities.User;
import com.icici.exception.ResourceNotFoundException;
import com.icici.repositories.InvestmentRepo;
import com.icici.repositories.MutualFundRepo;
import com.icici.repositories.UserRepo;
import com.icici.services.InvestmentService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class InvestmentServiceImpl implements InvestmentService {
	
	private final InvestmentRepo investmentRepo;
	private final UserRepo userRepo;
	private final MutualFundRepo mutualFundRepo;
	private final ModelMapper modelMapper;

	@Override
	public InvestmentDto createNewInevestment(Long userId, InvestmentDto investmentDto) {
		User user = userRepo.findById(userId)
							.orElseThrow(()-> new ResourceNotFoundException("user not found with this id : "+userId));
		
		MutualFund mutualFund = mutualFundRepo.findById(investmentDto.getMutualFund().getId())
					  .orElseThrow(()-> new ResourceNotFoundException("mutual fund not found with this id : "+userId));
		
		Investment investment = modelMapper.map(investmentDto, Investment.class);
		investment.setUser(user);
		investment.setMutualFund(mutualFund);
		
		Investment save = investmentRepo.save(investment);
		return modelMapper.map(save, InvestmentDto.class);
	}

	@Override
	public List<InvestmentDto> getAllDetails() {
		List<Investment> all = investmentRepo.findAll();
 		return all.stream().map(investments -> modelMapper.map(investments, InvestmentDto.class)).collect(Collectors.toList());
	}

}
