package javacamp.hrms.buisness.abstracts;


import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	Result add(City city);
}
