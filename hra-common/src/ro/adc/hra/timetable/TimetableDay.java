package ro.adc.hra.timetable;


public class TimetableDay {
    private Timetable timetable;
    private Integer dayIndex;
    private Boolean opened;
    private Integer workDuration;

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(final Timetable timetable) {
        this.timetable = timetable;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(final Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public Boolean getOpened() {
        return opened;
    }

    public void setOpened(final Boolean opened) {
        this.opened = opened;
    }

    public Integer getWorkDuration() {
        return workDuration;
    }

    public void setWorkDuration(final Integer workDuration) {
        this.workDuration = workDuration;
    }

}
