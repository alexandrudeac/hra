package ro.adc.hra.timetable;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import ro.adc.hra.AbstractDbTest;
import ro.adc.hra.timetable.EmployeeTimetable;
import ro.adc.hra.timetable.EmployeeTimetableMapper;
import ro.adc.hra.timetable.Timetable;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@DatabaseSetup("EmployeeTimetableMapperTest.xml")
public class EmployeeTimetableMapperTest extends AbstractDbTest {
    @Inject
    private EmployeeTimetableMapper employeeTimetableMapper;

    @Test
    public void testFindByCode() {
        final EmployeeTimetable expected = new EmployeeTimetable();
        final Timetable timetable = new Timetable();
        timetable.setActive(Boolean.TRUE);
        timetable.setCode("tt1");
        timetable.setName("TimeTable Unu");
        assertEquals(expected, employeeTimetableMapper.findById(3L));
    }
}
