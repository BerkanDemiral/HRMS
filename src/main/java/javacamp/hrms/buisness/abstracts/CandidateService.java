package javacamp.hrms.buisness.abstracts;

import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll(); // tüm candidate bilgilerini getirir.
	Result add(Candidate candidate); // parametre olarak yollanan candidate kişisini ekler.
}
