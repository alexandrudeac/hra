package ro.adc.hra.employee;

import ro.adc.hra.base.PersonName;

public class EmployeeModification extends EmployeeOperation {
	private String employeeCode;
	private PersonName name;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public PersonName getName() {
		return name;
	}

	public void setName(PersonName name) {
		this.name = name;
	}

}
