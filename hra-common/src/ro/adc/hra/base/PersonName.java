package ro.adc.hra.base;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class PersonName implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName);
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("lastName", lastName).add("firstName", firstName)
                .add("middleName", middleName).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<PersonName> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final PersonName anObject, final PersonName anoterObject) {
            return Objects.equals(anObject.lastName, anoterObject.lastName)
                    && Objects.equals(anObject.middleName, anoterObject.middleName)
                    && Objects.equals(anObject.firstName, anoterObject.firstName);
        }

    }
}
