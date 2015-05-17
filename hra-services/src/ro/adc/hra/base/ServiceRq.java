package ro.adc.hra.base;

import java.io.Serializable;

public class ServiceRq implements Serializable {

    private static final long serialVersionUID = 1L;
    private OperationInfo operationInfo;
    private String operatorLocale;

    public OperationInfo getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(final OperationInfo operationInfo) {
        this.operationInfo = operationInfo;
    }

    public String getOperatorLocale() {
        return operatorLocale;
    }

    public void setOperatorLocale(final String operatorLocale) {
        this.operatorLocale = operatorLocale;
    }

}
