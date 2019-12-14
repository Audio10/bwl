/**
 * 
 */
package mx.com.bwl.mutation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.service.AdnService;
import mx.com.bwl.mutation.dto.AdnDTO;
import mx.com.bwl.mutation.entity.Adn;

/**
 * @author claud
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/mutation")
public class AdnController {
	
	private final AdnService adnService;
	
	
	@PostMapping
	public ResponseEntity<Void> createAdn(@RequestBody AdnDTO adnDTO){
		boolean mutation = false;
		try {
			mutation = adnService.hasMutation(adnDTO);
		} catch (Exception e) {
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>( mutation == true ? HttpStatus.OK: HttpStatus.FORBIDDEN  );
	}
	
	@GetMapping("/all")
	public ResponseEntity< List<Adn> > findAll() {
		return new ResponseEntity<>(this.adnService.findAll(), HttpStatus.OK);
	}

}
