package com.klef.jfsd.exam.HibernateInheritance;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                   .addAnnotatedClass(Device.class)
                                                   .addAnnotatedClass(Smartphone.class)
                                                   .addAnnotatedClass(Tablet.class)
                                                   .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create objects of Device, Smartphone, and Tablet
            Device device = new Device("Samsung", "Galaxy S21", 999.99);
            Smartphone smartphone = new Smartphone("Apple", "iPhone 13", 1099.99, "iOS", 12.0);
            Tablet tablet = new Tablet("Lenovo", "Tab M10", 299.99, 10.1, 15);

            // Start a transaction
            session.beginTransaction();

            // Save the objects
            session.save(device);
            session.save(smartphone);
            session.save(tablet);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Records inserted successfully!");
        } finally {
            factory.close();
        }
    }
}
