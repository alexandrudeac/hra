package ro.adc.hra.fmt;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

public class BooleanFormatter implements Formatter<Boolean> {

    private final MessageSource messageSource;

    public BooleanFormatter(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String print(final Boolean object, final Locale locale) {
        return getDisplayValue(object, locale);
    }

    @Override
    public Boolean parse(final String text, final Locale locale) throws ParseException {
        Boolean booleanResult;
        if (text == null) {
            booleanResult = false;
        } else if ("true".equalsIgnoreCase(text)) {
            booleanResult = Boolean.TRUE;
        }  else if ("false".equalsIgnoreCase(text)) {
            booleanResult = Boolean.FALSE;
        } else {
            booleanResult = null;
        }
        return booleanResult;
    }

    private String getDisplayValue(final Boolean value, final Locale locale) {
        return messageSource.getMessage("common.fmt.bool.lov." + value, null, locale);
    }

}
