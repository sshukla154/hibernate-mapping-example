package sshukla.hibernate.service;

import org.springframework.stereotype.Service;
import sshukla.hibernate.repo.MyRepository;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */

@Service
public class MyServiceImpl implements MyService {

    private final MyRepository myRepository;

    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }
}
