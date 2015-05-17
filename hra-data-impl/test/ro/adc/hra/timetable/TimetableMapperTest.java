package ro.adc.hra.timetable;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import ro.adc.hra.AbstractDbTest;
import ro.adc.hra.timetable.Timetable;
import ro.adc.hra.timetable.TimetableMapper;

import com.github.springtestdbunit.annotation.DatabaseSetup;

@DatabaseSetup("TimetableMapperTest.xml")
public class TimetableMapperTest extends AbstractDbTest {

    @Inject
    private TimetableMapper timetableMapper;



    @Test
    public void testFindByCode() {
        final Timetable expected = new Timetable();
        expected.setActive(Boolean.TRUE);
        expected.setCode("tt1");
        expected.setName("TimeTable Unu");
        assertEquals(expected, timetableMapper.findByCode("tt1"));
    }
}
