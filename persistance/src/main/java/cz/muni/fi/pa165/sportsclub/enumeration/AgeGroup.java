package cz.muni.fi.pa165.sportsclub.enumeration;


import java.util.Date;

/**
 * @author Fabian Norbert
 */
public enum AgeGroup {
    JUVENILE(5, 10),
    JUNIOR(10, 15),
    YOUTH(15, 20),
    ADULT(20, 35),
    SENIOR(35, Integer.MAX_VALUE);

    private final long YEAR = 31536000000L;

    private final int ageFrom;
    private final int ageTo;
    private final Date yearFrom;
    private final Date yearTo;
    

    AgeGroup(int ageFrom, int ageTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.yearFrom = new Date(yearAgoFromNow(ageTo));
        this.yearTo = new Date(yearAgoFromNow(ageFrom));
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }
    
    public Date getYearFrom() {
        return yearFrom;
    }

    public Date getYearTo() {
        return yearTo;
    }

    
    /**
     * Returns an AgeGroup according to the players birthday. If no group exists
     * for the specified player's birthday, null is returned.
     *
     * @param dateOfBirth
     * @return AgeGroup for the players birthday or null if no group exists for
     * the player's birthday.
     */
    public static AgeGroup getAgeGroup(Date dateOfBirth) {
        for (AgeGroup group : AgeGroup.values()) {
            if (dateOfBirth.after(group.getYearFrom()) && dateOfBirth.before(group.yearTo)) {
                return group;
            }
        }
        return null;
    }

    private long yearAgoFromNow(int years) {
        long now = System.currentTimeMillis();
        long currentYear = now - (now % YEAR);
        return currentYear - years * YEAR;
    }
}
