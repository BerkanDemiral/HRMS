package javacamp.hrms.buisness.abstracts;

import javacamp.hrms.core.utilities.results.Result;

import javacamp.hrms.entities.concretes.Employer;

public interface ConfirmEmployerService {
	void createConfirmEmployer(Employer employer);
	Result confirmUser(String companyName); // employer kullanıcısının onaylanma işlemi 
}
