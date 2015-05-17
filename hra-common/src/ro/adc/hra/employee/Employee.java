package ro.adc.hra.employee;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.base.PersonName;
import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String uuid;
    private PersonName name;
    private String code;

    public PersonName getName() {
        return name;
    }

    public void setName(final PersonName name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, code, name);
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("uuid", uuid).add("code", code).add("name", name).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<Employee> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final Employee anObject, final Employee anoterObject) {
            return Objects.equals(anObject.uuid, anoterObject.uuid)
                    && Objects.equals(anObject.code, anoterObject.code)
                    && Objects.equals(anObject.name, anoterObject.name);
        }

    }
}
