package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add(Resume resume);
	DataResult<List<Resume>> getAll();
	DataResult<List<Resume>> findAllByCandidate(int id);
}
