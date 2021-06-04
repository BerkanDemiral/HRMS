package javacamp.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Language {
	
	private int id;
	
	private Resume resume;
	
	private String language;
	
	private char languageLevel;
	
	private Date createDate;
}
