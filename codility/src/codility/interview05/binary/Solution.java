package codility.interview05.binary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Ayman Yosry 
 * D:\DEV\workspace\POC\codility\interview_problems\05
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("binary", "05");
		System.out.println(test.str);
		int result = solution(test.str);
		System.out.println(Integer.toBinaryString(200));
		System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
	}

	private static int solution(String S)
	{
		int k;
		int count = 0;
		int num = Integer.parseInt(S, 2);
		System.out.println(num);
		while (num != 0)
		{
			if (num % 2 == 0)
			{
				k = log(num, 2);
				while (num % Math.pow(2, k) != 0)
					k--;
				num = num >>> k;
				count += k;
			}
			else
			{
				num--;
				count++;
			}
		}

		return count;
	}

	public static int log(int nunmer, int base)
	{
		return (int) (Math.log(nunmer) / Math.log(base));
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.str = sampleInput[0];
		input.n = input.str.length();

		input.expectedOutput = Integer.valueOf(sampleInput[1]);

		return input;
	}

	@SuppressWarnings("unused")
	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}

}
