package com.coderefer.entity;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Immutable
@AllArgsConstructor
@NoArgsConstructor
//@Table(name="CORONA_VACCINE") optional if we want different db table name
public class Employee implements Serializable{
	@Id //to make property as singular ID Property and to map with Singular PK Column
//	@Column(name="regNo") optional if you want different column name
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NonNull
	@Column(length = 20)
	private String company;
	@NonNull
	@Column(length = 20)
	private String firstname;
	@NonNull
	@Column(length = 20)
	private String lastname;
}
