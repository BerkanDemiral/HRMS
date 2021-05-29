package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="employers")
@Data // miras aldığı sınıfın ortak nesnesini burada da tanımlamazsak( id gibi ) @Data kullanımı sorun çıkarmaz
@AllArgsConstructor // parametreli constructorlar eklendi
@NoArgsConstructor // parametresiz constructorlar eklendi
public class Candidate extends User {
	
	
	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@Size(min=2, message="İsim alanı 2 karakterden küçük olamaz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyadınızı boş bırakmayınız")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "Kimlik numaranızı boş bırakmayınız")
	@Size(min=11, max=11, message = "Kimlik numaranız 11 haneli olmak zorundadır")
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotBlank(message = "Doğum tarihi alanını boş bırakılamaz")
	@Column(name="birth_year")
	private String birthDate;
	
}
