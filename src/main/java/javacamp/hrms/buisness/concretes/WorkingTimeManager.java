package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.WorkingTimeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.WorkingTimeDao;
import javacamp.hrms.entities.concretes.WorkingTime;

@Service
@Component
public class WorkingTimeManager implements WorkingTimeService{

	private WorkingTimeDao workingTimeDao;
	
	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(), "Listeleme başarılı");
	}



	
}
