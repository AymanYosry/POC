/**
 * 
 */
package hackerrank.grd.maxtoys;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * 26/01/2020
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 *
 */
public class Solution
{
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("001");
		printArray(tst.arr);
		System.out.println(maxToys(tst.arr, tst.k));
	}

	private static int maxToys(int[] prices, int k) 
	{
		int toys = 0;
		int n = prices.length;
		int sum = 0;
		Arrays.parallelSort(prices);
		for (int i = 0; i < n; i++)
		{
			sum += prices[i];
			if(sum <= k)
				toys++;
		}
		
		return toys;
    }

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/maxtoys/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.k = Integer.valueOf(sampleInput[0].split(" ")[1]);
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
