package sshukla.hibernate.tutorial.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Slf4j
public class HibernateJavaConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        log.info("HibernateJavaConfig.getSessionFactory() ::::");
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            log.info("HibernateJavaConfig.getSessionFactory() - Object Created :::: {}", sessionFactory);
            return sessionFactory;
        }
        return sessionFactory;
    }

}
