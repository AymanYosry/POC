/**
 * 
 */
package codility.lesson04.missing.integer;

import java.util.Arrays;

/**
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 *
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		int arr3[] = { -1, 3, 1, 10, 3, 4, 6, 7, 8, 9 };
		int arr4[] = { 2 };

		int missNo = solution(arr3);
		System.out.println(missNo);

	}

	private static int solution(int[] A)
	{
		return getMissingInteger(A);
	}

	public static int getMissingInteger(int[] arr)
	{
		int minMissNo = 1;
		Arrays.parallelSort(arr);
		for (int num : arr)
			if (num == minMissNo) minMissNo++;
		return minMissNo;
	}
}
