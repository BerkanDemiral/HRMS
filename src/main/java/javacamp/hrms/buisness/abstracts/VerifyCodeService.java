package javacamp.hrms.buisness.abstracts;

import javacamp.hrms.core.utilities.results.Result;

import javacamp.hrms.entities.concretes.User;

public interface VerifyCodeService {
	String createVerifyCode(User user); // doğrulama kodu oluşturma
	void sendMail(String mail); // mail gönderme
	Result verifyUser(String code); // kullanıcının doğrulanıp doğrulanmadığına dair işlemler.
}
