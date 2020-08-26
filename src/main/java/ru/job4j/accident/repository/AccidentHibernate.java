package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.List;


public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            session.save(accident);
            session.getTransaction().commit();
            return accident;
        }
    }

    public Accident findAccidentById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Accident.class, id);
        }
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            session.createQuery("update Accident a set a.name= :newName where a.id= :fId")
                    .setParameter("newName", accident.getName())
                    .setParameter("fId", accident.getId()).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident")
                    .list();
        }
    }

    public Collection<AccidentType> getAllTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType")
                    .list();
        }
    }

    public Collection<Rule> getAllRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule")
                    .list();
        }
    }

    public Rule findRuleById(int id) {
        try (Session session = sf.openSession()) {
            return session.get(Rule.class, id);
        }
    }
}
