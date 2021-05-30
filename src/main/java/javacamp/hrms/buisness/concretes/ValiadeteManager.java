package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
@Service
public class ValiadeteManager<T> implements ValidateService<T>{

	@Override
	public Result verifyData(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<T>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
