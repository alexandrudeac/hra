package ro.adc.hra.fmt;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.format.Formatter;

import ro.adc.hra.base.PersonName;

public class PersonNameFormatter implements Formatter<PersonName> {
    private final MessageSource messageSource;

    public PersonNameFormatter(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String print(final PersonName object, final Locale locale) {
        final ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(getFmtExpression(locale), new TemplateParserContext()).getValue(object,
                String.class);
    }

    @Override
    public PersonName parse(final String text, final Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }

    private String getFmtExpression(final Locale locale) {
        return messageSource.getMessage("common.fmt.personName.spel", null, locale);
    }
}
