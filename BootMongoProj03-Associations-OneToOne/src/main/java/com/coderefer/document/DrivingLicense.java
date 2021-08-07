package com.coderefer.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class DrivingLicense {
    @Id
    private Long id;
    private String type;
    private LocalDateTime expiryDate;
    private Person person;

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

    public DrivingLicense() {
        System.out.println("driving license constructor");
    }
}
