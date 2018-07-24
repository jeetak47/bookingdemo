package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	//6/12/2014 11:00:00
	private static String PATTERN1="M/dd/yyyy H:mm:ss";
	
	//6-21-2014 17:55:00
	private static String PATTERN2="M-dd-yyyy H:mm:ss";
		
	static SimpleDateFormat formatter1 = new SimpleDateFormat(PATTERN1);
	
	static SimpleDateFormat formatter2 = new SimpleDateFormat(PATTERN2);
	
	public static long parase1(String date) throws ParseException{
		return formatter1.parse(date).getTime();
	}
	
	public static long parase2(String date) throws ParseException{
		return formatter2.parse(date).getTime();
	}
	
	public static String formatDate(long date) throws ParseException{
		return formatter1.format(new Date(date));
	}
	
	
	public static double currencyParse(String value) throws ParseException {
        return  Double.valueOf(value.substring(1));
    }

}
