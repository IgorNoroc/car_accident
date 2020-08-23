package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

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

    public void save(Accident accident) {
        mem.create(accident);
    }

    public Accident findById(int id) {
        return mem.getAccidents().get(id);
    }

    public void update(Accident accident) {
        mem.update(accident);
    }
}
