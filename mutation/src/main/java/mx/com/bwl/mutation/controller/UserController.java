package mx.com.bwl.mutation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dto.UserDTO;
import mx.com.bwl.mutation.entity.User;
import mx.com.bwl.mutation.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

	private final UserService userService;
	
	@PostMapping
	@ApiOperation(value = "Crear Usuario.", notes = "Este EndPoint crea un usuario.")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Creacion Correcta."),
							@ApiResponse(code = 400, message = "No se pudo Generar por duplicidad de usuario tal vez.")})
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO){
		User user = new User(userDTO.getName(), userDTO.getPassword());
		try {
			return new ResponseEntity<>(this.userService.createUser(user),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@PostMapping("/login")
	@ApiOperation(value = "Login Usuario.", notes = "Este EndPoint hace Login.")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Login correcta."),
							@ApiResponse(code = 401, message = "No autorizado.")})
	public ResponseEntity<Void> findUserByNameAndPassword(@RequestBody UserDTO userDTO){
		
		User user = this.userService.login(userDTO.getName(), userDTO.getPassword());
		
		if (user != null) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>( HttpStatus.UNAUTHORIZED);
	}

}
