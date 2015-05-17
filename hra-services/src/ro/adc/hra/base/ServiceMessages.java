package ro.adc.hra.base;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

public class ServiceMessages implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ServiceError> errors;
    private List<ServiceInfo> infos;
    private ImmutableList.Builder<ServiceError> errorsBuilder;
    private ImmutableList.Builder<ServiceInfo> infosBuilder;
    private String messagesLocale;

    public List<ServiceError> getErrors() {
        if (errorsBuilder != null) {
            errors = errorsBuilder.build();
            errorsBuilder = null;
        }
        return errors;
    }

    public void setErrors(final List<ServiceError> errors) {
        errorsBuilder = null;
        this.errors = errors;
    }

    public List<ServiceInfo> getInfos() {
        return infos;
    }

    public void setInfos(final List<ServiceInfo> infos) {
    	infosBuilder = null;
        this.infos = infos;
    }

    public String getMessagesLocale() {
        return messagesLocale;
    }

    public void setMessagesLocale(final String messagesLocale) {
        this.messagesLocale = messagesLocale;
    }

    public ServiceMessages addError(@Nonnull final ServiceError error) {
        java.util.Objects.requireNonNull(error, "Null error not allowed");
        if (errorsBuilder == null) {
            errorsBuilder = ImmutableList.builder();
            if (errors != null) {
                errorsBuilder.addAll(errors);
                errors = null;
            }
        }
        errorsBuilder.add(error);
        return this;
    }
    
	public ServiceMessages addInfo(@Nonnull final ServiceInfo info) {
		java.util.Objects.requireNonNull(info, "Null info not allowed");
		if (infosBuilder == null) {
			infosBuilder = ImmutableList.builder();
			if (infos != null) {
				infosBuilder.addAll(infos);
				infosBuilder = null;
			}
		}
		infosBuilder.add(info);
		return this;
	}

}
