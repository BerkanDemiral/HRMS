package javacamp.hrms.buisness.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPostingDao;
import javacamp.hrms.entities.concretes.Employer;
import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;
@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao JobPostingDao;
	
	
	public JobPostingManager(javacamp.hrms.dataAccess.abstracts.JobPostingDao jobPostingDao) {
		super();
		JobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		Date now = new Date();
		if(jobPosting.getClosedDate().before(now)) {
			jobPosting.setActive(true);
			this.JobPostingDao.save(jobPosting);
			return new SuccessResult("İş ilanı başarı ile eklendi");
		}
		else {
			return new ErrorResult("Lütfen ilanın kapanış tarihini doğru giriniz");
		}
		

	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.JobPostingDao.delete(jobPosting);
		return new SuccessResult("İş ilanı başarı ile kaldırılmıştır");
	}
	

	@Override
	public DataResult<List<JobPostingDto>> getByIsActive(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingDto>> getByIsActiveOrderByClosedDate(boolean status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobPostingDto>> getByIsActiveAndEmployer_CompanyName(boolean status, String companyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result closeJobPosting(JobPosting jobPosting, Employer employer) {
		if(jobPosting.getEmployer().equals(employer)) {
			jobPosting.setActive(false);
			return new SuccessResult("İş ilanı pasif hale getirildi");
		}
		else {
			return new ErrorResult("Lütfen iş ilanını açan yönetici olarka giriş yapınız");
		}
		
	}

}
