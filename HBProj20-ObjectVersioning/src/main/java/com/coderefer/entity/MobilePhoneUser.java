package com.coderefer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MobilePhoneUser {

    @Id
    @GeneratedValue
    private Long regId;

    private Integer updationsCount;
    @NonNull
    private Long mobileNo;

    @NonNull
    private Boolean prepaid;

    @NonNull
    private String circle;

    @NonNull
    private String callerTune;
}
