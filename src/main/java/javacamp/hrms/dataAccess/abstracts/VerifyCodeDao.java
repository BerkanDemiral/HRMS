package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javacamp.hrms.entities.concretes.VerifyCode;
@Repository
public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer>{
	VerifyCode getByVerifyCode(String Code); 	
	boolean existsByVerifyCode(String Code);
}
