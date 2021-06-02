package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import javacamp.hrms.entities.concretes.VerifyCode;
public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer>{
	VerifyCode getByVerifyCode(String Code); 	
	boolean existsByVerifyCode(String Code);
}
