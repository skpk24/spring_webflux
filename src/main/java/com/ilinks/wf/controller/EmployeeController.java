package com.ilinks.wf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilinks.wf.model.Employee;
import com.ilinks.wf.repo.EmployeeReactiveRepository;

import lombok.experimental.PackagePrivate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeReactiveRepository empRepo;
	
	@GetMapping
	public Flux<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Employee> getEmployee(@PathVariable String id){
		return empRepo.findById(id);
	}
	
	@GetMapping( value = "/events",produces = MediaType.TEXT_EVENT_STREAM_VALUE )
	public Flux<Employee> getEmpEvents(){
		return empRepo.findAll();
	}
}
