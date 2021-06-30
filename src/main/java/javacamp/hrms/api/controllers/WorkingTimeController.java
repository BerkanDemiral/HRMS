package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.buisness.abstracts.WorkingTimeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingTime")
@CrossOrigin
public class WorkingTimeController {

	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimeController(WorkingTimeService workingTimeService) {
		super();
		this.workingTimeService = workingTimeService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll() {
		return this.workingTimeService.getAll();
	}
	
}
