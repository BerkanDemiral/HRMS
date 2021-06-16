package javacamp.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false) // her candidate'in bir resume'u
																						// olmak zorunda,
	private Candidate candidate;

	@Column(name = "image")
	private String image;
	
	
	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linkedin_link")
	private String linkedinLink;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@Column(name = "created_date")
	private Date createdDate;

	@JsonIgnore
	@Column(name = "updated_date")
	private Date updatedDate;

	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive = true;

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;

	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;

	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	@OneToMany(mappedBy = "resume")
	private List<Education> education;
	 
}
