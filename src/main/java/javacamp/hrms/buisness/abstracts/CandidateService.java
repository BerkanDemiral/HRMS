package javacamp.hrms.buisness.abstracts;

import java.util.List;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll(); // tüm candidate bilgilerini getirir.
	Result add(Candidate candidate); // parametre olarak yollanan candidate kişisini ekler. -- error veya success kullanarak farklı işlemler yapılabilecek
	
}
