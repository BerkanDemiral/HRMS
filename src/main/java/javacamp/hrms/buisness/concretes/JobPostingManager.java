package javacamp.hrms.buisness.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPostingDao;
import javacamp.hrms.entities.concretes.JobPosting;


@Service
@Component
public class JobPostingManager implements JobPostingService {

	private JobPostingDao JobPostingDao;

	@Autowired
	public JobPostingManager(javacamp.hrms.dataAccess.abstracts.JobPostingDao jobPostingDao) {
		super();
		JobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if(!checkIfNullField(jobPosting)) {
			//return new ErrorResult("Lütfen boş değer bırakmayınız");
			this.JobPostingDao.save(jobPosting);
			return new SuccessResult("İş ilanı başarı ile eklendi");
			
		}
		this.JobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarı ile eklendi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.JobPostingDao.save(jobPosting);
		return new SuccessResult("Güncelleme işlemi başarı ile tamamlandı");
	}

	@Override
	public Result delete(int id) {
		this.JobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı kaldırıldı");
	}

	@Override
	public Result closeJobPosting(int jobPostingId) {
		JobPosting jobPosting = new JobPosting();
		jobPosting = this.JobPostingDao.getOne(jobPostingId);
		jobPosting.setActive(false);
		this.JobPostingDao.save(jobPosting);
		return new SuccessResult("Seçilen iş ilanı pasif hale getirildi ve kaydedildi");
		
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.JobPostingDao.getById(id));
	}
	
	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.findAll(), "İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAllIsActiveJobPostings() {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.getAllIsActiveJobPostings());
	}

	@Override
	public DataResult<List<JobPosting>> getAllIsActiveJobPostingsOrderBayClosedDateAsc() {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.getAllIsActiveJobPostingsOrderBayClosedDateAsc());
	}

	@Override
	public DataResult<List<JobPosting>> getAllIsActiveJobPostingsByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.getAllIsActiveJobPostingsByEmployer(id));
	}
	
	private boolean checkIfNullField(JobPosting jobPosting) {
		if(jobPosting.getJobPosition() != null && jobPosting.getCity() == null) {
			return true;
		}
		return false;
	}



}
