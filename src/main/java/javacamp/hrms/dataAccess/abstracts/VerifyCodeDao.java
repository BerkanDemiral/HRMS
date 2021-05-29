package javacamp.hrms.dataAccess.abstracts;

import javacamp.hrms.entities.concretes.VerifyCode;

public interface VerifyCodeDao {
	VerifyCode getByVerifyCode(String Code);
	boolean existsByVerifyCode(String Code);
}
