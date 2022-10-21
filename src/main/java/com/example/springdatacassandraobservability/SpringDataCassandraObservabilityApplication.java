package com.example.springdatacassandraobservability;

import io.micrometer.observation.Observation;
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
	CommandLineRunner initData(EmployeeRepository repository, ObservationRegistry registry) { // <1>
		Observation observation = Observation.start("init-database", registry); // <2>
		try (Observation.Scope scope = observation.openScope()) { // <3>
			return args -> {
				repository.save(new Employee("1", "Frodo", "ring bearer"));
				repository.save(new Employee("2", "Bilbo", "burglar"));
			};
		} catch (Exception e) {
			observation.error(e); // <4>
			throw e;
		} finally {
			observation.stop(); // <5>
		}
	}
}
