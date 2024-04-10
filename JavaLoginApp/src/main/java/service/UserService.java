package service;

import dto.LoginDTO;
import dto.UserDTO;
import response.MessageResponse;

public interface UserService {
	
	public MessageResponse addUser(UserDTO userDTO);

	public MessageResponse loginUser(LoginDTO loginDTO);

}
