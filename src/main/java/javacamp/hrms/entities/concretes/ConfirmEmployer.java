package javacamp.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "confirm_employers")
public class ConfirmEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonIgnore
	private int Id;

	@OneToOne(targetEntity = Employer.class) // 1 employer için 1 onaylanma durumu vardır -- OnetoOne
	@JoinColumn(name="employer_id", referencedColumnName = "user_id") // employer_id değeri user_id ile ilişkilidir
	private Employer employer; // -- employer_id tanımlamak yerine employer tanımlayarak ilişkiyi tanımladık.
	
	@Column(name="confirmed_system_personnel")
	private int system_personnel;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
}
