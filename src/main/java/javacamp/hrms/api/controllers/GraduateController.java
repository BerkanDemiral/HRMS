package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.GraduateService;

@RestController
@RequestMapping("/api/graduate")
public class GraduateController {
	
	private GraduateService graduateService;

	@Autowired
	public GraduateController(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
	
	
}
