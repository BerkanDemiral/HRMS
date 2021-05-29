package javacamp.hrms.core.utilities.results;

public class Result {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success = success;
	}
	public Result(boolean success,String message) {
		this(success); // tek parametreli olan cons çağırlır. this.. = .. yapmamıza gerek yok 
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public String getMessage() {
		return message;
	}
	
}
