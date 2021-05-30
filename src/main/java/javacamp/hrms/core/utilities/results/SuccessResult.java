package javacamp.hrms.core.utilities.results;

public class SuccessResult extends Result { // true veya false parametreleri ile uğraşmak istemiyoruz, başarılı ise bu class'a yönlendirsin.
	public SuccessResult() {
		super(true);

	}

	public SuccessResult(String message) {
		super(true, message);
	
	}
}
