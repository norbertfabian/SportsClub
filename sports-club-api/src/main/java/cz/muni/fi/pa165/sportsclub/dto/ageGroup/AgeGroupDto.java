package cz.muni.fi.pa165.sportsclub.dto.ageGroup;

/**
 * Created by norbert on 23.11.16.
 */
public class AgeGroupDto {

    private String label;
    private int ageFrom;
    private int ageTo;

    public AgeGroupDto() {

    }

    public AgeGroupDto(AgeGroupDto dto) {
        this.label = dto.getLabel();
        this.ageFrom = dto.getAgeFrom();
        this.ageTo = dto.getAgeTo();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(int ageFrom) {
        this.ageFrom = ageFrom;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgeGroupDto)) return false;

        AgeGroupDto that = (AgeGroupDto) o;

        if (getAgeFrom() != that.getAgeFrom()) return false;
        if (getAgeTo() != that.getAgeTo()) return false;
        return getLabel() != null ? getLabel().equals(that.getLabel()) : that.getLabel() == null;

    }

    @Override
    public int hashCode() {
        int result = getLabel() != null ? getLabel().hashCode() : 0;
        result = 31 * result + getAgeFrom();
        result = 31 * result + getAgeTo();
        return result;
    }
}
