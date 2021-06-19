package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.Result;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll(); // tüm employer'leri listeleyeceğiz 
	Result add(Employer employer); // employer ekleme işlemi yapılacak -- gerekli validate parametrelerine göre 
	DataResult<Employer> getById(int id);
}
