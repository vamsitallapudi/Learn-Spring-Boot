package com.coderefer.service;

import com.coderefer.document.Customer;
import com.coderefer.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService{
    @Autowired
    private ICustomerRepo repo;
    @Override
    public List<Customer> getCustomersByCadd(String addrs) {
        return repo.getCustomersDataByCadd(addrs);
    }

    @Override
    public List<Customer> getCustomersByCaddAndCname(String addr, String cname) {
        return repo.getCustomersDataByCaddAndName(addr, cname);
    }

    @Override
    public List<Customer> getCustomersByCaddOrCname(String addr, String cname) {
        return repo.getCustomersDataByCaddOrName(addr, cname);
    }

    @Override
    public List<Customer> getCustomersByBillAmtRange(double start, double end) {
        return repo.getCustomersDataByBillAmtRange(start, end);
    }
}
