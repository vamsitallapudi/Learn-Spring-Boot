package com.coderefer.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Document
@Data
public class PersonDetails {
    @Id
    private Integer pid;
    private String pname;
    private String paddrs;
    private LocalDateTime dob;
    private boolean maritalStatus;
    private Set<Long> mobileNos;
    private String[] nickNames;
    private List<String> academics;
    private Map<String, Long> bankAccounts;
    private Properties idDetails;
}
