package hackerrank.dyp.abbreviation;

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
		//System.out.println(abbreviation("ABcDE", "ABDE"));

	}

	static int count1 = 0;
	static int count2 = 0;

	static String abbreviation(String a, String b)
	{
		boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
		
		// initializing the first raw to all false; ie. if b is
		// not empty, isValid will always be false
		isValid[0][0] = true;
		// array initialization -
		// if a is non-empty but b is empty,
		// then isValid == true 
		// if remaining(a) != contain uppercase
		boolean containsUppercase = false;
		for (int k = 1; k <= a.length(); k++)
		{
			int i = k - 1;
			// if the pointer at string a is uppercase
			if (isUbberCase(a.charAt(i)) || containsUppercase)
			{
				containsUppercase = true;
				isValid[k][0] = false;
			}
			else isValid[k][0] = true;
		}
		// tabulation from start of string
		for (int k = 1; k <= a.length(); k++)
		{
			for (int l = 1; l <= b.length(); l++)
			{
				int i = k - 1;
				int j = l - 1;
				// when the characters are equal, set = previous character bool.
				if (a.charAt(i) == b.charAt(j))
				{
					isValid[k][l] = isValid[k - 1][l - 1];
					continue;
				}
				// elif uppercase a == b, set = prev character bool. or just eat
				// a.
				else if (getLowerCase(a.charAt(i)) == (int) b.charAt(j))
				{
					isValid[k][l] = isValid[k - 1][l - 1] || isValid[k - 1][l];
					continue;
				}
				// elif a is uppercase and no more b, or uppercase a is not b,
				// then false
				else if (isUbberCase(a.charAt(i)))
				{
					isValid[k][l] = false;
					continue;
				}
				// else just eat a
				else
				{
					isValid[k][l] = isValid[k - 1][l];
					continue;
				}
			}
		}
		return isValid[a.length()][b.length()] ? "YES" : "NO";
	}

	private static boolean isUbberCase(char c)
	{
		return (c <= 90 && c >= 65);
	}
	
	private static int getLowerCase(char c)
	{
		return ((int)c - 32);
	}
	
	@SuppressWarnings("unused")
	private static boolean difference(String str1, String str2)
	{
		if (str1.equals(str2)) return true;

		StringBuffer itrStr = new StringBuffer(str1);
		StringBuffer remStr = new StringBuffer(str1);

		int currCharPos = 0;
		String currChar;
		int n = str2.length();
		System.out.println(str2);
		System.out.println(str1);
		System.out.println(str1.length());
		for (int i = n - 1; i >= 0; i--)
		{
			if (i + 1 > itrStr.length()) return false;

			currChar = str2.charAt(i) + "";
			currCharPos = itrStr.lastIndexOf(currChar);
			if (currCharPos < 0)
			{
				currCharPos = itrStr.lastIndexOf(currChar.toLowerCase());
				if (currCharPos < 0) return false;
			}

			// itrStr.deleteCharAt(currCharPos);
			itrStr.delete(currCharPos, itrStr.length());
			remStr.deleteCharAt(currCharPos);

			System.out.println(itrStr.toString());
			System.out.println(itrStr.length());
		}

		String remaining = remStr.toString();
		if (remaining.length() != 0 && hasUpperCase(remaining)) return false;

		return true;
	}

	private static boolean hasUpperCase(String text)
	{
		String regx = ".*[A-Z]+.*";
		boolean isMatch = text.matches(regx);
		return isMatch;
	}

	@SuppressWarnings("unused")
	private static boolean hasLowerCase(String text)
	{
		String regx = ".*[A-Z]+.*";
		boolean isMatch = text.matches(regx);
		return isMatch;
	}

	private static String[] readTestCase(String testCaseNo) throws IOException
	{
		String sampleInput[] = Files.lines(Paths.get("files/apprev/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		// long input[] = Stream.of(sampleInput[1].split("
		// ")).mapToLong(Long::parseLong).toArray();
		return sampleInput;
	}

	// ###########################################################
	@SuppressWarnings("unused")
	/**
	 * Returns an array of size 2. The entries contain a minimal set of
	 * characters that have to be removed from the corresponding input strings
	 * in order to make the strings equal.
	 */
	private static String[] difference_baaad(String a, String b)
	{
		count1++;
		if (a.isEmpty() || b.isEmpty())
		{
			return new String[] { a, b };
		}
		else if (a.charAt(0) == b.charAt(0))
		{
			return difference_baaad(a.substring(1), b.substring(1));
		}
		else
		{
			String[] aa = difference_baaad(a.substring(1), b);
			String[] bb = difference_baaad(a, b.substring(1));
			if (aa[0].length() + aa[1].length() < bb[0].length() + bb[1].length())
			{
				return new String[] { a.charAt(0) + aa[0], aa[1] };
			}
			else
			{
				return new String[] { bb[0], b.charAt(0) + bb[1] };
			}
		}
	}

	static int MAX_CHAR = 26;

	@SuppressWarnings("unused")
	private static void difference2(String str1, String str2)
	{
		// mark presence of each character as 0
		// in the hash table 'present[]'
		int present[] = new int[MAX_CHAR];

		int n1 = str1.length();
		int n2 = str2.length();

		// for each character of str1, mark its
		// presence as 1 in 'present[]'
		for (int i = 0; i < n1; i++)
		{
			count2++;
			present[str1.charAt(i) - 'a'] = 1;
		}

		// for each character of str2
		for (int i = 0; i < n2; i++)
		{
			count2++;
			// if a character of str2 is also present
			// in str1, then mark its presence as -1
			if (present[str2.charAt(i) - 'a'] == 1 || present[str2.charAt(i) - 'a'] == -1)
			{
				present[str2.charAt(i) - 'a'] = -1;
			}

			// else mark its presence as 2
			else
			{
				present[str2.charAt(i) - 'a'] = 2;
			}
		}

		// print all the uncommon characters
		for (int i = 0; i < MAX_CHAR; i++)
		{
			if (present[i] == 1 || present[i] == 2)
			{
				System.out.print((char) (i + 'a') + " ");
			}
		}
	}
}
