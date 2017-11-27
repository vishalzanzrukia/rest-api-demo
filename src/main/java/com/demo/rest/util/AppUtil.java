package com.demo.rest.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * The Class AppUtil.
 * 
 * @author VishalZanzrukia
 * @version 1.0
 */
public class AppUtil {

	private AppUtil() {
	}

	/**
	 * Gets the duration breakdown.
	 *
	 * @param millis
	 *            the millis
	 * @return the duration breakdown
	 */
	public static String getDurationBreakdown(long millis) {
		if (millis < 0) {
			throw new IllegalArgumentException("Duration must be greater than zero!");
		}

		long days = TimeUnit.MILLISECONDS.toDays(millis);
		millis -= TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

		final StringBuilder sb = new StringBuilder(64);
		if (days > 0) {
			sb.append(days);
			sb.append(" Days ");
		}
		if (hours > 0) {
			sb.append(hours);
			sb.append(" Hours ");
		}
		if (minutes > 0) {
			sb.append(minutes);
			sb.append(" Minutes ");
		}

		sb.append(seconds);
		sb.append(" Seconds");

		return sb.toString();
	}

	/**
	 * Format user date.
	 *
	 * @param dateFormat
	 *            the date format
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String formatUserDate(final SimpleDateFormat dateFormat, final Date date) {
		if (date != null) {
			return dateFormat.format(date);
		}
		return null;
	}

	/**
	 * Gets the display timezone.
	 *
	 * @param timezoneId
	 *            the timezone id
	 * @return the display timezone
	 */
	public static String getDisplayTimezone(final String timezoneId) {
		for (final String id : TimeZone.getAvailableIDs()) {
			if (id.equals(timezoneId)) {
				return TimeZone.getTimeZone(id).getDisplayName();
			}
		}
		return null;
	}

	/**
	 * Gets the combined error message.
	 *
	 * @param originalMessage
	 *            the original message
	 * @param cause
	 *            the cause
	 * @return the combined error message
	 */
	public static String getCombinedErrorMessage(final String originalMessage, final Throwable cause) {
		final StringBuffer message = new StringBuffer();
		message.append(originalMessage);
		if (cause != null) {
			message.append(" $$ Root Cause : [").append(cause.getMessage()).append("]");
		}
		return message.toString();
	}
}
