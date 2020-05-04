package my.samples;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.Instant;

public class PrintTime {

	public static void main(String[] args) {
		Long currDateTime = new Date().getTime();
		Long currCalendarTime = Calendar.getInstance().getTime().getTime();
		Long currInstantTime = Instant.now().getMillis();
		
		System.out.println("currDateTime = " + currDateTime);
		System.out.println("currCalendarTime = " + currCalendarTime);
		System.out.println("currInstantTime = " + currInstantTime);
		System.out.println("Instant.now().plus(28800000).toString() = " + Instant.now().plus(28800000).toString());
		System.out.println("");

		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()); // Quoted "Z" to indicate UTC, no timezone offset
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println("df.format(new Date()) = " + df.format(new Date()));
		
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
		df2.setTimeZone(TimeZone.getTimeZone("MYT"));
		System.out.println("df2.format(new Date()) = " + df2.format(new Date()));
		
		df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssXXX", Locale.getDefault());
		df2.setTimeZone(TimeZone.getTimeZone("Asia/Hong_Kong"));
		System.out.println("df2.format(new Date()) = " + df2.format(new Date()));

		df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssXXX");
		df2.setTimeZone(TimeZone.getDefault());
		System.out.println("df2.format(new Date()) = " + df2.format(new Date()));

		ZoneId zoneId = ZoneId.of("Asia/Hong_Kong");
		//System.out.println("ZoneId.of(Locale.getDefault().toString()) = " + ZoneId.of(Locale.getDefault().toString()));		
		System.out.println("DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now(ZoneId.of(\"Asia/Hong_Kong\")) = " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + "(" + zoneId.toString() + ")" );
		
		//String s = DateTimeFormatter.ISO_DATE_TIME.format(

	}

}
