package sshukla.hibernate.service;

import sshukla.hibernate.onetoone.unidirectional.Tutorial;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */
public interface TutorialService {
    Tutorial createTutorial(Tutorial tutorial);
}
