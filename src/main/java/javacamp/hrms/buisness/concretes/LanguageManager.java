package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.LanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Language;

@Service
@Component
public class LanguageManager implements LanguageService{

	@Override
	public Result add(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Language>> getByResume_Id(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
