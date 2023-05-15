package org.example.repository;

import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DefaultPersonRepository implements PersonRepository {

    private final SessionFactory sessionFactory;

    public DefaultPersonRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public Person get(int id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Person.class, id);
        }
    }
}
