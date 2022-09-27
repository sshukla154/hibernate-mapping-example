package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshukla.hibernate.onetoone.unidirectional.Tutorial;
import sshukla.hibernate.service.TutorialService;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@RestController
@RequestMapping("/v1/ttd")
@Slf4j
public class TutorialAndTutorialDetailsController {

    @Autowired
    private TutorialService tutorialService;

    @PostMapping("/")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
        Tutorial createdTutorial = tutorialService.createTutorial(tutorial);
        return new ResponseEntity<>(createdTutorial, HttpStatus.CREATED);
    }


}
