package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPositionService;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionsDao;

	public JobPositionManager(JobPositionDao jobPositionsDao) {
		this.jobPositionsDao =  jobPositionsDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionsDao.findAll(); // her şeyi getir --> findall;
	}

}
