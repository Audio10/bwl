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
	 */
	public List<Adn> findAll() {
		return this.adnRepository.findAll();
	}
	
	/**
	 * Metodo para listar todas las secuencias sin Mutacion.
	 */
	public List<Adn> sinMutation(){
		return this.adnRepository.findNoMutation();
	}
	
	/**
	 * Metodo para listar todas las secuencias con Mutacion. 
	 */
	public List<Adn> mutation(){
		return this.adnRepository.findMutation();
	}
	
	/**
	 * Metodo para verificar Status.
	 */
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
	 */
	@Transactional
	public void createAdn(String[] squence, boolean mut) {
		String id = getSquence(squence);
		Adn adn = adnRepository.findBySequence(id);
		if (adn == null) {
			adn = new Adn();
			adn.setSequence(id);
			adn.setMutation(mut);
			adn.setCreated(new Timestamp(System.currentTimeMillis()));
			this.adnRepository.save(adn);
		}
			
	}
	
	/**
	 * Metodo para obtener la Secuencia que se guardara en la base de datos.
	 */
	public String getSquence(String[] squence) {
		String squenceT="";
		for(String cadena : squence) {
			squenceT+=cadena+"-";
		}
		
		return squenceT.substring(0, squenceT.length()-1);
	}

	/**
	 * Metodo que determina si una secuencia tiene mutacion.
	 */
	@Transactional
	public Boolean hasMutation(AdnDTO adnDTO) {
		
		boolean mut = mutation.hasMutation(adnDTO.getDna());
		this.createAdn(adnDTO.getDna(), mut);
		return mut;
	}
	
	/**
	 * Metodo para validar caracteres de secuencia.
	 */
	public boolean validar(String[] adn) {
		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < adn[i].length(); j++) {
				if( adn[i].charAt(j) == 'A' || adn[i].charAt(j) == 'C' || adn[i].charAt(j) == 'T'|| adn[i].charAt(j) == 'G') {
					
				}else {
					System.out.println(adn[i].charAt(j));
					return false;
				}
			}
		}
		return true;
	}
	
}
