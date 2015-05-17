package ro.adc.hra.employee;

import ro.adc.hra.base.ModificationIdHolder;
import ro.adc.hra.base.ServiceMessages;

public interface EmployeeOperationHandler<T extends EmployeeOperation> {

    void handleEmployeeOperation(final ModificationIdHolder modificationId, final T operation,
            final ServiceMessages messages);
}
