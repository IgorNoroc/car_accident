package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.List;

//@Repository
//public class AccidentJdbcTemplate {
//    private final JdbcTemplate jdbc;
//
//    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public Accident save(Accident accident) {
//        jdbc.update("insert into accident (name, text, address, accident_type) values (?, ?, ?, ?)",
//                accident.getName(),
//                accident.getText(),
//                accident.getAddress(),
//                accident.getType().getId());
//        return accident;
//    }
//
//    public void update(Accident accident) {
//        jdbc.update( "update accident set name = ? where id = ?",
//                accident.getName(),
//                accident.getId());
//    }
//
//    public Accident findAccidentById(int id) {
//        return jdbc.queryForObject(
//                "select id, name, text, address, accident_type from accident where id = ?",
//                (resultSet, rowNum) -> {
//                    Accident acc = new Accident(
//                            resultSet.getString("name"),
//                            resultSet.getString("text"),
//                            resultSet.getString("address"),
//                            getTypeById(resultSet.getInt("accident_type")));
//                    acc.setId(resultSet.getInt("id"));
//                    return acc;
//                },
//                id);
//    }
//
//    public AccidentType getTypeById(int id) {
//        return jdbc.queryForObject(
//                "select id, name from types where id = ?",
//                (resultSet, rowNum) -> AccidentType.of(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name")),
//                id);
//    }
//
//    public List<Accident> getAll() {
//        return jdbc.query("select id, name, text, address, accident_type from accident",
//                (rs, row) -> {
//                    Accident accident = new Accident(
//                            rs.getString("name"),
//                            rs.getString("text"),
//                            rs.getString("address"),
//                            getTypeById(rs.getInt("accident_type")));
//                    accident.setId(rs.getInt("id"));
//                    return accident;
//                });
//    }
//
//    public Collection<AccidentType> getTypes() {
//        return jdbc.query("select id, name from types",
//                (rs, row) -> AccidentType.of(
//                        rs.getInt("id"),
//                        rs.getString("name")));
//    }
//
//    public Collection<Rule> getRules() {
//        return jdbc.query("select id, name from rules",
//                (rs, row) -> Rule.of(
//                        rs.getInt("id"),
//                        rs.getString("name")));
//    }
//}
