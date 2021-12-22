package com.coderefer.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@AllArgsConstructor
public class ExceptionResp {
    //     time stamp
    private Date timeStamp;
    private String message;
    private String desc;
    public ExceptionResp() {
        log.info("test");
    }
}
