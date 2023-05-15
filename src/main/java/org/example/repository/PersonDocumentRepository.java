package org.example.repository;

import org.example.entity.Document;
import org.example.entity.Person;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public interface PersonDocumentRepository {
    Map<Person, List<Document>> getAllPersonDocuments(OffsetDateTime expireBefore, String docNumberLike);
}
