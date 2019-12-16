/**
 * 
 */
package mx.com.bwl.mutation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.bwl.mutation.entity.User;

/**
 * @author claud
 *
 */

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByName(String name);

	@Query("SELECT u FROM User u WHERE u.name =:name and u.password=:password ")
	public User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
