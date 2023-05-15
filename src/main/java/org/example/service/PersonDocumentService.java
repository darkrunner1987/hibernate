package org.example.service;

import org.example.entity.Document;
import org.example.entity.Person;
import org.example.repository.PersonDocumentRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PersonDocumentService {
    private final PersonDocumentRepository personDocumentRepository;

    public PersonDocumentService(PersonDocumentRepository personDocumentRepository) {
        this.personDocumentRepository = personDocumentRepository;
    }

    public Map<Person, List<Document>> getPersonActiveDocumentsWith777() {
        return personDocumentRepository.getAllPersonDocuments(OffsetDateTime.now(), "777");
    }
}
