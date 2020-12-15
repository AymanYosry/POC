package codility.interview03.mobilebill.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ayman
 * @link D:\DEV\workspace\POC\codility\interview_problems\03
 */
public class Solution
{
	private static int serial;

	public static void main(String[] args) throws IOException
	{
		String sampleLog = Files.lines(Paths.get("files/mobile.log")).
				map(line -> line + "\n").
				reduce("",String::concat);
		System.out.println(sampleLog);

		Map<String, Integer> bill = getPhonBill(sampleLog);
		bill.forEach((k, v) -> System.out.println(++serial + "- Mob: " + k + " has bill: " + v));

		System.out.println(solution(sampleLog));
	}

	public static int solution(String S)
	{
		Map<String, Integer> billMap = getPhonBill(S);
		int prm = Collections.min(billMap.values());
		return prm;
	}

	private static String logSeparator = "\\r?\\n";
	private static String recordSeparator = ",";

	private static Map<String, Integer> getPhonBill(String log)
	{
		String lines[] = log.split(logSeparator);

		Map<String, Integer> billMap = Arrays.stream(lines).
				map(mobileRecord -> mobileRecord.split(recordSeparator)).
				collect(
				Collectors.toMap(
						record -> record[1], 
						record -> calculateBill(record[0]), 
						(v1, v2) -> v1 + v2));

		return billMap;
	}

	private static int calculateBill(String callTime)
	{
		int bill = 0;
		int hour = getHour(callTime);
		int min = getMinutes(callTime);
		int sec = getSeconds(callTime);

		if (hour == 0 && min < 5)
		{
			bill = (min * 60 + sec) * 3;
		}
		else
		{
			min += ((sec > 0) ? 1 : 0) + hour * 60;
			bill = min * 150;
		}

		return bill;
	}

	private static int getSeconds(String callTime)
	{
		String[] time = callTime.split(":");
		int s = Integer.parseInt(time[2].trim());
		return s;
	}

	private static int getMinutes(String callTime)
	{
		String[] time = callTime.split(":");
		int m = Integer.parseInt(time[1].trim());
		return m;
	}

	private static int getHour(String callTime)
	{
		String[] time = callTime.split(":");
		int h = Integer.parseInt(time[0].trim());
		return h;
	}
}