package javacamp.hrms.buisness.abstracts;
import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Graduate;

public interface GraduateService {
	DataResult<List<Graduate>> getAll();
	Result add(Graduate graduate);
	Result update(int graduateId,  String description);
}
