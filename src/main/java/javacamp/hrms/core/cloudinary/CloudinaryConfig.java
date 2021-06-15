package javacamp.hrms.core.cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javacamp.hrms.core.cloudinary.api.CloudinaryManager;
import javacamp.hrms.core.cloudinary.service.CloudinaryService;


@Configuration
public class CloudinaryConfig {
	
	@Value("${cld.access-key}")
	String apiKey;
	
	@Value("${cld.secret-key}")
	String apiSercetKey;
	
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dkua99dn1",
				"api_key", "686172137193984",
				"api_secret", "IhjZzFHNvaWCvf-oXVI2CEmvpCA"));
	}
	

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
}
