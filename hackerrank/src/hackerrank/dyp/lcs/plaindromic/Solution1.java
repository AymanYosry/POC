/**
 * 
 */
package hackerrank.dyp.lcs.plaindromic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ayman Yosry	
 * @link https://www.techiedelight.com/find-minimum-number-deletions-convert-string-into-palindrome/
 */
public class Solution1
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("plaindromic", "001");
		System.out.println("String before Deletion:\n" + test.str);
		System.out.print("The min no. of deletion to convert into plaindromix is: " + solution(test.str));
	}

	private static int solution(String str)
	{
		return minDeletions(str);
	}

	private static int minDeletions(String str)
	{
		int n = str.length();
		int minDel;
		String X = str;
		String Y = new StringBuilder(X).reverse().toString();
		
		int LCS[][] = new int[n + 1][n + 1];
		
		int i,j;
		for(i = 1; i <= n; i++)
		{
			for(j = 1; j <= n; j++)
			{
				if(X.charAt(i - 1) == Y.charAt(j - 1))
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				else
					LCS[i][j] = Integer.max(LCS[i - 1][j], LCS[i][j - 1]);
			}
		}
		
		minDel = n - LCS[n][n];
		return minDel;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.str = sampleInput[0];

		return input;
	}
}