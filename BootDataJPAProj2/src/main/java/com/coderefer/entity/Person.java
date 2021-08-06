package com.coderefer.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OTM_PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pid;
    @Column
    @NonNull
    private String pname;
    @Column
    @NonNull
    private String addr;

    @OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", referencedColumnName ="PID")
    private Set<PhoneNumber> contactDetails;

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", addr='" + addr + '\'' +
                ", contactDetails=" + contactDetails +
                '}';
    }
}
