package cz.muni.fi.pa165.sportsclub.exception;

import org.springframework.dao.DataAccessException;

/**
 * @author Norbert Fabian.
 */
public class SportsClubServiceException extends DataAccessException {

    public SportsClubServiceException(String msg) {
        super(msg);
    }

    public SportsClubServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
