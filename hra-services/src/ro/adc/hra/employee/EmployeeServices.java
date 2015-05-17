package ro.adc.hra.employee;

public interface EmployeeServices {
    FindEmployeesRs findEmployees(FindEmployeesRq request);

    ModifyEmployeesRs modifyEmployees(ModifyEmployeesRq request);
}
