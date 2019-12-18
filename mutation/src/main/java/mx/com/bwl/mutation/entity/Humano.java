package mx.com.bwl.mutation.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "humanos")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Humano {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adn_id", referencedColumnName = "id")
	private Adn adn;
	
	@Column(name = "created")
	private Timestamp created;
	
}
