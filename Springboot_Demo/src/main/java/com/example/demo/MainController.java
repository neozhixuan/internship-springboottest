package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
	@RequestMapping("/")
    public ModelAndView index(@RequestParam(name = "name", required = false) String name){
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        return new ModelAndView("/index", model);

    }
}

