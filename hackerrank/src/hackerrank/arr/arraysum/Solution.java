package hackerrank.arr.arraysum;

import java.util.Arrays;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/simple-array-sum/problem 
 */
public class Solution 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//int arCount = 6;
		int[] ar = {1, 2, 3, 4, 10, 11};
		int result = simpleArraySum(ar);
		System.out.println("Array Sum ==> "+ result);
	}

	private static int simpleArraySum(int[] ar) 
	{
		return Arrays.stream(ar).sum();
	}
}
