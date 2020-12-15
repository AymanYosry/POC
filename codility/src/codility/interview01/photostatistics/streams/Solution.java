package codility.interview01.photostatistics.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * @author Ayman Yosry
 * @link D:\DEV\workspace\POC\codility\interview_problems\01
 */
public class Solution
{
	public static void main(String[] args) throws IOException
	{
		String sampleLog = Files.lines(Paths.get("files/photo.log")).
				map(line -> line.trim() + "\n").
				reduce("",String::concat);

		System.out.println(sampleLog);
		System.out.println(solution(sampleLog));
	}

	private static Map<String, Integer> indexMap = new Hashtable<>();
	public static String solution(String S)
	{
		String result = "";
		String records[][] = getOrganaizedPhotos(S);
		result = Stream.of(records).
				map(v -> v[0] + getPadding(v[0], v[1]) + "." + v[2] + "\n").
				reduce("", String::concat);
		return result;
	}

	private static int serial = 0;
	private static String[][] getOrganaizedPhotos(String photoLog)
	{
		Set<String> sortedPhotoes = new TreeSet<>(new Comparator<String>()
		{
			@Override
			public int compare(String s1, String s2)
			{
				String s1Arr[] = s1.split(":");
				String s2Arr[] = s2.split(":");

				String city1 = s1Arr[1].substring(1);
				String city2 = s2Arr[1].substring(1);

				String date1 = s1Arr[2];
				String date2 = s2Arr[2];

				int cityCompareValue = city1.compareTo(city2);
				int dateCompareValue = date1.compareTo(date2);
				int compareValue = cityCompareValue + dateCompareValue;
				return compareValue;
			}
		});

		String logSeparator = "\\r?\\n";
		String recordSeparator = ", ";
		String lines[] = photoLog.split(logSeparator);

		Stream.of(lines).
			map(record -> record.split(recordSeparator)).
			map(record -> serial++ + ":" + record[1] + ":" + getDate(record[2]) + ":" + getExt(record[0])).
			collect(Collectors.toSet()).
			forEach(e -> sortedPhotoes.add(e));

		String result[][] = new String[sortedPhotoes.size()][3];
		sortedPhotoes.forEach(e -> {
			String record[] = e.split(":");
			serial = Integer.valueOf(record[0]);
			String city = record[1];
			String ext = record[3];

			if (!indexMap.containsKey(city)) indexMap.put(city, 1);
			else indexMap.put(city, indexMap.get(city).intValue() + 1);

			String values[] = { city, indexMap.get(city) + "", ext };

			result[serial] = values;
		});
		return result;
	}

	private static String getPadding(String city, String index)
	{
		String zeroPading = "";
		int padding = (indexMap.get(city) + "").length();
		if (index.length() < padding)
		{
			for (int i = 1; i < padding; i++)
				zeroPading += "0";
		}
		return zeroPading + index;
	}
	
	private static String getExt(String fileName)
	{
		String nameSeparator = "[.]";// or \\.
		String ext = fileName.split(nameSeparator)[1];
		return ext;
	}

	private static String getDate(String dateRecord)
	{
		String dateTime;
		String date,time, dateTimeArr[];
		String dateSeparator = " ";

		dateTimeArr = dateRecord.split(dateSeparator);
		date = dateTimeArr[0];
		time = dateTimeArr[1];
		
		String year = getYear(date);
		String month= getMonth(date);
		String day  = getDay(date);
		String hour = getHour(time);
		String min  = getMinutes(time);
		String sec  = getSeconds(time);
		
		dateTime = year+month+day+hour+min+sec;
		return dateTime;
	}

	private static String getSeconds(String string)
	{
		String[] time = string.split(":");
		return time[2];
	}

	private static String getMinutes(String string)
	{
		String[] time = string.split(":");
		return time[1];
	}

	private static String getHour(String string)
	{
		String[] time = string.split(":");
		return time[0];
	}

	private static String getDay(String string)
	{
		String[] date = string.split("-");
		return date[2];
	}

	private static String getMonth(String string)
	{
		String[] date = string.split("-");
		return date[1];
	}

	private static String getYear(String string)
	{
		String[] date = string.split("-");
		return date[0];
	}
}
