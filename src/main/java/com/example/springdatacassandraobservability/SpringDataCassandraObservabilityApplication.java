package com.example.springdatacassandraobservability;

import io.micrometer.observation.ObservationRegistry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.observability.EnableCassandraObservability;

@SpringBootApplication
@EnableCassandraObservability
public class SpringDataCassandraObservabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataCassandraObservabilityApplication.class, args);
	}

	// Pre-load data
	@Bean
	CommandLineRunner initData(EmployeeRepository repository, ObservationRegistry registry) {
		return args -> {
			repository.save(new Employee("1", "Frodo", "ring bearer"));
			repository.save(new Employee("2", "Bilbo", "burglar"));
		};
	}
}
