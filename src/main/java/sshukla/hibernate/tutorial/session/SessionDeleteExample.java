package sshukla.hibernate.tutorial.session;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sshukla.hibernate.tutorial.config.HibernateJavaConfig;
import sshukla.hibernate.tutorial.model.SessionStudent;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */
public class SessionDeleteExample {

    public void sessionDelete(SessionStudent sessionStudent) {
        Transaction transaction = null;
        try (Session session = HibernateJavaConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
//            session.get(1l, sessionStudent);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
