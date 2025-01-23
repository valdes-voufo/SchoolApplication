package com.ydova.schoolapp;

import com.ydova.schoolapp.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

    public static void saveUser(String name, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student user = new Student();
            user.setLastname(name);

            session.persist(user);
            transaction.commit();
            System.out.println("User saved: " + name + ", " + email);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}