package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;

public interface ValidateService<T> { // buradaki T parametresi class olacaktır ör: Candidate 
	Result verifyData(T data); // Mernis sitemi ve diğer doğrulamalar bu fonksiyon sayesinde sağlanacak
	DataResult<List<T>> getAll();  // yollanan bir sınıfı listeleyeceğiz
}
