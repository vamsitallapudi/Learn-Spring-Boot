package com.coderefer.service;

import com.coderefer.document.Customer;

import java.util.List;

public interface ICustomerMgmtService {
    List<Customer> getCustomersByCadd(String addrs);
    List<Customer> getCustomersByCaddAndCname(String addr, String cname);
    List<Customer> getCustomersByCaddOrCname(String addr, String cname);
    List<Customer> getCustomersByBillAmtRange(double start, double end);
}
