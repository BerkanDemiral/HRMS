package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "job_positions") // veritabanında hangi tabloya karşılık geliyor.
@Data
public class JobPositions {
	@Id // id alanını belirttik.
	@GeneratedValue // auto increment(bir bir artırılacak) diye belirttik.
	@Column(name = "job_id") // hangi sütuna karşılık geliyor.
	private int id;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "job_description")
	private String jobDescription;

	public JobPositions() {
		
	}

	public JobPositions(int id, String jobTitle, String jobDescription) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
	}

}
