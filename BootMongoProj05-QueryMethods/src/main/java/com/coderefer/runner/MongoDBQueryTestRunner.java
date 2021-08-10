package com.coderefer.runner;

import com.coderefer.service.ICustomerMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoDBQueryTestRunner implements CommandLineRunner {

    @Autowired
    private ICustomerMgmtService service;

    @Override
    public void run(String... args) throws Exception {
        service.getCustomersByCadd("Bglr").forEach(customer -> {
            System.out.println(customer.getCno() + " "
                    + customer.getCname() + " "
                    + customer.getCadd() + " "
                    + customer.getBillAmt() + " "
                    + customer.getMobileNo());
        });
        service.getCustomersByCaddAndCname("Bglr", "Krishna").forEach(customer -> {
            System.out.println(customer.getCno() + " "
                    + customer.getCname() + " "
                    + customer.getCadd() + " "
                    + customer.getBillAmt() + " "
                    + customer.getMobileNo());
        });
        service.getCustomersByCaddOrCname("Hyd", "Krishna").forEach(
                customer ->
                        System.out.println(customer.getCno() + " "
                                + customer.getCname() + " "
                                + customer.getCadd() + " "
                                + customer.getBillAmt() + " "
                                + customer.getMobileNo()));
        System.out.println("################# get customers by Bill Amount Range ##################");
        service.getCustomersByBillAmtRange(0.0,5.0).forEach(
                customer ->
                        System.out.println(customer.getCno() + " "
                                + customer.getCname() + " "
                                + customer.getCadd() + " "
                                + customer.getBillAmt() + " "
                                + customer.getMobileNo()));
    }
}
