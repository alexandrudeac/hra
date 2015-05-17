package ro.adc.hra.obj;

public interface ToStringBuider {
	ToStringBuider add(String property, Object value);

	ToStringBuider add(Object value);
	
	ToStringBuider omitNull();
	
	String toString();
}
