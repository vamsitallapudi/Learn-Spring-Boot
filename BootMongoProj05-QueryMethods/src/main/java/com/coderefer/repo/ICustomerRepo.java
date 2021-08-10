package com.coderefer.repo;

import com.coderefer.document.Customer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICustomerRepo extends CrudRepository<Customer, String> {

    @Query(fields = "{cno:1, cname:1,cadd:1}",value = "{cadd:?0}")
    List<Customer> getCustomersDataByCadd(String addrs);

    @Query(fields = "{cno:1, cname:1,cadd:1}",value = "{cadd:?0,cname:?1}")
    List<Customer> getCustomersDataByCaddAndName(String addr, String name);
    @Query(fields = "{cno:1, cname:1,cadd:1}",value = "{$or:[{cadd:?0},{cname:?1}]}")
    List<Customer> getCustomersDataByCaddOrName(String addr, String name);

    @Query(fields = "{id:1, cno:1, cname:1, cadd:1}",value = "{billAmt:{$gte:?0},billAmt:{$lte:?1}")
    List<Customer> getCustomersDataByBillAmtRange(double start, double end);

}
