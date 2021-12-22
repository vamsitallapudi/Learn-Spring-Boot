package com.coderefer.runners;

import com.coderefer.service.ITouristMgmtService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyAppRunner implements CommandLineRunner {

    Logger logger = LogManager.getLogger(MyAppRunner.class.getName());
    @Autowired
    private ITouristMgmtService service;

    @Override
    public void run(String... args) throws Exception {
        logger.info(service.testAop());
    }
}
