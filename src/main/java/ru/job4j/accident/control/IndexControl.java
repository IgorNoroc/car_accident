package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {
        Collection<String> list = List.of("Привет", "меня зовут Игорь", "начал Spring", "и пока нифига толком не понимаю))");
        model.addAttribute("list",  list);
        return "index";
    }
}
