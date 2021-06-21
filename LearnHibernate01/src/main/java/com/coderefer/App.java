package com.coderefer;

import entity.Department;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Vamsi Tallapudi
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Employee sai = new Employee();
        sai.setFirstname("Sai");
        sai.setLastname("Ram");
        sai.setSalary(100000);
        sai.setCompany("HCL");

        Department dept = new Department();
        dept.setName("Finance");

        sai.setDept(dept);

        Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(sai);
        tx.commit();
    }
}
