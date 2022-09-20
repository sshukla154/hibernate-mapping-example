package sshukla.hibernate.controller;

import sshukla.hibernate.service.MyService;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }



}
