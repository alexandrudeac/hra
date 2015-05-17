package ro.adc.hra.timetable;

import javax.transaction.Transactional;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import ro.adc.hra.timetable.EmployeeTimetable;


@Transactional
public interface EmployeeTimetableMapper  {

    @Select("select e.EMPLOYEE_ID, e.EMPLOYEE_UID, e.LAST_NAME, e.FIRST_NAME, e.MIDDLE_NAME"
            + ", t.TIMETABLE_ID, t.CODE as TIMETABLE_CODE, t.NAME as TIMETABLE_NAME, t.ACTIVE as TIMETABLE_ACTIVE"
            + ", et.EMPLOYEE_TIMETABLE_ID, et.VALID_FROM, et.VALID_UNTIL"
            + " from EMPLOYEE_TIMETABLE et"
            + " inner join EMPLOYEE e on et.EMPLOYEE_ID=e.EMPLOYEE_ID"
            + " inner join TIMETABLE t on et.TIMETABLE_ID=t.TIMETABLE_ID"
            + " where et.EMPLOYEE_TIMETABLE_ID=#{employeeTimetableId}")
    @Results({
            @Result(column="EMPLOYEE_ID", property="employee.id"),
            @Result(column="EMPLOYEE_UID", property="employee.employeeUid"),
            @Result(column="LAST_NAME", property="employee.name.lastName"),
            @Result(column="FIRST_NAME", property="employee.name.firstName"),
            @Result(column="MIDDLE_NAME", property="employee.name.middleName"),
            @Result(column="TIMETABLE_ID", property="timetable.id"),
            @Result(column="TIMETABLE_CODE", property="timetable.code"),
            @Result(column="TIMETABLE_NAME", property="timetable.name"),
            @Result(column="TIMETABLE_ACTIVE", property="timetable.active"),
            @Result(column="EMPLOYEE_TIMETABLE_ID", property="id"),
            @Result(column="VALID_FROM", property="period.validFrom"),
            @Result(column="VALID_UNTIL", property="period.validUntil")
    })
    EmployeeTimetable findById(@Param("employeeTimetableId") Long id);
}
