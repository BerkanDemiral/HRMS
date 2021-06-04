package javacamp.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_postings")
@Entity
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik artan alan
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = JobPosition.class ,fetch = FetchType.LAZY, optional = false) // bir pozisyon birden fazla iş ilanında bulunabilir. 
	@JoinColumn(name = "job_position_id", referencedColumnName =  "id" ,nullable = false) // buradaki job_position_id --> referenced --> id(job_positions table)
	private JobPosition jobPosition;
	
	@ManyToOne(targetEntity = City.class ,fetch = FetchType.LAZY, optional = false) // bir şehir birden fazla iş ilanında bulunabilir.
	@JoinColumn(name = "city_id", referencedColumnName =  "id" ,nullable = false)
	private City city;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="closed_date")
	private Date closedDate;
	
	@Column(name="is_active")
	private boolean isActive=false;
	
	@ManyToOne(targetEntity = Employer.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "user_id" ,nullable = false)
	private Employer employer;

}