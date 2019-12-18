/**
 * 
 */
package mx.com.bwl.mutation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.com.bwl.mutation.entity.Humano;

/**
 * @author claud
 *
 */
public interface HumanoRepository extends JpaRepository<Humano, String> {
	
}
