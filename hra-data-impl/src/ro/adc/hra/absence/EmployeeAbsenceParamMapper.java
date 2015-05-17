package ro.adc.hra.absence;

import javax.transaction.Transactional;

import ro.adc.hra.absence.EmployeeAbsencePeriodRepository;
@Transactional
public interface EmployeeAbsenceParamMapper extends EmployeeAbsencePeriodRepository {

}
