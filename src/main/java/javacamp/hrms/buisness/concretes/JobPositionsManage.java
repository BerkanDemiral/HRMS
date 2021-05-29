package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPositionsService;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionsManage implements JobPositionsService {

	private JobPositionDao jobPositionsDao;

	public JobPositionsManage(JobPositionDao jobPositionsDao) {
		this.jobPositionsDao =  jobPositionsDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionsDao.findAll(); // her şeyi getir --> findall;
	}

}
