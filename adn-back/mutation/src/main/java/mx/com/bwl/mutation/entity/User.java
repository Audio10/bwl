package mx.com.bwl.mutation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "users")
@EqualsAndHashCode(of = { "id" })
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "user", nullable = false, length = 50)
	private String user;
	
	@Column(name = "password", nullable = false, length = 12)
	private String password;
	
	
}
