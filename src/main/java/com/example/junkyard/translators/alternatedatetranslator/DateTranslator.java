package com.example.junkyard.translators.alternatedatetranslator;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.internal.translator.AbstractTranslator;
import org.apache.tapestry5.services.FormSupport;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rbaptiste
 * Date: 4/6/12
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateTranslator extends AbstractTranslator<Date> {

    public DateTranslator() {
        super("datecheck", Date.class, "date-format-exception");
    }


    public static boolean isValidDateStr(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean  isValidDate(String date){
        boolean isValid = false;
        String expression = "^[0-1][1-9][- / ]?(0[1-9]|[12][0-9]|3[01])[- /]?(18|19|20|21)\\d{2}$";
        /*
        * ^[0-1][1-9] : The month starts with a 0 and a digit between 1 and 9
        * [- / ]?: Followed by  an optional "-" or "/".
        * (0[1-9]|[12][0-9]|3[01]) : The day part must be either between 01-09, or 10-29 or 30-31.
        * [- / ]?: Day part will be followed by  an optional "-" or "/".
        * (18|19|20|21)\\d{2}$ : Year begins with either 18, 19, 20 or 21 and ends with two digits.
        */
        CharSequence inputStr = date;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    public Date parseClient(Field field, String clientValue, String message) throws ValidationException {

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        if (clientValue == null) {
            return null;
        } else {
            //Get string from client field
            String stringFromClient = clientValue.toLowerCase();
            //Confirm a valid date
            if (isValidDate(stringFromClient)) {
                //then we return a date object
                try {
                    return dateFormat.parse(stringFromClient);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                throw new ValidationException(message);
            }
        }
        return null;

    }

    public String toClient(Date date) {
        return new SimpleDateFormat("MM/dd/yyyy").format(date);

    }

    public void render(Field field, String message, MarkupWriter writer, FormSupport formSupport) {
        // Do nothing; we don't yet support client-side validation.
        // formSupport.addValidation(field, "yesno", message, null);
    }
}

