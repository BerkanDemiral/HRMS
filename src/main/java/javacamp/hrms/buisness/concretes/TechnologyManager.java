package javacamp.hrms.buisness.concretes;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import javacamp.hrms.buisness.abstracts.TechnologyService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Technology;
@Service
@Component
public class TechnologyManager implements TechnologyService{

	@Override
	public Result add(Technology technology) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
