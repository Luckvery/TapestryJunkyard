package com.example.junkyard.translators;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.internal.translator.AbstractTranslator;
import org.apache.tapestry5.services.FormSupport;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 */
public class DateTranslator extends AbstractTranslator<Date> {

    private final Format format = new SimpleDateFormat("MM/dd/y");

    public DateTranslator() {
        super("date", Date.class, "date-format-exception");
    }

    public String toClient(Date date) {
        return format.format(date);
    }

    public Date parseClient(Field field, String clientValue, String message) throws ValidationException {
        if (clientValue == null) {
            return null;
        }

        try {
            return (Date)format.parseObject(clientValue);
        } catch (ParseException e) {
            throw new ValidationException(message);
        }
    }

    public void render(Field field, String s, MarkupWriter markupWriter, FormSupport formSupport) {
    }
}
