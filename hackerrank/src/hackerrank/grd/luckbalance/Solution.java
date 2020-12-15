/**
 * 
 */
package hackerrank.grd.luckbalance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 *         https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("05");
		System.out.println(luckBalance(test.k, test.contests));
	}

	static int luckBalance(int k, int[][] contests)
	{
		int balance = 0;
//		if(k == 0)
//			return Arrays.stream(contests).mapToInt(arr -> arr[0]).sum();
		//print2DArray(contests);
		Arrays.sort(contests, new Checker());
		//print2DArray(contests);
		int sumFlag = 1;
		boolean kNotZero = true;
		for(int i = 0; i < contests.length; i++)
		{
			if(i == 0 && k == 0) 
				kNotZero = false;
			if(k <= 0 && kNotZero)  
				sumFlag = -1;
			
			balance += sumFlag * contests[i][0];
			if(contests[i][1] == 1) k--;
		}
		
		if(k == -1 * contests.length)
			balance *=-1;
		return balance;
	}

	@SuppressWarnings("unused")
	private static void print2DArray(int arr[][])
	{
		System.out.println("------");
		for (int rec[] : arr)
		{
			System.out.println(rec[0] + " " + rec[1]);
		}
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();
		String sampleInput[] = Files.lines(Paths.get("files/luck/input" + testCaseNo + ".txt")).toArray(String[]::new);
		int inputSize[] = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.n = inputSize[0];
		input.k = inputSize[1];

		int num[];
		for (int i = 0; i < input.n; i++)
		{
			num = Stream.of(sampleInput[i+1].split(" ")).mapToInt(Integer::parseInt).toArray();
			input.setContests(i, num);
		}

		return input;
	}
}
