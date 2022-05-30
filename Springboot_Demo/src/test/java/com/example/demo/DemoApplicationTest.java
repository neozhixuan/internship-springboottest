// package com.example.demo;

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// // Take note that this is in src/test!!

// // Find @SpringBootApplication and start a Spring app context.
// @SpringBootTest
// class DemoApplicationTest {

// 	@Test
// 	void contextLoads() {
// 	}

// }



// Useful approach: to not start the server at all but to test only the layer below that, 
// where Spring handles the incoming HTTP request and hands it off to your controller.

// Your code will be called in exactly the same way as if it were processing a real 
// HTTP request but without the cost of starting the server
package com.example.demo;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTest {

	// MockMvc is a built in class in Spring
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}
}