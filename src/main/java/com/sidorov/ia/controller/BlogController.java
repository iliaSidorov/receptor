package com.sidorov.ia.controller;

import com.sidorov.ia.enums.PageEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.sidorov.ia.enums.PageEnum.BLOG;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @GetMapping
    public String getBlogForm(Map<String, Object> model) {
        model.put("uInput", "");
        return BLOG.getName();
    }

    @PostMapping
    public String makeSomethingWithInput(@RequestParam String uInput,
                                         Map<String, Object> model) {

        String result = "";
        switch (uInput) {
            case "1":
                result = "Franz Kafka";
                break;
            case "2":
                result = "Ben Goor";
                break;
            case "3":
                result = "Tata";
                break;
            default:
                result = "You are fool";
                break;
        }
        model.put("uInput", result);
        return BLOG.getName();
    }
}
