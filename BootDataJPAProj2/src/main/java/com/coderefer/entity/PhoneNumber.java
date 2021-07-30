package com.coderefer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_PHONENUMBER")
public class PhoneNumber implements Serializable {
    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "regno_seq", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long regNo;
    @NonNull
    private Long phoneNo;
    @Column(length = 20)
    @NonNull
    private String provider;
    @Column(length = 20)
    @NonNull
    private String type;
    @ManyToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PID") //FK Column
    private Person person; // for Many to One
}
