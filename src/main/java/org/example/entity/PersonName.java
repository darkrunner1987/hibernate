package org.example.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PersonName {
    private String firstName;
    private String lastName;
    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonName that = (PersonName) o;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, secondName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(lastName).append(' ');
        sb.append(firstName).append(' ');
        sb.append(secondName);
        return sb.toString();
    }
}
