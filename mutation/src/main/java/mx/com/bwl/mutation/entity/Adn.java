/**
 * 
 */
package mx.com.bwl.mutation.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claud
 *
 */

@Entity
@Data
@Table(name = "adn")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Adn {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name = "sequence", nullable = false, length = 50, unique = true)
	private String sequence;
	
	@Column(name = "mutation", nullable = false, length = 25)
	private boolean mutation;
	
	@Column(name = "created")
	private Timestamp created;
	

	public Adn(String sequence, boolean mutation) {
		super();
		this.sequence = sequence;
		this.mutation = mutation;
	}

	
	
}
