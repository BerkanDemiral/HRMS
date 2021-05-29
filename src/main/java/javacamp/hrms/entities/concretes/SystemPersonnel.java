package javacamp.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor // parametreli constructorlar eklendi
@NoArgsConstructor // parametresiz constructorlar eklendi
@Table(name="employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class SystemPersonnel extends User {
	
	@NotBlank(message = "İsim alanını boş bırakmayınız")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyisim alanını boş bırakmayınız")
	@Column(name="last_name")
	private String lastName;
	
	@JsonIgnore // belirtilen alanın json nesnesine dönüştürülmesini sağlar
	@Column(name="is_verify")
	private boolean verify = false; // default olarak verify ayarlanmasını belirttik
}
