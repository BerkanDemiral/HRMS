package javacamp.hrms.buisness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javacamp.hrms.buisness.abstracts.GraduateService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.GraduateDao;
import javacamp.hrms.entities.concretes.Graduate;

@Service
@Component
public class GraduateManager implements GraduateService {

	private GraduateDao graduateDao;

	@Autowired
	public GraduateManager(GraduateDao graduateDao) {
		super();
		this.graduateDao = graduateDao;
	}

	@Override
	public Result add(Graduate graduate) {
		this.graduateDao.save(graduate);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(int graduateId,  String description) {
		Graduate updatedGraduate = new Graduate();
		if(!this.graduateDao.existsById(graduateId)) {
			return new ErrorResult("ID girdiğiniz mezun durumu sistemde mevcut değil");
		}
		updatedGraduate = this.graduateDao.getOne(graduateId);
		updatedGraduate.setDescription(description);
		
		return new SuccessResult("Güncelleme işlemi tamamlandı");
		
	}

	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>(this.graduateDao.findAll(), "Listeleme başarılı");
	}

}
