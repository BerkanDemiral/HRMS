package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	Result verifySystemPersonnel(SystemPersonnel systemPersonnel);
	DataResult<SystemPersonnel> getById(int id);
	DataResult<List<SystemPersonnel>> getAll();
}
