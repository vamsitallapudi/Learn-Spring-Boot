package com.coderefer.learnconcepts.fillingHashcode;

import java.util.Objects;

public class Employee {


    public void check(Integer a) {
        System.out.println("calling integer");
    }
    public void check(String b) {
        System.out.println("calling string");
    }

    String name;
    int id;

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!Objects.equals(name, employee.name)) return false;
        return true;
    }
}
