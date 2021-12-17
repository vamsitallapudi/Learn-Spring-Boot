package com.nt.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "REST_TOURIST")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer tId;
    @NonNull
    String name;
}
