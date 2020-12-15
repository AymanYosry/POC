package hackerrank.dyp.lcs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
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
		int arr1[] = { 3, 4, 1, 2, 1, 3 };
		int arr2[] = { 1, 2, 3, 4, 1 };

		int arr11[] = readTestCase("02")[0];
		int arr22[] = readTestCase("02")[1];

		int result[] = logestCommonSequence(arr2, arr1);
		printArray(arr1);
		//System.out.println("\n" + arr1.length + "\n-----------");
		printArray(arr2);
		//System.out.println("\n" + arr2.length + "\n-----------");
		printArray(result);
	}

	private static int[] logestCommonSequence(int[] X, int[] Y)
	{
		int n = X.length;
		int m = Y.length;
		int LCS[][] = new int[n + 1][m + 1];

		int i, j;
		for (i = 1; i <= n; i++)
		{
			for (j = 1; j <= m; j++)
			{
				if (X[i - 1] == Y[j - 1])
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
				else
					LCS[i][j] = Integer.max(LCS[i][j - 1], LCS[i - 1][j]);
			}
		}
		//System.out.println(LCS[n][m]);
		return getLCS(X, Y, LCS, n, m);
	}

	private static int[] getLCS(int X[], int Y[], int LCS[][], int n, int m)
	{
		int k = LCS[n][m];
		int[] lcs = new int[k + 1];
		lcs[k] = 0;

		int i = n;
		int j = m;
		while (i > 0 && j > 0)
		{
			if (X[i - 1] == Y[j - 1])
			{
				lcs[k - 1] = X[i - 1];

				i--;
				j--;
				k--;
			}
			else if (LCS[i - 1][j] > LCS[i][j - 1]) 
				i--;
			else 
				j--;
		}
		return lcs;
	}

	private static void printArray(int[] arr)
	{
		String result = "";
		for (int i = 0; i < arr.length - 1; i++)
		{
			result += arr[i] + " ";
		}
		System.out.println(result.trim());
	}

	private static int[][] readTestCase(String testCaseNo) throws IOException
	{
		String sampleInput[] = Files.lines(Paths.get("files/lcs/input" + testCaseNo + ".txt")).toArray(String[]::new);
		int input[][] = new int[2][1];
		input[0] = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		input[1] = Stream.of(sampleInput[2].split(" ")).mapToInt(Integer::parseInt).toArray();
		return input;
	}
}
