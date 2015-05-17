package ro.adc.hra.absence;

public class AbsenceParamSheet {
    private String code;
    private String name;
    private AbsenceParamSheet parent;

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

    public AbsenceParamSheet getParent() {
        return parent;
    }

    public void setParent(final AbsenceParamSheet parent) {
        this.parent = parent;
    }

}
