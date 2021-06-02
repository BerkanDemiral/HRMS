package javacamp.hrms.buisness.validates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

public class JobTitleValidateManager implements ValidateService<JobPosition> {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobTitleValidateManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result verifyData(JobPosition jobPosition) {
		if(jobPositionDao.existByPosition(jobPosition.getJobTitle())) {
			return new ErrorResult("Bu iş pozisyonu daha önce oluşturulmuş.");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(jobPosition.getJobTitle().toString() + " pozisyonu başarı ile kaydedildi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "Tüm pozisyonlar başarı ile listelendi");
	}

}
