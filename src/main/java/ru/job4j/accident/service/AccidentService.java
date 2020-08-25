package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccidentService {
    private final AccidentMem mem;

    public AccidentService(AccidentMem mem) {
        this.mem = mem;
    }

    public Map<Integer, Accident> getAllAccidents() {
        return mem.getAccidents();
    }

    public Collection<AccidentType> types() {
        return mem.getTypes();
    }

    public HashMap<Integer, Rule> rules() {
        return mem.getRules();
    }

    public void save(Accident accident) {
        mem.save(accident);
    }

    public Accident findById(int id) {
        return mem.getAccidents().get(id);
    }

    public void setRulesToAccident(Accident accident, String[] rules) {
        for (String id : rules) {
            accident.getRules().add(
                    Rule.of(
                            Integer.parseInt(id),
                            mem.getRules().get(Integer.valueOf(id)).getName()));
        }
    }
}
