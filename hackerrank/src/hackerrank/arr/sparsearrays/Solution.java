package hackerrank.arr.sparsearrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/sparse-arrays/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class Solution
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String strings[] = {"aba","baba","aba","xzxb"};
		String queries[] = {"aba", "xzxb", "ab"};
		long freq[] = matchingStrings(strings, queries);
		for (long f : freq)
		{
			System.out.println(f);
		}
	}

	static long[] matchingStrings(String[] strings, String[] queries)
	{
		List<String> stringList = Arrays.asList(strings);
		List<String> queryList = Arrays.asList(queries);
		long frequency[] = queryList.stream().mapToLong(q -> stringList.stream().filter(q::equals).count()).toArray();
		return frequency;
	}
}
