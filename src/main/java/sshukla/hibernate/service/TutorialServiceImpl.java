package sshukla.hibernate.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sshukla.hibernate.onetoone.unidirectional.Tutorial;
import sshukla.hibernate.onetoone.unidirectional.TutorialDetails;
import sshukla.hibernate.repo.TutorialDetailsRepository;
import sshukla.hibernate.repo.TutorialRepository;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@Service
@Slf4j
public class TutorialServiceImpl implements TutorialService{
    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialDetailsRepository tutorialDetailsRepository;

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

}
