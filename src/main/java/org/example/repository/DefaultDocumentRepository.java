package org.example.repository;

import org.example.entity.Document;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DefaultDocumentRepository implements DocumentRepository {
    private final SessionFactory sessionFactory;

    public DefaultDocumentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public Document get(long id) {
        try (var session = sessionFactory.openSession()) {
            return session.get(Document.class, id);
        }
    }
}
