package sshukla.hibernate.exception;

/**
 * @author 'Seemant Shukla' on '20/09/2022'
 */
public class TutorialException extends RuntimeException{

    String message;

    public TutorialException(String message){
        super(message);
    }

}
