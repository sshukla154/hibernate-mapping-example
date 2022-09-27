package sshukla.hibernate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sshukla.hibernate.onetoone.bidirectional.User;
import sshukla.hibernate.repo.UserProfileRepository;
import sshukla.hibernate.repo.UserRepository;

/**
 * @author 'Seemant Shukla' on '27/09/2022'
 */

@RestController
@RequestMapping("/v1/uup")
@Slf4j
public class UserAndUserProfileController {

    private UserRepository userRepository;

    private UserProfileRepository userProfileRepository;

    public UserAndUserProfileController(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
