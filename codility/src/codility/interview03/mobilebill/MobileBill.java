/** 
 * 
 */
package codility.interview03.mobilebill;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayman Yosry
 *
 */
public class MobileBill 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
//		String sampleLog = "00:01:05;01001918835 "
//				 + "00:05:00;01111171419 "
//				 + "00:05:01;01001918834 "
//				 + "00:06:01;01001918834";
		String sampleLog = "00:01:07;400-234-090\n"
				 + "00:05:01;701-080-080\n"
				 + "00:05:00;400-234-090\n";
		Map<String, Integer> bill = calcualteBill(sampleLog);
		for (Map.Entry<String, Integer> entry : bill.entrySet())
		{
			System.out.println("Mob: " + entry.getKey() + " has bill: " + entry.getValue());
		}
		
		System.out.println(solution(sampleLog));
	}
	
	public static int solution (String S)
	{
		int prm = 0;
		Map<String, Integer> billMap = calcualteBill(S);
		
		prm = Collections.min(billMap.values());
		
		return prm;	
	}
	
	private static Map<String, Integer> calcualteBill(String callLog)
	{
		Map<String, Integer> billMap = new HashMap<>();
		String mobileInfo[] = callLog.split("\\r?\\n");

		String mobNo = "", mobRecord[] = null;
		int bill = 0, min = 0, sec = 0, hour = 0;
		
		for (int i = 0; i < mobileInfo.length; i++)
		{
			bill = 0;
			mobRecord = mobileInfo[i].split(";");
			mobNo = mobRecord[1];
			hour = getHour(mobRecord[0]);
			min  = getMinutes(mobRecord[0]);
			sec  = getSeconds(mobRecord[0]);
			
			if (hour == 0 && min < 5) 
			{
				bill = (min*60 + sec) * 3;
			}
			else
			{
				min += ((sec > 0)? 1:0) + hour*60;
				bill = min * 150;
			}
		
			if(billMap.containsKey(mobNo))
			{
				bill += billMap.get(mobNo);
			}
			billMap.put(mobNo, bill);

		}

		return billMap;
	}

	private static int getSeconds(String callTime) 
	{
		String[] time = callTime.split (":");
		int s = Integer.parseInt(time[2].trim());
		return s;
	}

	private static int getMinutes(String callTime) 
	{
		String[] time = callTime.split (":");
		int m = Integer.parseInt(time[1].trim());
		return m;
	}
	
	private static int getHour(String callTime) 
	{
		String[] time = callTime.split (":");
		int h = Integer.parseInt(time[0].trim());
		return h;
	}
}