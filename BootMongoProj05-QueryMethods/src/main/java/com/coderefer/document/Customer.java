package com.coderefer.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Customer {
    @Id
    String cno;
    String cname;
    String cadd;
    String billAmt;
    String mobileNo;
}
