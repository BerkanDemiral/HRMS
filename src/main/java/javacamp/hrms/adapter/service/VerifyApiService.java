package javacamp.hrms.adapter.service;

public interface VerifyApiService<T> { // T değeri class anlamına gelmektedir. Ör: Candidate, User ... 
	boolean apiControl (T data);
}
