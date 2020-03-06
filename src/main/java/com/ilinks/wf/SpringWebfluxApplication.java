package com.ilinks.wf;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ilinks.wf.model.Employee;
import com.ilinks.wf.repo.EmployeeReactiveRepository;

@SpringBootApplication
public class SpringWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeReactiveRepository empRepo) {
		return args ->{
			empRepo.deleteAll().subscribe(null, null, ()->{
				List<Employee> employees = Stream.of(
						new Employee(UUID.randomUUID().toString(), "Pradeep", new BigDecimal("3000")),
						new Employee(UUID.randomUUID().toString(), "Kumar", new BigDecimal("3300")),
						new Employee(UUID.randomUUID().toString(), "Arun", new BigDecimal("4500")),
						new Employee(UUID.randomUUID().toString(), "Patil", new BigDecimal("65000")),
						new Employee(UUID.randomUUID().toString(), "Vinay", new BigDecimal("22000")),
						new Employee(UUID.randomUUID().toString(), "Jayraj", new BigDecimal("23000"))
					).collect(Collectors.toList());
				
				empRepo.saveAll(employees).subscribe(System.out::println);
				
			});
		};
	}

}
