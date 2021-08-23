package com.coderefer.document;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Map<Employee, String> employees;

    @BeforeEach
    void setUp() {
        employees = new HashMap<>();
    }

    @Test
    void testIfEmployeeRecordsAreInserted() {
        employees.put(new Employee(), "1");
        employees.put(new Employee(), "2");
        employees.put(new Employee(), "3");
        employees.put(new Employee(), "4");
        System.out.println(employees.size());
        assertEquals(employees.size(), 4);
    }


}