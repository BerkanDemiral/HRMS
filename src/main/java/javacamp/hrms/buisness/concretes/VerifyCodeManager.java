package javacamp.hrms.buisness.concretes;

import org.springframework.stereotype.Service;

import com.sun.net.httpserver.Authenticator.Result;

import javacamp.hrms.buisness.abstracts.VerifyCodeService;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.dataAccess.abstracts.VerifyCodeDao;
import javacamp.hrms.entities.concretes.User;

@Service
public class VerifyCodeManager implements VerifyCodeService {

	private VerifyCodeDao verifyCodeDao;
	private UserDao UserDao;
	
	
	
	@Override
	public String createVerifyCode(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMail(String mail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Result verifyUser(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
