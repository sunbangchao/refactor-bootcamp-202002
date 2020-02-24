package cc.xpbootcamp.warmup.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private static final String YYYYMMDDEEEE_CH = "yyyy年MM月dd日，EEEE";

    public static String format2YYYYMMDDEEEE_CH(Date date){
        DateFormat format = new SimpleDateFormat(YYYYMMDDEEEE_CH);
        return format.format(date);
    }
}
