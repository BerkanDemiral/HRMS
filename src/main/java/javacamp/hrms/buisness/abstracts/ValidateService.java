package javacamp.hrms.buisness.abstracts;

import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import javacamp.hrms.core.utilities.results.DataResult;

public interface ValidateService<T> { // buradaki T parametresi class olacaktır ör: Candidate 
	Result verifyData(T data); 
	DataResult<List<T>> getAll(); 
}
