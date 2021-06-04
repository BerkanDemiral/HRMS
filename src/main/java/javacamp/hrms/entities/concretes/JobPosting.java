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
import javax.validation.constraints.NotBlank;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = JobPosition.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_position_id", referencedColumnName =  "id" ,nullable = false)
	private JobPosition jobPosition;
	
	@ManyToOne(targetEntity = City.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", referencedColumnName =  "id" ,nullable = false)
	private City city;
	
	@NotBlank(message = "Minimimum maaş miktarını boş girmeyiniz.")
	@Column(name="min_salary")
	private int minSalary;
	
	@NotBlank(message = "Maximum maaş miktarını boş girmeyiniz.")
	@Column(name="max_salary")
	private int maxSalary;
	
	@NotBlank(message = "Açık pozisyon sayısını boş bırakmayınız")
	@Column(name="open_position_number")
	private int openPositionNumber;
	
	@NotBlank(message = "İş ilanı oluşturma tarihi giriniz.")
	@Column(name="created_date")
	private Date createdDate;
	
	@NotBlank(message = "İş ilanı için son tarih giriniz")
	@Column(name="closed_date")
	private Date closedDate;
	
	
	@Column(name="is_active")
	private boolean isActive = false;
	
	@ManyToOne(targetEntity = Employer.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "user_id" ,nullable = false)
	private Employer employer;

}