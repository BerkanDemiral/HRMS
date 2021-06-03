package javacamp.hrms.adapter.api;

import org.springframework.stereotype.Service;

import javacamp.hrms.adapter.service.VerifyApiService;
import javacamp.hrms.entities.concretes.Candidate;


@Service
public class MernisAdapter implements VerifyApiService { // Fake mernis adapter :/ 
	
	@Override
	public boolean IfUserRealPerson(Candidate candidate) {
		if(!candidate.getFirstName().isEmpty() && !candidate.getLastName().isEmpty() 
				&& !candidate.getBirthDate().isEmpty() && !candidate.getIdentityNumber().isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
