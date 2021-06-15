package javacamp.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.TechnologyService;
@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

	private TechnologyService technologyService;

	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
}
