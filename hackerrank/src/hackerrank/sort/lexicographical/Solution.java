package hackerrank.sort.lexicographical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ayman Yosry
 *         https://www.hackerrank.com/challenges/morgan-and-a-string/problem
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase input = readTestCase("001");
		System.out.println(morganAndString(input.strArr[1], input.strArr[2]));
	}

	static String morganAndString(String str1, String str2)
	{
		StringBuilder res = new StringBuilder();
		int i = 0, j = 0;
		while (i < str1.length() && j < str2.length())
		{
			if (lexicographicalCompare(str1, i, str2, j))
			{
				res.append(str1.charAt(i++));
				i = appendRepeatedChar(res, str1, i);
			}
			else
			{
				res.append(str2.charAt(j++));
				j = appendRepeatedChar(res, str2, j);
			}
		}
		if (i < str1.length()) res.append(str1.substring(i));
		if (j < str2.length()) res.append(str2.substring(j));
		return res.toString();
	}

	private static int appendRepeatedChar(StringBuilder sb, String str, int charPosition)
	{
		while (isRepeatedChar(str, charPosition))
			sb.append(str.charAt(charPosition++));
		return charPosition;
	}

	private static boolean isRepeatedChar(String str, int charPosition)
	{
		return charPosition < str.length() && str.charAt(charPosition) == str.charAt(charPosition - 1);
	}

	/**
	 * @param str1
	 * @param i
	 * @param str2
	 * @param j
	 *            compare str1 with str2
	 * @return true if str1 (lexicographically < ) str 2
	 */
	private static boolean lexicographicalCompare(String str1, int i, String str2, int j)
	{
		while (i < str1.length() && j < str2.length())
		{
			if (str1.charAt(i) < str2.charAt(j)) return true;
			if (str1.charAt(i) > str2.charAt(j)) return false;
			i++;
			j++;
		}
		/*
		 * if len(BBB) > len(BB) then BBB (lexicographically <) BB 
		 * if len(STR1) > len(STR2) then STR1 (lexicographically <) STR2
		 */
		return j == str2.length();
	}

	static String morganAndString_NotWorkingOnHR(String str1, String str2)
	{
		StringBuilder res = new StringBuilder();
		StringBuilder sb1 = new StringBuilder(str1);
		StringBuilder sb2 = new StringBuilder(str2);
		char firstChar1, firstChar2;
		while (sb1.length() > 0 && sb2.length() > 0)
		{
			firstChar1 = sb1.charAt(0);
			firstChar2 = sb2.charAt(0);
			if (firstChar1 < firstChar2)
			{
				res.append(firstChar1);
				sb1.deleteCharAt(0);
			}
			else if (firstChar1 > firstChar2)
			{
				res.append(firstChar2);
				sb2.deleteCharAt(0);
			}
			else if (firstChar1 == firstChar2)
			{
				res.append(firstChar1);
				if (sb1.compareTo(sb2) < 0) sb1.deleteCharAt(0);
				else sb2.deleteCharAt(0);
			}
		}
		return res.append(sb1).append(sb2).toString();
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		input.strArr = Files.lines(Paths.get("files/morgan/input" + testCaseNo + ".txt")).toArray(String[]::new);
		return input;
	}
}