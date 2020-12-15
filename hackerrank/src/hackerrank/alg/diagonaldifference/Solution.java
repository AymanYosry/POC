/**
 * 
 */
package hackerrank.alg.diagonaldifference;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 2; i++)
		{
			TestCase test = readTestCase("diagonaldifference", "00" + i);
			print2DArray(test.arr2D);
			int result = solution(test.arr2D);
			System.out.println(result + " expected " + test.result + " --> " + (result == test.result));
		}
	}

	private static int solution(int[][] arr)
	{
		int result = diagonalDifference(arr);
		return result;
	}

	private static int diagonalDifference(int[][] arr)
	{
		int n = arr[0].length;
		int rightLeftDiag = 0, LeftRightDiag = 0;
		for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--)
		{
			rightLeftDiag += arr[i][i];
			LeftRightDiag += arr[i][j];
		}
		int dif = Math.abs(LeftRightDiag - rightLeftDiag);

		return dif;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		String sampleOutput[] = Files.lines(Paths.get("files/" + problem + "/output" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.n = Integer.valueOf(sampleInput[0]);
		input.result = Integer.valueOf(sampleOutput[0]);

		int arr[] = new int[input.n];
		int arr2D[][] = new int[input.n][input.n];
		int i, j;
		for (i = 0; i < input.n; i++)
		{
			arr = Stream.of(sampleInput[i + 1].split(" ")).mapToInt(Integer::parseInt).toArray();
			for (j = 0; j < input.n; j++)
			{
				arr2D[i][j] = arr[j];
			}
		}
		input.arr2D = arr2D;
		return input;
	}

	public static void print2DArray(int arr[][])
	{
		System.out.println("------");
		for (int row[] : arr)
		{
			for (int num : row)
				System.out.print(num + " ");
			System.out.println();
		}
		System.out.println("------");
	}

}
