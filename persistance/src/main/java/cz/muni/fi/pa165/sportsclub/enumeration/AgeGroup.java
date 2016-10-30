package cz.muni.fi.pa165.sportsclub.enumeration;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Fabian Norbert
 */
public enum AgeGroup {
    JUVENILE(5, 9),
    JUNIOR(10, 14),
    YOUTH(15, 19),
    ADULT(20, 34),
    SENIOR(35, 150);

    private final int ageFrom;
    private final int ageTo;
    private final Date dateFrom;
    private final Date dateTo;
    

    AgeGroup(int ageFrom, int ageTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.dateFrom = yearAgoFromNow(ageTo);
        this.dateTo = yearAgoFromNow(ageFrom);
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }
    
    public Date getDateFrom() {
        return new Date(dateFrom.getTime());
    }

    public Date getDateTo() {
        return new Date(dateTo.getTime());
    }

    
    /**
     * Returns an AgeGroup according to the birthday. If no group exists
     * for the specified birthday, null is returned.
     *
     * @param dateOfBirth
     * @return AgeGroup for the given birthday or null if no group exists for
     * the given birthday.
     */
    public static AgeGroup getAgeGroup(Date dateOfBirth) {
        for (AgeGroup group : AgeGroup.values()) {
            if (dateOfBirth.after(group.getDateFrom()) && dateOfBirth.before(group.dateTo)) {
                return group;
            }
        }
        return null;
    }

    private Date yearAgoFromNow(int years) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, - years);
        return cal.getTime();
    }
}
