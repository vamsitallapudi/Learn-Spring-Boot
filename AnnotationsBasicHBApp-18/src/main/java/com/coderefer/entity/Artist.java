package com.coderefer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="ARTIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamicInsert()
@Proxy(lazy = true)
public class Artist implements Serializable {
    @Id
    @Column
    private Integer aid;
    @Column(name="NAME", length = 15)
    private String name;
    @Column(name = "ADDRS")
    private String addrs;
    @Column(name = "MobileNo")
    private Long mobileNo;
    @Column(name = "CATEGORY", length = 15)
    private String category;
}
