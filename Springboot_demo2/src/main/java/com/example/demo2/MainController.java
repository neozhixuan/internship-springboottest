package com.example.demo2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    // @ResponseBody
    // public String index(){
    //     return "my quick blog";
    // }
    @RequestMapping("/")
    public ModelAndView index(@RequestParam(name="name", required = false) String name){
        Map<String, Object> model = new HashMap<>();
        model.put("name", name);
        return new ModelAndView("/index", model);
    }
}
