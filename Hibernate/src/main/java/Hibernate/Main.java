package Hibernate;

import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HiberbateUtil.getSessionFactory();
        User user = new User();
        user.setAge(3);
    }
}
