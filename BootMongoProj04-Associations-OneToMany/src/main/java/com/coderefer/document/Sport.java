package com.coderefer.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Sport {

    private Long id;
    private String name;
    private boolean teamSport;
    private boolean olympicSport;
    private String[] kits;

    public Sport() {
        System.out.println("Sport:: 0-Param Constructor");
    }
}
