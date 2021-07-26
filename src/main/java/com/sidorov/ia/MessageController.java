package com.sidorov.ia;

import com.sidorov.ia.domain.Message;
import com.sidorov.ia.enums.PageEnum;
import com.sidorov.ia.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static com.sidorov.ia.enums.PageEnum.MAIN;
import static com.sidorov.ia.enums.PageEnum.MESSAGE;


@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name = "name", required = true, defaultValue = "World") String family, Map<String, Object> model) {
        model.put("family", family);
        return "greeting";
    }

    @GetMapping
    public String messages(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return MESSAGE.getName();
    }

    @PostMapping
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return MESSAGE.getName();
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,
                         Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }

        model.put("messages", messages);
        return MESSAGE.getName();
    }
}
