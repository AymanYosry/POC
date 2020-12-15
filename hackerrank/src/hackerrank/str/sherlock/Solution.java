package hackerrank.str.sherlock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class Solution
{
	public static void main(String[] args) throws IOException
	{
		//String sampeInput[] = Files.lines(Paths.get("files/sherlock_big.txt")).
		String sampeInput[] = Files.lines(Paths.get("files/sherlock.txt")).
				map(line -> line.split(":")[1].trim()).
				toArray(String[]::new);
		
		String str = sampeInput[1];
		System.out.println(isValid(str));
	}

	private static String isValid(String s)
	{
		String GOOD = "YES", BAD = "NO"; 
		if(s.length() < 4) return GOOD;
		
		String result = GOOD;
		
		Map<String, Integer> charFrequency = getFrequency(s);
		charFrequency.forEach((k,v)-> System.out.println(k + " -> " + v ));
		
		int minFreq = Collections.min(charFrequency.values());
		int maxFreq = Collections.max(charFrequency.values());
		
		if(maxFreq == minFreq) return GOOD;
		if(maxFreq - minFreq > 1 && minFreq !=1) return BAD;
		
		int minFreqCount = 0, maxFreqCount = 0, othFreqCount=0;
		for (Integer freq : charFrequency.values())
		{
			if (freq == minFreq) 
			{
				minFreqCount++;
			}
			else if (freq == maxFreq) 
			{
				maxFreqCount++;
			}
			else
			{
				othFreqCount++;
				break;
			}
		}
		
		if(othFreqCount > 0) 
			return BAD;
		if(maxFreqCount > 1 && minFreqCount > 1)
			return BAD;
		if(minFreqCount == 1 && minFreq != 1)
			return BAD;
		if(maxFreqCount == 1 && maxFreq-minFreq != 1)
			return BAD;
		
		return result;
	}

	private static Map<String, Integer> getFrequency(String str)
	{
		// Stream.of(str).map(s -> s.split("(?!^)").collect(Collectors.toMap(
		Map<String, Integer> charFrequency = Stream.of(str).
				map(s -> s.split("")).flatMap(Arrays::stream).
				collect(Collectors.toMap(c -> c, f -> 1, Integer::sum));

		return charFrequency;
	}
}
