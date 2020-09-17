package pro.bolshakov.geekbrains.lesson05.config;

import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component("dateFormatter")
public class MyDateFormatter {

    private static final String PROPERTY_DATE_FORMAT = "date.format";
    private static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("dd - mm <-> yyyy");

    private final MessageSource messageSource;
    private final Formatter<Date> formatter = new Formatter<Date>() {
        private Map<Locale, SimpleDateFormat> cache = new HashMap<>();

        @Override
        public Date parse(String text, Locale locale) throws ParseException {
            return getFormat(locale).parse(text);
        }

        @Override
        public String print(Date object, Locale locale) {
            return getFormat(locale).format(object);
        }

        private SimpleDateFormat getFormat(Locale locale){
            SimpleDateFormat resultFormat = cache.get(locale);
            if(resultFormat != null){
                return resultFormat;
            }

            String pattern = messageSource.getMessage(PROPERTY_DATE_FORMAT, null, locale);
            resultFormat = pattern == null ? DEFAULT_FORMAT : new SimpleDateFormat(pattern);
            cache.put(locale, resultFormat);
            return resultFormat;
        }
    };

    public MyDateFormatter(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String format(Date date, Locale locale){
        return formatter.print(date, locale);
    }

}
