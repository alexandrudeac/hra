package ro.adc.hra.employee;

public class EmployeeUpdateActiveState extends EmployeeOperation {
	private String employeeCode;
	private Boolean activeState;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Boolean getActiveState() {
		return activeState;
	}

	public void setActiveState(Boolean activeState) {
		this.activeState = activeState;
	}

}
