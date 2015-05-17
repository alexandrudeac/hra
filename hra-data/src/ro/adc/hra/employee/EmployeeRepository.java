package ro.adc.hra.employee;

import java.util.List;

public interface EmployeeRepository {
    EmployeeRecord findOneEmployee(final FindOneEmployeeParam param);

    List<EmployeeRecord> findEmployees(final FindEmployeesParam param);

    void createEmployee(final CreateEmployeeParam param);

    void updateEmployeeDetail(final UpdateEmployeeDetailParam param);

    void updateEmployeeActiveState(final UpdateEmployeeActiveStateParam param);

    void markDeletedEmployee(final UpdateEmployeeActiveStateParam param);

    int storeOldEmployeeVersion(final StoreOldEmployeeVersionParam param);
}
