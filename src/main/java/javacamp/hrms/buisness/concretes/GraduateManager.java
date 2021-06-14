package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.GraduateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Graduate;
@Service
@Component
public class GraduateManager implements GraduateService{

	@Override
	public DataResult<List<Graduate>> gerAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(Graduate graduate) {
		// TODO Auto-generated method stub
		return null;
	}

}
