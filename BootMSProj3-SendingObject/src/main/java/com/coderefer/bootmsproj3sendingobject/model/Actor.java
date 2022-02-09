package com.coderefer.bootmsproj3sendingobject.model;

import java.io.Serializable;

public class Actor implements Serializable {
    String name;
    int age;
    String type;

    public Actor(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
