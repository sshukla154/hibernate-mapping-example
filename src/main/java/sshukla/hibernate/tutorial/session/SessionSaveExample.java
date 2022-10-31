package sshukla.hibernate.tutorial.session;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sshukla.hibernate.tutorial.config.HibernateJavaConfig;
import sshukla.hibernate.tutorial.model.SessionStudent;

import java.io.Serializable;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */

@Slf4j
public class SessionSaveExample {

    public void sessionSave(SessionStudent sessionStudent) {
        Transaction transaction = null;
        try (Session session = HibernateJavaConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Serializable savedSessionStudent = session.save(sessionStudent);
            log.info("SessionSaveExample.sessionSave() :::: {}", savedSessionStudent);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
