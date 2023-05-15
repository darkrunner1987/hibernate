package org.example.repository;

import org.example.entity.Document;

public interface DocumentRepository {
    Document get(long id);
}
