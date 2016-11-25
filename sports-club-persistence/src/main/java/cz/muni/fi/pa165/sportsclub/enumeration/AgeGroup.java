package cz.muni.fi.pa165.sportsclub.enumeration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Enum class representing age groups of Team.
 * 
 * @author Patrik Novak
 */
public enum AgeGroup {
    JUVENILE(5, 9, "Juvenile"),
    JUNIOR(10, 14, "Junior"),
    YOUTH(15, 19, "Youth"),
    ADULT(20, 34, "Adult"),
    SENIOR(35, 150, "Senior"),
    NOT_CATEGORIZED(Integer.MIN_VALUE, 4, "Not categorized");

    private final int ageFrom;
    private final int ageTo;
    private final Date dateFrom;
    private final Date dateTo;
    private final String label;
    

    AgeGroup(int ageFrom, int ageTo, String label) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
        this.dateFrom = yearAgoFromNow(ageTo);
        this.dateTo = yearAgoFromNow(ageFrom);
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public static List<String> getAllLabels() {
        List<String> labels = new ArrayList<>();
        for(AgeGroup group: values())
            labels.add(group.getLabel());
        return labels;
    }

    /**
     * Returns an AgeGroup according to the birthday. If no group exists
     * for the specified birthday, NOT_CATEGORIZED is returned.
     *
     * @param dateOfBirth Date of birth
     * @return AgeGroup for the given birthday
     */
    public static AgeGroup getByDate(Date dateOfBirth) {
        for(AgeGroup group: values()) {
            if (dateOfBirth.after(group.getDateFrom()) && dateOfBirth.before(group.dateTo)) {
                return group;
            }
        }
        return AgeGroup.NOT_CATEGORIZED;
    }

    /**
     * Returns AgeGroup with the given label. If no group exists
     * for the specified label, NOT_CATEGORIZED is returned.
     *
     * @param label Label
     * @return AgeGroup with the given label
     */
    public static AgeGroup getByLabel(String label) {
        for(AgeGroup group: values()) {
            if(group.getLabel().equals(label))
                return group;
        }
        return AgeGroup.NOT_CATEGORIZED;
    }

    private Date yearAgoFromNow(int years) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, - years);
        return cal.getTime();
    }
}
