package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.CityService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CityDao;
import javacamp.hrms.entities.concretes.City;
@Service
@Component
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}


	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(), "Tüm şehirler listelendi.");
	}


	@Override
	public Result add(City city) {
		this.cityDao.save(city);
		return new SuccessResult(city+ " Şehri eklendi");
	}

}
