package mx.com.bwl.mutation.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dto.HumanoDTO;
import mx.com.bwl.mutation.entity.User;
import mx.com.bwl.mutation.service.HumanoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class HumanoController {
	final private HumanoService humanoService;
	
	@PostMapping("humano")
	@ApiOperation(value = "Crear Humano.", notes = "Este EndPoint crea un Humano.")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Creacion Correcta.")})
	public ResponseEntity<User> createUser(@RequestBody HumanoDTO humanoDTO){
		humanoService.createHumano(humanoDTO);
		return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@GetMapping("")
	@ApiOperation(value = "Home.", notes = "Este EndPoint es el Home.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Llegada a Home.")})
	public ResponseEntity<String> createUser(){
		return new ResponseEntity<String> ("Bienvendio al API ADN para BWL, Te recomiendo ir al Swagger para ver los mapeos http://adnbwl.us-east-2.elasticbeanstalk.com/swagger-ui.html#/adn-controller/createAdnUsingPOST",HttpStatus.OK);
	}
	
}
