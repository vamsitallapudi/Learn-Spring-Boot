package com.nt.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "REST_TOURIST")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tId;
    @Column(length = 20)
    @NonNull
    private String name;
    @Column(length = 20)
    @NonNull
    private String city;

    @Column(length = 20)
    @NonNull
    private String packageType;
    @NonNull
    private Double budget;
}
