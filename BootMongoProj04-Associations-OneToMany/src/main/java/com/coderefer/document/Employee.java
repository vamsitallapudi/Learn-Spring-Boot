package com.coderefer.document;

import lombok.Getter;

@Getter
public class Employee {
    private String name;

    @Override
    public int hashCode() {
        return 1;
    }
}
