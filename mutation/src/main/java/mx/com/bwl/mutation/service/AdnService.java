/**
 * 
 */
package mx.com.bwl.mutation.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dao.AndRepository;
import mx.com.bwl.mutation.dto.AdnDTO;
import mx.com.bwl.mutation.dto.AdnEstadisticas;
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
	
	public List<Adn> sinMutation(){
		return this.adnRepository.findNoMutation();
	}
	
	public List<Adn> mutation(){
		return this.adnRepository.findMutation();
	}
	
	public AdnEstadisticas estadistica() {
		int con = this.adnRepository.countConMutation();
		int sin = this.adnRepository.countSinMutation();
		int ratio;
		
		if (con > sin) {
			ratio = sin%con;
		}else {
			ratio = con%sin;
		}
		
		System.out.println(ratio);
		
		return new AdnEstadisticas(con,sin,ratio);
	}
	
	/**
	 * Metodo para guardar una secuencia de ADN.
	 * @param user
	 * @return
	 * 
	 */
	@Transactional
	public Adn createAdn(Adn adn) {
		adn.setCreated(new Timestamp(System.currentTimeMillis()));
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
	
	public boolean validar(String[] adn) {
		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < adn[i].length(); j++) {
				if( adn[i].charAt(j) == 'A' || adn[i].charAt(j) == 'C' || adn[i].charAt(j) == 'T'|| adn[i].charAt(j) == 'G') {
					
				}else {
					return false;
				}
			}
		}
		return true;
	}
	
}
