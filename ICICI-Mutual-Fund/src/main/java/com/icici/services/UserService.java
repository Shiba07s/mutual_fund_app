package com.icici.services;

import com.icici.dto.UserDTO;

import java.util.List; // Import the correct List
public interface UserService {
	
	UserDTO registerUser(UserDTO userDTO);
	List<UserDTO> getAll();

}
