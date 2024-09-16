package com.icici.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.icici.dto.MutualFundDto;
import com.icici.entities.MutualFund;
import com.icici.repositories.MutualFundRepo;
import com.icici.services.MutualFundService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MutualFundServiceImpl implements MutualFundService {
	
	private final MutualFundRepo mutualFundRepo;
	private final ModelMapper modelMapper;

	@Override
	public MutualFundDto createNewMutualFund(MutualFundDto mutualFundDto) {
		MutualFund mutualFund = modelMapper.map(mutualFundDto, MutualFund.class);
		MutualFund save = mutualFundRepo.save(mutualFund);
		return modelMapper.map(save, MutualFundDto.class);
	}

	@Override
	public List<MutualFundDto> getAllDetails() {
		List<MutualFund> all = mutualFundRepo.findAll();
		return all.stream().map(mutualFund-> modelMapper.map(mutualFund, MutualFundDto.class)).collect(Collectors.toList());
	}

}
