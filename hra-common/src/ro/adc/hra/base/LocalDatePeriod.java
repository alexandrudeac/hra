package ro.adc.hra.base;

import java.io.Serializable;

import org.joda.time.LocalDate;

public class LocalDatePeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate start;
    private LocalDate end;

    public LocalDate getStart() {
        return start;
    }

    public void setStart(final LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(final LocalDate end) {
        this.end = end;
    }


}
