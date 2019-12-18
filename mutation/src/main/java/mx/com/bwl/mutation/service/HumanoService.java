package mx.com.bwl.mutation.service;

import java.sql.Timestamp;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.bwl.mutation.dao.AndRepository;
import mx.com.bwl.mutation.dao.HumanoRepository;
import mx.com.bwl.mutation.dto.HumanoDTO;
import mx.com.bwl.mutation.entity.Adn;
import mx.com.bwl.mutation.entity.Humano;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HumanoService{
	final private HumanoRepository humanoRepository;
	final private AndRepository adnRepository;
	final private Mutation mutation = new Mutation();
	
	@Transactional
	public void createHumano(HumanoDTO humanoDTO) {
		Humano humano = new Humano();
		humano.setName(humanoDTO.getName());
		humano.setCreated(new Timestamp(System.currentTimeMillis()));
		
		Adn adn = createSquence();
		humano.setAdn(adn);
		adn.setHumano(humano);
		
		humanoRepository.save(humano);	
		
	}
	
	public Adn createSquence() {
		Random aleatorio = new Random(); 
		String[] letra = {"A","T","G","C"};
		boolean noHay = true;
		Adn adnE= null;
		String adn="";
		
		while(noHay) {
			adn ="";
			for(int j =0; j<6; j++) {
				for(int i =0; i<6; i++) {
					adn+= letra[aleatorio.nextInt(4)];
				}
				adn+="-";
			}
			System.out.print(adn);
			adnE = adnRepository.findBySequence(adn.substring(0, adn.length()-1));
			
			if( adnE== null) noHay=false;
		}
		
		adnE = new Adn();
		adnE.setSequence(adn.substring(0, adn.length()-1));
		
		String [] squence = adn.split("-");
		boolean mut = mutation.hasMutation(squence);
		adnE.setMutation(mut);
		adnE.setCreated(new Timestamp(System.currentTimeMillis()));
		
		return adnE;		
		
	}
}
