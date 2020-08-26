package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentControl {
    private final AccidentRepository accidents;
    private final AccidentTypeRepository accidentTypeRepository;
    private final RuleRepository ruleRepository;

    public AccidentControl(AccidentRepository accidents, AccidentTypeRepository accidentTypeRepository, RuleRepository ruleRepository) {
        this.accidents = accidents;
        this.accidentTypeRepository = accidentTypeRepository;
        this.ruleRepository = ruleRepository;
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AccidentType> types = new ArrayList<>();
        List<Rule> rules = new ArrayList<>();
        accidentTypeRepository.findAll().forEach(types::add);
        ruleRepository.findAll().forEach(rules::add);
        model.addAttribute("types", types);
        model.addAttribute("rules", rules);
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.save(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("updateAccident", accidents.findById(id).get());
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident) {
        accidents.save(accident);
        return "redirect:/";
    }
}
