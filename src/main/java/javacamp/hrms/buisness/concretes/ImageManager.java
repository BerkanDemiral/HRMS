package javacamp.hrms.buisness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.buisness.abstracts.ImageService;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.ImageDao;

public class ImageManager implements ImageService{

	private ImageDao imageDao;
	
	
	@Autowired
	public ImageManager(ImageDao imageDao) {
		super();
		this.imageDao = imageDao;
	}

	@Override
	public Result add(MultipartFile file, int resumeId) {
		return null;
	}

	@Override
	public Result delete(int imageId) {
		this.imageDao.delete(this.imageDao.getOne(imageId));
		return new SuccessResult("Silme işlemi başarılı");
	}
	
	
}
