package javacamp.hrms.buisness.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add(Resume resume);
	Result saveImage(MultipartFile file, int resumeId);
	DataResult<List<Resume>> getAll();
	DataResult<List<Resume>> findAllByCandidate_Id(int id);
	Result update(Resume resume);
}
