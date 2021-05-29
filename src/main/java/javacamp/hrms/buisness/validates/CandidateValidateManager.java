package javacamp.hrms.buisness.validates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.net.httpserver.Authenticator.Result;

import javacamp.hrms.adapter.service.VerifyApiService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.buisness.abstracts.VerifyCodeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Candidate;

public class CandidateValidateManager implements ValidateService<Candidate>{

	@Autowired
	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerifyApiService<Candidate> verifyApiService;
	private VerifyCodeService verifyCodeService;
	
	
	
	public CandidateValidateManager(CandidateDao candidateDao, UserDao userDao,
			VerifyApiService<Candidate> verifyApiService, VerifyCodeService verifyCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.verifyApiService = verifyApiService;
		this.verifyCodeService = verifyCodeService;
	}

	@Override
	public Result verifyData(Candidate candidate) {
		if(!this.verifyApiService.apiControl(candidate)) { // doğrulama sonucu result değeri false dönerse 
			return new ErrorResult("Merni kimlik doğrulaması başarısız oldu");
		}
		if(this.userDao.existByEmail(candidate.getEmail())){
			return new ErrorResult("Mail adresi zaten mevcut");
		}
		if(candidateDao.existByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu kimlik numarası sistemimizde zaten mevcut")
		}
		if(!candidate.getPassword().equals(candidate.getRepeatPassword())) {
			return new ErrorResult("Şifreler uyuşmuyor");
		}
		
		this.candidateDao.save(candidate);
		this.verifyCodeService.createVeriftCode(userDao.getOne(candidate.getId())); // getOne -- doğrulama kodu oluşturmak için kullandık.
		this.verifyCodeService.sendMail(candidate.getEmail());
		return new SuccessResult("Kayıt başarılı");
				
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Listeleme başarılı");
	}
	
}
