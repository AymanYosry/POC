package hackerrank.dyp.lcs.plaindromic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class Solution2
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		String sampeInput[] = Files.lines(Paths.get("files/plaindromic/special_string.txt")).toArray(String[]::new);

		String str = sampeInput[2];
		System.out.println(str);

		System.out.println(substrCount(str.length(), str));

	}

	static long substrCount(int n, String str)
	{
		return countSpecialPalindrome(str);
	}

	private static long countSpecialPalindrome(String str)
	{
		int n = str.length();
		int result = 0;

		int[] sameChar = new int[n];
		int i = 0;

		while (i < n)
		{
			int sameCharCount = 1;
			int j = i + 1;

			while (j < n && str.charAt(i) == str.charAt(j))
			{
				sameCharCount++;
				j++;
			}

			//N *( N + 1 ) / 2
			result += (sameCharCount * (sameCharCount + 1) / 2);
			sameChar[i] = sameCharCount;
			i = j;
		}

		for (int j = 1; j < n; j++)
		{
			if (str.charAt(j) == str.charAt(j - 1)) 
				sameChar[j] = sameChar[j - 1];

			if (j > 0 && j < (n - 1) && 
					(str.charAt(j - 1) == str.charAt(j + 1) && 
					str.charAt(j) != str.charAt(j - 1)))
				result += Math.min(sameChar[j - 1], sameChar[j + 1]);
		}

		return result;
	}
}