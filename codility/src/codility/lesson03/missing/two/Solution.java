package codility.lesson03.missing.two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 *         https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
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
		for (int i = 1; i <= 3; i++)
		{
			TestCase test = readTestCase("miss2num", "0" + i);
			printArray(test.arr);
			int result[] = solution(test.arr.length + 2, test.arr);
			System.out.println("Two Missing Numbers are ");
			printArray(result);
			System.out.println(test.expectedOutput + " --> expected");
		}
	}

	private static int[] solution(int n, int... arr)
	{
		int result[] = getTwoMissingNumbers(n, arr);
		return result;
	}

	private static int[] getTwoMissingNumbers(int n, int... arr)
	{
		int missing[] = new int[2];
		/*
		 * Get the XOR of all elements in arr[] and {1, 2 .. n}
		 */
		int XOR = arr[0];
		for (int i = 1; i < n - 2; i++)
			XOR ^= arr[i];
		for (int i = 1; i <= n; i++)
			XOR ^= i;

		// Now XOR has XOR of two missing elements.
		// Any set bit in it must be set in one missing
		// and unset in other missing number

		// Get a set bit of XOR (We get the rightmost
		// set bit)
		int bit = XOR & ~(XOR - 1);

		// Now divide elements in two sets by comparing
		// rightmost set bit of XOR with bit at same
		// position in each element.
		int x = 0, y = 0; // Initialize missing numbers
		for (int i = 0; i < n - 2; i++)
		{
			if ((arr[i] & bit) > 0)

				/* XOR of first set in arr[] */
				x = x ^ arr[i];
			else
				/* XOR of second set in arr[] */
				y = y ^ arr[i];
		}

		for (int i = 1; i <= n; i++)
		{
			if ((i & bit) > 0)

				/*
				 * XOR of first set in arr[] and {1, 2, ...n }
				 */
				x = x ^ i;
			else
				/*
				 * XOR of second set in arr[] and {1, 2, ...n }
				 */
				y = y ^ i;
		}
		missing[0] = x;
		missing[1] = y;

		return missing;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.n = Integer.valueOf(sampleInput[0]);
		;

		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.n = input.arr.length;
		input.expectedOutput = sampleInput[2];

		return input;
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}
}