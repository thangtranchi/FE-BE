package com.metasoft.em.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Tran C Thang
 *
 */
public class DateUtils {

	/**
	 * 
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static String convertToString(Date d, String pattern) {

		return new SimpleDateFormat(pattern).format(d);
	}
}
