package javacamp.hrms.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javacamp.hrms.buisness.abstracts.ConfirmEmployerService;
import javacamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/confirmEmployer")
public class ConfirmEmployerController {
	private ConfirmEmployerService confirmEmployerService;

	public ConfirmEmployerController(ConfirmEmployerService confirmEmployerService) {
		super();
		this.confirmEmployerService = confirmEmployerService;
	}
	
	@PutMapping("/{companyName}")
	public Result update (@PathVariable("companyName") String companyName) {
		return this.confirmEmployerService.confirmUser(companyName);
	}
}
