/**
 * 
 */
package mx.com.bwl.mutation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.com.bwl.mutation.entity.Adn;

/**
 * @author claud
 *
 */
public interface AndRepository extends JpaRepository<Adn, String>{
	
	public Adn findBySequence(String sequence);
	
	@Query("SELECT a FROM Adn a WHERE a.mutation =:true")
	public List<Adn> findMutation();
	
	@Query("SELECT a FROM Adn a WHERE a.mutation =:false")
	public List<Adn> findNoMutation();
	
}
