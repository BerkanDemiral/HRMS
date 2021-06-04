package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.CityService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.CityDao;
import javacamp.hrms.entities.concretes.City;
@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}


	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(), "Tüm şehirler listelendi.");
	}

}
