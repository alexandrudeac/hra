package ro.adc.hra.employee;

import static org.junit.Assert.assertEquals;
import static ro.adc.hra.Sequences.EMPLOYEE_IDENTITY;

import javax.inject.Inject;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import ro.adc.hra.AbstractDbTest;
import ro.adc.hra.base.Modification;
import ro.adc.hra.base.PersonName;
import ro.adc.hra.base.RecordStatus;
import ro.adc.hra.base.RecordTrace;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

//TODO NEXT
// - vezi ce e cu timezone-ul timestampurilor
// - teste unitare pentru restul operatiilor din EmployeeRepository
// - serviciu pentru Employee CRUD
@DatabaseSetup("EmployeeRepositoryTest.xml")
public class EmployeeRepositoryTest extends AbstractDbTest {

    @Inject
    private EmployeeRepository employeeRepo;

    @Test
    public void testFindOneDetailByCode() {
        final EmployeeRecord expected = new EmployeeRecord();
        final EmployeeDetail expEmplDet = new EmployeeDetail();
        final Employee employee = new Employee();
        expEmplDet.setActive(Boolean.TRUE);
        employee.setCode("adc");
        final PersonName name = new PersonName();
        name.setFirstName("Alexandru");
        name.setLastName("DEAC");
        employee.setName(name);
        employee.setUuid("eee1mmm");
        expEmplDet.setBasic(employee);
        final RecordTrace versionInfo = RecordTrace.builder()
                .since(Modification.builder().id(1L).operator("userecu")
                    .timestamp(LocalDateTime.parse("2015-02-28T12:13:14.000")).build())
                .verno(1)
                .status(RecordStatus.C)
                .build();
        expected.setDetail(expEmplDet);
        expected.setRecordTrace(versionInfo);

        final FindOneEmployeeParam param = new FindOneEmployeeParam();
        param.setCriteria(EmployeeCriteria.builder().employeeCodeEq("adc").build());
        final EmployeeRecord actual = employeeRepo.findOneEmployee(param);
        assertEquals(expected.toString(), actual.toString());
        assertEquals(expected.hashCode(), actual.hashCode());
        assertEquals(expected, actual);
    }

    @Test
    @ExpectedDatabase(value = "EmployeeRepositoryTest-expect-create.xml", table = "EMPLOYEE",
            assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testCreateEmployee() throws Exception {
        final EmployeeDetail emplDet = new EmployeeDetail();
        emplDet.setActive(Boolean.TRUE);
        final PersonName name = new PersonName();
        name.setFirstName("Mihaela");
        name.setMiddleName("Maria");
        name.setLastName("CAMPAN");
        final Employee emplRef = new Employee();
        emplRef.setName(name);
        emplRef.setCode("mcm");
        emplRef.setUuid("eee2mmm");
        emplDet.setBasic(emplRef);
        final CreateEmployeeParam param = new CreateEmployeeParam();
        param.setEmployeeDetail(emplDet);
        param.setModificationId(2L);
        setSqNextval(EMPLOYEE_IDENTITY, 20L);
        employeeRepo.createEmployee(param);

    }

    @Test
    @ExpectedDatabase(value = "EmployeeRepositoryTest-expect-updateDetail.xml", table = "EMPLOYEE")
    public void testUpdateEmployeeDetail() throws Exception {
        final UpdateEmployeeDetailParam updateParam = new UpdateEmployeeDetailParam();
        final PersonName name = new PersonName();
        name.setFirstName("Alex");
        name.setMiddleName("C.L.");
        name.setLastName("DEAQ");
        updateParam.setEmployeeCodeIs("adc");
        updateParam.setEmployeeName(name);
        updateParam.setModificationId(2L);
        setSqNextval(EMPLOYEE_IDENTITY, 2L);
        employeeRepo.storeOldEmployeeVersion(StoreOldEmployeeVersionParam.builder().employeeCodeIs("adc")
                .modificationId(2L).build());
        employeeRepo.updateEmployeeDetail(updateParam);

    }

}
