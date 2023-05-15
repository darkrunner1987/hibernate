package org.example.repository;

import org.example.entity.Person;

public interface PersonRepository {
    Person get(int id);
}
