package com.coderefer.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Document
@Getter
@Setter
public class Player {
    @Id
    private Integer id;
    private String pname;
    private String paddrs;
    private String country;
    private Set<Sport> sports;
    private Map<String, Medal> medals;

    public Player() {
        System.out.println("Player :: 0-Param Constructor");
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", paddrs='" + paddrs + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
