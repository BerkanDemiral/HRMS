package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.ResumeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Resume;

@Service
@Component
public class ResumeManager implements ResumeService{

	@Override
	public Result add(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Resume>> findAllByCandidate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
