package com.coderefer.test;

import com.coderefer.entity.Product;
import com.coderefer.utility.HibernateUtilMySQL;
import com.coderefer.utility.HibernateUtilPostgres;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DataTransferTest {
    public static void main(String[] args) {
        SessionFactory mySqlFactory = HibernateUtilMySQL.getSessionFactory();
        SessionFactory postgresFactory = HibernateUtilPostgres.getSessionFactory();
        Session mySQLSession = HibernateUtilMySQL.getSession();
        Session postgresSession = HibernateUtilPostgres.getSession();
        Transaction tx = null;
        try(mySqlFactory;mySQLSession;postgresFactory;postgresSession) {
            Product prod = mySQLSession.get(Product.class, 2);
            if(prod != null) {
//                begin tx
                tx = mySQLSession.beginTransaction();
                mySQLSession.save(prod);
                tx.commit();
            }
        }
    }
}
