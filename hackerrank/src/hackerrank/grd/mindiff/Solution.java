package hackerrank.grd.mindiff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class Solution
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("002");
		printArray(tst.arr);
		System.out.println(minimumAbsoluteDifference(tst.arr));
	}

	private static int minimumAbsoluteDifference(int[] arr)
	{
		int n = arr.length;
		int dif = 0;
		int i, j;
		Arrays.parallelSort(arr);
		int minDiff = Math.abs(arr[0] - arr[1]);
		printArray(arr);
		for (i = 1, j = 2; j < n; i++, j++)
		{
			dif = Math.abs(arr[i] - arr[j]);
			if (dif < minDiff) 
				minDiff = dif;
		}
		return minDiff;
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/mindif/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		return input;
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}
}
