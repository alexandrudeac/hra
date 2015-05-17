package ro.adc.hra.fmt;

import java.text.ParseException;
import java.util.Locale;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    private final MessageSource messageSource;

    public LocalDateTimeFormatter(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String print(final LocalDateTime object, final Locale locale) {
        return createFormat(locale).print(object.toDateTime().getMillis());
    }

    @Override
    public LocalDateTime parse(final String text, final Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

    private DateTimeFormatter createFormat(final Locale locale) {
        final String format = messageSource.getMessage("common.fmt.datetime.pattern", null, locale);
        final DateTimeFormatter dateFormat = DateTimeFormat.forPattern(format);
        return dateFormat;
    }

}
