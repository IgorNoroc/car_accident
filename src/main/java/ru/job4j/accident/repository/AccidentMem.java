package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;

@Repository
public class AccidentMem {
    private HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident(1, "item1", "desc1", "addresA"));
        accidents.put(2, new Accident(2, "item2", "desc2", "addresB"));
        accidents.put(3, new Accident(3, "item3", "desc3", "addresC"));
        accidents.put(4, new Accident(4, "item4", "desc4", "addresD"));
    }

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

    public void setAccidents(HashMap<Integer, Accident> accidents) {
        this.accidents = accidents;
    }

}
