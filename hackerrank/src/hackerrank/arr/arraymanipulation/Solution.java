package hackerrank.arr.arraymanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/crush/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
 */
public class Solution
{
	/**
	 * @param args
	 * @throws IOException 
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		int n = 10;
		int q1[][] = { { 1, 2, 100 }, { 2, 5, 200 }, { 3, 4, 300 } };
		int q3[][] = { { 1, 5, 3 }, { 4, 8, 7 }, { 6, 9, 1 } };
		int q2[][] = { { 2, 6, 8 }, { 3, 5, 7 }, { 1, 8, 1 }, { 5, 9, 15 } };
		TestCase input = readTestCase("04");
		int Q[][] = input.getQ();
		n = input.getN();
		long result = arrayManipulation(n,Q);
		System.out.print("\nMax element in array is: " + result);
	}
	
	private static long arrayManipulation(int n, int[][] Q)
	{
		long arr[] = new long[n+1];
		for (int i = 0; i < Q.length; i++)
			arr = fillArray(arr, Q[i]);
		return max(arr);
	}

	private static long max(long[] arr)
	{
		int n = arr.length -1;
		long max = 0, sum = 0;
		for (int i=1; i<=n; i++)
		{
			sum += arr[i];
			if (sum > max) max = sum;
		}
		return max;
	}

	private static long[] fillArray(long[] arr, int[] query)
	{
		int n = arr.length - 1;
		int lower = query[0];
		int upper = query[1];
		long value = query[2];
		arr[lower] += value;
		if (upper < n) 
			arr[upper+1] -= value;
		return arr;
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();
		String sampleInput[] = Files.lines(Paths.get("files/arr_man/input"+testCaseNo+".txt")).
				toArray(String[]::new);
		int inputSize[] = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.setN(inputSize[0]);
		input.setM(inputSize[1]);

		int num[];
		for(int i=0; i<input.getM(); i++) 
		{
			num = Stream.of(sampleInput[i+1].split(" ")).mapToInt(Integer::parseInt).toArray();
			input.setQ(i, num);
		}

		return input;
	}
}