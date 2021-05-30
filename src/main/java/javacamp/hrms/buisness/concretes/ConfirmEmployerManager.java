package javacamp.hrms.buisness.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.buisness.abstracts.ConfirmEmployerService;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ConfirmEmployerDao;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.entities.concretes.ConfirmEmployer;
import javacamp.hrms.entities.concretes.Employer;
@Service
public class ConfirmEmployerManager implements ConfirmEmployerService{

	private ConfirmEmployerDao confirmEmployerDao;
	private EmployerDao employerDao;
	
	
	@Autowired	
	public ConfirmEmployerManager(ConfirmEmployerDao confirmEmployerDao,
			EmployerDao employerDao) {
		super();
		this.confirmEmployerDao = confirmEmployerDao;
		this.employerDao = employerDao;
	}

	@Override
	public void createConfirmEmployer(Employer employer) {
		ConfirmEmployer confirmEmployer = new ConfirmEmployer();
		confirmEmployer.setEmployer(employer); // @OneToOne olarak belirttiğimiz Employer employer referansına, parametre olarak yolladığımız değeri atıyoruz.
		confirmEmployer.setSystem_personnel(1);
		this.confirmEmployerDao.save(confirmEmployer);
		
	}

	@Override
	public Result confirmUser(String companyName) {
		if(!employerDao.existByCompanyName(companyName)) {
			return new ErrorResult("Şirket kaydı bulunamadı.");
		}
		if(employerDao.getByCompanyName(companyName).isUserConfirm()) {
			return new ErrorResult("Bu şirket ismi daha önce onaylanmış");
		}
		
		Employer employer = new Employer();
		ConfirmEmployer confirmEmployer = new ConfirmEmployer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setUserConfirm(true);
		employerDao.save(employer);
		
		confirmEmployer = confirmEmployerDao.getByEmployerId(employer.getId());
		confirmEmployer.setConfirmed(true);
		
		LocalDate date = (LocalDate.now());
		confirmEmployer.setConfirmedDate(Date.valueOf(date));
		confirmEmployerDao.save(confirmEmployer);
		
		return new SuccessResult("Doğrulama başarılı");
		
	}

}
