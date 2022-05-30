package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//To convince yourself that the context is creating your controller

@SpringBootTest
public class SmokeTest {
    //Spring interprets the @Autowired annotation, and the controller
    // is injected before the test methods are run
	@Autowired
	private MainController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}