package cz.muni.fi.pa165.sportsclub.exception;

/**
 * Created by norbert on 22.11.16.
 */
public class SportsClubServiceException extends RuntimeException {

    public SportsClubServiceException(String msg) {
        super(msg);
    }

    public SportsClubServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
