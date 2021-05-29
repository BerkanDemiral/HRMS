package javacamp.hrms.core.utilities.results;

public class SuccessResult extends Result { // true veya false parametreleri ile uğraşmak istemiyoruz, başarılı ise bu class'a yönlendirsin.
	public SuccessResult() { // işlem sonucu başarılı ama mesaj vermek istemiyor
		super(true);
	}
	
	public SuccessResult(String message) { // işlem başarılı ve mesaj göndermek istiyoruz. 
		super(true,message);
	}
}
