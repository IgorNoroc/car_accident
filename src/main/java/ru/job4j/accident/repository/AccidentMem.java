package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    public HashMap<Integer, AccidentType> types = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(1);

    public AccidentMem() {
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
    }

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
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

