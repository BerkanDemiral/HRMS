package javacamp.hrms.core.cloudinary.api;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javacamp.hrms.core.cloudinary.service.CloudinaryService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorDataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryManager implements CloudinaryService {

	private Cloudinary cloudinary;

	public CloudinaryManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
            Map cloudinaryUploader = cloudinary.uploader()
            		.upload(file.getBytes()
            ,ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
