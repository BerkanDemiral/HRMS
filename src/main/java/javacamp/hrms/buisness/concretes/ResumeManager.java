package javacamp.hrms.buisness.concretes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.buisness.abstracts.ResumeService;
import javacamp.hrms.core.cloudinary.service.CloudinaryService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ResumeDao;
import javacamp.hrms.entities.concretes.Resume;

@Service
@Component
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;

	}

	@Override
	public Result add(Resume resume) {
		Date date = new Date();
		resume.setCreatedDate(date);
		this.resumeDao.save(resume);
		return new SuccessResult("Resume ekleme işlemi başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(), "Listeleme işlemi başarılı");
	}

	@Override
	public DataResult<List<Resume>> findAllByCandidate_Id(int id) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAllByCandidate_Id(id), "Listeleme işlemi başarılı");
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) 
				cloudinaryService.save(file).getData(); 
		String imageUrl= uploader.get("url");
		Resume resume = resumeDao.getOne(resumeId);
		resume.setImage(imageUrl);
		resumeDao.save(resume);
		return new SuccessResult("Kayıt Başarılı");
		
	}

	@Override
	public Result update(int resumeId, String linkedinLink, String githubLink) {
		Resume updatedResume = this.resumeDao.getOne(resumeId);
		updatedResume.setGithubLink(githubLink);
		updatedResume.setLinkedinLink(linkedinLink);
		this.resumeDao.save(updatedResume);
		return new SuccessResult("Github ve Linkedin Linkleri güncellendi");
	}

	@Override
	public Result updateLinkedin(int resumeId, String linkedinLink) {
		Resume updatedResume = this.resumeDao.getOne(resumeId);
		updatedResume.setLinkedinLink(linkedinLink);
		this.resumeDao.save(updatedResume);
		return new SuccessResult("Linkedin Linki güncellendi");
	}

	@Override
	public Result updateGithub(int resumeId, String githubLink) {
		Resume updatedResume = this.resumeDao.getOne(resumeId);
		updatedResume.setGithubLink(githubLink);
		this.resumeDao.save(updatedResume);
		return new SuccessResult("Github Linki güncellendi");
	}

	@Override
	public DataResult<Resume> findById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.findById(id), "Listeleme başarılı");
	}

}
