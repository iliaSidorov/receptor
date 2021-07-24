package com.sidorov.ia;

import com.sidorov.ia.enums.PageEnum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.sidorov.ia.enums.PageEnum.MAIN;


@Controller
public class GreetingsController {

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name = "name", required = true, defaultValue = "World") String family, Map<String, Object> model) {
        model.put("family", family);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("greeting", "Welcome to Receptor+");
        return MAIN.getName();
    }
}
