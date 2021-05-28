package javacamp.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employers")
@Getter
@Setter
@AllArgsConstructor // parametreli constructorlar eklendi
@NoArgsConstructor // parametresiz constructorlar eklendi
public class Employers extends Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="website")
	private String website;
	
	@Column(name="verified_company")
	private String verifiedCompany;
	
	
}
