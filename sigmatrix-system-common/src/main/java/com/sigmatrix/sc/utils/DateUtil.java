package com.sigmatrix.sc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
@SuppressWarnings({"deprecation", "unused", "unchecked", "rawtypes"})
public class DateUtil {
	
	  /**
	 * Format 格式 yyyy-MM-dd
	 */
	public static final String YMD="yyyy-MM-dd";
	/**
	 *  Format 格式 yyyy-MM-dd HH:mm:ss
	 */
	public static final String YMDHMS="yyyy-MM-dd HH:mm:ss";
	/**
	 *  Format 格式 yyyyMMdd-HHmm
	 */
	public static final String YMD_HM="yyyyMMdd-HHmm";
	/**
	 *  Format 格式 dd/HHmm
	 */
	public static final String DD_HHmm="dd/HHmm";
	/**
	 *  Format 格式 MMdd/HHmm
	 */
	public static final String MMDD_HHmm="MMdd/HHmm";
	/**
	 *  Format 格式 yyyy-MM
	 */
	public static final String YM="yyyy-MM";

	public static final String YYYY="yyyy";
	/**
	 * Format 格式 yyyyMM
	 */
	public static final String YYYYMM="yyyyMM";

    public static final String YYYYMMDD="yyyyMMdd";
    
    /***
     * 计算两日期间相差几天
     * @param firstDate
     * @param secondDate
     * @return
     */
	  public   static int   nDaysBetweenTwoDate(Date   firstDate,Date   secondDate)   {  
          int   nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));  
          return   nDay;  
      }
	  
	  public static String getNowYm()
	    {
	        return DateUtil.getDateValue (new Date(),DateUtil.YYYYMM);
	    }

	    public static String getNowYmd()
	    {
	        return DateUtil.getDateValue (new Date(),"yyyy年MM月dd日");
	    }

	    public static String getNowHms()
	    {
	        return DateUtil.getDateValue (new Date(),"HH:mm:ss");
	    }
	    
	    public static String getNowYMDHMS()
	    {
	        return DateUtil.getDateValue (new Date(),"yyyy-MM-dd HH:mm:ss");
	    }
	    
	    public static String getNowNumber()
	    {
	        return DateUtil.getDateValue (new Date(),"yyyyMMddHHmmss");
	    }
	    
	     /**
	     * 获取当前年份
	     * @return    String 当前年份 如2013
	     */
	    public static String getNowYear()
	    {
	        return DateUtil.getDateValue (new Date(),DateUtil.YYYY);
	    }

	    /**
	     * 获取当前年份
	     * @return    int 当前年份 如2013
	     */
	    public static int getYear(){
	        return Integer.parseInt(getNowYear());
	    }

	    /**
	     * 获取当前月份
	     * @return    String 当前月份  如：01
	     */
	    public static String getNowMonth(){
	        return DateUtil.getDateValue (new Date(),"MM");
	    }

	    /**
	     * 获取当前月份
	     * @return    int 当前月份
	     */
	    public static  int getMonth(){
	        return Integer.parseInt(getNowMonth());
	    }

	    /**
	     * 两时间相减得到天数(yyyyMMdd) ,日期字符串2-日期字符串1
	     * @param date1 日期字符串1
	     * @param date2 日期字符串2
	     * @return 天数
	     */
	    public static long getDayTimes(String date1, String date2) {
	        try {
	            SimpleDateFormat yyyyMMdd =
	                    new SimpleDateFormat(DateUtil.YMD);
	            long d1 = yyyyMMdd.parse(date1).getTime();
	            long d2 = yyyyMMdd.parse(date2).getTime();
	            return (d2 - d1) / (1000 * 60 * 60 * 24);
	        } catch (Exception ex) {
	            System.out.println(ex);
	            return 0;
	        }
	    }

		/**
		 * 日期字符串2-日期字符串1， 获得小时数(yyyyMMdd)
		 * @param date2 日期字符串2
		 * @return  小时数
		 */
	    public static long getHours(String date1, String date2) {
	        try {
	            SimpleDateFormat yyyyMMdd =new SimpleDateFormat(DateUtil.YMD);
	            long d1 = yyyyMMdd.parse(date1).getTime();
	            long d2 = yyyyMMdd.parse(date2).getTime();
	            return (d2 - d1) / (1000 * 60 * 60);
	        } catch (Exception ex) {
	            System.out.println(ex);
	            return 0;
	        }
	    }

	    /**
	     * 根据时间戳获取当前时间
	     * @param date
	     * @return
	     */
	    public static String getHHSS(Long time) {
	    	Date date=new Date(time);
	    	SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
	    	String str=format.format(date);
	    	return str;
	    }
		/**
	     * 获取小时数(yyyyMMddhhmmss)
	     * @param date1 日期字符串1
	     * @param date2 日期字符串2
	     * @return  小时数
	     */
	    public static float getDayTimes0(String date1, String date2) {
	        try {
	            SimpleDateFormat yyyyMMddhhmmss =
	                    new SimpleDateFormat(DateUtil.YMDHMS);
	            long d1 = yyyyMMddhhmmss.parse(date1).getTime();
	            long d2 = yyyyMMddhhmmss.parse(date2).getTime();
	            return ((float)(d2 - d1)) / (1000 * 60 *60);
	        } catch (Exception ex) {
	            return 0;
	        }
	    }

	    /**
	     * 获取天数(yyyyMMddhhmmss)
	     * @param date1 日期字符串1
	     * @param date2 日期字符串2
	     * @return  天数
	     */
	    public static float getDayTimes1(String date1, String date2) {
	        try {
	            SimpleDateFormat yyyyMMddhhmmss =
	                    new SimpleDateFormat(DateUtil.YMDHMS);
	            long d1 = yyyyMMddhhmmss.parse(date1).getTime();
	            long d2 = yyyyMMddhhmmss.parse(date2).getTime();
	            return ((float)(d2 - d1)) / (1000 * 60 *60)/24;
	        } catch (Exception ex) {
	            return 0;
	        }
	    }
	    /**
	     * 获取天数
	     * @param date1 日期
	     * @param date2 日期
	     * @return  天数
	     */
	    public static float getDayTimes2(Date date1, Date date2) {
	    	if(null == date1 || null == date2){
	    		return 0;
	    	}
	        return ((float)(date2.getTime() - date1.getTime())) / (1000 * 60 *60)/24;
	    }
	    
	    /**
	     * 设置一个时间根据偏移量得到新的时间
	     * @param dateTime  日期
	     * @param excursion 偏移量
	     * @param format  日期格式 [yyyy-MM-dd|yyyy-MM-dd HH:mm:ss]
	     * @return  字符串
	     */
	    public static String getExcursionDateString(String dateTime,int excursion,String format){
	        return getDateValue(getExcursionDate(dateTime,excursion,format),format);
	    }

	    /**
	     * 设置一个时间根据偏移量得到新的年月
	     * @param dateTime 日期
	     * @param excursion 偏移量
	     * @return 年月
	     */
	    public static String getExcursionYearMonthString(String dateTime,int excursion){
	        if(dateTime.length ()<10)dateTime=dateTime+"-01";
	        return getDateValue(getExcursionMonth(dateTime,excursion),DateUtil.YM);
	    }

	    /**
	     * 设置一个时间根据偏移量得到新的时间
	     * @param dateTime  日期
	     * @param excursion 偏移量(天)
	     * @param fmt 格式
	     * @return Date对象
	     */
	    public static Date getExcursionDate(String dateTime,int excursion,String fmt){

	        Calendar cal = Calendar.getInstance();
	        if(fmt.equals(DateUtil.DD_HHmm)){
				cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)),Integer.parseInt(dateTime.substring(11,13)),Integer.parseInt(dateTime.substring(14,16)));
		  }else if (fmt.equals(DateUtil.YMDHMS)){
			   cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)),Integer.parseInt(dateTime.substring(11,13)),Integer.parseInt(dateTime.substring(14,16)),Integer.parseInt(dateTime.substring(17,19)));
	        }else
	           cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)));
		     cal.add(Calendar.DATE,excursion);
			
			return cal.getTime();
	    }

	    public static Date getExcuSecond(String dateTime,int second)
	    {
	        Calendar cal=Calendar.getInstance ();
	        cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)),Integer.parseInt(dateTime.substring(11,13)),Integer.parseInt(dateTime.substring(14,16)),Integer.parseInt(dateTime.substring(17,19)));
	        cal.add (Calendar.SECOND,second);
	        return cal.getTime ();
	    }

	      /**
		 * 设置一个时间根据偏移量得到新的时间
		 * @param dateTime
		 * @param excursion 偏移量（小时）
		 * @param fmt DD_HHmm| YMDHMS | others
		 * @return Date对象
		 */
		public static Date getExcursionDateTime(String dateTime,int excursion,String fmt){
	          if(dateTime!=null){
	            Calendar cal = Calendar.getInstance();
			if(fmt.equals(DateUtil.DD_HHmm)){
				cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)),Integer.parseInt(dateTime.substring(11,13)),Integer.parseInt(dateTime.substring(14,16)));
			}else if (fmt.equals(DateUtil.YMDHMS)){
				cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)),Integer.parseInt(dateTime.substring(11,13)),Integer.parseInt(dateTime.substring(14,16)),Integer.parseInt(dateTime.substring(17,19)));
			}else
				cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7))-1, Integer.parseInt(dateTime.substring(8,10)));

			cal.add(Calendar.HOUR,excursion);

			return cal.getTime();
	          }else{
	              return null;
	          }
	      }

		/**
		 * 月份的偏移
		 * @param dateTime
		 * @param excursion
		 * @return
		 */
	    public static Date getExcursionMonth(String dateTime,int excursion){
	        Calendar cal = Calendar.getInstance();
	        cal.set(Integer.parseInt(dateTime.substring(0,4)), Integer.parseInt(dateTime.substring(5,7)), Integer.parseInt(dateTime.substring(8,10)));
	        cal.add(Calendar.MONTH, excursion);
	        return cal.getTime();
	    }

	    /**
	     * 获取当前的时间
	     * @return 字符串格式
	     */
	    public static String getNowDayTime() {
	        java.util.Date nowdate = new java.util.Date();
	        Timestamp ts=new java.sql.Timestamp(nowdate.getTime());
	        String now = ts.toString();

	        nowdate=null;
	        ts=null;
	        return now;
	    }

	    /**
	     * 将时间对象按照一定的格式转换成字符串
	     * @param aDate  时间对象
	     * @param format yyyy-MM-dd | yyyy-MM-dd HH:mm:ss | dd/HHmm
	     * @return 时间字符串
	     */
	    public static String getDateValue(Date aDate,String format) {
	        try {
	            if (aDate == null) {
	                return "";
	            }
	            SimpleDateFormat yyyyMMddhhmmss =
	                    new SimpleDateFormat(format);
	            return yyyyMMddhhmmss.format(aDate);
	        } catch (Exception ex) {
	            return "";
	        }
	    }

	    /**
	     * 将时间对象按照一定的格式转换成字符串
	     * @param aDate  时间对象 输入格式 yyyy-mm-dd
	     * @param format yyyy年MM月dd 
	     * @return 时间字符串
	     */
	    public static String getDateValue(String aDate) {
	        try {
	            if (aDate == null) {
	                return "";
	            }
	            String yyyy = aDate.substring(0,4);//年
	            String mm = aDate.substring(5,7);//月
	            String dd = aDate.substring(8,10);//日
	            return yyyy+"年"+mm+"月"+dd+"日";
	        } catch (Exception ex) {
	            return "日期格式异常";
	        }
	    }
	    
	    
	    

	    /**
	     * 比较d段是否包含t段
	     * @param d1
	     * @param d2
	     * @param t1
	     * @param t2
	     * @return true 包含 | false 不包含
	     */
	    public static boolean dateAreaIsContain(Date d1,Date d2,Date t1,Date t2)
	    {
	        return DateUtil.getDayTimes0 (DateUtil.getDateValue (d1,DateUtil.YMDHMS),
	                    DateUtil.getDateValue (t1,DateUtil.YMDHMS))>=0 &&
	                DateUtil.getDayTimes0 (DateUtil.getDateValue (t2,DateUtil.YMDHMS),
	                    DateUtil.getDateValue (d2,DateUtil.YMDHMS))>=0  ;
	    }

		/**
		 * 年月的偏移
		 * @param ym 年月
		 * @param move 偏移量
		 * @return 新的年月
		 */
	    public static String getExcursionYearMonthString0(String ym,int move){
	        String _tmp=DateUtil.getExcursionYearMonthString(ym.substring (0,4)+"-"+ym.substring (4),move);
			return _tmp.substring (0,4)+_tmp.substring (5);
	    }

		/**
		 * 获取某年某月的天数
		 * @param year  年
		 * @param month  月
		 * @return 天数
		 */
		public static int getMonthDays(int year,int month)
		{
			Calendar time=Calendar.getInstance();
			time.clear();
			time.set(Calendar.YEAR,year);
			time.set(Calendar.MONTH,month-1);//注意,Calendar对象默认一月为0
			return time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
		}



	      /**
		 * 判断当前是否是本月的最后一天
		 * @return true 是 false 否
		 */
		
		public static boolean isMonthEndDay()
		{
			boolean isEndDay=false;

			java.util.Date nowdate = new java.util.Date();      
			int days=getMonthDays(nowdate.getYear (),nowdate.getMonth ());

	        if(DateUtil.getDayTimes(DateUtil.getDateValue(new Date(),DateUtil.YM)+"-"+days,DateUtil.getDateValue(new Date(),DateUtil.YMD))==0)
			{
				isEndDay=true;
			}
			return isEndDay;
		}

		/**
		 * 返回指定年月的最后一天
		 * @param year  年
		 * @param month  月
		 * @return  最后一天
		 */
		public static String getEndDay(int year,int month)
		{
		  int days=getMonthDays(year,month);

	        if(month<10)
	        {
	            return year+"-0"+month+"-"+days;
	        }else{
	            return year+"-"+month+"-"+days;
	        }
		}

	    /**
		 * 返回指定年月的一天
		 * @param year  年
		 * @param month  月
		 * @return  指定年月的一天
		 */
		public static String getStartDay(int year,int month){
	        if (month < 10) {
	            return year + "-0" + month + "-01";
	        } else {
	            return year + "-" + month + "-01";
	        }
		}

		public static String getFDateTime(String dateTime)
		{
			if(dateTime!=null)
			{
				return dateTime.substring (5,7)+dateTime.substring (8,10)+"/"+dateTime.substring (11,13)+dateTime.substring (14,16);
			}
			return null;
		}

		/**
		 * 将日期字符串转换为日期类型,格式：yyyy-mm-dd
		 * @param dateTime  日期字符串
		 * @return  转换后的日期类型
		 */
		public static Date getDateByStr(String dateTime)
		{
			return getExcursionDate(dateTime,0,DateUtil.YMD);
		}

		public static Date getDate(String dateTime)
		{
			return getExcursionDate(dateTime,0,DateUtil.YMDHMS);
		}

		/**
		 * 获取年月集合，如果参数是本年就取出本年到当前为止的月份
		 * 目前该方法只在月度经济分析会程序中使用 ydfx
		 * @param ym
		 * @return
		 */
		public static List<String> getYearMonthArrayByLineChart(String ym)
		{
			String _ym=DateUtil.getExcursionYearMonthString(DateUtil.getNowDayTime (),-1);
			String _nym=DateUtil.getExcursionYearMonthString(DateUtil.getNowDayTime (),1);
			List<String> result=new ArrayList ();
			//去年。。前年。。
			if(Integer.parseInt (ym.substring (0,4))<Integer.parseInt (_ym.substring (0,4)))
			{
				result.add(ym.substring (0,4)+"01");
				result.add(ym.substring (0,4)+"02");
				result.add(ym.substring (0,4)+"03");
				result.add(ym.substring (0,4)+"04");
				result.add(ym.substring (0,4)+"05");
				result.add(ym.substring (0,4)+"06");
				result.add(ym.substring (0,4)+"07");
				result.add(ym.substring (0,4)+"08");
				result.add(ym.substring (0,4)+"09");
				result.add(ym.substring (0,4)+"10");
				result.add(ym.substring (0,4)+"11");
				result.add(ym.substring (0,4)+"12");
			}
			//今年
			else{
				for(int i=Integer.parseInt (_ym.substring (5,7));i>=1;i--)
				{
					result.add(getExcursionYearMonthString0(_ym.substring (0,4)+_ym.substring (5,7),(i)*-1));
				}
			}

			return result;
		}

	    /**
	     * 传入的参数：日期，几天后，天数加减
	     * 返回结果：几天后的日期
	     */
	    public static Date getDayDate(Date date , int days) {
	        Calendar now =Calendar.getInstance();
	        now.setTime(date);
	        now.set(Calendar.DATE,now.get(Calendar.DATE)+days);
	        return now.getTime();
	    }

	    /**
	     * 判断输入年月格式是否正确
	     * @param dateTime
	     * @return
	     */
	    public static boolean checkIsRightDate(String dateTime)
	    {
	        if(!dateTime.contains ("-")&&!dateTime.contains ("/")&&!dateTime.contains("."))
	        {
	            dateTime=dateTime.substring (0,4)+"-"+dateTime.substring (4,6)+
	                    "-"+dateTime.substring (6,8)+" "+dateTime.substring (8,10)+":"+dateTime.substring (10);
	        }
	        String regex= "^((\\d{2}(([02468][048])|([13579][26]))[\\(/|\\-)\\/\\s]?" +
	                "((((0?[13578])|(1[02]))[\\(/|\\-)\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))" +
	                "|(((0?[469])|(11))[\\(/|\\-)\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +
	                "(0?2[\\(/|\\-)\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|" +
	                "([13579][01345789]))[\\(/|\\-)\\/\\s]?" +
	                "((((0?[13578])|(1[02]))[\\(/|\\-)\\/\\s]?((0?[1-9])|([1-2][0-9])|" +
	                "(3[01])))|(((0?[469])|(11))[\\(/|\\-)\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|" +
	                "(0?2[\\(/|\\-)\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))" +
	                "(\\s(([0-1]?[0-9])|2[0-3]):[0-5]?[0-9](:[0-5]?[0-9])?)?";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(dateTime);
	        return m.matches ();
	    }

	    /*
	    * 箱动时间的判断输入的类型
	    * 返回:
	    * 0 为 未知类型
	    * 1 为 2009-1-8 2009-01-08    不包含时间
	    * 2 为 2009-01-8 8:08         不包含秒（ss）
	    * 3 为 2009-01-08 8:08:08      标准格式
	    * 4 为 09.01.08  09.1.8       特殊格式
	    * 5 为 2009-01-08 08          不包含分秒
	    * */
	    public static String checkDateType(String dateTime)
	    {
	        String flag="0";
	        if(dateTime.matches ("[0-9]{4}(/|-|\\.)([0-9]{1,2})(/|-|\\.)([0-9]{1,2})")){
	            flag="1";
	        } else if(dateTime.matches ("[0-9]{4}(/|-|\\.)([0-9]{1,2})(/|-|\\.)([0-9]{1,2})" +
	                    "\\s{1}([0-9]{1,2}):([0-9]{1,2})")){
	            flag="2";
	        }else if(dateTime.matches ("[0-9]{4}(/|-|\\.)([0-9]{1,2})(/|-|\\.)([0-9]{1,2})" +
	                        "\\s{1}([0-9]{1,2}):([0-9]{1,2}):([0-9]{1,2})")){
	            flag="3";
	        }else if (dateTime.matches("[0-9]{2}(/|-|\\.)([0-9]{1,2})(/|-|\\.)([0-9]{1,2})")){
	            flag="4";
	        }else if(dateTime.matches("[0-9]{4}(/|-|\\.)[0-9]{1,2}(/|-|\\.)[0-9]{1,2}\\s{1}[0-9]{1,2}")){
	            flag="5";
	        }
	        return flag;
	    }

	    /*
	    * 根据给定的字符串dateTime 转化成Date类型
	    * 与DateUtil.checkDateType一起用
	    * 例: vo.setDateTime(DateUtil.getDateTime(DateStr,DateUtil.checkDateType(DateStr)))
	    * 输入参数 dateTime 为时间字符串
	    * 格式为
	    *     1、  2009-01-08/2009-1-8
	    *     2、  2009-01-08/2009-1-8 08:08/8:8
	    *     3、  2009-01-08 08:08:08/8:8:8
	    *     4、  09.01.08  09.1.8
	    *     5、  2009-01-08 08
	    * 中的一种
	    * 返回的格式为  如下
	    *    格式1 会返回  2009-01-08
	    *    格式2 会返回  2009-01-08 08:08:00
	    *    格式3 会返回  2009-01-08 00:00:00      *
	    *    格式4 会返回  2009-01-08
	    *    格式5 会返回  2009-01-08 08:00:00
	    * */
	    public static Date getDateTime(String dateTime,String type)
	    {
	        if(!dateTime.contains ("-")&&!dateTime.contains ("/")&&!dateTime.contains("."))
	        {
	            dateTime=dateTime.substring (0,4)+"-"+dateTime.substring (4,6)+
	                    "-"+dateTime.substring (6,8)+" "+dateTime.substring (8,10)+":"+dateTime.substring (10);
	        }
	        DateFormat formart1   =   DateFormat.getDateInstance ();     //不带时分秒
	        DateFormat formart2   =   DateFormat.getDateTimeInstance();  //带有时分秒
	        Date   date =null;
	        if("1".equals (type)){
	            try {
	                date= formart1.parse (dateTime.replace ("/","-"));
	            } catch (ParseException e) {
	                e.printStackTrace ();
	            }
	        }else if("2".equals (type)){
	            dateTime+=":00";
	            try{
	                date   =   formart2.parse(dateTime.replace ("/","-"));
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        }else if("4".equals(type)){
	            if(dateTime.substring(0,1).matches("[0-2]")){
	                dateTime="20"+dateTime;
	                try{
	                    date = formart1.parse(dateTime.replace (".","-"));
	                }catch(ParseException e){
	                    e.printStackTrace();
	                }
	            }
	        }else if("3".equals(type)){
	            try {
	                date=formart1.parse(dateTime);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        }else if("5".equals(type)){
	            dateTime+=":00:00";
	            try {
	                date = formart2.parse(dateTime);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        }
	        return date;
	    }

		/**
		 * 获取年月集合，如果参数是本年就取出本年到当前为止的月份
		 * 目前该方法只在月度经济分析会程序中使用 ydfx
		 * @param ym
		 * @return
		 */
		public static List<String> getYearMonthArray(String ym)
		{
			String _ym=DateUtil.getExcursionYearMonthString(DateUtil.getNowDayTime (),-1);
			String _nym=DateUtil.getExcursionYearMonthString(DateUtil.getNowDayTime (),1);
			List<String> result=new ArrayList ();
			//去年。。前年。。
			if(Integer.parseInt (ym.substring (0,4))<Integer.parseInt (_ym.substring (0,4)))
			{

				result.add(DateUtil.getExcursionYearMonthString0(ym.substring (0,4)+"01",-2).substring (0,4)+"12");
				result.add(ym.substring (0,4)+"01");
				result.add(ym.substring (0,4)+"02");
				result.add(ym.substring (0,4)+"03");
				result.add(ym.substring (0,4)+"04");
				result.add(ym.substring (0,4)+"05");
				result.add(ym.substring (0,4)+"06");
				result.add(ym.substring (0,4)+"07");
				result.add(ym.substring (0,4)+"08");
				result.add(ym.substring (0,4)+"09");
				result.add(ym.substring (0,4)+"10");
				result.add(ym.substring (0,4)+"11");
				result.add(ym.substring (0,4)+"12");
				result.add(DateUtil.getExcursionYearMonthString0(ym.substring (0,4)+"12",2).substring (0,4)+"01");
			}
			//今年
			else{
				for(int i=Integer.parseInt (_ym.substring (5,7));i>=0;i--)
				{
					result.add(getExcursionYearMonthString0(_ym.substring (0,4)+_ym.substring (5,7),(i+1)*-1));
				}
			}

			return result;
		}

	      /**
		 * 获取年月集合，如果参数是本年就取出本年到当前为止的月份,加上去年的本月
		 * 目前该方法只在 分中心贡献航线需求设计  各航线月运力投入、产生的收益和成本 中用到
	       * liqingxu于2010年6月5日9:51:08 加入
		 * @param ym
		 * @return
		 */
		public static List<String> getToParameterMonthArray(String ym)
		{
			List<String> result=new ArrayList<String>();
	            for(int i=Integer.parseInt (ym.substring (4));i>0;i--)
	            {
	                result.add(getExcursionYearMonthString0(ym.substring (0,4)+ym.substring (4),(i)*-1));
	            }
	            result.add (getExcursionYearMonthString0(ym,-13));
			return result;
		}

	    /**
	     * 返回标准的 yyyy-mm-dd 时间字符串
	     * @param dateStr  2012-3-2 10:02:05
	     * @return    2012-03-02 10:02:05
	     */
	    public static String getStarderDateStr(String dateStr){
	       String[] str = dateStr.split("-");
	       String resStr = "";
	       if(str.length==3){
	            resStr = str[0]+"-"+(str[1].length()<2?"0"+str[1]:str[1])+"-"
	                    +((str[2].length()<=2?str[2].substring(0):str[2].substring(0,str[2].indexOf(" "))).length()<2?"0"+str[2]:str[2]);
	        }
	       return resStr;
	    }

	    /**
	     * 获取传入的日期是周几
	     * @param d     日期
	     * @return    int
	     */
	    public static int getWeekDay(Date d) {
	         int a = 0;
	         Calendar calendar = Calendar.getInstance();
	         calendar.setTime(d);
	         if (calendar.get(Calendar.DAY_OF_WEEK) == 2)
	             a = 1;// 星期一
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 3)
	             a = 2;
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 4)
	             a = 3;
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 5)
	             a = 4;
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 6)
	             a = 5;
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
	             a = 6;
	         else if (calendar.get(Calendar.DAY_OF_WEEK) == 1)
	             a = 7;
	         return a;
	    }

	    
	  //加密 s = new Date().getTime()   13位
		public static String encrypt(String s) {
			String olds = s;
			s = s.substring(s.length()-9, s.length());
			Long l = Long.parseLong(s);
			l = l*1177;
			String lStr = l+"";
			if(lStr.length()<12){
				if(lStr.length()==0){
					lStr = "000000000000";
				}else if(lStr.length()==1){
					lStr = "00000000000" + lStr;
				}else if(lStr.length()==2){
					lStr = "0000000000" + lStr;
				}else if(lStr.length()==3){
					lStr = "000000000" + lStr;
				}else if(lStr.length()==4){
					lStr = "00000000" + lStr;
				}else if(lStr.length()==5){
					lStr = "0000000" + lStr;
				}else if(lStr.length()==6){
					lStr = "000000" + lStr;
				}else if(lStr.length()==7){
					lStr = "00000" + lStr;
				}else if(lStr.length()==8){
					lStr = "0000" + lStr;
				}else if(lStr.length()==9){
					lStr = "000" + lStr;
				}else if(lStr.length()==10){
					lStr = "00" + lStr;
				}else if(lStr.length()==11){
					lStr = "0" + lStr;
				}
			}
			lStr = lStr.substring(0, lStr.length()-6)+olds.substring(0, 1)+lStr.substring(lStr.length()-6, lStr.length()-4)+olds.substring(1, 2)+lStr.substring(lStr.length()-4, lStr.length()-2)+olds.substring(2, 3)+lStr.substring(lStr.length()-2, lStr.length()-1)+olds.substring(3, 4)+lStr.substring(lStr.length()-1, lStr.length());
			return lStr;
		}
		
		//解密
		//参数为一个base64加密过的字符串
		public static String decrypt(String s){
			String lStr =s;
			//解密
			String lstr1 = lStr.substring(0, lStr.length()-10)+lStr.substring(lStr.length()-9, lStr.length()-7)+lStr.substring(lStr.length()-6, lStr.length()-4)+lStr.substring(lStr.length()-3, lStr.length()-2)+lStr.substring(lStr.length()-1, lStr.length());
			String lstr2 = lStr.substring(lStr.length()-10,lStr.length()-9)+lStr.substring(lStr.length()-7,lStr.length()-6)+lStr.substring(lStr.length()-4,lStr.length()-3)+lStr.substring(lStr.length()-2,lStr.length()-1);
			Long l1 = Long.parseLong(lstr1);
			l1 = l1/1177;
			String l1Str = l1+"";
			if(l1Str.length()<9){
				if(l1Str.length()==0){
					l1Str = "000000000";
				}else if(l1Str.length()==1){
					l1Str = "00000000" + l1Str;
				}else if(l1Str.length()==2){
					l1Str = "0000000" + l1Str;
				}else if(l1Str.length()==3){
					l1Str = "000000" + l1Str;
				}else if(l1Str.length()==4){
					l1Str = "00000" + l1Str;
				}else if(l1Str.length()==5){
					l1Str = "0000" + l1Str;
				}else if(l1Str.length()==6){
					l1Str = "000" + l1Str;
				}else if(l1Str.length()==7){
					l1Str = "00" + l1Str;
				}else if(l1Str.length()==8){
					l1Str = "0" + l1Str;
				}
			}
			String news = lstr2+l1Str;
			return news;
		}
		

		/**
		 * @Method: isBetweenDate
		 * @Description: 当前时间在某个时间范围之内
		 * @param begDate 开始时间
		 * @param endDate 结束时间
		 * @return boolean 在时间之内 true
		 */
	    public static boolean isBetweenDate(Date begDate,Date endDate){
	        if(null != begDate && null != endDate){
	             //获取系统当前时间
	            Date nowDate = new Date(System.currentTimeMillis());
	            if(nowDate.after(begDate) && nowDate.before(endDate)){
	                return true;
	            }else{
	                return false;
	            }
	        }
	        return false;
	    }
	    
	    //判断当前时间 开始时间之前(1)在两个时间之间(2)结束时间之后(3)
	    public static String nowDateStatus(Date begDate,Date endDate){
	        if(null != begDate && null != endDate){
	             //获取系统当前时间
	            Date nowDate = new Date(System.currentTimeMillis());
	            if(nowDate.before(begDate)){
	                return "1";
	            }else if(nowDate.after(begDate) && nowDate.before(endDate)){
	                return "2";
	            }else if(nowDate.after(endDate)){
	                return "3";
	            }
	        }
	        return null;
	    }
	    
	    /**
	     * @Method: formatDateToString
	     * @Description: 格式化日期并转为字符串
	     * @param date 要格式化的日期
	     * @param pattern 如 yyyy-MM-dd HH：mm：ss
	     * @return String 日期字符串
	     */
		public static String formatDateToStr(Date date, String pattern) {
			if(null != date && StringUtils.isNotBlank(pattern)){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat(pattern);
					return sdf.format(date);
				} catch (Exception e) {
					return "";
				}
			}
			return "";
		}
		
		/**
		 * @Method: formatStrToDate
		 * @Description: 字符串转化日期类型
	     * @param date 要格式化的字符串日期
	     * @param pattern 如 yyyy-MM-dd HH：mm：ss
		 * @return Date
		 */
		public static Date formatStrToDate(String strDate, String pattern) {
			if(null != strDate && StringUtils.isNotBlank(pattern)){
				try {
					SimpleDateFormat sdf = new SimpleDateFormat(pattern);
					return sdf.parse(strDate);
				} catch (Exception e) {
					return null;
				}
			}
			return null;
		}
 
		//获取系统字符串时间
		public static String getSysDateStr(String pattern){
			if(null == pattern){
				return "";
			}
            //获取系统当前时间
           Date nowDate = new Date(System.currentTimeMillis());
           return formatDateToStr(nowDate,pattern);
		}
		
		//判断两个日期是否未同一天
		public static boolean isSameDate(Date date1,Date date2){
			if(null == date1 || null == date2){
				return false;
			}
			return formatDateToStr(date1, YMD).equals(formatDateToStr(date2, YMD));
		}
		
		/**
		 * @Method: addDate
		 * @Description: 日期+天数=新的日期
		 * @param date
		 * @param day
		 * @return Date
		 * @date 2016年6月30日 上午10:51:13
		 */
		public static Date addDate(Date date, long day){
			long time = date.getTime();
			day = day * 24 * 60 * 60 * 1000;
			time += day;
			return new Date(time);
		}
		
		/**
		 * @Method: addDate
		 * @Description: 日期+天数=新的日期
		 * @param date
		 * @param day
		 * @param fmt
		 * @throws Exception
		 * @return String
		 * @date 2016年6月30日 上午10:51:48
		 */
		public static String addDate(String date, long day,String fmt) throws Exception{
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			Date d = sdf.parse(date);
			long time = d.getTime();
			day = day * 24 * 60 * 60 * 1000;
			time += day;
			return sdf.format(new Date(time));

		}
	    
	    public static void main(String[] args) {
	    	
	    	float dd = getDayTimes1(getNowDayTime(), getNowDayTime());
	    	System.out.println((dd<=0)+"========"+getNowDayTime());
		}
	    
	    
	    
	    
	    
		/**
		 * main函数 用于测试:
		 *<br>1、日期前移2天
		 *<br>&nbsp;&nbsp;	System.out.println(getExcursionYearMonthString("2006-10-10",-2));
		 *<br>2、转换日期字符串格式为MMdd/HHmm
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getExcursionDateString("2006-10-30 13:20:00",0,DateUtil.MMDD_HHmm));
		 *<br>3、两时间字符串相减
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getDayTimes("2006-10-01","2006-10-05"));
		 *<br>4、两时间字符串相减
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getDayTimes0("2007-05-18 17:00:00.0","2006-11-01 03:40:00"));
		 *<br>5、年月前偏移2月
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getExcursionYearMonthString("2006-11",-2));
		 *<br>6、年月前偏移2月
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getExcursionYearMonthString0("200601",-2));
		 *<br>7、将日期对象转换为yyyyMM格式的日期字符串
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getDateValue(new Date(),DateUtil.YYYYMM));
		 *<br>8、判断当前是否本月的最后一天
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.isMonthEndDay());
		 *<br>9、将日期字符串转换为 0518/1700的格式
		 *<br>&nbsp;&nbsp;	System.out.println(DateUtil.getFDateTime("2007-05-18 17:00:00.0"));
		 * @param args
		 */
}
