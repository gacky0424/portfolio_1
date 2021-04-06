package test;

import java.time.LocalDateTime;

public class DateTest {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String year = ldt.getYear() + "";
		String month = ldt.getMonthValue() + "";
		String day = ldt.getDayOfMonth() + "";
		String hour = ldt.getHour()+"";
		String min = ldt.getMinute()+"";
		String sec = ldt.getSecond()+"";
		int number =Integer.parseInt(year+month+day+hour+min+sec);
		System.out.println(number);
	}
}
