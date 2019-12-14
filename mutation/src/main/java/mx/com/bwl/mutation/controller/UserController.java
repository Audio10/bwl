package mx.com.bwl.mutation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dto.UserDTO;
import mx.com.bwl.mutation.entity.User;
import mx.com.bwl.mutation.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
		User user = new User(userDTO.getName(), userDTO.getPassword());
		try {
			return new ResponseEntity<>(this.userService.createUser(user),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Void> findUserByNameAndPassword(@RequestBody UserDTO userDTO){
		
		User user = this.userService.login(userDTO.getName(), userDTO.getPassword());
		
		if (user != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
	}

}
