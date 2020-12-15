package hackerrank.dyp.lcs.abbreviation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/abbr/problem
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
		String testCase[] = readTestCase("12");

		for (int i = 1; i < testCase.length; i += 2)
		{
			System.out.println(abbreviation(testCase[i], testCase[i + 1]));
		}
	}

	static String abbreviation(String X, String Y)
	{
		int n = X.length();
		int m = Y.length();
		int i, j;

		//STEP 1- LCS initialized by default to false
		//STEP 2- LCS[0][0] = true
		//STEP 3- LCS[i][0] = true if character is lower case
		//STEP 4- apply LCS algorithm
		
		//STEP 1
		boolean LCS[][] = new boolean[n + 1][m + 1];
		
		//STEP 2
		LCS[0][0] = true;
		
		//STEP 3
		for(i = 1; i <= n; i++)
		{
			if(isLowerCase(X.charAt(i - 1))) 
				LCS[i][0] = true;
		}
		
		//STEP 4
		for (i = 1; i <= n; i++)
		{
			for (j = 1; j <= m; j++)
			{
				if (X.charAt(i - 1) == Y.charAt(j - 1))
					LCS[i][j] = LCS[i - 1][j - 1];
				else if(getUpperCase(X.charAt(i - 1)) == Y.charAt(j - 1))
					LCS[i][j] = LCS[i - 1][j - 1] || LCS[i - 1][j];
				else if (isUpperCase(X.charAt(i - 1)))
					LCS[i][j] = false;
				else
					LCS[i][j] = LCS[i - 1][j];
			}
		}

		return LCS[n][m] ? "YES" : "NO";
	}

	private static boolean isLowerCase(char c)
	{
		return (c >= 97 && c <= 122);
	}
	
	private static boolean isUpperCase(char c)
	{
		return (c >= 65 && c <= 90);
	}
	
	private static char getUpperCase(char c)
	{
		return (char) (c - 32);
	}
	
	@SuppressWarnings("unused")
	private static char getLowerCase(char c)
	{
		return (char) (c + 32);
	}

	private static String[] readTestCase(String testCaseNo) throws IOException
	{
		String sampleInput[] = Files.lines(Paths.get("files/apprev/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		return sampleInput;
	}
}
