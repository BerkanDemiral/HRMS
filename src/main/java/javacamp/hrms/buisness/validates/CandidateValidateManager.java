package javacamp.hrms.buisness.validates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.buisness.abstracts.VerifyCodeService;
import javacamp.hrms.core.utilities.adapter.service.VerifyApiService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CandidateDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Candidate;

@Service
public class CandidateValidateManager implements ValidateService<Candidate> {


	private CandidateDao candidateDao;
	private UserDao userDao;
	private VerifyApiService verifyApiService;
	private VerifyCodeService verifyCodeService;
	
	@Autowired
	public CandidateValidateManager(CandidateDao candidateDao, UserDao userDao,
			VerifyApiService verifyApiService, VerifyCodeService verifyCodeService) {
		super();
		this.candidateDao = candidateDao;
		this.userDao = userDao;
		this.verifyApiService = verifyApiService;
		this.verifyCodeService = verifyCodeService;
	}

	@Override
	public Result verifyData(Candidate candidate) {
		if (!this.verifyApiService.IfUserRealPerson(candidate)) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (this.userDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Mail adresi zaten mevcut");
		}
		if (candidateDao.existsByIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu kimlik numarası sistemimizde zaten mevcut");
		}
		if (!candidate.getPassword().equals(candidate.getRepeatPassword())) {
			return new ErrorResult("Şifreler uyuşmuyor");
		}
		
		candidate.setVerify(true);
		this.candidateDao.save(candidate);
		this.verifyCodeService.createVerifyCode(userDao.getOne(candidate.getId())); // getOne -- doğrulama kodu
																					// oluşturmak için kullandık.
		this.verifyCodeService.sendMail(candidate.getEmail());
		return new SuccessResult("Kayıt başarılı");

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Listeleme başarılı");
	}

}
