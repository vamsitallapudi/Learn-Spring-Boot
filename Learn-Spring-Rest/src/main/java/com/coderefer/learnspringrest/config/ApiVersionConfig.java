package com.coderefer.learnspringrest.config;

public final class ApiVersionConfig {
    public static final String V1 = "v1";
    public static final String V2 = "v2";
    
    public static final String HEADER_API_VERSION = "X-API-Version";
    
    // Base paths
    public static final String API_BASE_PATH = "/api";
    public static final String V1_PATH = API_BASE_PATH + "/v1";
    public static final String V2_PATH = API_BASE_PATH + "/v2";
    
    private ApiVersionConfig() {
        // Private constructor to prevent instantiation
    }
} 