package ro.adc.hra.timetable;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import ro.adc.hra.timetable.Timetable;


public interface TimetableMapper {

    @Select("select * from TIMETABLE where code=#{code}")
    Timetable findByCode(@Param("code") String code);
}
