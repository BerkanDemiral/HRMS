package javacamp.hrms.buisness.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPostingService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPostingDao;
import javacamp.hrms.entities.concretes.JobPosting;
import javacamp.hrms.entities.dtos.JobPostingDto;


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


	
	private boolean checkIfNullField(JobPosting jobPosting) {
		if(jobPosting.getJobPosition() != null && jobPosting.getCity() == null) {
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.findAll(),"Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobPostingDto>> getByIsActive() {
		List<JobPosting> jobs =	this.JobPostingDao.getByIsActive(true);
		List<JobPostingDto> jobPostingDtos = new ArrayList<JobPostingDto>();
			
			for (JobPosting jobPosting : jobs) {
				for (JobPostingDto jobPostingDto : jobPostingDtos) {
					jobPostingDto.setJobPositionPosition(jobPosting.getJobPosition().getPosition());		
					jobPostingDto.setCreatedDate(jobPosting.getCreatedDate());
					jobPostingDto.setClosedDate(jobPosting.getClosedDate());
				}
			}
		return new SuccessDataResult<List<JobPostingDto>>(jobPostingDtos, "Listeleme başarılı");
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
		Sort sort = Sort.by(Sort.Direction.DESC,"closedDate");
		return new SuccessDataResult<List<JobPosting>>(this.JobPostingDao.findAll(sort),"Listeleme başarılı");
	}

	@Override
	public DataResult<List<JobPostingDto>> getByEmployer_EmployerId(int employerId) {
		List<JobPosting> jobs =	this.JobPostingDao.getByIsActive(true);
		List<JobPostingDto> jobPostingDtos = new ArrayList<JobPostingDto>();
			
			for (JobPosting jobPosting : jobs) {
				for (JobPostingDto jobPostingDto : jobPostingDtos) {
					jobPostingDto.setJobPositionPosition(jobPosting.getJobPosition().getPosition());		
					jobPostingDto.setCreatedDate(jobPosting.getCreatedDate());
					jobPostingDto.setEmployerCompanyName(jobPosting.getEmployer().getCompanyName());
					jobPostingDto.setClosedDate(jobPosting.getClosedDate());
				}
			}
		return new SuccessDataResult<List<JobPostingDto>>(jobPostingDtos, "Listeleme başarılı");
	}



}
