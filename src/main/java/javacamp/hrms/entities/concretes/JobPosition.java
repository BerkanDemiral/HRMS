package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_positions") // veritabanında hangi tabloya karşılık geliyor.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
	
	@Id // id alanını belirttik
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment(bir bir artırılacak) diye belirttik.
	@Column(name = "id") // hangi sütuna karşılık geliyor.
	private int id;

	@Column(name = "position")
	private String jobTitle;

	@Column(name = "job_describe")
	private String jobDescribe;


}
