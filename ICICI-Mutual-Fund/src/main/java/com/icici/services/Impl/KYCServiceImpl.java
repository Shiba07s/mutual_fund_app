package com.icici.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.icici.dto.KYCDto;
import com.icici.entities.KYC;
import com.icici.entities.User;
import com.icici.exception.ResourceNotFoundException;
import com.icici.repositories.KYCRepo;
import com.icici.repositories.UserRepo;
import com.icici.services.KYCService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class KYCServiceImpl implements KYCService {
	
	private final KYCRepo kycRepo;
	private final UserRepo userRepo;
	private final ModelMapper modelMapper;

	@Override
	public KYCDto createNewKyc(Long userId, KYCDto kycDto) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with this id : "+userId));
		
		KYC kyc = modelMapper.map(kycDto, KYC.class);
		user.setKycVerified(true);
		kyc.setUser(user);
		KYC save = kycRepo.save(kyc);
		return modelMapper.map(save, KYCDto.class);
	}

	@Override
	public List<KYCDto> getAll() {
		List<KYC> all = kycRepo.findAll();
		return all.stream().map(kyc->modelMapper.map(kyc, KYCDto.class)).collect(Collectors.toList());
	}

}
