package sshukla.hibernate.tutorial.client;

import sshukla.hibernate.tutorial.model.SessionStudent;
import sshukla.hibernate.tutorial.session.SessionSaveExample;

/**
 * @author 'Seemant Shukla' on '08/10/2022'
 */
public class SessionAPIsClient {

    public static void main(String[] args) {

        //Student Object - Transient Object
        SessionStudent sessionStudent = new SessionStudent();
        sessionStudent.setFirstName("Seemant");
        sessionStudent.setLastName("Shukla");
        sessionStudent.setPhoneNumber("987654345");

        //Save
        SessionSaveExample sessionSaveExample = new SessionSaveExample();
        sessionSaveExample.sessionSave(sessionStudent);

        //Update

        //SaveOrUpdate

        //Persist

        //Merge

        //Load

        //Get

        //Delete

    }

}
