package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javacamp.hrms.buisness.abstracts.SystemPersonnelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.SystemPersonnelDao;
import javacamp.hrms.dataAccess.abstracts.UserDao;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@Service
@Component
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;
	private UserDao userDao;

	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, UserDao userDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
		this.userDao = userDao;
	}


	@Override
	public DataResult<SystemPersonnel> getById(int id) {
		return new SuccessDataResult<SystemPersonnel>(this.systemPersonnelDao.getById(id));
	}

	@Override
	public DataResult<List<SystemPersonnel>> getAll() {

		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(), "Listeme başarılı");
	}

	@Override
	public Result verifySystemPersonnel(SystemPersonnel systemPersonnel) {
		if(userDao.existsByEmail(systemPersonnel.getEmail())) {
			return new ErrorResult("Bu mail adresi zaten mevcut");
		}
		else {
			this.systemPersonnelDao.save(systemPersonnel);
			return new SuccessResult(systemPersonnel.getFirstName() + " personeli sisteme kaydedildi");
		}
	}

}
