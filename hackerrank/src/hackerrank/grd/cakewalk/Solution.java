package hackerrank.grd.cakewalk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry 
 * 26/01/2020
 *         https://www.hackerrank.com/challenges/marcs-cakewalk/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class Solution
{
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("03");
		printArray(tst.arr);
		System.out.println(marcsCakewalk(tst.arr));
	}

	private static long marcsCakewalk(int[] calorie)
	{
		int n = calorie.length;
		long x = 0;
		int i;

		Arrays.parallelSort(calorie);
		for (i = 0; i < n; i++)
		{
			x += Math.pow(2, n - 1 - i) * calorie[i];
		}

		return x;
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/cakewalk/input" + testCaseNo + ".txt"))
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