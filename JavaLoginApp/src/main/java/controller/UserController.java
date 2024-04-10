package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.LoginDTO;
import dto.UserDTO;
import response.MessageResponse;
import service.UserService;

@RestController
@CrossOrigin
@RequestMapping("app/login/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(path = "/save")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
		
		MessageResponse id = userService.addUser(userDTO);
		return ResponseEntity.ok(id);
	}
	
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        MessageResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
	
	@GetMapping(path = "/test")
	public String responseTest() {
		return "UserContollerOK";
	}

}
