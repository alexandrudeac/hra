package ro.adc.hra.absence;

public class AbsenceType {
    private String code;
    private String name;
    private Boolean rollover;
    private Boolean active;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getRollover() {
        return rollover;
    }

    public void setRollover(final Boolean rollover) {
        this.rollover = rollover;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

}
