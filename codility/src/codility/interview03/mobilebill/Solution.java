/**
 * 
 */
package codility.interview03.mobilebill;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Ayman
 * @link D:\DEV\workspace\POC\codility\interview_problems\03
 */
public class Solution
{
	public static void main(String[] args)
	{
		// String sampleLog = "00:01:05;01001918835 "
		// + "00:05:00;01111171419 "
		// + "00:05:01;01001918834 "
		// + "00:06:01;01001918834";

		String sampleLog = "" + "00:01:07,400-234-090\n" + "00:05:01,701-080-080\n" + "00:05:00,400-234-090\n";
		Map<String, Integer> bill = getPhonBill(sampleLog);
		for (Map.Entry<String, Integer> entry : bill.entrySet())
		{
			System.out.println("Mob: " + entry.getKey() + " has bill: " + entry.getValue());
		}

		System.out.println(solution(sampleLog));
	}

	public static int solution(String S)
	{
		Map<String, Integer> billMap = getPhonBill(S);
		int prm = Collections.min(billMap.values());
		return prm;
	}

	private static Map<String, Integer> getPhonBill(String log)
	{
		Map<String, Integer> billMap = new Hashtable<>();
		String logSeparator = "\\r?\\n";
		String recordSeparator = ",";

		String line[] = log.split(logSeparator);

		String mobNo = "", record[] = null;
		int bill = 0, min = 0, sec = 0, hour = 0;

		for (int i = 0; i < line.length; i++)
		{
			bill = 0;
			record = line[i].split(recordSeparator);
			mobNo = record[1];
			hour = getHour(record[0]);
			min = getMinutes(record[0]);
			sec = getSeconds(record[0]);

			if (hour == 0 && min < 5)
			{
				bill = (min * 60 + sec) * 3;
			}
			else
			{
				min += ((sec > 0) ? 1 : 0) + hour * 60;
				bill = min * 150;
			}

			if (billMap.containsKey(mobNo))
			{
				bill += billMap.get(mobNo);
			}
			billMap.put(mobNo, bill);
		}

		return billMap;
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