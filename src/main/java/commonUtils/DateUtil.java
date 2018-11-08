package commonUtils;





import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;


public class DateUtil {
    private static Logger logger = Logger.getLogger(DateUtil.class.getName());

    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";

    private static String format = "yyyy-MM-dd HH:mm:ss";

    private static String format1 = "HH:mm:ss";

    private static String format2;

    public static final String TIMESTAMP_DF2 = "yyyy-MM-dd HH:mm:ss:SSS";

    public static final String format3 = "yyyyMMdd";

    public static final String format4 = "yyyy-MM";

    public static String formatDateToyyyyMM() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String date = formatter.format(new Date());
        return date;
    }

    public static Date formatCurrentDate(String pattern) {
        Date startDate;
        DateFormat formatter = new SimpleDateFormat(pattern);
        try {
            startDate = formatter.parse(formatter.format(new Date()));
        } catch (Exception e) {
            startDate = new Date();
        }

        return startDate;
    }

    public static Date formatCurrentDate() {
        Date startDate;
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            startDate = formatter.parse(formatter.format(new Date()));
        } catch (Exception e) {
            startDate = new Date();
        }

        return startDate;
    }

    public static java.sql.Date toSqlDate(java.util.Date date) {
        java.sql.Date d = new java.sql.Date(date.getTime());
        return d;
    }

    public static java.sql.Timestamp toSqlTimeStamp(Date date) {
        Timestamp d = new Timestamp(date.getTime());
        return d;
    }

    public static java.sql.Timestamp dateToSqlTimeStamp(java.util.Date date) {
        return Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(date));
    }

    public static Date dateBegin(Date date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = formatter.parse(formatter.format(date));

        return begin;
    }

    public static Date dateEnd(Date date) throws ParseException {
        Date end = new Date(date.getTime() + 24 * 60 * 60 * 1000);

        return end;
    }

    public static Date dateAdd(Date date, int dayNum) throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(formatter.parse(formatter.format(date)));
        cal.add(Calendar.DATE, dayNum);
        return cal.getTime();
    }

    public static Date addDates(Date date, int dayNum){
        try {
            Calendar cal = Calendar.getInstance();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            cal.setTime(formatter.parse(formatter.format(date)));
            cal.add(Calendar.DATE, dayNum);
            return cal.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date dateMinus(Date date, int dayNum) throws ParseException {
        Calendar cal = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(formatter.parse(formatter.format(date)));
        cal.add(Calendar.DATE, -(dayNum));
        return cal.getTime();
    }

    /**
     * 根据参数date，计算星期天对应的日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static java.util.Date sunday(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int diff = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return dateMinus(date, diff);
    }

    /**
     * 根据参数date，计算date对应的月初的日期
     *
     * @param date
     *            ：运行程序的当日
     * @return
     * @throws ParseException
     */
    public static Date thisMonthOfDate(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int diff = cal.get(Calendar.DAY_OF_MONTH) - 1;

        // logger.info("------DAY_OF_MONTH=" + diff);
        return dateMinus(date, diff);
    }

    /**
     * 根据参数date，计算date对应的年初的日期。即1月1日的日期
     *
     * @param date
     *            ：运行程序的当日
     * @return
     * @throws ParseException
     */
    public static Date thisYearBeginOfDate(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int diff = cal.get(Calendar.DAY_OF_YEAR) - 1;
        // logger.info("------DAY_OF_YEAR=" + diff);
        return dateMinus(date, diff);
    }

    public static Date stringToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;

        try {
            d = sdf.parse(date);

        } catch (Exception e) {
        }
        return d;
    }

    public static Date stringToDate(String date,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (Exception e) {
        }
        return d;
    }

    public static Date stringToDate2(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;

        try {
            d = sdf.parse(date);

        } catch (Exception e) {
            logger.warning("stringToDate2转换出错。date=[" + date + "]"
                    + e.getMessage());
        }
        return d;
    }


    public static Date stringToDate3(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date d = null;

        try {
            d = sdf.parse(date);

        } catch (Exception e) {
            logger.warning("stringToDate2转换出错。date=[" + date + "]"
                    + e.getMessage());
        }
        return d;
    }

    public static String getEndTime(String dateStr) throws ParseException {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date= sf.parse(dateStr);
        calendar.setTime(date);
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        // 打印
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateEndStr=format.format(calendar.getTime());
        return dateEndStr;

    }

    public static String getStartTime(String dateStr) throws ParseException {
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date= sf.parse(dateStr);
        calendar.setTime(date);
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));

        // 打印
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateEndStr=format.format(calendar.getTime());
        return dateEndStr;

    }

    public static String dateToString(Date date) {
        if(date == null){
            return null;
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public static String dateToStringShort(Date date) {
        if(date == null)
            return null;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static String dateToStringMonth(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM");
        return formatter.format(date);
    }

    public static String getFormatday(int num) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String date1 = sdf.format(new Date());
            date = sdf.parse(date1);
            cal.setTime(date);
            cal.add(Calendar.DATE, num);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sdf.format(cal.getTime());
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static String getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    public static Date getMonthFirstDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return calendar.getTime();
    }
    /**
     * 给当前日期-5分钟
     * */
    public static String getSubtractTime(int num) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String date1 = sdf.format(new Date());
            date = sdf.parse(date1);
            cal.setTime(date);
            cal.add(Calendar.DATE, num);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sdf.format(cal.getTime());
    }

    /**
     * 得到两个日期之间的时间差 以毫秒返回后面时间-前面时间
     * */
    public static Long getDateSubtractTime(String date1, String date2) {
        long datetime = 0;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date firstdate = df.parse(date1);
            Date enddate = df.parse(date2);
            datetime = enddate.getTime() - firstdate.getTime();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return datetime;
    }

    public Long dateDiff(String date1, String date2, String format) {
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff = 0;

        try {
            diff = sd.parse(date2).getTime() - sd.parse(date1).getTime();
            long day = diff / nd;// 计算差多少天
            long hour = diff % nd / nh;// 计算差多少小时
            long min = diff % nd % nh / nm;// 计算差多少分钟
            long sec = diff % nd % nh % nm / ns;// 计算差多少秒
            logger.info("时间相差：" + day + "天" + hour + "小时" + min + "分钟"
                    + sec + "秒。");
            diff = day;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return diff;
    }

    public static String transferToWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(Calendar.DAY_OF_WEEK);

        String[] weekNames = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

        return weekNames[week - 1];
    }

    /**
     *
     * 方法说明: <br>
     * 根据输入日期，计算出该所在的那周的星期一
     *
     * @param inputDate
     *            yyyy-MM-dd日期
     * @return 返回星期一
     *
     */
    public static String getThisMondayDateFrom(String inputDate) {
        String thisMonday = "";

        Date d = DateUtil.stringToDate2(inputDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int week = cal.get(Calendar.DAY_OF_WEEK);

        if (week == 1) {
            cal.add(Calendar.DATE, -6);
        } else {
            cal.add(Calendar.DATE, 2 - week);
        }

        thisMonday = DateUtil.dateToStringShort(cal.getTime());
        return thisMonday;
    }

    /**
     *
     * 方法说明: <br>
     * 根据输入日期，计算出该所在的那周的星期一
     *
     * @param inputDate
     *            yyyy-MM-dd日期
     * @return 返回星期一
     *
     */
    public static String getThisMondayDateFrom(Date inputDate) {
        String thisMonday = "";

        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);
        int week = cal.get(Calendar.DAY_OF_WEEK);

        if (week == 1) {
            cal.add(Calendar.DATE, -6);
        } else {
            cal.add(Calendar.DATE, 2 - week);
        }

        thisMonday = DateUtil.dateToStringShort(cal.getTime());
        return thisMonday;
    }

    /**
     *
     * 方法说明: <br>
     * 根据星期一，计算出星期日
     *
     * @param monday
     *            星期一
     * @return 返回星期一所在周的星期日
     *
     */
    public static String getThisSundayFromMonday(String monday) {
        String thisSunday = "";

        Date d = DateUtil.stringToDate2(monday);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        cal.add(Calendar.DATE, 6);
        thisSunday = DateUtil.dateToStringShort(cal.getTime());

        return thisSunday;
    }

    public static Date getMonthAfter(Date date, int afterMonthNumber) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month + afterMonthNumber);
        return c.getTime();
    }

    public static Date getYearAfter(Date date, int afterYearNumber) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        c.set(Calendar.YEAR, year + afterYearNumber);
        return c.getTime();
    }

    /**
     * 得到date月的最后一天
     *
     * @return
     */
    public static String getMonthLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }

    /**
     * 得到date月的最后一天
     *
     * @return
     */
    public static Timestamp getMonthLastDayTimestamp(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return new Timestamp(calendar.getTime().getTime());
    }

    /**
     * 上月一个月第一天和最后一天
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Map<String, String> getFirstday_Lastday_Month()
            throws ParseException {
        Date datea = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datea);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        // 上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first);// .append(" 00:00:00");
        day_first = str.toString();

        // 上个月最后一天
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last);// .append(" 23:59:59");
        day_last = endStr.toString();

        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }

    /**
     * data 上个月的组后一天
     *
     * @param datea
     * @return
     * @throws ParseException
     */
    public static Timestamp get_Lastday_Month(Date datea) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datea);
        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();

        // 上个月最后一天
        calendar.add(Calendar.MONTH, 1); // 加一个月
        calendar.set(Calendar.DATE, 1); // 设置为该月第一天
        calendar.add(Calendar.DATE, -1); // 再减一天即为上个月最后一天
        String day_last = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_last);// .append(" 23:59:59");
        day_last = endStr.toString();

        Timestamp ts = null;
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ts = Timestamp.valueOf(df.format(df.parse(day_last)));
        return ts;
    }

    /**
     * String类型转换为date类型
     *
     * @return
     */
    public static Date getStringToDate(String str) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        try {
            return sf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * date类型转换为String类型
     */
    public static String getDateToString(Date str) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(str);
    }

    /**
     * 获得当前系统时间 String类型
     */
    public static String getSystemDate() {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(new Date());
    }

    /**
     * 获得当前时分秒 String类型
     */
    public static String getSystemHHmmss() {
        SimpleDateFormat sf = new SimpleDateFormat(format1);
        return sf.format(new Date());
    }

    /**
     * date类型转换为String类型 yyyy-MM-dd
     */
    public static String getDateToyyyyMMdd(Date str) {
        String ft = "yyyy-MM-dd";
        SimpleDateFormat sf = new SimpleDateFormat(ft);
        return sf.format(str);
    }

    public static int getMonthDiff(Date date1, Date date2) {
        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DATE);

        int result;
        if (year == year2) {
            result = month2 - month;// 两个日期相差几个月，即月份差
        } else {
            result = 12 * (year2 - year) + month2 - month;// 两个日期相差几个月，即月份差
        }

        if (day == 1) {
            result++;
        }

        return Math.abs(result);
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getMonthDiff1(Date startDate, Date endDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(endDate);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);

        int result;
        if (year == year2) {
            result = month2 - month;// 两个日期相差几个月，即月份差
        } else {
            result = 12 * (year2 - year) + month2 - month;// 两个日期相差几个月，即月份差
        }

        return result;
    }

    public static int getMonthDiffIgnoreDays(Date date1, Date date2) {
        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        int day2 = c2.get(Calendar.DATE);

        int result;
        if (year == year2) {
            result = month2 - month;// 两个日期相差几个月，即月份差
        } else {
            result = 12 * (year2 - year) + month2 - month;// 两个日期相差几个月，即月份差
        }

//		if (day == 1) {
//			result++;
//		}

        return Math.abs(result);
    }

    /**
     * 获得两个时间的天数，包含其实时间天数
     *
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static Long getDayBeteewnDate(String dateStart, String dateEnd) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        long quot = 0;
        try {
            startDate = df.parse(dateStart);
            endDate = df.parse(dateEnd);

            quot = endDate.getTime() - startDate.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
            quot += 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    public static String getSimpleDateText(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
            return sdf.format(date);
        }
        return null;
    }
    /**
     *
     * @param dateStr日期或时间字符串，例：2016-12-23 14:12:34
     * @param pattern日期格式，例：yyyy-MM-dd HH:mm:ss
     * @description 如果pattern为空或为null，则使用默认的日期格式：yyyy-MM-dd
     * @return Date
     */
    public static Date parseDateStr2Date(String dateStr, String pattern) {
        Date date = null;
        SimpleDateFormat sdf = null;
        try {
            if (StringUtils.isEmpty(pattern)) {
                sdf = new SimpleDateFormat(pattern);
            } else {
                sdf = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
            }
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 根据date对象获取时间戳对象
     * @param date
     * @description 如果date为null，则返回null
     * @return Timestamp
     */
    public static Timestamp getTimestampFromDate(Date date){
        Timestamp timestamp = null;
        if(date!=null){
            timestamp = new Timestamp(date.getTime());
        }
        return timestamp;
    }

    public static String addMonth(String date,int monthNum) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, monthNum);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 获得本月的开始时间，即2012-01-01 00:00:00
     */
    public static String getCurrentMonthStartTime(String month) {
        return month+"-01 00:00:00";
    }

    /**
     * 获得选择月份的结束时间，即2013-07-31 00:00:00
     */
    public static String getCurrentMonthEndTime(String monthDate) {
        Calendar ca = Calendar.getInstance();
        String lp = monthDate + "-01 00:00:00";
        Date datetime1 = DateUtil.stringToDate(lp);
        ca.setTime(datetime1);
        ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DATE, ca.get(Calendar.DATE) - 1);
        String lpd = DateUtil.dateToString(ca.getTime());
        return lpd;
    }

    public static String getCurrentMonthEnd() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH,
                ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = format.format(ca.getTime());
        return last + " 00:00:00";
    }

    /**
     * 根据日期获取年龄
     */
    public static int getAge(Date birthDay) throws Exception {
        //获取当前系统时间
        Calendar cal = Calendar.getInstance();
        //如果出生日期大于当前时间，则抛出异常
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        //取出系统当前时间的年、月、日部分
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        //将日期设置为出生日期
        cal.setTime(birthDay);
        //取出出生日期的年、月、日部分
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        //当前年份与出生年份相减，初步计算年龄
        int age = yearNow - yearBirth;
        //当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁
        if (monthNow <= monthBirth) {
            //如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }

    public static boolean checkDate(String target,String formatStr){
        boolean result = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            format.setLenient(false);
            format.parse(target);

            result = true;
        } catch (ParseException e) {
        }
        return result;
    }

    /**
     * 格式化日期为YYYYMMdd，例：2016-11-01-->20161101
     * 如果传入日期，则格式化传入Date为对应字符串返回
     * 如果不传，则格式化当前Date为对应字符串返回
     * @param date
     * @return
     */
    public static String formatDateToYYYYMMdd(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        if(date!=null){
            return format.format(date);
        }
        return format.format(new Date());
    }

    /**
     * 格式化日期为HHmmss，例：13-56-01-->135601
     * 如果传入日期，则格式化传入Date为对应字符串返回
     * 如果不传，则格式化当前Date为对应字符串返回
     * @param date
     * @return
     */
    public static String formatTimeToHHmmss(Date date){
        SimpleDateFormat format = new SimpleDateFormat("HHmmss");
        if(date!=null){
            return format.format(date);
        }
        return format.format(new Date());
    }

    /**
     * 格式化日期为HHmmss，例：某一date对应的毫秒时间数为1477980111410，则取到最后三位410返回
     * 如果传入日期，则格式化传入Date为对应字符串返回
     * 如果不传，则格式化当前Date为对应字符串返回
     * @return
     */
    public static String getLastThreeMillisecond(Date date){
        if(date!=null){
            String milliSec = String.valueOf(date.getTime());
            return milliSec.substring(milliSec.length()-3, milliSec.length());
        }
        String milliSec = String.valueOf((new Date()).getTime());
        return milliSec.substring(milliSec.length()-3, milliSec.length());
    }

    /**
     * 格式华20161110形式的字符串为Date对象
     * @param dateStr
     * @return
     */
    public static Date parseYyyyMMddStr2Date(String dateStr){
        if(StringUtils.isEmpty(dateStr)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = null;
            try {
                date = sdf.parse(dateStr);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 获取传入月份x月后的月份
     */
    public static String getNextMonthFirstDay(String loanDate,int monthAdd) throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date todayDate =dateFormat.parse(loanDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, monthAdd);
        Date resultDate= calendar.getTime();
        return dateFormat.format(resultDate);
    }

    /**
     * 获取下个月第一天[2017-01-01 00:00:00]
     */
    public static Date getCurrMonthFirstDay(){
        Date todayDate = DateUtil.stringToDate2(DateUtil.dateToStringShort(new Date()));
        //Date nextMonthFirstDay = DateUtil.getMonthAfter(todayDate, 1);
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(todayDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        Date resultDate = gcLast.getTime();
        return resultDate;
    }

    /**
     * 获取日期到今天相差多少天
     */
    public static Integer subtractOfDate(Date smdate) throws ParseException {
        Date bdate=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String addDays(Date date, Integer days) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return df.format(c.getTime());
    }

    public static String getDateFromTimeMills(long millis){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(millis);
        return sdf.format(cal.getTime());
    }

    /**
     * 计算两个日期间月份差（自然数差），date2-date1,例：
     * 1.同年12-同年11月=1个月
     * 2.次年1月-当前年12月=1个月
     * 3.同年11月-同年12月=-1个月
     * 4.当前年12月-次年1月=-1个月
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthsBetweenTwoDates(Date date1, Date date2) {
        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);

        int result;
        if (year == year2) {
            result = month2 - month;// 两个日期相差几个月，即月份差
        } else {
            result = 12 * (year2 - year) + month2 - month;// 两个日期相差几个月，即月份差
        }
        return result;
    }

    /**
     * 得到月份相加后的日期
     * @Title: addMonth
     * @author WuJie
     * @date 2018年1月22日下午5:48:10
     * @param date
     * @param monthNum
     * @return
     * @throws ParseException
     */
    public static Date addMonth(Date date,int monthNum) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, monthNum);
        return rightNow.getTime();
    }

    public static String formatDateToyyyy() {
        DateFormat formatter = new SimpleDateFormat("yyyy");
        String date = formatter.format(new Date());
        return date;
    }

    public static String getDateStringByFormat(Date date, String format) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return null;
    }

    public static String formatDateByPattern(Date date,String pattern){
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String getEndTimeByStartTime(String startTime) {
        try {
            // 获取Calendar
            Calendar calendar = Calendar.getInstance();
            // 设置时间,当前时间不用设置
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            Date date= sf.parse(startTime);
            calendar.setTime(date);
            // 设置日期为本月最大日期
            calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

            // 打印
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateEndStr=format.format(calendar.getTime());
            return dateEndStr;
        } catch (ParseException e) {
            logger.warning("时间转换出现异常");
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException{
//        Date startDate  = stringToDate("2017-09-01","yyyy-MM-dd");
//        Date endDate  = stringToDate("2017-08-31","yyyy-MM-dd");
//        int count = daysBetween(startDate,endDate);
//        logger.info(count);
//    }
}
