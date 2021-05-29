package javacamp.hrms.core.utilities.results;

public class ErrorResult extends Result {
	public ErrorResult() { // işlem sonucu başarılı ama mesaj vermek istemiyor
		super(false);
	}
	
	public ErrorResult(String message) { // işlem başarılı ve mesaj göndermek istiyoruz. 
		super(false,message);
	}
}
