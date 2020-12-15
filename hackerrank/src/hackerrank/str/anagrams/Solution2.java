/**
 * 
 */
package hackerrank.str.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 *         https://www.hackerrank.com/challenges/java-anagrams/problem
 */
public class Solution2
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		boolean ret = isAnagramJavaLangOnly("Abul", "BulA");
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}

	static boolean isAnagramJavaLangOnly(String a, String b)
	{
		if (a.equalsIgnoreCase(b)) return true;
		if (a.length() != b.length()) return false;
		StringBuffer bf = new StringBuffer(b);
		b = bf.reverse().toString();
		if (a.equalsIgnoreCase(b)) return true;

		int aFreq[] = getCharFrequency(a.toLowerCase());
		int bFreq[] = getCharFrequency(b.toLowerCase());
		
		for(int i=0; i < aFreq.length; i++)
			if(aFreq[i] != bFreq[i])
				return false;
//		boolean isAnagram = aMap.entrySet().stream().allMatch(
//				e -> bMap.containsKey(e.getKey()) && (bMap.get(e.getKey()).intValue() == e.getValue().intValue()));
		return true;  
	}
	
	private static int[] getCharFrequency(String str)
	{
		int letterFrquency[] = new int[26];
		for (char letter : str.toCharArray())
			letterFrquency[letter - 'a']++;

		return letterFrquency;
	}

	static boolean isAnagramBest(String a, String b)
	{
		if (a.equalsIgnoreCase(b)) return true;
		if (a.length() != b.length()) return false;
		StringBuffer bf = new StringBuffer(b);
		b = bf.reverse().toString();
		if (a.equalsIgnoreCase(b)) return true;

		Map<String, Integer> aMap = getFrequency(a);
		Map<String, Integer> bMap = getFrequency(b);

		boolean isAnagram = aMap.entrySet().stream().allMatch(
				e -> bMap.containsKey(e.getKey()) && (bMap.get(e.getKey()).intValue() == e.getValue().intValue()));
		return isAnagram;
	}

	private static Map<String, Integer> getFrequency(String str)
	{
		Map<String, Integer> charFrequency = Stream.of(str).map(s -> s.toLowerCase()).map(s -> s.split(""))
				.flatMap(Arrays::stream).collect(Collectors.toMap(c -> c, f -> 1, Integer::sum, HashMap::new));

		return charFrequency;
	}
}
