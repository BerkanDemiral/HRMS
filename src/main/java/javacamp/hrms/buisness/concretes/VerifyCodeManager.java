package javacamp.hrms.buisness.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.VerifyCodeService;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.dataAccess.abstracts.VerifyCodeDao;
import javacamp.hrms.entities.concretes.User;
import javacamp.hrms.entities.concretes.VerifyCode;

@Service
public class VerifyCodeManager implements VerifyCodeService {

	private VerifyCodeDao verifyCodeDao;
	private UserDao UserDao;
	
	@Autowired
	public VerifyCodeManager(VerifyCodeDao verifyCodeDao, javacamp.hrms.dataAccess.abstracts.UserDao userDao) {
		super();
		this.verifyCodeDao = verifyCodeDao;
		UserDao = userDao;
	}

	@Override
	public String createVerifyCode(User user) { // parametre olarak yollanan user için kod oluşturan fonksiyonumuz. 
		String verifyCode = UUID.randomUUID().toString(); // random code oluşturmak için kullanıyoruz.
		VerifyCode code = new VerifyCode();
		LocalDate localDate = (LocalDate.now());
		code.setUserId(user); // userId referansı User değeri döndürür bu nedenle user parametresi verdik.
		code.setCreatedDate(Date.valueOf(localDate));
		code.setVerifyCode(verifyCode);
		this.verifyCodeDao.save(code);
		return verifyCode;
	}

	@Override
	public void sendMail(String email) {
		System.out.println(email+ " adresine doğrulama maili gönderildi ");
		
	}

	@Override
	public Result verifyUser(String code) {
		if(!this.verifyCodeDao.existsByVerifyCode(code)) {
			return new ErrorResult("Doğrulama işlemi hatalı!");
		}
		VerifyCode newVerifyCode = verifyCodeDao.getByVerifyCode(code); 
		if(this.verifyCodeDao.getOne(newVerifyCode.getId()).isConfirmed()) { // o kod zaten mevcut ise 
			return new ErrorResult("Doğrulama işlemi daha önce yapıldı");
		}
		LocalDate localDate = (LocalDate.now());
		newVerifyCode.setConfirmed(true);
		newVerifyCode.setConfirmedDate(Date.valueOf(localDate));
		verifyCodeDao.save(newVerifyCode);
		
		User verifyUser = new User();
		verifyUser = UserDao.getOne(newVerifyCode.getUserId().getId()); // getOne() metodu verilen id'ye ait objenin referansını döner
		verifyUser.setVerify(true);
		UserDao.save(verifyUser);
		return new SuccessResult("Doğrulama başarılı");
		
	}

}
