package com.icici.services;

import com.icici.dto.KYCDto;
import java.util.*;
public interface KYCService {
	
	KYCDto createNewKyc(Long userId,KYCDto kycDto);
	List<KYCDto>getAll();

}
