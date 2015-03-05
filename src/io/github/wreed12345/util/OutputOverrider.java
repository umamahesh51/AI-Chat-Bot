package io.github.wreed12345.util;

import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Meant to override standard system output to add time stamps to all
 * <code> System.out.println()</code> calls
 */
public class OutputOverrider extends PrintStream{

	public OutputOverrider(OutputStream out) {
		super(out, true);
	}
	
	@Override
	public void println(String x) {
		super.println("[" + getTime() + "]" + " " + x);
	}
	
	/**
	 * @return the time in the form of 'hours:minutes:seconds.millis'
	 */
	private String getTime(){
		Calendar cal = Calendar.getInstance();
		int hours = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		int millis = cal.get(Calendar.MILLISECOND);
		
		return new String(hours + ":" + minutes + ":" + seconds + "." + millis);
	}

}
