package service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@GetMapping("/rest/employee/getAll")
	public String getEmployeeByID() {
		return "Hello multi module";
	}

}
