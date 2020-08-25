package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

import java.util.Collection;

@Service
public class AccidentService {
    private AccidentJdbcTemplate jdbc;

    public AccidentService(AccidentJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Accident accident) {
        jdbc.save(accident);
    }

    public void update(Accident accident) {
        jdbc.update(accident);
    }

    public Accident findById(int id) {
        return jdbc.findAccidentById(id);
    }

    public Collection<Accident> allAccidents() {
        return jdbc.getAll();
    }

    public Collection<AccidentType> allTypes() {
        return jdbc.getTypes();
    }

    public Collection<Rule> allRules() {
        return jdbc.getRules();
    }

    public AccidentType findTypeById(int id) {
        return jdbc.getTypeById(id);
    }
}
