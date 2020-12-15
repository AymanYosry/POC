/**
 * 
 */
package hackerrank.arr.twoDarrsum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/2d-array/problem
 *
 */
public class Solution
{

	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("002");
		print2DArray(tst.arr);
		System.out.println(solution(tst.arr));
	}
	
	private static int solution(int[][] arr)
	{
		return hourglassSum(arr);
	}

	static int hourglassSum(int[][] arr) 
	{
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		int rows = arr.length;
		int cols = arr[0].length;
		int i, j;
		int top, mid, bot;
		for (i = 0; i < rows - 2; i++)
		{
			for(j = 0; j < cols - 2; j++)
			{
				top = arr[i + 0][j + 0] + arr[i + 0][j + 1] + arr[i + 0][j + 2];
				mid = arr[i + 1][j + 1];
				bot = arr[i + 2][j + 0] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				
				sum = top + mid + bot;
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		
		return maxSum;
    }
	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/twoDarrsum/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		int arr[] = new int[input.n];
		int i,j = 0;
		int rows = input.n;
		int cols = input.n;
		
		for(i = 0; i < rows; i++)
		{
			arr = Stream.of(sampleInput[i].split(" ")).mapToInt(Integer::parseInt).toArray();
			for(j = 0; j < cols; j++)
			{
				input.arr[i][j] = arr[j];
			}
		}
		return input;
	}
	
	private static void print2DArray(int arr[][])
	{
		System.out.println("------");
		int rows = arr.length;
		int cols = arr[0].length;
		int i, j;
		String perintStatment = "";
		for (i = 0; i < rows; i++)
		{
			for (j = 0; j < cols; j++)
				perintStatment += arr[i][j];
			perintStatment += "\n";
		}
		System.out.println(perintStatment);
		System.out.println("------");
	}
}
