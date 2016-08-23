package com.sigmatrix.sc.web.util;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.sigmatrix.sc.web.controller.common.BaseController;

/**
 * 提供对数字进行精确计算的方法
 * @author youjun
 *
 */
public class BigDecimalUtils {

	private static Logger logger = Logger.getLogger(BigDecimalUtils.class);
	
	public static BigDecimal INT_MAX_VALUE = new BigDecimal(Integer.MAX_VALUE);
	public static BigDecimal INT_MIN_VALUE = new BigDecimal(Integer.MIN_VALUE);
	
	/**
	 * 用参数一和Integer的最大值和最小值进行对比,不能超出这个范围,即:min<=result<=max,
	 * 数据正确返回true,否则返回false
	 * @param result 要对比的数
	 * @param max Integer最大值
	 * @param min Integer最小值
	 * @return
	 * @throws Exception
	 */
	public static boolean compareToMaxOrMin(BigDecimal result,BigDecimal max,BigDecimal min) throws Exception{
		// 满足min<=result<=max,返回true,否则返回false
		int minResult = result.compareTo(min);
		int maxResult = result.compareTo(max);
		// 如果当前数为小于对比数返回-1，大于对比数返回1，等于对比数返回0
		if(minResult>=0 && maxResult <= 0){
			return true;
		}
		return false;
	}
	
	/**  
	 * 提供两个Integer类型值的精确的加法运算。  
	 * @param v1 加数  
	 * @param v2 加数  
	 * @return 两个参数的和  
	 * @throws Exception 结果超出Integer的存储范围则抛出异常
	*/ 
	public static Integer addInteger(Integer v1,Integer v2) throws Exception{
		if(v1 == null){
			v1 = 0;
		}
		if(v2 == null){
			v2 = 0;
		}
		BigDecimal b1 = new BigDecimal(v1);   
		BigDecimal b2 = new BigDecimal(v2);   
		BigDecimal result = b1.add(b2);
		if(!compareToMaxOrMin(result, INT_MAX_VALUE, INT_MIN_VALUE)){
			logger.error("加法运算结果("+b1+"+"+b2+"="+result+")超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
			throw new Exception("加法运算结果("+b1+"+"+b2+"="+result+")超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
		}
		return result.intValue();
	}
	/**
	 * 支持多个Integer类型值的精确的加法运算
	 * @param nums
	 * @return
	 * @throws Exception
	 */
	public static Integer addInteger(Integer... nums) throws Exception{
		BigDecimal result = new BigDecimal(0); // 总和
        for(Integer num : nums) {
        	BigDecimal temp = new BigDecimal(num==null?0:num);
        	result = result.add(temp);
        }
		if(!compareToMaxOrMin(result, INT_MAX_VALUE, INT_MIN_VALUE)){
			logger.error("返回值类型为Integer,但加法运算结果="+result+"超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
			throw new Exception("返回值类型为Integer,但加法运算结果="+result+"超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
		}
		return result.intValue();
	}
	
	public static void main(String[] args) {
		try {
//			Integer a = 1;
//			Integer b = 2;
//			Integer c = 3;
//			Integer d = Integer.MAX_VALUE;
//			System.out.println(addInteger(a));
//			System.out.println(addInteger(a,b));
//			System.out.println(addInteger(a,b,c));
//			System.out.println(addInteger(a,b,c,d));
			
			Long prizeTotalAmount = prizeAmountMultiplyLong("1213212100.332", 100);
			System.out.println(prizeTotalAmount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**  
	* 提供两个Integer类型值的精确的减法运算。  
	* @param v1 减数
	* @param v2 被减数  
	* @return 两个参数的差  
	* @throws Exception 结果超出Integer的存储范围则抛出异常
	*/  
	public static Integer subInteger(Integer v1,Integer v2) throws Exception{ 
		if(v1 == null){
			v1 = 0;
		}
		if(v2 == null){
			v2 = 0;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal result = b1.subtract(b2);
		if(!compareToMaxOrMin(result, INT_MAX_VALUE, INT_MIN_VALUE)){
			logger.error("减法运算结果("+b1+"-"+b2+"="+result+")超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
			throw new Exception("减法运算结果("+b1+"-"+b2+"="+result+")超出Integer存储限制("+INT_MIN_VALUE+"<=结果<="+INT_MAX_VALUE+")");
		}
		return result.intValue();   
	}
	
	/**  
	 * 提供两个Long类型值的精确的加法运算。  
	 * @param v1 加数  
	 * @param v2 加数  
	 * @return 两个参数的和  
	 * @throws Exception
	*/ 
	public static Long addLong(Long v1,Long v2) throws Exception{
		if(v1 == null){
			v1 = 0l;
		}
		if(v2 == null){
			v2 = 0l;
		}
		BigDecimal b1 = new BigDecimal(v1);   
		BigDecimal b2 = new BigDecimal(v2);   
		BigDecimal result = b1.add(b2);
		
		return result.longValue();
	}
	
	/**  
	 * 提供支持多个Long类型值的精确的加法运算。  
	 * @param nums Long类型参数,可为多个  
	 * @return 
	 * @throws Exception
	*/ 
	public static Long addLong(Long... nums) throws Exception{
		BigDecimal result = new BigDecimal(0); // 总和
        for(Long num : nums) {
        	BigDecimal temp = new BigDecimal(num==null?0:num);
        	result = result.add(temp);
        }
        
		return result.longValue();
	}
	
	/**  
	* 提供两个Long类型值的精确的减法运算。  
	* @param v1 减数
	* @param v2 被减数  
	* @return 两个参数的差  
	* @throws Exception
	*/  
	public static Long subLong(Long v1,Long v2) throws Exception{
		if(v1 == null){
			v1 = 0l;
		}
		if(v2 == null){
			v2 = 0l;
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));   
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		BigDecimal result = b1.subtract(b2);
		
		return result.longValue();   
	}

	/**
	 * 提供两个Integer类型的数字的乘法运算，返回类型为Long
	 * @param one
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public static Long multiplyLong(Integer one, Integer count) throws Exception {
		BigDecimal b1 = new BigDecimal(Double.toString(one));   
		BigDecimal b2 = new BigDecimal(Double.toString(count));
		BigDecimal result = b1.multiply(b2);
		return result.longValue();
	}
	
	/**
	 * 此方法主要是提供给系统中金额的计算,适用业务比如:奖项表中的金额存储的是分,页面中是元,页面存入表中的值需要乘以100,
	 * 注意这个方法的返回值是Long类型,若是Integer类型请自行再定义并对返回值的结果范围进行判断(符合Integer类型的最大、小值)
	 * 提供两个Integer类型的数字的乘法运算，返回类型为Long
	 * @param prizeAmount String类型,可为1232421.32、2432.333（但是做乘法后好像会直接丢弃小数点后面的值而保留整数,请自行验证）
	 * @param count 对于元转分的业务,一般这里为100
	 * @return
	 * @throws Exception
	 */
	public static Long prizeAmountMultiplyLong(String prizeAmount, Integer count) throws Exception {
		BigDecimal b1 = new BigDecimal(prizeAmount);   
		BigDecimal b2 = new BigDecimal(Double.toString(count));
		BigDecimal result = b1.multiply(b2);
		return result.longValue();
	}
	/**
	 * 此方法主要供系统对取得的数据库中的金额(为分)转换为元(进行除以100操作)
	 * @param prizeTotalAmount 数据库中以分为单位的金额
	 * @param count 一般为100
	 * @return
	 */
	public static Long prizeAmountDivide(Long prizeTotalAmount,Long count) throws Exception{
		BigDecimal b1 = new BigDecimal(prizeTotalAmount);   
		BigDecimal b2 = new BigDecimal(Double.toString(count));
		BigDecimal result = b1.divide(b2);
		return result.longValue();
	}
	
}
