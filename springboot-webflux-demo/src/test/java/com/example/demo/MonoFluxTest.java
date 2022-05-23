package com.example.demo;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

	@Test
	public void testMono() {
		Mono<?> monoString = Mono.just("Hello from mono")
				//.then(Mono.error(new RuntimeException("Exception occured")))
				.log();
		monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
	}

	@Test
	public void testFlux() {
		Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservices")
				.concatWithValues("AWS")
				//.concatWith(Flux.error(new RuntimeException("Exception occured")))
				.log();

		fluxString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
	}

}
