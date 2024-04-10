package service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dto.LoginDTO;
import dto.UserDTO;
import entity.User;
import repo.UserRepo;
import response.MessageResponse;
import service.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public MessageResponse addUser(UserDTO userDTO) {
		
		User user = userRepo.findByUserName(userDTO.getUserName());
		
		if( user == null ) {
			user = new User(
					userDTO.getUserId(),
					userDTO.getUserName(),
					this.passwordEncoder.encode(userDTO.getUserPassword()),
					userDTO.getUserMail()
				);
			userRepo.save(user);
		} else {
			return new MessageResponse("User Already Exists with that Name", false);
		}
		
		return new MessageResponse("User Created Succesfully ["+user.getUserName()+"]", true);
	}

	@Override
	public MessageResponse loginUser(LoginDTO loginDTO) {
        User user = userRepo.findByUserName(loginDTO.getUserName());
        if (user != null) {
            String password = loginDTO.getUserPassword();
            String encodedPassword = user.getUserPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findByUserNameAndUserPassword(loginDTO.getUserName(), encodedPassword);
                if (employee.isPresent()) {
                    return new MessageResponse("Login Success", true);
                } else {
                    return new MessageResponse("Login Failed", false);
                }
            } else {
                return new MessageResponse("Password Not Match", false);
            }
        }else {
            return new MessageResponse("User not exits", false);
        }
	}


}
