package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.JobPositionsService;
import javacamp.hrms.dataAccess.abstracts.JobPositionsDao;
import javacamp.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManage implements JobPositionsService {

	private JobPositionsDao jobPositionsDao;

	public JobPositionsManage(JobPositionsDao jobPositionsDao) {
		this.jobPositionsDao =  jobPositionsDao;
	}

	@Override
	public List<JobPositions> getAll() {
		return this.jobPositionsDao.findAll(); // her şeyi getir --> findall;
	}

}
