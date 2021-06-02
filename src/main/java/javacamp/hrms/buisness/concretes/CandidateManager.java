package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javacamp.hrms.buisness.abstracts.CandidateService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

@Service
@Component
public class CandidateManager implements CandidateService {

	private ValidateService<Candidate> validateService;
	
	@Autowired
	public CandidateManager(ValidateService<Candidate> validateService) {
		super();
		this.validateService = validateService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return validateService.getAll();
	}

	@Override
	public Result add(Candidate newCandidate) {
		return validateService.verifyData(newCandidate); // eğer doğrulama başarılı olursa onun içerisinde ekleme işlemi
															// gerçekleşecek.
	}

}
