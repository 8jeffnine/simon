package impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date now = new Date();
		System.out.println(df.format(now).substring(0, 8) );
		System.out.println(df.format(now) );
	}
	

}

