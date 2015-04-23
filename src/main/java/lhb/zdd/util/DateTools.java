/*******************************************************************************
 * 
 * <b>创建日期: </b> 2004-8-12<br>
 * <b>标题: </b>日期格式化工具类<br>
 * <b>类描述: </b>对日期进行加减运算，格式化，闰年处理<br>
 * <br>
 * <p>
 * Copyright: Copyright (c)2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author zhouxj
 * 
 * @version 1.28
 * 
 * @since 2003-2015
 * 
 * @see
 * 1.09 修改了isTime对00小时00分00秒的时间的处理的问题
 * 1.10 修改了toDate月份表示错误的问题
 * 1.11 增加了取上一日的算法，修正了时区问题，取本地时间不在会有时间差
 * 1.13 增加了时间相加函数函数
 * 1.14 修改了函数名
 * 1.15 增加了Timestamp转Date形式
 * 1.16 增加了getTimeByFormat（）方法
 * 1.17 增加了getGMTByFormat（）方法
 * 1.18 增加了getCurrentTimeStrMs（）方法
 * 1.19 增加了getPStr（）方法
 * 1.20 增加了getGMTByFormat3方法
 * 1.21 增加了一些异常处理方法
 * 1.22 修改了一些会导致异常的BUG，atol()
 * 1.23 增加了getCurrentTimeSprit()
 * 1.24 增加了getTimeByFormat,getTimeCN方法
 * 1.25 修改了时间默认格式，更改了下午时间显示。
 * 1.26 增加了getSomeDay()方法
 * 1.27 增加了getSomeMonth() 方法
 * 1.28 修改了getTimeCN的空值处理
 ******************************************************************************/

package lhb.zdd.util;

import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateTools {
	/**
	 * 
	 */
	private static java.util.Calendar Cal_temp=Calendar.getInstance(); 

	private static java.util.Date D_date= Cal_temp.getTime() ;

	private static String sTimeZone="GMT-8";

/**
 * 从格林威治时间转换为本地标准时间格式
 * @param args
 */
	public static void main(String[] args) {


		System.out.println(getTimeByFormat("1426558238")); //输出 1414380888
	}
	/**
	 * 将格林威治时间秒数转成时间，带秒数格式
	 * @param second
	 * @return
	 */
	public static String getTimeByFormat(String second) {
		return getTimeByFormat(second,"yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 将格林威治时间秒数转成时间，指定格式化字符
	 * @param second 格林威治时间秒数
	 * @param FMT 格式化字符，例如："yyyy年MM月dd日 hh时mm分ss秒"
	 * @return
	 */
	public static String getTimeByFormat(String second ,String FMT){
		try{
			if(isEmpty(second)) return "";
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(Long.valueOf(second+"000"));
			Date d1=cal.getTime();
			java.text.DateFormat format1 = new java.text.SimpleDateFormat(FMT);
		    String  sd1 = format1.format(d1);
		        
			return sd1; 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return second+"";
		}  
	}
	/**
	 * 将格林威治时间秒数转成时间，带秒数格式
	 * @param second
	 * @return
	 */
	public static String getTimeByFormat(long second) {
		return getTimeByFormat(second+"","yyyy-MM-dd HH:mm:ss");
	}	
	/**
	 * 将带秒数格式yyyy-MM-dd HH:mm:ss转化 格林威治时间秒数，
	 * @param second
	 * @return
	 */
	public static String getGMTByFormat(String strd) {
		String timeS;
		try {
			timeS = unformatYMD(strd);
			Date d1=toDate(timeS);

			long l_time=d1.getTime()/1000; //格林威治时间秒数
			return Long.toString(l_time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return strd;
		}    
		 
	}
	
	/**
	 * 将带秒数格式yyyyMMddhhmmss转化 格林威治时间秒数，
	 * @param second
	 * @return
	 */
	public static String getGMTByFormat3(String strd) {
		String timeS;
		try {
			//timeS = unformatYMD(strd);
			Date d1=toDate(strd);

			long l_time=d1.getTime()/1000; //格林威治时间秒数
			return Long.toString(l_time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return strd;
		}    
		 
	}
	/**
	 *  将格林威治时间秒数转成短时间格式yyyy-MM-dd，不带秒数格式
	 * @param second
	 * @return
	 */
	public static String getTimeByFormat2(String second) {
		return getTimeByFormat(second,"yyyy-MM-dd");
	}
	/**
	 *  将格林威治时间秒数转成短时间格式yyyy年MM月dd日，不带秒数格式
	 * @param second
	 * @return
	 */	
	public static String getTimeCN(String second) {
		if(isEmpty(second)) return "";
		return getTimeByFormat(second,"yyyy年MM月dd日");
	}
	/**
	 *  将格林威治时间秒数转成短时间格式，不带秒数格式
	 * @param second
	 * @return
	 */
	public static String getTimeByFormat2(long second) {
		return getTimeByFormat(second+"","yyyy-MM-dd");
	}
	
	/**
	 * 将格林威治时间秒数转成时间格式yyyy-MM-dd HH:mm
	 * @param second
	 * @return
	 */
	public static String getTimeByFormat3(String second) {
		return getTimeByFormat(second,"yyyy-MM-dd HH:mm");
		
	}
	/**
	 * 将带秒数格式yyyy-MM-dd转化 格林威治时间秒数，
	 * @param second
	 * @return
	 */
	public static String getGMTByFormat2(String strd) {
	    if(isEmpty(strd)) return strd;
	    
		return getGMTByFormat(strd+" 00:00:00");
	}

	//设置时区	，中国区为GMT-8
	public static void setTimeZone(String sGMT) throws Exception {
//
//		String sGMT="GMT";
//		if(i_num>0){
//			sGMT=sGMT+"+"+i_num;
//		}
//		if(i_num<0){
//			sGMT=sGMT+i_num;
//		}		
		sTimeZone=sGMT;
		Cal_temp.setTimeZone(TimeZone.getTimeZone(sGMT));
		Cal_temp.set(Calendar.MILLISECOND,0);
		D_date=Cal_temp.getTime() ;
	}

	/**
	 * <b>功能描述: </b>对日期变量(YYYYMMDD)进行加减以日期计算<br>
	 * <p>
	 * DateTools.addDate("19990908",-30)) 结果为 19990809
	 * </p>
	 * 
	 * @param s_Date
	 *            日期
	 * @param i_num
	 *            加减的天数
	 * @return 加减后的日期
	 * @throws Exception
	 * 
	 */
	public static String addDate(String s_Date, int i_num) throws Exception {
//		Calendar Cal_temp= Calendar.getInstance();
		if (!isDate(s_Date)) {
			return "Not a valid date";
		}

		String y = s_Date.substring(0, 4); // year
		int i_y = cInt(y);
		String m = s_Date.substring(4, 6); // month
		int i_m = cInt(m) - 1; // month is from 00.
		String d = s_Date.substring(6, 8); // day
		int i_d = cInt(d);
	
		Cal_temp.clear();
		Cal_temp.set(i_y, i_m, i_d);
		// set(int year, int month, int date) Sets the values for the fields
		// year, month, and date.
		/*
		 * Cal_temp.set(Cal_temp.YEAR,i_y); Cal_temp.set(Cal_temp.MONTH,i_m);
		 * Cal_temp.set(Cal_temp.DATE,i_d);
		 */
		Cal_temp.add(Cal_temp.DATE, i_num); // add(Calendar.DATE, -5).

		// long l_k= Cal_temp.get(Cal_temp.time);
		i_y = Cal_temp.get(Cal_temp.YEAR);
		i_m = Cal_temp.get(Cal_temp.MONTH) + 1; // add a month
		i_d = Cal_temp.get(Cal_temp.DATE);

		int i_len;

		y = "0000" + cStr(i_y);
		i_len = y.length();
		y = y.substring(i_len - 4, i_len); // 取最右边4个字符

		m = "00" + cStr(i_m);
		i_len = m.length();
		m = m.substring(i_len - 2, i_len); // 取最右边2个字符

		d = "00" + cStr(i_d);
		i_len = d.length();
		d = d.substring(i_len - 2, i_len); // 取最右边2个字符

		String s_ret = y + m + d;

		return s_ret;
	}

	/**
	 * <b>功能描述: </b>对日期变量(YYYYMMDD)进行加减以月份计算<br>
	 * <p>
	 * DateTools.addMonth("19990908",6) 结果为 20000308
	 * </p>
	 * 
	 * @param s_Date
	 *            日期
	 * @param i_num
	 *            加减的月数
	 * @return 加减后的日期
	 * @throws Exception
	 * 
	 */
	public static String addMonth(String s_Date, int i_num) throws Exception {
		// java.util.Calendar Cal_temp2= java.util.Calendar.getInstance();
		if (!isDate(s_Date)) {
			return "Not a valid date";
		}

		String y = s_Date.substring(0, 4); // year
		int i_y = cInt(y);
		String m = s_Date.substring(4, 6); // month
		int i_m = cInt(m) - 1; // month is from 00.
		String d = s_Date.substring(6, 8); // day
		int i_d = cInt(d);

		Cal_temp.clear();
		Cal_temp.set(i_y, i_m, i_d);
		// set(int year, int month, int date) Sets the values for the fields
		// year, month, and date.
		/*
		 * Cal_temp.set(Cal_temp.YEAR,i_y); Cal_temp.set(Cal_temp.MONTH,i_m);
		 * Cal_temp.set(Cal_temp.DATE,i_d);
		 */
		Cal_temp.add(Cal_temp.MONTH, i_num); // add(Calendar.DATE, -5).

		i_y = Cal_temp.get(Cal_temp.YEAR);
		i_m = Cal_temp.get(Cal_temp.MONTH) + 1; // add a month
		i_d = Cal_temp.get(Cal_temp.DATE);

		int i_len;

		y = "0000" + cStr(i_y);
		i_len = y.length();
		y = y.substring(i_len - 4, i_len); // 取最右边4个字符

		m = "00" + cStr(i_m);
		i_len = m.length();
		m = m.substring(i_len - 2, i_len); // 取最右边2个字符

		d = "00" + cStr(i_d);
		i_len = d.length();
		d = d.substring(i_len - 2, i_len); // 取最右边2个字符

		String s_ret = y + m + d;

		return s_ret;
	}

	/**
	 * <b>功能描述: </b>转换String为int<br>
	 * <p>
	 * </p>
	 * 
	 * @param s_temp
	 * @return
	 * @throws Exception
	 * 
	 */
	public static int cInt(String s_temp) throws Exception {
		int i_temp;
		if (isInt(s_temp)) {
			i_temp = Integer.parseInt(s_temp);
		} else {
			Exception ee = new Exception("Not an int number!");
			throw ee;
		}

		// doule d_num=Double.parseDouble((Sting)S_num);
		/*
		 * //String toString(int i) String
		 * s_Ins=String.valueOf(this.getDoubleAt("InsAmount"));
		 * java.text.DecimalFormat df = new java.text.DecimalFormat();
		 * df.applyLocalizedPattern("#,##0.00"); String ss =
		 * df.format(this.getDoubleAt("InsAmount"));
		 */
		return i_temp;
	}

	/**
	 * <b>功能描述: </b>转换int为String<br>
	 * <p>
	 * </p>
	 * 
	 * @param i_temp
	 * @return
	 * 
	 */
	public static String cStr(int i_temp) {
		String s_temp = Integer.toString(i_temp);
		return s_temp;
	}

	/**
	 * <b>功能描述: </b>转换long为String<br>
	 * <p>
	 * </p>
	 * 
	 * @param i_temp
	 * @return
	 * 
	 */
	public static String cStrlong(long i_temp) {
		String s_temp = Long.toString(i_temp);
		return s_temp;
	}
	/**
	 * <b>功能描述: </b>计算两个日期的间隔天数<br>
	 * <p>
	 * 可以比较两个日期的大小 。DayBetween("19990830","19990901") 结果为2.
	 * </p>
	 * 
	 * @param s_from
	 *            开始日期
	 * @param s_end
	 *            结束日期
	 * @return 结果日期-开始日期的天数
	 * @throws Exception
	 * 
	 */
	public static long dayBetween(String s_from, String s_end) throws Exception {
		long l_fromDay;
		long l_endDay;

		String s_Date = s_from;

		if (!isDate(s_Date)) {
			Exception ee = new Exception("Not a valid Date!");
			throw ee;
		}

		String y = s_Date.substring(0, 4); // year
		int i_y = cInt(y);
		String m = s_Date.substring(4, 6); // month
		int i_m = cInt(m) - 1; // month is from 00.
		String d = s_Date.substring(6, 8); // day
		int i_d = cInt(d);

		Cal_temp.clear();
		Cal_temp.set(i_y, i_m, i_d);
		D_date = Cal_temp.getTime();
		l_fromDay = D_date.getTime() / (24 * 60 * 60 * 1000);
		// 将开始时间转成从since January 1, 1970, 00:00:00 GMT 算起的天数。

		s_Date = s_end;
		if (!isDate(s_Date)) {
			throw new Exception();
		}

		y = s_Date.substring(0, 4); // year
		i_y = cInt(y);
		m = s_Date.substring(4, 6); // month
		i_m = cInt(m) - 1; // month is from 00.
		d = s_Date.substring(6, 8); // day
		i_d = cInt(d);

		Cal_temp.clear();
		Cal_temp.set(i_y, i_m, i_d);
		D_date = Cal_temp.getTime();
		l_endDay = D_date.getTime() / (24 * 60 * 60 * 1000);
		// 将开始时间转成从since January 1, 1970, 00:00:00 GMT 算起的天数。

		return l_endDay - l_fromDay;

	}

	/**
	 * <b>功能描述: </b><br>
	 * <p>
	 * 计算两个时间点的间隔的秒数
	 * </p>
	 * 
	 * @param D_from
	 * @param D_end
	 * @return 间隔的秒数
	 * 
	 */
	public static long timeBetween(Date D_from, Date D_end) {
		long l_from = D_from.getTime();
		long l_end = D_end.getTime();
		long l_Secondbtw = (l_end - l_from) / 1000;
		return l_Secondbtw;
	}
	
	/**
	 * <b>功能描述: </b><br>
	 * <p>
	 * 计算两个时间点的间隔的秒数
	 * </p>
	 * 
	 * @param String from 开始时间 yyyyMMDDHHmmss
	 * @param String end 结束时间 yyyyMMDDHHmmss
	 * @return 间隔的秒数
	 * @throws Exception 
	 * 
	 */
	public static long timeBetweenS(String from, String end) throws Exception {
		Date D_from=toDate(from);
		Date D_end=toDate(end);		
		long l_Secondbtw=timeBetween(D_from,D_end);
		return l_Secondbtw;
	}
	/**
	 * <b>功能描述: </b>将日期YYYYMMDD转换为加"/"<br>
	 * <p>
	 * </p>
	 * 
	 * @param s_Date
	 *            日期YYYYMMDD
	 * @return 日期YYYY/MM/DD
	 * @throws Exception
	 * 
	 */
	public static String formatYMD(String s_Date) throws Exception {
		if (isDate(s_Date)) {
			String s_retrun = s_Date.substring(0, 4) + "/"
					+ s_Date.substring(4, 6) + "/" + s_Date.substring(6, 8);
			return s_retrun;
		} else {
			return "Not a valid date!";
		}
		/*
		 * java.text.SimpleDateFormat dateFmt1 = new
		 * java.text.SimpleDateFormat(format); // format:"yyyy.MM.dd G 'at'
		 * HH:mm:ss z" ->> 1996.07.10 AD at 15:08:56 PDT
		 * 
		 * java.util.Calendar c1 = java.util.Calendar.getInstance();
		 * c1.set(year,month-1,date,hour,minute,second); tmpStr1 =
		 * dateFmt1.format(c1.getTime());
		 */
	}

	/**
	 * <b>功能描述: </b>将日期YYYYMMDD转换为加"-"<br>
	 * <p>
	 * </p>
	 * 
	 * @param s_Date
	 *            日期YYYYMMDD
	 * @return 日期YYYY-MM-DD
	 * @throws Exception
	 * 
	 */
	public static String formatYMD2(String s_Date) throws Exception {
		if (isDate(s_Date)) {
			String s_retrun = s_Date.substring(0, 4) + "-"
					+ s_Date.substring(4, 6) + "-" + s_Date.substring(6, 8);
			return s_retrun;
		} else {
			return "Not a valid date!";
		}

	}

	/**
	 * <b>功能描述: </b>将数字日期转换成日期字符串<br>
	 * <p>
	 * </p>
	 * 
	 * @param i_date
	 *            数字日期
	 * @return 日期
	 * @throws Exception
	 * 
	 */
	public String getStrDate(int i_date) throws Exception {
		String s_Date = cStr(i_date);
		if (isDate(s_Date)) {
			return s_Date;
		} else {
			return "Not a valid Date!";
		}

	}

	/**
	 * <b>功能描述: </b>日期字符<br>
	 * <p>
	 * </p>
	 * 
	 * @param s_date
	 * @return
	 * 
	 */
	public String getStrDate(String s_date) throws Exception {
		if (isDate(s_date)) {
			return s_date;
		} else {
			return "Not a valid Date!";
		}
	}

	/**
	 * <b>功能描述: </b>判断日期的合法性<br>
	 * <p>
	 * </p>
	 * 
	 * @param theStr
	 *            日期YYYYMMDD
	 * @return true or flase
	 * @throws Exception
	 * 
	 */
	public static boolean isDate(String theStr) throws Exception {
		if (theStr.length() != 8)
			return false;
		String y = theStr.substring(0, 4);
		int i_y = cInt(y);
		String m = theStr.substring(4, 6);

		int i_m = cInt(m);
		if (i_m < 1 || i_m > 12)
			return false;

		String d = theStr.substring(6, 8);
		int i_d = cInt(d);

		int maxDays = 31;
		if (isInt(m) == false || isInt(d) == false || isInt(y) == false) {
			return (false);
		} else if (i_y < 1000 || i_y > 9999) {
			return (false);
		} else if (i_m == 4 || i_m == 6 || i_m == 9 || i_m == 11)
			maxDays = 30;
		else if (i_m == 2) {
			if ((i_y % 4) > 0)
				maxDays = 28;
			else if ((i_y % 100) == 0 && (i_y % 400) > 0)
				maxDays = 28;
			else
				maxDays = 29;
		}
		if (i_d < 1 || i_d > maxDays) {
			return (false);
		}
		// if (isBetween(d,1,maxDays) == false) { return(false);}

		else {
			return (true);
		}

	}

	/**
	 * <b>功能描述: </b>判断日期时间的合法性<br>
	 * <p>
	 * </p>
	 * 
	 * @param theStr
	 *            日期yyyyMMDDHHmmss
	 * @return true or flase
	 * @throws Exception
	 * 
	 */
	public static boolean isTime(String theStr) throws Exception {
		if (theStr.length() != 14)
			return false;
		String ymd = theStr.substring(0, 8);
		boolean df = isDate(ymd);
		if (df == false)
			return false;
		String hh = theStr.substring(8, 10);
		int i_hh = cInt(hh);
		if (i_hh < 0 || i_hh > 23)
			return false;
		String mm = theStr.substring(10, 12);
		int i_mm = cInt(mm);
		if (i_mm < 0 || i_mm > 59)
			return false;
		String ss = theStr.substring(12, 14);
		int i_ss = cInt(ss);
		if (i_ss < 0 || i_ss > 59) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * <b>功能描述: </b>判断是否数字<br>
	 * <p>
	 * </p>
	 * 
	 * @param theNum
	 * @return
	 * 
	 */
	public static boolean isDigit(String theNum) {
		String theMask = "0123456789";
		if (isEmpty(theNum))
			return false;
		else if (theMask.indexOf(theNum) == -1)
			return false;
		return true;
	}

	/**
	 * <b>功能描述: </b>判断是否空值<br>
	 * <p>
	 * </p>
	 * 
	 * @param str
	 * @return
	 * 
	 */
	public static boolean isEmpty(String s) {

		if (null == s ||  "".equals(s.trim()) || "null".equalsIgnoreCase(s)) 
			return true;
		else
			return (false);
	}

	/**
	 * <b>功能描述: </b>判断是否整数值<br>
	 * <p>
	 * </p>
	 * 
	 * @param theStr
	 * @return
	 * @throws Exception
	 * 
	 */
	public static boolean isInt(String theStr) throws Exception {
		boolean flag = true;
		theStr = trim(theStr);
		if (isEmpty(theStr))
			flag = true;
		else {
			if (theStr.substring(0, 1).equals("-")) // 负数
				theStr = theStr.substring(1);
			for (int i = 0; i < theStr.length(); i++) {
				if (isDigit(theStr.substring(i, i + 1)) == false) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	/**
	 * <b>功能描述: </b>去掉首尾空格<br>
	 * <p>
	 * </p>
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 * 
	 */
	public static String trim(String str) throws Exception {
		String returnstr = "";
		if (str==null)
			return str;
		if ("".equals(str))
			return "";
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				continue;
			}
			break;
		}
		str = str.substring(i, str.length());
		if ("".equals(str))
			return "";
		for (i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				continue;
			}
			break;
		}
		returnstr = str.substring(0, i + 1);
		return returnstr;
	}

	/**
	 * <b>功能描述: </b>去掉日期格式化<br>
	 * <p>
	 * 1999/01/09->19990109
	 * </p>
	 * 
	 * @param s_Date
	 *            日期YYYY/MM/DD或者YYYY-MM-DD日期YYYY/MM/DD HH:mm:ss 或者YYYY-MM-DD HH:mm:ss
	 * @return 日期YYYYMMDD 或者  YYYYMMDDhhmmss
	 * @throws Exception
	 * 
	 */
	public static String unformatYMD(String s_Date) throws Exception {

		if (isEmpty(s_Date)) {
			return "Not a valid date!";
		}
		s_Date=s_Date.trim();
		s_Date=s_Date.replace("-", "");
		s_Date=s_Date.replace(" ", "");
		s_Date=s_Date.replace("/", "");
		s_Date=s_Date.replace(":", "");
		return s_Date;
	}

	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间[MM/dd HH:mm:ss:SSSS]
	 * 
	 */
	public static String getCurrentTimeString() {

		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat(
				"MM/dd HH:mm:ss:SSSS");
		Date date = getCurrentTimeDate();
		return "[" + fmt.format(date) + "] ";
	}
	/**
	 * <b>功能描述: </b>取现格林威治时间，秒数格式<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间[从 1970年的 秒数1970-01-01 00:00:00 GMT]
	 * 
	 */
	public static long getCurrentSecond() {

	
		Date date = getCurrentTimeDate();
		long l_t=date.getTime()/1000; //将毫秒转化成秒
		return l_t;
	}
		
	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间[HH:mm:ss:]
	 * 
	 */
	public static String getCurrentTimeStringHms() {

		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat(
				"HH:mm:ss:");
		Date date = getCurrentTimeDate();
		return  fmt.format(date) ;
	}
	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间yyyyMMddHHmmss
	 * 
	 */
	public static String getCurrentTimeStringyyyyMMddHHmmss() {

		Date curDate = getCurrentTimeDate();
		SimpleDateFormat fmtdate = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = fmtdate.format(curDate);

		return datetime;
	}
	/**
	 * <b>功能描述: </b>取现在时间,精确到毫秒级<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间yyyyMMddHHmmssSSS
	 * 
	 */
	public static String getCurrentTimeStrMs() {

		Date curDate = getCurrentTimeDate();
		SimpleDateFormat fmtdate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String datetime = fmtdate.format(curDate);

		return datetime;
	}

	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间yyyyMMdd
	 * 
	 */
	public static String getCurrentDateString() {

		Date curDate =getCurrentTimeDate();
		SimpleDateFormat fmtdate = new SimpleDateFormat("yyyyMMdd");
		String datetime = fmtdate.format(curDate);

		return datetime;
	}
	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * @return 现在时间yyyy-MM/dd
	 */
	public static String getCurrentTimeSprit() {

		Date curDate = getCurrentTimeDate();
		SimpleDateFormat fmtdate = new SimpleDateFormat("yyyy-MM/dd");
		String datetime = fmtdate.format(curDate);

		return datetime;
	}
	/**
	 * <b>功能描述: </b>取上一日时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在上一日的日期yyyyMMdd
	 * @throws Exception 
	 * 
	 */
	public static String getLastDateString() throws Exception {

		String sLastDay=addDate(getCurrentDateString(),-1);
		return sLastDay;
	}
	/**
	 * <b>功能描述: </b>取现在时间<br>
	 * <p>
	 * </p>
	 * 
	 * @return 现在时间Date
	 * 
	 */
	public static Date getCurrentTimeDate() {
		
		Calendar Cal_temp=Calendar.getInstance(); 
//		Cal_temp.setTimeZone(TimeZone.getTimeZone(sTimeZone));
//		Cal_temp.set(Calendar.MILLISECOND,0);
		Date date=Cal_temp.getTime() ;
		return date;
	}

	/**
	 * <b>功能描述: </b>返回s_year年s_month月的天数<br>
	 * <p>
	 * </p>
	 * 
	 * @param s_year
	 *            年
	 * @param s_month
	 *            月份
	 * @return 当月的天数
	 * 
	 */
	public static int getDays(String s_year, String s_month) {
		int year = atoi(s_year);
		int month = atoi(s_month);
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 下面的这段代码是判断当前是否是闰年的
		if (month == 2)
			return ((0 == year % 4) && (0 != (year % 100)))
					|| (0 == year % 400) ? 29 : 28;
		else
			return daysInMonth[month - 1];
	}

	/**
	 * <b>功能描述: </b>判断年份是否润年<br>
	 * <p>
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public static boolean isLeapYear(String s_year) {
		int year = atoi(s_year);
		boolean bflag;
		if (((0 == year % 4) && (0 != (year % 100))) || (0 == year % 400)) {
			bflag = true;
		} else {
			bflag = false;
		}
		return bflag;
	}

	/**
	 * <b>功能描述: </b>求两日期间的间隔天数<br>
	 * <p>
	 * DateTools.getDaysBetweenDate("20040301","20040301") 结果为1。
	 * 不推荐的方法，用DayBetween方法更方便
	 * </p>
	 * 
	 * @param startdate
	 *            开始日期
	 * @param enddate
	 *            结束日期
	 * @return 天数
	 * @throws Exception
	 * 
	 */
	public static int getDaysBetweenDate(String startdate, String enddate)
			throws Exception {
		if (startdate.length() != 8 || enddate.length() != 8)
			throw new Exception("日期格式错误" + startdate + ", " + enddate);

		long d1 = parseDate(startdate, "yyyyMMdd").getTime();
		long d2 = parseDate(enddate, "yyyyMMdd").getTime();
		long d3 = d2 - d1;

		return atoi(String.valueOf(d3 / (1000 * 60 * 60 * 24) + 1));
		// return 0;
	}

	/**
	 * <b>功能描述: </b>按日期字符串格式转换为日期类型<br>
	 * <p>
	 * </p>
	 * 
	 * @param date
	 *            日期字符串
	 * @param fmt
	 *            日期字符串的格式，如"yyyy/MM/dd"代表"2002/02/15" ,"HH:mm:ss"代表24时和分秒，"hh'a:mm:ss"代表12时AM和分秒
	 * @return 返回日期
	 * @throws Exception
	 * 
	 */
	public static java.util.Date parseDate(String date, String fmt)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		ParsePosition pos = new ParsePosition(0);
		java.util.Date newDate = sdf.parse(date, pos);
		return newDate;
	}

	/**
	 * <b>功能描述: </b>转换字符串为long<br>
	 * <p>
	 * </p>
	 * 
	 * @param str
	 * @return
	 * 
	 */
	public static long atol(String str) {
		if (str==null || "".equals(str) || "-".equals(str))
			return 0;

		return Long.parseLong(str);
	}

	/**
	 * <b>功能描述: </b>转换String为int<br>
	 * <p>
	 * </p>
	 * 
	 * @param str
	 *            字符串
	 * @return 数字
	 * 
	 */
	public static int atoi(String str) {
		if (str==null ||"".equals(str) || "-".equals(str))
			return 0;
		return Integer.parseInt(str);
	}

	/**
	 * <b>功能描述: </b>返回当前客户端时间yyyyMMdd<br>
	 * <p>
	 * </p>
	 * 
	 * @return
	 * 
	 */
	public static String getLocalDate() {
		Date date =  getCurrentTimeDate();
		String strDate = getDateTime(date, "yyyyMMdd"); // ==>mydt="153026"
		return strDate;
	}

	/**
	 * <b>功能描述: </b>返回当前客户端时间yyyy-MM-dd HH:mm<br>
	 * <p>
	 * </p>
	 * 
	 * @return 客户端时间yyyy-MM-dd HH:mm
	 * 
	 */
	public static String getLocalDateTime() {

		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		Date date =getCurrentTimeDate();
		return fmt.format(date);
	}

	/**
	 * <b>功能描述: </b>将日期按指定格式格式化<br>
	 * <p>
	 * 例如：getDateTime(date,"yyyy-MM-dd HH:mm")
	 * </p>
	 * 
	 * @param dt
	 *            日期型变量
	 * @param fmt
	 *            格式
	 * @return 格式化后的日期字符串
	 * 
	 */
	public static String getDateTime(java.util.Date dt, String fmt) {
		// 把日期dt转换成按格式fmt的日期字符串
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		String myd = sdf.format(dt);
		return myd;
	}

	/**
	 * <b>功能描述: </b>由YYYYmmdd返回格式化后的日期YYYY年mm月dd日<br>
	 * <p>
	 * </p>
	 * 
	 * @param date
	 *            日期YYYYmmdd
	 * @return 日期YYYY年mm月dd日
	 * 
	 */
	public static String getFormatedDate(String date) {

		if (date == null)
			return "-";
		if (date.length() != 8)
			return date;
		return date.substring(0, 4) + "年" + date.substring(4, 6) + "月"
				+ date.substring(6) + "日";
	}

	/**
	 * <b>功能描述: </b>由日期YYYY年mm月dd日去掉格式化后YYYYmmdd返回<br>
	 * <p>
	 * </p>
	 * 
	 * @param date
	 *            日期YYYY年mm月dd日
	 * @return 日期YYYYMMDD
	 * 
	 */
	public static String ungetFormatedDate(String s_Date) {

		if (isEmpty(s_Date)) {
			return "Not a valid date!";
		}
		if (s_Date.length() == 11) {
			String s_retrun = s_Date.substring(0, 4) + s_Date.substring(5, 7)
					+ s_Date.substring(8, 10);
			return s_retrun;
		}
		return "Not a valid date!";
	}

	/**
	 * <b>功能描述: </b>由字符串yyyyMMDDHHmmss转换成对应的日期对象<br>
	 * <p>
	 * </p>
	 * 
	 * @param date
	 *            日期yyyyMMDDHHmmss
	 * @return Date对象
	 * @throws Exception 
	 * 
	 */
	public static Date toDate(String s_Date) throws Exception {
		if (isTime(s_Date)) {
			String yy=s_Date.substring(0, 4);
			String MM=s_Date.substring(4, 6);
			String DD=s_Date.substring(6, 8);
			String HH=s_Date.substring(8, 10);
			String mm=s_Date.substring(10, 12);
			String ss=s_Date.substring(12, 14);
			int i_yy= cInt(yy);
			int i_MM= cInt(MM);	
			int i_DD= cInt(DD);	
			int i_HH= cInt(HH);
			int i_mm= cInt(mm);	
			int i_ss= cInt(ss);	
//			Date dd=new Date();
//			dd.setYear(i_yy);
//			dd.setMonth(i_MM-1);	//注意：the month value between 0-11.	我们认为的12月用11表示
//			dd.setDate(i_DD);
//			dd.setHours(i_HH);	
//			dd.setMinutes(i_mm);	
//			dd.setSeconds(i_ss);
//			return dd;
			Calendar cal1 = Calendar.getInstance();
		    cal1.set(i_yy, i_MM-1, i_DD, i_HH, i_mm, i_ss);
		    Date dd2=cal1.getTime();
		    return dd2;	
						
		}

		return null;
	}
	/**
	 * 时间相加函数
	 * @param d 日期
	 * @param type 要增加的类型：年月日，小时都可以
	 * @param number 数值
	 * @return
	 */
	public static Date addDate2(Date d,String type,int number){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		if(type.equals("YEAR"))calendar.add(Calendar.YEAR,number);
		if(type.equals("MONTH"))calendar.add(Calendar.MONTH,number);
		if(type.equals("DAY"))calendar.add(Calendar.DAY_OF_MONTH,number);
		if(type.equals("HOUR"))calendar.add(Calendar.HOUR_OF_DAY,number);
		if(type.equals("SECOND"))calendar.add(Calendar.SECOND,number);
		if(type.equals("MINUTE"))calendar.add(Calendar.MINUTE,number);
		Date date = calendar.getTime();
		return date;
	}
	/**
	 * 把Timestamp形式转成Date
	 * @param ts
	 * @return
	 */
	public static Date noem(Timestamp ts){
		Long lms = ts.getTime();  
		Date date = new Date(lms); 
		return date;
	}
	/**
	 * 取得贷款期限的日期表示字符，小于1按天数输出，大于等于1按月数输出
	 * @param borrow_period
	 * @return
	 */
	public static String getPStr(Double borrow_period){
		String borrow_periodStr;
		//borrow_period ,小于1，取整数天，大于等于1，取整数月
		
		if(borrow_period<1){
			int i_t=(int) Math.rint(borrow_period*30);//四舍五入取整 
			
			borrow_periodStr=i_t+"天";
		}else{
			int i_t=(int) Math.rint(borrow_period); //四舍五入取整 
			borrow_periodStr=i_t+"月";
		}
		return borrow_periodStr;
	}
	

	/**
	 * 格林威治时间，增加指定日期后的秒数
	 * 指定日期dayNum天后的日期
	 * @param date 现在的秒数
	 * @param dayNum 增加的日期数
	 * @return 格林威治时间（秒数）
	 */
	public static String getSomeDay(long date, int i) {
		long ret=date+i*60*60*24;
		return ret+"";
	}
	
	/**
	 * 格林威治时间，增加指定月数后的秒数
	 * 指定日期monthNum月后的日期
	 * @param date
	 * @param monthNum
	 * @return 格林威治时间
	 */
	public static String getSomeMonth(long date,int monthNum){
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(Long.valueOf(date+"000"));
		cal.add(Calendar.MONTH, monthNum);
		String some = String.valueOf(cal.getTimeInMillis());
		some = some.substring(0, some.length()-3);
		//System.out.println(some);
		return some;
		
	}
	/**
	 * 从格林威治时间得到当前日期的天
	 * @param second
	 * @return
	 */
	public static String getDay(String second) {
		return getTimeByFormat(second,"dd");
	}
}
