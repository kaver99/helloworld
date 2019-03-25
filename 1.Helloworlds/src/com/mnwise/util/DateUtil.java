package com.mnwise.util;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

//safe - uses Joda Time

public class DateUtil {
  public static final DateFormatSymbols defaultDFS = new DateFormatSymbols(Locale.getDefault());
  public static final DateFormatSymbols usDFS = new DateFormatSymbols(Locale.US);
  public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd HH:mm:ss", defaultDFS);

  
//  private static DateTimeFormatter dtfJoda = DateTimeFormat.forPattern("EEE, dd MMM yyyy HH:mm:ss +0900");
//
//  public static String format(Date date) {
//    return dtfJoda.print(date.getTime());
//  }
  
  public static void init() {
    // 초기?�� ?��?��.
  }
  
  /**
   * Date ?�� �??��?�� ?���? 만큼?�� ?��?��?��.
   *
   * @param     date    ?��?���? Source date
   * @param     day     ?��?�� ?��(?��) ?��
   * @param     hour    ?��?�� ?���?
   * @param     min     ?��?�� �?
   * @param     sec     ?��?�� �?
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public static java.util.Date addTime(Date date, int day, int hour, int min, int sec) {
    long term;
    term = ( (long)day * 24L * 60L * 60L * 1000L ) +
           ( (long)hour * 60L * 60L * 1000L ) +
           ( (long)min * 60L * 1000L) +
           ( (long)sec * 1000L);
    return (new java.util.Date(date.getTime() + term));
  }
  
  /**
   * Date ?�� �??��?�� ?���? 만큼?�� ?��?��?��.
   *
   * @param     date     Source date
   * @param     sday     ?��?�� ?��(?��) ?�� (String)
   * @param     shour    ?��?�� ?���? (String)
   * @param     smin     ?��?�� �? (String)
   * @param     ssec     ?��?�� �? (String)
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public static java.util.Date addTime(Date date, String sday, String shour, String smin, String ssec) {
    long term;
    long day = Long.parseLong(sday);
    long hour = Long.parseLong(shour);
    long min = Long.parseLong(smin);
    long sec = Long.parseLong(ssec);
    term = ( day * 24L * 60L * 60L * 1000L ) +
           ( hour * 60L * 60L * 1000L ) +
           ( min * 60L * 1000L) +
           ( sec * 1000L);
    return (new java.util.Date(date.getTime() + term));
  }
  
  /**
   * Date ?�� �??��?�� ?���? 만큼?�� �??��.
   *
   * @param     date     Source date
   * @param     sday     �? ?��(?��) ?�� (String)
   * @param     shour    �? ?���? (String)
   * @param     smin     �? �? (String)
   * @param     ssec     �? �? (String)
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public static java.util.Date minusTime(Date date, String sday, String shour, String smin, String ssec) {
    long term;
    long day = Long.parseLong(sday);
    long hour = Long.parseLong(shour);
    long min = Long.parseLong(smin);
    long sec = Long.parseLong(ssec);
    term = ( day * 24L * 60L * 60L * 1000L ) +
           ( hour * 60L * 60L * 1000L ) +
           ( min * 60L * 1000L) +
           ( sec * 1000L);
    return (new java.util.Date(date.getTime() - term));
  }
  
  /**
   * Date ?�� �??��?�� 개월 ?�� 만큼?�� ?��?��?��.
   * 개월?�� ?��?�� ?��?���? 증�??�� 경우 ?��?�� 처리까�? ?��?��. 1999.10 + 4개월 = 2000.2?��
   * @param     date     Source date
   * @param     mon     ?��?�� 개월 ?��
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date addMonth(Date date, int mon) {
    // mirang: 15 FEB 2001
    // SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd HH:mm:ss", Locale.KOREA);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String yearmonth = temp.substring(0, 6);
    String time = temp.substring(6);
    int year = Integer.parseInt(yearmonth.substring(0,4));
    int month = Integer.parseInt(yearmonth.substring(4,6));
    year += (month + mon) / 12;
    month = (month + mon) % 12;
    temp = (month > 9) ? (String.valueOf(year) + String.valueOf(month) + time)
                       : (String.valueOf(year) + "0" + String.valueOf(month) + time);
    return (sdfLocal.parse(temp, new ParsePosition(0)));
    // mirang
    //return (stringToDate("yyyyMMdd HH:mm:ss", temp));
  }

  /**
   * Date ?�� �??��?�� 개월 ?�� 만큼?�� �??��.
   * 개월?�� �? ?��?���? 감소?�� 경우 ?��?�� 처리까�? ?��?��. 2007.02 - 4개월 = 2006.10?��
   * @param     date     Source date
   * @param     mon     �? 개월 ?��
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date minusMonth(Date date, int mon) {
    // mirang: 15 FEB 2001
    // SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd HH:mm:ss", Locale.KOREA);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String yearmonth = temp.substring(0, 6);
    String time = temp.substring(6);
    int year = Integer.parseInt(yearmonth.substring(0,4));
    int month = Integer.parseInt(yearmonth.substring(4,6));
    int tmp_mon= month - mon;

    if (tmp_mon < 0) year -= ((-tmp_mon)+11) / 12;
    else year += tmp_mon / 12;

    month = tmp_mon % 12;

    if (month < 0) month = (12 + month);

    temp = (month > 9) ? (String.valueOf(year) + String.valueOf(month) + time)
                       : (String.valueOf(year) + "0" + String.valueOf(month) + time);
    return (sdfLocal.parse(temp, new ParsePosition(0)));
    // mirang
    //return (stringToDate("yyyyMMdd HH:mm:ss", temp));
  }
  
  /**
   * Date ?�� �??��?�� 개월 ?�� 만큼?�� ?��?��?��.
   * 개월?�� ?��?�� ?��?���? 증�??�� 경우 ?��?�� 처리까�? ?��?��. 1999.10 + 4개월 = 2000.2?��
   * @param     date     Source date
   * @param     mon     ?��?�� 개월 ?��
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date addMonth(Date date, String mon) {
    // mirang: 15 FEB 2001
    // SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd HH:mm:ss", Locale.KOREA);
    return addMonth(date, Integer.parseInt(mon));
  }
  
  /**
   * Date ?�� �??��?�� ?�� ?�� 만큼?�� ?��?��?��.
   *
   * @param     date     Source date
   * @param     y     ?��?�� ?�� ?��
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date addYear(Date date, int y) {
    // mirang
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String nyear = temp.substring(0, 4);
    String srest = temp.substring(4);
    int year = Integer.parseInt(nyear);
    year += y;
    temp = String.valueOf(year) + srest;
    // return (stringToDate("yyyyMMdd HH:mm:ss", temp));
    return (sdfLocal.parse(temp, new ParsePosition(0)));
  }

  /**
   * Date ?�� �??��?�� ?�� ?�� 만큼?�� �??��.
   *
   * @param     date     Source date
   * @param     tempyear     �? ?�� ?��
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date minusYear(Date date, String tempyear) {
    int y = Integer.parseInt(tempyear);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String nyear = temp.substring(0, 4);
    String srest = temp.substring(4);
    int year = Integer.parseInt(nyear);
    year -= y;
    temp = String.valueOf(year) + srest;
    //return (stringToDate("yyyyMMdd HH:mm:ss", temp));
    return (sdfLocal.parse(temp, new ParsePosition(0)));
  }
  
  /**
   * Date ?�� �??��?�� ?�� ?�� 만큼?�� ?��?��?��.
   *
   * @param     date     Source date
   * @param     tempyear     ?��?�� ?�� ?�� (String)
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date addYear(Date date, String tempyear) {
    int y = Integer.parseInt(tempyear);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String nyear = temp.substring(0, 4);
    String srest = temp.substring(4);
    int year = Integer.parseInt(nyear);
    year += y;
    temp = String.valueOf(year) + srest;
    //return (stringToDate("yyyyMMdd HH:mm:ss", temp));
    return (sdfLocal.parse(temp, new ParsePosition(0)));
  }
  
  /**
   * Date ?�� �??��?�� ?�� ?�� 만큼?�� ?��?��?��.
   *
   * @param     date     Source date
   * @param     daytemp     ?��?�� ?�� ?�� (String)
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date addDay(Date date,String daytemp) {
    int d = Integer.parseInt(daytemp);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    //SimpleDateFormat formatter = new SimpleDateFormat ("yyyyMMdd HH:mm:ss", Locale.KOREA);
    //ParsePosition pos = new ParsePosition(0);
    String temp = sdfLocal.format(date);
    String nday = temp.substring(0, 8);
    String srest = temp.substring(8);
    int day = Integer.parseInt(nday);
    day += d;
    temp = String.valueOf(day) + srest;
    //return (stringToDate("yyyyMMdd HH:mm:ss", temp));
    return (sdfLocal.parse(temp, new ParsePosition(0)));
  }

  /**
   * Date ?�� �??��?�� ?�� ?�� 만큼?�� �?.
   *
   * @param     date     Source date
   * @param     daytemp     �? ?�� ?�� (String)
   * @return     java.util.Date  계산 ?�� Date
   * @since     com.imas.foundation
   * ?���? 버그?��?��.. ?���?마시�?..
   */
  public synchronized static java.util.Date minusDay(Date date,String daytemp) {
    int d = Integer.parseInt(daytemp);
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    String temp = sdfLocal.format(date);
    String nday = temp.substring(0, 8);
    String srest = temp.substring(8);
    int day = Integer.parseInt(nday);
    day -= d;
    temp = String.valueOf(day) + srest;
    return (sdfLocal.parse(temp, new ParsePosition(0)));
  }
  
  /**
   * ?��?�� ?��짜에?�� ?��?���? 만큼 add ?��?�� 리턴
   * 3?�� ?��?���? 주면 3?�� ?�� ?��짜�? 리턴?���? -3?�� 주면 3?��?��?�� 리턴?��.
   * @param day
   * @return
   */
  @SuppressWarnings("static-access")
public synchronized static  java.util.Date addDay(String day) {
	  
	  GregorianCalendar cal = new GregorianCalendar();
	  cal.add(cal.DATE, Integer.parseInt(day));
	  return cal.getTime();
  }
  
  /**
   * Date�? MIME(Email)?�� Date?��?��?���? 바꾼?��.
   * �? EEE, dd MMM yyyy HH:mm:ss +gmt
   * ?���??�� 경우 Fri, 26 Jan 2001 09:13:34 +0900 (KST)
   * �? 같�? ?��?���? 바�?�다.
   *
   * @param     date     Source date
   * @return    �??�� ?�� Date String
   * @since     com.imas.foundation
   */
  public synchronized static String getMimeDate(java.util.Date date) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.setDateFormatSymbols(usDFS);
    sdfLocal.applyPattern("EEE, dd MMM yyyy HH:mm:ss +0900");
    return (sdfLocal.format(date));
  }

  /**
   *  MIME(Email)?�� Date string ?�� java.util.Date?��?���? 바꾼?��.
   * �? EEE, dd MMM yyyy HH:mm:ss +gmt
   * ?���??�� 경우 Fri, 26 Jan 2001 09:13:34 +0900 (KST)
   * �? 같�? ?��?���? 바�?�다.
   *
   * @param     date     Source date string
   * @return    �??�� ?�� java.util.Date
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date parseMimeDate(String datestr) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.setDateFormatSymbols(usDFS);
    sdfLocal.applyPattern("EEE, dd MMM yyyy HH:mm:ss +0900");
    return (sdfLocal.parse(datestr, new ParsePosition(0)));
  }
  
  /**
   * java.util.Date�? ?��?�� format?�� 문자?���? 바꾼?��.
   * format?�� ?��?��?? ?��?��?? 같다.
   *
   * yyyy : year
   * MM : Month (0-12)
   * MMM : Month (JAN, FEB, MAR....)
   * EEE : Day (Mon, Tue, Wed...)
   * dd : date
   * HH : hour
   * mm : minute
   * ss : second
   *
   * ?��) yyyy-MM-dd HH:mm:ss
   * ?��) EEE, dd MMM yyyy HH:mm:ss +0900
   *
   * @param     format     Date convert format
   * @param     date       Source date
   * @return    �??�� ?�� date string
   * @see       java.text.SimpleDateFormat
   * @since     com.imas.foundation
   */
  // Counter.inc()
  // yyyyMMddHHmmssSSS
  public synchronized static String dateToString(String format, java.util.Date date) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern(format);
    return (sdfLocal.format(date));
    /*
    if (simpleDateFormatB == null) simpleDateFormatB = new SimpleDateFormat(format, Locale.US);
    //mirang 2001/02/15: SimpleDateFormat formatter = new SimpleDateFormat (format, Locale.KOREA);
    //mirang 2001/02/15: SimpleDateFormat formatter = new SimpleDateFormat (format, Locale.US);
    //?��?��?���??��?��: ParsePosition pos = new ParsePosition(0);
//   return (formatter.format(addTime(date, 0, 16, 0, 0)));
   //mirang 2001/02/15:  return (formatter.format(date));
    return (simpleDateFormatB.format(date));*/
  }
  
  /**
   * ?��?�� format?�� 문자?��?�� java.util.Date�? 바꾼?��.
   * format?�� ?��?��?? ?��?��?? 같다.
   *
   * yyyy : year
   * MM : Month (0-12)
   * MMM : Month (JAN, FEB, MAR....)
   * EEE : Day (Mon, Tue, Wed...)
   * dd : date
   * HH : hour
   * mm : minute
   * ss : second
   *
   * ?��) yyyy-MM-dd HH:mm:ss
   * ?��) EEE, dd MMM yyyy HH:mm:ss +0900
   *
   * @param     format     Date convert format
   * @param     date       Source date string
   * @return    �??�� ?�� date (java.util.Date)
   * @see       java.text.SimpleDateFormat
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date stringToDate(String format, String datestr) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern(format);
    Date date = sdfLocal.parse(datestr, new java.text.ParsePosition(0));
    return date;
  }
  
  /**
   * java.util.Date�? yyyy-MM-dd HH:mm:ss format?�� 문자?���? 바꾼?��.
   *
   * @param     date       Source date
   * @return    �??�� ?�� date
   * @see       java.text.SimpleDateFormat
   * @since     com.imas.foundation
   */
  public synchronized static String dateToString(Date date) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    return (sdfLocal.format(date)); // US�? 바꾸?��
    //dateToString("yyyy-MM-dd HH:mm:ss", date));
  }
  
  /**
   * yyyy-MM-dd HH:mm:ss format?�� 문자?��?�� java.util.Date�? 바꾼?��.
   *
   * @param     date       Source date string
   * @return    �??�� ?�� date (java.util.Date)
   * @see       java.text.SimpleDateFormat
   * @since     com.imas.foundation
   */
  public synchronized static java.util.Date stringToDate(String datestr) {
    SimpleDateFormat sdfLocal = (SimpleDateFormat)SDF.clone();
    sdfLocal.applyPattern("yyyyMMdd HH:mm:ss");
    return (sdfLocal.parse(datestr, new java.text.ParsePosition(0)));
  }
  
  /**
   * ?��?�� ?��간을 yyyy-MM-dd HH:mm:ss format?���? 구한?��.
   *
   * @return    ?��?�� ?���? date
   * @see       java.text.SimpleDateFormat
   * @since     com.imas.foundation
   */
  public static String getTimeString() {
    return dateToString(new Date());
  }
  
  /**
   * String ?��?��?�� ?���? 값을 format ?��?���? �?�?
   * 
   * @param oriFormat ?��?�� ?��간값 ?���? ?��?��
   * @param desFormat 바�? ?��간값 ?���? ?��?��
   * @param date ?��?�� ?���?
   * @return 바�?? ?���? ?��?��?�� ?��?�� ?���?
   * @throws ParseException
   */
  public static String stringToString(String oriFormat, String desFormat, String date) throws ParseException {
  	SimpleDateFormat inFormat = new SimpleDateFormat(oriFormat);
  	SimpleDateFormat outFormat = new SimpleDateFormat(desFormat);
  	
  	Date d = inFormat.parse(date);
  	
  	return outFormat.format(d);
  }

  public static void main(String[] args) {
  	try {
  		Date d = new Date();
  		for(int cnt=0;cnt<=13;cnt++){
  			String sSendStartDt = dateToString("yyyyMM", addMonth(d, -cnt));
  			System.out.println("�??��?���? "+sSendStartDt +" - �?: " + cnt);
  		}
  		System.out.println(stringToString("yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "20091009095012"));
  	} catch (Exception e) {
  		e.printStackTrace();
  	}
  }

  public static String getRandomNumber() {
    double dTemp = Math.random()%1000;
    return String.valueOf(dTemp);
  }
}
