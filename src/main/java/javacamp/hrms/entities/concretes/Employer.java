package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id") // primary key yazmayacağız ve hangi tablodan mirası alındığını(ilişki)
										// belirtiyoruz.
public class Employer extends User {

	@NotBlank(message = "Şirket ismini boş bırakmayınız")
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Telefon Numarası alanını boş bırakmayınız")
	@Column(name = "phone_number")
	private String phone;

	@NotBlank(message = "Web sitesi bilgisini boş bırakmayınız")
	@Column(name = "web_address")
	private String webAddress;

	@JsonIgnore
	@Column(name = "user_confirm")
	private boolean userConfirm;

}
