package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(1);

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
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

