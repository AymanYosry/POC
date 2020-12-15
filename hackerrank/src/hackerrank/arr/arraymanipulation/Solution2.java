package hackerrank.arr.arraymanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ayosry
 * @link https://www.hackerrank.com/challenges/crush/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 */
public class Solution2
{

	/**
	 * @param args
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int n = 10;
		// int m = 3;
		int q1[][] = { { 1, 2, 100 }, { 2, 5, 200 }, { 3, 4, 300 } };
		int q3[][] = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
		int q2[][] = { { 2, 6, 8 }, { 3, 5, 7 }, { 1, 8, 1 }, { 5, 9, 15 } };
		// int[m][3];
		// int max_i = 0, min_j = 10000000;
		// i 1, j 2
		// i 2, j 4// min_j>max_i;
		// long result = arrayManipulation(n, queries, max_i, min_j);
		long result2 = 0; //arrayManipulation(n,q2);
		// System.out.print("\nMax element in array is: " + result);
		System.out.print("\nMax element in array is: " + result2);

	}
		
	@SuppressWarnings("unused")
	private static long arrayManipulation3(int[][] Q)
	{
		int n = Q.length;
		List<Number[]> numList = new ArrayList<>();
		int upper,pupper, lower, plower, maxLower, minUpper;
		maxLower = Q[0][0] - 1;
		minUpper = Q[0][1] - 1;
		int common;
		for (int i = 1; i < n; i++)
		{
			lower = Q[i][0] - 1;
			upper = Q[i][1] - 1;
			plower = Q[i-1][0] - 1;
			pupper = Q[i-1][1] - 1;

			if (lower > maxLower && lower < minUpper)
			{
				maxLower = lower; 
				if(upper < minUpper)
					minUpper = upper;
			}
			else if(lower > minUpper || maxLower > upper)
				common = -1;	
			
				
		}
		return 0;
	}
	@SuppressWarnings("unused")
	private static long arrayManipulation2(int[][] Q)
	{
		int n = Q.length;
		int L = Q[0][0] - 1;
		int U = Q[0][1] - 1;
		int out = -1;
		long sum = Q[0][2];
		int upper, lower;
		int max = Math.max(U, Q[1][1] - 1);
		List<Number> outList = new ArrayList<Number>();
		for (int i = 1; i < n; i++)
		{
			lower = Q[i][0] - 1;
			upper = Q[i][1] - 1;

			sum += Q[i][2];

			if (lower > U && lower > max) 
				out = i;
			if (upper < U) 
				U = upper;
			if (lower > L) 
				if (lower <= U) 
					L = lower;
			if (out > 0)
			{
				sum -= Q[out][2];
				outList.add(Q[out][2]);
				out = -1;
			}

			if (i < n-1) 
				max = Math.max(max, Q[i + 1][1]);
		}
		return sum;
	}

	@SuppressWarnings("unused")
	private static long arrayManipulation(int n, int[][] queries, int max_i, int min_j)
	{
		int arr[] = new int[n];
		for (int i = 0; i < queries.length; i++)
		{
			arr = fillArray(arr, queries[i], max_i, min_j);
			printArray(arr);

		}
		return Arrays.stream(arr).max().getAsInt();
	}

	private static int[] fillArray(int[] arr, int[] indx, int max_i, int min_j)
	{
		for (int i = max_i; i < min_j && i < indx[1]; i++)
		{
			arr[i] += indx[2];
		}
		return arr;
	}

	private static void printArray(int[] arr)
	{
		for (int num : arr)
		{
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}
}
