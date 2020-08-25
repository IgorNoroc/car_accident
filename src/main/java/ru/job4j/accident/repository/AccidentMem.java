package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    public HashMap<Integer, AccidentType> types = new HashMap<>();
    private HashMap<Integer, Rule> rules = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(1);

    public AccidentMem() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
    }

    public HashMap<Integer, Rule> getRules() {
        return rules;
    }

    public void save(Accident accident) {
        if (accident.getId() != 0) {
            update(accident);
        } else {
            accident.setId(id.incrementAndGet());
            accidents.put(id.get(), accident);
        }
    }

    public void update(Accident accident) {
        accidents.put(accident.getId(), accident);
    }
}

