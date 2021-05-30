package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.CandidateService;
import javacamp.hrms.buisness.abstracts.ValidateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private ValidateService<Candidate> validateService;
	
	@Autowired
	public CandidateManager(ValidateService<Candidate> validateService) {
		super();
		this.validateService= validateService;
	}
	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.validateService.getAll();
	}

	@Override
	public Result add(Candidate newCandidate) {
		return this.validateService.verifyData(newCandidate);
	}

}
