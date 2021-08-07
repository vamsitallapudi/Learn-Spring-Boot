package com.coderefer.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Person {
    @Id
    private Integer pid;
    private String pname;
    private String padd;
    private DrivingLicense drivingLicense; //HAS-A Property

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", padd='" + padd + '\'' +
                '}';
    }

    public Person() {
        System.out.println("person constructor");
    }
}
