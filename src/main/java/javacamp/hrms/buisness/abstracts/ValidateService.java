package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;

public interface ValidateService<T> { // yollanan sınıfa göre validasyon işlemleri gerçekleştirilecek. Bu sayede birden çok manager sınıfı tanımlanıp kullanılabilir.
	Result verifyData(T data);
	DataResult<List<T>> getAll(); // artık değerleri boolean yerine result ile döndürdüğümüz için, direkt validasyon işlemi 
							// ile bu listelemeyi bir anda bitirip mesaj vereceğiz.
	
}
