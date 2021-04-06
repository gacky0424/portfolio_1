package model;

import java.time.LocalDateTime;

public class SalesNumberMaker {
	public int makeNumber() {
		LocalDateTime ldt = LocalDateTime.now();
		String month = ldt.getMonthValue() + "";
		String day = ldt.getDayOfMonth() + "";
		String hour = ldt.getHour()+"";
		String min = ldt.getMinute()+"";
		String sec = ldt.getSecond()+"";
		int number =Integer.parseInt(month+day+hour+min+sec);
		return number;
	}
}
