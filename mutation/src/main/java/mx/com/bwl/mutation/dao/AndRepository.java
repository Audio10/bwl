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
	
	@Query("SELECT a FROM Adn a WHERE a.mutation = 1")
	public List<Adn> findMutation();
	
	@Query("SELECT a FROM Adn a WHERE a.mutation = 0")
	public List<Adn> findNoMutation();
	
	@Query("SELECT count(*) FROM Adn as a where a.mutation = 1")
	public int countConMutation();
	
	@Query("SELECT count(*) FROM Adn as a where a.mutation = 0")
	public int countSinMutation();
}
