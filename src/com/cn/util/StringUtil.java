package com.cn.util;

import java.text.*;

public class StringUtil {
	//判空
	public static Boolean isNull(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	//判断日期格式
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	//判断是否为数字
	public static boolean isNumeric(String str) {
		String reg = "^[0-9]+(.[0-9]+)?$";

        return str.matches(reg);
	}

}

