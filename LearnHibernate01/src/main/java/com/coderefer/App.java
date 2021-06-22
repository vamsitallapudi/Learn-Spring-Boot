package com.coderefer;

import entity.Department;
import entity.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * @author Vamsi Tallapudi
 */
public class App {
    public static void main(String[] args) {
//        Employee sai = new Employee();
//        sai.setFirstname("Sai");
//        sai.setLastname("Ram");
//        sai.setSalary(100000);
//        sai.setCompany("HCL");
//
//        Department dept = new Department();
//        dept.setName("Finance");
//
//        sai.setDept(dept);

//        Activate Hibernate Framework
        Configuration cfg = new Configuration();
//        specify hibernate cfg file name and location
        cfg.configure().addAnnotatedClass(Employee.class);
//        create HB SessionFactory Object
        SessionFactory sf = cfg.buildSessionFactory();
//        create Session Object
        Session session = sf.openSession();
//        use this in case of saving the data to db
//        Transaction tx = session.beginTransaction();
        try {
//            load object (ses.get())
            Employee vamsi = session.load(Employee.class, 1);
            System.out.println(vamsi.getDept().getName());
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
//        use these in case of saving the data to db
//        session.save(sai);
//        tx.commit();
    }
}
