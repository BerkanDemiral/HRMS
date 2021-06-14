package javacamp.hrms.buisness.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Technology;

public interface TechnologyService {
	Result add(Technology technology);
	DataResult<List<Technology>> getAll();
}
