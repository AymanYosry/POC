package hackerrank.alg.sockmerchant;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/sock-merchant/problem
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Example 1
		// int n = 9;
		int[] ar = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };// new int[n];

		int result = solution(ar);
		System.out.println("No. of pairs are: " + result);
	}

	private static int solution(int[] ar)
	{
		int res = sockMerchant(ar);
		// int n = ar.length;
		// int res = sockMerchant(n, ar);
		return res;
	}

	private static int sockMerchant(int[] sockArr)
	{
		int sockPairs = 0;
		Set<Integer> sockSet = new HashSet<Integer>();
		//Stream.of(sockArr).collect(Collectors.toList());
		
		for (int item : sockArr)
		{
			if (!sockSet.contains(item))
			{
				sockSet.add(item);
			}
			else
			{
				sockPairs++;
				sockSet.remove(item);
			}
		}
		return sockPairs;
	}

	/**
	 * 
	 */
	static int sockMerchant(int n, int[] ar)
	{
		Arrays.sort(ar);
		int sockPairs = 0;
		for (int i = 0; i < n - 1; i++)
		{
			// System.out.println(i);
			if (ar[i] == ar[i + 1])
			{
				i++;
				if (i >= n) break;
				sockPairs += 1;
			}
		}
		return sockPairs;
	}
}
