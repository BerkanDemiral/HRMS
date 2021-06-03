package javacamp.hrms.adapter.service;

import javacamp.hrms.entities.concretes.Candidate;

public interface VerifyApiService { // T değeri class anlamına gelmektedir. Ör: Candidate, User ... 
	public boolean IfUserRealPerson(Candidate candidate	);
}
