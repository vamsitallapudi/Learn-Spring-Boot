package com.coderefer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;
import org.hibernate.annotations.Immutable;

@Data
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
//@Table(name="CORONA_VACCINE") optional if we want different db table name
public class CoronaVaccine implements Serializable{
	@Id //to make property as singular ID Property and to map with Singular PK Column
//	@Column(name="regNo") optional if you want different column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long regNo;
	@NonNull
	@Column(length = 20)
	private String name;
	@NonNull
	@Column(length = 20)
	private String company;
	@NonNull
	@Column(length = 20)
	private String country;
	@NonNull
	private Double price;
	@NonNull
	private Integer requiredDoseCount;
}
