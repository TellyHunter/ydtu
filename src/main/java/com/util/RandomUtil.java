package com.util;

import java.util.Random;

public class RandomUtil {

	/**
	 * java生成随机数字
	 */
	public static String getNum(int n) {
		Random random = new Random();
		StringBuffer num = new StringBuffer("");
		for (int i = 0; i < n; i++) {
			num.append(random.nextInt(10));
		}
		return num.toString();
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length
	 *            [生成随机数的长度]
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		StringBuffer val = new StringBuffer("");
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val.append((char) (choice + random.nextInt(26)));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val.append(String.valueOf(random.nextInt(10)));
			}
		}
		return val.toString();
	}
	
	/**
	 * 生成流水号
	 */
	public static String getOrderId(){
		return DateUtil.getDate("yyyyMMddHHmmss")+RandomUtil.getNum(4);
	}
}
