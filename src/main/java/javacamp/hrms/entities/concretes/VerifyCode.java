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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users_verify")
public class VerifyCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int id;
	
	@ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY, optional = false) 
	// Birden fazla kullanıcıya aynı onay kodu gidebilir, 
	@JoinColumn(name="user_id", referencedColumnName = "id", nullable=false) // bu tablodaki user_id kısmı, User.class'daki id sütununu refere eder
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User userId;
	
	@JsonIgnore
	@Column(name="verify_code")
	private String verifyCode;
	
	@JsonIgnore
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonIgnore
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
}
