package codility.interview01.photostatistics;

import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Ayman Yosry
 * @link D:\DEV\workspace\POC\codility\interview_problems\01
 */
public class Solution
{

	public static void main(String[] args)
	{
		String sampleLog = "" + 
				"photo.jpg, Warsaw, 2013-09-05 14:08:15\n" + 
				"john.png, London, 2013-06-20 15:13:22\n" + 
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\n" +
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\n" +
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\n"+
				"BOB.jpg, London, 2015-08-05 00:02:03\n"+
				"notredam.png, Paris, 2015-09-01 12:00:00\n"+
				"me.jpg, Warsaw, 2013-09-06 15:40:22\n"+
				"a.png, Warsaw, 2016-02-13 13:33:50\n"+
				"b.jpg, Warsaw, 2016-01-02 15:12:22\n"+
				"c.jpg, Warsaw, 2016-01-02 14:34:30\n"+
				"d.jpg, Warsaw, 2016-01-02 15:15:01\n"+
				"e.png, Warsaw, 2016-01-02 09:49:09\n"+
				"f.png, Warsaw, 2016-01-02 10:55:32\n"+
				"g.jpg, Warsaw, 2016-02-29 22:13:11";
		
		//test();		
		System.out.println(solution(sampleLog));
	}
	
	private static Map<String, Integer> indexMap = new Hashtable<>();
	public static String solution(String S)
	{
		String result = "";
		Map<String, String[]> photos = getOrganaizedPhotos(S);
		String cityIndex="";
		for (Map.Entry<String, String[]> entry : photos.entrySet())
		{
			cityIndex = getPadding(entry.getValue()[0],entry.getValue()[1]);
			result += entry.getValue()[0] + cityIndex + "." + entry.getValue()[2]+"\n";  
		}
		return result;
	}
	
	private static String getPadding(String city, String index)
	{
		String zeroPading ="";
		int padding = (indexMap.get(city)+"").length();
		if(index.length() < padding)
		{	
			for(int i=1; i<padding; i++) zeroPading +="0";
		}
		return zeroPading+index;
	}

	private static Map<String, String[]> getOrganaizedPhotos(String photoLog)
	{
		Map<String, String[]> linkedPhotoes = new LinkedHashMap<>();
		Map<String, String> sortedPhotoes = new TreeMap<>
		(new Comparator<String>() 
		{
            @Override
            public int compare(String s1, String s2) 
            {
            	int separator01Index = s1.indexOf(":");
            	int separator02Index = s2.indexOf(":");

            	String city1 = s1.substring(0, separator01Index);
            	String city2 = s2.substring(0, separator02Index);
            	
            	String date1 = s1.substring(separator01Index+1);
            	String date2 = s2.substring(separator02Index+1);
            	
            	int cityCompareValue = city1.compareTo(city2);
            	int dateCompareValue = date1.compareTo(date2);
            	int compareValue = cityCompareValue + dateCompareValue;
            	
            	return compareValue;
            }
        });


		String logSeparator = "\\r?\\n";
		String recordSeparator = ", ";
		String dateSeparator = " ";
		String nameSeparator = "[.]";// or \\.
		
		String log[] = photoLog.split(logSeparator);
		
		String line[] = null;		
		String fileName[] = null;	
		String fileDate[] = null;	
		String city = null, ext=null;
		String year, month, day, hour, min , sec;

		for (int i = 0; i < log.length; i++)
		{
			line = log[i].split(recordSeparator);
			fileName = line[0].split(nameSeparator);
			fileDate = line[2].split(dateSeparator);
			city = line[1];
			ext = fileName[1];
			year = getYear(fileDate[0]);
			month  = getMonth(fileDate[0]);
			day  = getDay(fileDate[0]);
			hour = getHour(fileDate[1]);
			min  = getMinutes(fileDate[1]);
			sec  = getSeconds(fileDate[1]);
			String values[]= {ext};

			sortedPhotoes.put(city+":"+year+month+day+hour+min+sec, ""+i);
			linkedPhotoes.put(i+"", values);
		}
		
		String key,value;
		int cityIndex;
		
		for (Map.Entry<String, String> entry : sortedPhotoes.entrySet())
		{
			key = entry.getKey();
			value = entry.getValue();
			ext = linkedPhotoes.get(value)[0];
			city = key.substring(0,key.indexOf(":"));
			if(!indexMap.containsKey(city)) 
				indexMap.put(city, 1);
			else
				indexMap.put(city,indexMap.get(city).intValue()+1);
			cityIndex = indexMap.get(city);
			
			String values[]= {city,cityIndex+"",ext};

			linkedPhotoes.put(value, values);
		}
		
		return linkedPhotoes;
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

	/*
	@SuppressWarnings("unused")
	private static void test()
	{
		Map<Integer, String> m = new LinkedHashMap<>();
		int key = 1; String value="s";
		m.put(key, value+key);
		m.put(++key, value+key);
		m.put(++key, value+key);
		m.put(++key, value+key);
		m.put(7, value+7);

		m.put(++key, value+key);
		m.put(++key, value+key);
		m.forEach((k, v)->System.out.println(v));	
		System.out.println("-----------------------");
		
		Map<Integer, String> m2 = new HashMap<>();
		int key2 = 1; String value2="s";
		m2.put(key2, value+key2);
		m2.put(++key2, value+key2);
		m2.put(++key2, value+key2);
		m2.put(++key2, value+key2);
		m2.put(7, value+7);

		m2.put(++key2, value+key2);
		m2.put(++key2, value+key2);
		m2.forEach((k, v)->System.out.println(v));
		System.out.println("-----------------------");

		Set<String> m3 = new HashSet<>();
		int key3 = 1; String value3="s";
		key2=key3;
		m3.add(value+key2);
		m3.add(value+(++key2));
		m3.add(value+(++key2));
		m3.add(value+(++key2));
		m3.add(value+(7));

		m3.add(value+(++key2));
		m3.add(value+(++key2));
		m3.forEach((v)->System.out.println(v));
		
		String s = "Paris:20150722235959";
		System.out.println("-----------------------");
		System.out.println(s.substring(0,s.indexOf(":"))+" -- "+s.substring(s.indexOf(":")+1));
	}
	
	@SuppressWarnings("unused")
	private static void printMap(Map<String, String> m)
	{
		m.forEach((k, v)->System.out.println(k+"==>"+v));	
		System.out.println("-----------------------");		
	}
	*/
}
