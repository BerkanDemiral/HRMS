package javacamp.hrms.buisness.abstracts;

import com.sun.net.httpserver.Authenticator.Result;

import javacamp.hrms.entities.concretes.User;

public interface VerifyCodeService {
	String createVerifyCode(User user);
	void sendMail(String mail);
	Result verifyUser(String code);
}
