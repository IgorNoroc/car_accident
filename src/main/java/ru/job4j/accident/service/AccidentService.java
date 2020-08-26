package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentHibernate;

import java.util.*;

//@Service
//public class AccidentService {
//    private final AccidentHibernate database;
//
//    public AccidentService(AccidentHibernate database) {
//        this.database = database;
//    }
//
//    public void save(Accident accident) {
//        database.save(accident);
//    }
//
//    public Collection<Accident> accidents() {
//        return database.getAll();
//    }
//
//    public Collection<AccidentType> types() {
//        return database.getAllTypes();
//    }
//
//    public Collection<Rule> rules() {
//        return database.getAllRules();
//    }
//
//    public Object findById(int id) {
//        return database.findAccidentById(id);
//    }
//
//    public void update(Accident accident) {
//        database.update(accident);
//    }
//
//    public void addRulesToAccident(Accident accident, String[] ids) {
//        for (String id : ids) {
//            Rule rule = database.findRuleById(Integer.parseInt(id));
//            accident.getRules().add(rule);
//        }
//    }
//}
