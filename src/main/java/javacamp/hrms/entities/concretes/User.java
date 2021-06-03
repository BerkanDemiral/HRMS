package javacamp.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor // parametreli constructor ekledi
@NoArgsConstructor // parametresiz constructor ekledi
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id // id alanını belirttik.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment(bir bir artırılacak) diye belirttik.
	@Column(name = "id") // hangi sütuna karşılık geliyor.
	private int id;
	
	@NotBlank(message = "Email alanı boş bırakılamaz.")
	@Email(message="Geçerli bir email adresi giriniz")
	@Column(name = "email")
	private String email; 
	
	@NotBlank(message = "Şifre alanını boş bırakmayınız.")
	@Size(min=6,max =18 , message="Şifre min 6 max 18 karakterden oluşmalıdır.")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "Şifre alanı boş bırakılamaz.")
	@javax.persistence.Transient // ! veritabanına tekrar kaydetmeye gerek duymadığımız ama karşılaştırma vb. kullanımlar için tutmamız gereken değişkenlerde @Transient kullanılabilir.
	@JsonProperty(access = Access.WRITE_ONLY)
	private String repeatPassword;
	
	@JsonIgnore // belirtilen alanın json nesnesine dönüştürülmesini sağlar
	@Column(name="is_verify")
	private boolean verify = false; // default olarak verify ayarlanmasını belirttik
	
	
}
