/**
 * 
 */
package mx.com.bwl.mutation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dao.AndRepository;
import mx.com.bwl.mutation.dto.AdnDTO;
import mx.com.bwl.mutation.entity.Adn;
import mx.com.bwl.mutation.service.Mutation;

/**
 * @author claud
 *
 */

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdnService {
	
	final private AndRepository adnRepository;
	final private Mutation mutation = new Mutation();
	
	/**
	 * Metodo para listar todas las secuencias de ADN.
	 * @param user
	 * @return
	 * 
	 */
	public List<Adn> findAll() {
		return this.adnRepository.findAll();
	}
	
	/**
	 * Metodo para guardar una secuencia de ADN.
	 * @param user
	 * @return
	 * 
	 */
	@Transactional
	public Adn createAdn(Adn adn) {
		return this.adnRepository.save(adn);
	}
	
	@Transactional
	public Boolean hasMutation(AdnDTO adnDTO) {
		String adnS="";
		boolean mut = mutation.hasMutation(adnDTO.getDna());
		
		for (String secuencia : adnDTO.getDna()) {
			adnS+= secuencia+"-";
		}
		
		Adn adn = new Adn(adnS.substring(0,adnS.length()-1) , mut);
		this.createAdn(adn);
		
		return mut;
	}
	
}
