package com.icici.services.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icici.dto.UserDTO;
import com.icici.entities.OTP;
import com.icici.entities.User;
import com.icici.repositories.OTPRepo;
import com.icici.repositories.UserRepo;
import com.icici.services.UserService;
 

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private OTPRepo otpRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Method to register a new user and return UserDTO
    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class); // Convert DTO to entity
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDTO.class); // Convert entity to DTO
    }

	@Override
	public List<UserDTO> getAll() {
		List<User> all = userRepository.findAll();
		return all.stream().map(user->modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}
 
}
