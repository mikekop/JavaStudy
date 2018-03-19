package ru.logrocon.utils.logging;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

class PrettyFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        DateFormat df = DateFormat.getDateInstance( DateFormat.LONG, new Locale("ru"));
        String formattedDate = df.format(record.getMillis());
        return record.getThreadID()+"::"+record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +formattedDate+"::"
                +record.getLevel()+"::"
                +record.getMessage()+"\n";
    }
}