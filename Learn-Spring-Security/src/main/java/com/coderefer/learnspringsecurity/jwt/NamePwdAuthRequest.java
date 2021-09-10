package com.coderefer.learnspringsecurity.jwt;

import lombok.Data;

@Data
public class NamePwdAuthRequest {
    private String username;
    private String password;
}
