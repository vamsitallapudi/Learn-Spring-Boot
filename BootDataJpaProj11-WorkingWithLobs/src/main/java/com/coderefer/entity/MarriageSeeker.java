package com.coderefer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarriageSeeker implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @Column(length=20)
    private String name;
    @NonNull
    @Column(length=500)
    private String addrs;
    @NonNull
    @Lob
    private byte[] photo;
    @NonNull
    @Lob
    private char[] biodata;
    @NonNull
    @Lob
    private boolean isIndian;

}