package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.WorkingTypeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingType")
@CrossOrigin
public class WorkingTypeController {

	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypeController(WorkingTypeService workingTypeService) {
		super();
		this.workingTypeService = workingTypeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingType>> getAll() {
		return workingTypeService.getAll();
	}
	
}
