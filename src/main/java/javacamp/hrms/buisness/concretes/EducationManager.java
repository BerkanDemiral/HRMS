package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.EducationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EducationDao;
import javacamp.hrms.entities.concretes.Education;

@Service
@Component
public class EducationManager implements EducationService{
	
	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		this.educationDao = educationDao;
	}
	
	
	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("Kayıt ekleme işlemi başarılı");
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Veriler listelendi");
	}

	@Override
	public DataResult<List<Education>> sortOrderByEndedDateDesc(int resumeId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "endedDate");
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll(sort),"Listeleme başarılı");
	}

}
