package hackerrank.dst.heapsFindRunningMedian;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author ayosry
 * @link https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
 */
public class Solution 
{
	private int notSubmitted; 
	public static void main(String[] args) 
	{
		//int n = 11;
		long numbers [] = {99976,
				99977,
				99978,
				99978,
				99979,
				99979,
				99979,
				99981,
				99981,
				99981,
				99981,
				99984,
				99983,
				99984,
				99985,
				99987,
				99991,
				99988,
				99990,
				99993,
				99995,
				99997,
				99998,
				99999,
				99991,
				99984,
				99977,
				99996
};
			//{12,4,5,3,8,7,2,5,10,9,1};
				//{1,2,3,4,5,6,7,8,9,10};
		List<Long> a = new ArrayList<>();
		long newValue = 0;
		//List data = readData();
		//for(int i=0; i<n; i++)
		//for(int i=0; i<data.size(); i++)
		for(int i=0; i<numbers.length; i++)
		{
			//Read new Value
			newValue = numbers[i];
			//newValue = (new Long((String)data.get(i))).longValue();
			a = addValue(a,newValue);
			System.out.print(newValue + "  -   ");	
			System.out.println(getMedianValue(a,0,a.size()));
		}
		System.out.println("------------------------------");
		a.forEach(e->System.out.println(e.doubleValue()));
		//readData();
	}
	
	private static List<Long> addValue(List<Long> a, long value) 
	{
		int hi = a.size();
		int lo = 0;
		double median = 0.0;
		
		if(hi <= 10)
		{
			a.add(value);
			Collections.sort(a);
			return a;
		}
		
		for(int m = (int)((hi+lo)/2); hi!=lo+1 && hi!=lo; m = (int)((hi+lo)/2))
		{
			median = getMedianValue(a,lo,hi);
			if(value == median) 
				lo = hi = m;
			if(value < median) 
				hi = m;
			if(value > median) 
				lo = m;
		}

		//if(lo == 0 && value < a.get(lo))
			//a.add(lo,value);
		//else
			a.add(hi, value);
			
		return a;
	}

	private static double getMedianValue(List<Long> a, int lo, int hi) 
	{
		int medianIndex = (lo+hi)/2;
		double loMedian = 0.0;
		double hiMedian = 0.0;
		double median = 0.0;
		
		if ((hi+lo)%2 == 1)
			median = a.get(medianIndex).doubleValue();
		else  
		{
			loMedian = a.get(medianIndex-1).doubleValue();
			hiMedian = a.get(medianIndex).doubleValue();
			median = (loMedian + hiMedian)/2.0;
		}
		return median;
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	private static List readData()
	{
		String crunchifyFile = "D:/DEV/workspace/TestPocWS/HACKERRANK/src//heapsFindRunningMedian/nums.csv";
		List<String> dataList = new ArrayList<>();
		 
		BufferedReader crunchifyBufferReader = null;
		try {
 
			// newBufferedReader opens a file for reading
			crunchifyBufferReader = Files.newBufferedReader(Paths.get(crunchifyFile));
 
		} catch (IOException e) {
			e.printStackTrace();
		}
 
		// toList: returns a Collector that accumulates the input elements into a new List
		// lines(): returns a Stream, the elements of which are lines read from this BufferedReader
		dataList = crunchifyBufferReader.lines().collect(Collectors.toList());
 
		// forEach: performs the given action for each element of the Iterable until all elements have been processed or the
		// action throws an exception.
		// dataList.forEach(System.out::println);
		return dataList;
		
	}
}
