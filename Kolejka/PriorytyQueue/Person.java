package ProjectWithScanner.Odc40_ProjectSolution_Scanner;

import java.util.Objects;

public class Person {

    private final String name;
    private final String surName;
    private final Integer counter;
    private Boolean vip;
    private final String id;


    public Person(String name, String surName, Integer counter) {
        this(name, surName, counter, false);
    }

    public Person(String name, String surName, Integer counter, Boolean vip) {
        this.name = name;
        this.surName = surName;
        this.vip = vip;
        this.counter = counter;
        this.id = generatedId();
    }

    private String generatedId() {


        return this.vip
                ? String.format("%s_%s_VIP%s", this.name, this.surName, this.counter)
                : String.format("%s_%s_%s", this.name, this.surName, this.counter);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(surName, person.surName) && Objects.equals(counter, person.counter) && Objects.equals(vip, person.vip) && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
