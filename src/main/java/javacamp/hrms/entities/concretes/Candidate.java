package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name = "id") // bu tablodaki hangi değer user tablosunun primary keyi ile işkili --> id;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

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
	
	@JsonIgnore
	@Column(name = "is_verify", columnDefinition = "boolean default false")
	private boolean isVerify = false;
	
}
