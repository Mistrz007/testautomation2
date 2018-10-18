package pl.mig.qa.api.model;

public class UserGeneric<T> {
    public T id;
    public String name;
    public String surname;

    public UserGeneric() {
    }

    public UserGeneric(T id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
