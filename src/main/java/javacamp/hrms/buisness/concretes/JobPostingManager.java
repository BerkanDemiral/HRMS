package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
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
		if (!checkIfNullField(jobPosting)) {
			// return new ErrorResult("Lütfen boş değer bırakmayınız");
			this.JobPostingDao.save(jobPosting);
			return new SuccessResult("İş ilanı başarı ile eklendi");

		}
		this.JobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarı ile eklendi");
	}

	private boolean checkIfNullField(JobPosting jobPosting) {
		if (jobPosting.getJobPosition() != null && jobPosting.getCity() == null) {
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.findAll(), "Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getByIsActive() {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.getByIsActive(true), "Listeleme başarılı");

	}

	@Override
	public Result update(JobPosting jobPosting) {
		JobPosting updadetJobPosting = this.JobPostingDao.getOne(jobPosting.getId());
		updadetJobPosting.setActive(false);
		this.JobPostingDao.save(updadetJobPosting);
		return new SuccessResult("Güncelleme başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "closedDate");
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.findAll(sort), "Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.getByEmployer_Id(employerId), "Listeleme başarılı");
	}

	@Override
	public DataResult<JobPosting> changeStatus(int jobPostingId, boolean status, int employerId) {
		List<JobPosting> jobPosting = this.JobPostingDao.getByEmployer_Id(employerId);

		for (JobPosting jobPosting2 : jobPosting) {
			if (jobPostingId == jobPosting2.getId()) {
				jobPosting2.setActive(status);
				this.JobPostingDao.save(jobPosting2);
				return new SuccessDataResult<JobPosting>(this.JobPostingDao.getById(jobPostingId),
						"Listeleme başarılı");
			}
		}

		return new ErrorDataResult<>("Listeleme Başarısız");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(JobPostingDao.getById(id), "Listeleme başarılı");
	}

	@Override
	public DataResult<JobPosting> getByName(String name) {
		return new SuccessDataResult<JobPosting>(this.JobPostingDao.getByJobPosition_Position(name), "Başarılı");
	}

}
