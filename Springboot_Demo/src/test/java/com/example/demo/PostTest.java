package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// Modeled after HttpRequestTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostTest {
    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
    
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + "body" + "/" + "title",
				String.class)).contains("\"title\":\"body\",\"body\":\"title\"");
	}
}
