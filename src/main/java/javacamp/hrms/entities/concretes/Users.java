package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor // parametreli constructor ekledi
@NoArgsConstructor // parametresiz constructor ekledi
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {
	
	@Id // id alanını belirttik.
	@GeneratedValue // auto increment(bir bir artırılacak) diye belirttik.
	@Column(name = "user_id") // hangi sütuna karşılık geliyor.
	private int id;
	
	
	@Email(message="Geçerli bir email adresi giriniz")
	@Column(name = "email")
	private String email; 
	
	@NotBlank(message = "Şifre alanını boş bırakmayınız.")
	@Size(min=6,max =20 , message="Şifre min 6 max 20 karakterden oluşmalıdır.")
	@Column(name = "password")
	private String password;
	
}
