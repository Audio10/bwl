package mx.com.bwl.mutation.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name = "name", nullable = false, length = 50, unique = true)
	private String name;
	
	@Column(name = "password", nullable = false, length = 25)
	private String password;

	@Column(name = "created")
	private Timestamp created;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	
}
