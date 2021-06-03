package javacamp.hrms.buisness.validates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.ConfirmEmployerService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.buisness.abstracts.VerifyCodeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.Employer;
@Service
public class EmployerValidateManager implements ValidateService<Employer>{

	@Autowired
	private EmployerDao employerDao;
	private UserDao userDao;
	private VerifyCodeService verifyCodeService;
	private ConfirmEmployerService confirmEmployerService; // bizim şirketi onaylamamamız gerektiği için bunu da enject edip kullanıyoruz.
	
	
	
	public EmployerValidateManager(EmployerDao employerDao, UserDao userDao,
			VerifyCodeService verifyCodeService,
			ConfirmEmployerService confirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.verifyCodeService = verifyCodeService;
		this.confirmEmployerService = confirmEmployerService;
	}

	@Override
	public Result verifyData(Employer employer) {
		String[] splitMail = employer.getEmail().split("@"); // @'den öncesi ve sonrası olarak ikiye ayırıp diziye atıyoruz. (0.index öncesi, 1.index sonrası)
		if(!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult("Şirket uzantısına sahip bir mail adresi olmadığı için : KAYIT BAŞARISIZ");
			// info: şirketlerde -> technopat.com gibi bir web adresi varsa tüm çalışanların mail uzantısı da böyle olmalı (exchange mail)
		}
		if(this.userDao.existsByEmail(employer.getEmail()) == true) {
			return new ErrorResult("Mail adresi sistemde zaten mevcut");
		}
		if(employer.getPassword().equals(employer.getRepeatPassword()) == false) { // 2.kez girilen password ile eşleşmiyorsa
			return new ErrorResult("Şifreler uyuşmuyor");
		}
		
		this.employerDao.save(employer); // eğer iflerin içine girmediyse doğrulama tamam demektir..
		this.verifyCodeService.createVerifyCode(employer);
		this.confirmEmployerService.createConfirmEmployer(employer);
		this.verifyCodeService.sendMail(employer.getEmail());
		return new SuccessResult("Kayıt başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Tüm işverenler listelendi");
	}

}
