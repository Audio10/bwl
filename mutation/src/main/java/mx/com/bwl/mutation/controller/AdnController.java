/**
 * 
 */
package mx.com.bwl.mutation.controller;

import java.util.List;
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
import mx.com.bwl.mutation.service.AdnService;
import mx.com.bwl.mutation.dto.AdnDTO;
import mx.com.bwl.mutation.dto.AdnEstadisticas;
import mx.com.bwl.mutation.entity.Adn;

/**
 * @author claud
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/mutation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AdnController {
	
	private final AdnService adnService;
	
	@PostMapping
	@ApiOperation(value = "Crear Sequencia.", notes = "Este EndPoint crea una secuencia de ADN.")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Creacion Correcta."),
							@ApiResponse(code = 400, message = "No se pudo Generar por duplicidad tal vez.")})
	public ResponseEntity<Void> createAdn(@RequestBody AdnDTO adnDTO){
		boolean mutation = false;
		try {
			boolean valida = adnService.validar(adnDTO.getDna());
			
			if ( valida == true) 
				mutation = adnService.hasMutation(adnDTO);
			else 
				return new ResponseEntity<> (HttpStatus.UNSUPPORTED_MEDIA_TYPE);
			
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>( mutation == true ? HttpStatus.OK: HttpStatus.FORBIDDEN  );
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Obtener todas las secuencias.", notes = "Este EndPoint obtiene todas las secuencias de adn.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Todas las secuencias de ADN.")})
	public ResponseEntity< List<Adn> > findAll() {
		return new ResponseEntity<>(this.adnService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/conmutation")
	@ApiOperation(value = "Obtener todas las secuencias con mutacion.", notes = "Este EndPoint obtiene todas las secuencias de adn con mutacion.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Todas las secuencias de ADN con mutacion.")})
	public ResponseEntity< List<Adn> > conmutation() {
		return new ResponseEntity<>(this.adnService.mutation(), HttpStatus.OK);
	}
	
	@GetMapping("/sinmutation")
	@ApiOperation(value = "Obtener todas las secuencias sin mutacion.", notes = "Este EndPoint obtiene todas las secuencias de adn sin mutacion.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Todas las secuencias de ADN sin mutacion.")})
	public ResponseEntity< List<Adn> > sinmutations() {
		return new ResponseEntity<>(this.adnService.sinMutation(), HttpStatus.OK);
	}
	
	@GetMapping("/status")
	@ApiOperation(value = "Obtener el status.", notes = "Este EndPoint el status de las secuencias de adn.")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Status de secuencias de AND.")})
	public ResponseEntity< AdnEstadisticas > status() {
		return new ResponseEntity<>(this.adnService.estadistica(), HttpStatus.OK);
	}

}
