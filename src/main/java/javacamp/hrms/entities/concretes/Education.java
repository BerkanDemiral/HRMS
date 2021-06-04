package javacamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Resume resume;
	private String schoolName;
	private Graduate graduate;
	private String schoolDepartment;
	private Date startedDate;
	private Date endDate;
}
