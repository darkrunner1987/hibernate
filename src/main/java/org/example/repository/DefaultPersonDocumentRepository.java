package org.example.repository;

import org.example.entity.Document;
import org.example.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DefaultPersonDocumentRepository implements PersonDocumentRepository {
    private final SessionFactory sessionFactory;

    public DefaultPersonDocumentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public Map<Person, List<Document>> getAllPersonDocuments(OffsetDateTime expireBefore, String docNumberLike) {
        try (var session = sessionFactory.openSession()) {
            var query = session.createQuery(
                    "select d " +
                            "from Document d " +
                            "join fetch d.person p " +
                            "where d.expirationDate >= :expireBefore and d.number like :docNumberLike",
                    Document.class);
            query.setParameter("expireBefore", expireBefore);
            query.setParameter("docNumberLike", "%" + docNumberLike + "%");
            try (var stream = query.getResultStream()) {
                return stream.collect(Collectors.groupingBy(Document::getPerson));
            }
        }
    }
}
