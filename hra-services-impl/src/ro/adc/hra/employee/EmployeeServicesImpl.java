package ro.adc.hra.employee;

import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import ro.adc.hra.base.ModificationIdHolder;
import ro.adc.hra.base.ModificationRepository;
import ro.adc.hra.base.RecordStatus;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

@Named
public class EmployeeServicesImpl implements EmployeeServices {
    private final EmployeeRepository employeeRepo;
    private final ModificationRepository modifRepo;
    private final Map<Class<? extends EmployeeOperation>, EmployeeOperationHandler<?>> opHandlers;

    @Inject
    public EmployeeServicesImpl(final EmployeeRepository employeeRepo, final ModificationRepository modifRepo) {
        this.employeeRepo = employeeRepo;
        opHandlers = ImmutableMap.<Class<? extends EmployeeOperation>, EmployeeOperationHandler<?>>builder()
                .put(EmployeeCreation.class, new EmployeeCreationHandler(employeeRepo))
                .put(EmployeeModification.class, new EmployeeModificationHandler(employeeRepo))
                .put(EmployeeUpdateActiveState.class, new EmployeeUpdateActiveStateHandler(employeeRepo))
                .build();
        this.modifRepo = modifRepo;
    }

    @Override
    @Transactional
    public FindEmployeesRs findEmployees(final FindEmployeesRq request) {
        final FindEmployeesRs rs = new FindEmployeesRs();
        final EmployeeCriteria criteria = EmployeeCriteria.builder()
             .employeeCodeEq(request.getEmployeeCodeIs())
             .recordStatusEq(RecordStatus.C)
             .build();
        if (request.getExpectsOne()) {
            final FindOneEmployeeParam findParam = new FindOneEmployeeParam();
            findParam.setCriteria(criteria);
            rs.setEmployee(employeeRepo.findOneEmployee(findParam));
        } else {
            final FindEmployeesParam findParam = new FindEmployeesParam();
            findParam.setCriteria(criteria);
            findParam.setPaginationCriterion(request.getPagination());
            rs.setEmployees(employeeRepo.findEmployees(findParam));
        }
        return rs;
    }

    @Override
    public ModifyEmployeesRs modifyEmployees(final ModifyEmployeesRq request) {
        final ModifyEmployeesRs rs = new ModifyEmployeesRs();
        final ModificationIdHolder modifIdProv = new ModificationIdHolder(request.getOperationInfo(), modifRepo);
       for (final EmployeeOperation operation : request.getOperations()) {
           final EmployeeOperationHandler<EmployeeOperation> handler = getOperationHandler(operation);
           Objects.requireNonNull(operation, "Unexpected null employee operation");
           Preconditions.checkArgument(handler != null, "Unknown employee operation type %s", operation.getClass());
           handler.handleEmployeeOperation(modifIdProv, operation, rs.getMessages());
        }

        return rs;
    }

    @SuppressWarnings("unchecked")
    private <T extends EmployeeOperation, H extends EmployeeOperationHandler<T>> H getOperationHandler(final T operation) {
        return (H) opHandlers.get(operation.getClass());
    }
}
