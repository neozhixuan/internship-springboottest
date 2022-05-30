package com.example.demo2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class Demo2Application {
	
	@RequestMapping("/docker")
	public ModelAndView home(@RequestParam(name="name", required = false) String name){
		Map<String, Object> model = new HashMap<>();
		model.put("name", name);
		return new ModelAndView("index", model);
	}
	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
	}

}
