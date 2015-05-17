package ro.adc.hra.timetable;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String code;
    private String name;

    private Boolean active;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, active);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("id", id).add("code", code).add("name", name).add("active", active).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<Timetable> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final Timetable anObject, final Timetable anoterObject) {
            return Objects.equals(anObject.id, anoterObject.id)
                    && Objects.equals(anObject.code, anoterObject.code)
                    && Objects.equals(anObject.name, anoterObject.name)
                    && Objects.equals(anObject.active, anoterObject.active);
        }

    }
}
