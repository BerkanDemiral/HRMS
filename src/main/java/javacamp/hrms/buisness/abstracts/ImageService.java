package javacamp.hrms.buisness.abstracts;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.Result;

public interface ImageService {
	Result add(MultipartFile file, int resumeId);
}
