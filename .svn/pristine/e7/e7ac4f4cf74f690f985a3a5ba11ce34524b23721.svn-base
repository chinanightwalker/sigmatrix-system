package com.sigmatrix.sc.utils;


import java.util.Random;

public class RandomBuilder {
	private static final StringBuffer RANDOM_DL2_BUFFER = new StringBuffer(
			"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");

	private static final StringBuffer RANDOM_DL_BUFFER = new StringBuffer(
			"0123456789abcdefghijklmnopqrstuvwxyz");

	private static final StringBuffer RANDOM_LETTER_BUFFER = new StringBuffer(
			"abcdefghijklmnopqrstuvwxyz");

	private static final StringBuffer RANDOM_DIGITAL_BUFFER = new StringBuffer(
			"0123456789");

	private static final int CODE_LENGTH = 10; // 加上前6位，总共16位

	public RandomBuilder() {
		super();
	}

	public static String getRandomDL2String(int num) {
		StringBuffer sb = new StringBuffer();
		try {
			int range = RANDOM_DL2_BUFFER.length();
			int random = range;
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				random = r.nextInt(range);
				sb.append(RANDOM_DL2_BUFFER.charAt(random));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getRandomDLString(int num) {
		StringBuffer sb = new StringBuffer();
		try {
			int range = RANDOM_DL_BUFFER.length();
			int random = range;
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				random = r.nextInt(range);
				sb.append(RANDOM_DL_BUFFER.charAt(random));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getRandomLetterString(int num) {
		StringBuffer sb = new StringBuffer();
		try {
			int range = RANDOM_LETTER_BUFFER.length();
			int random = range;
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				random = r.nextInt(range);
				sb.append(RANDOM_LETTER_BUFFER.charAt(random));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getRandomDigitalString(int num) {// 参数为生成几位随机数
		StringBuffer sb = new StringBuffer();
		try {
			int range = RANDOM_DIGITAL_BUFFER.length();
			int random = range;
			Random r = new Random();
			for (int i = 0; i < num; i++) {
				random = r.nextInt(range);
				sb.append(RANDOM_DIGITAL_BUFFER.charAt(random));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param id
	 * @param num
	 *            得到的随机数总位数10
	 * @return
	 */

	public static String getInputCode(String id) {
		if (id == null) {
			return getRandomDigitalString(CODE_LENGTH);
		} else {
			int length = id.length();
			if (id.length() < CODE_LENGTH) {
				return id + getRandomDigitalString(CODE_LENGTH - length);
			} else if (id.length() >= CODE_LENGTH) {
				return id;
			} else {
				return id;
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(getRandomDLString(7));
		}
			
	}
}
