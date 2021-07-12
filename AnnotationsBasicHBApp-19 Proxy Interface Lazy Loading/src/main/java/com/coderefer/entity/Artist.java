package com.coderefer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ARTIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamicInsert()
@Proxy(lazy = true, proxyClass = IArtist.class)
public class Artist implements IArtist, Serializable {
    @Id
    @Column
    private Integer aid;
    @Column(name="NAME", length = 15)
    private String name;
    @Column(name = "ADDRS")
    private String addrs;
    @Column(name = "MobileNo")
    private Long mobileNo;
    @Transient
    @Column(name = "CATEGORY", length = 15)
    private String category;
}
