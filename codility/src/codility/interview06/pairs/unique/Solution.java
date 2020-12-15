package codility.interview06.pairs.unique;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link D:\DEV\workspace\POC\codility\interview_problems\06
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
		for (int i = 1; i <= 9; i++)
		{
			TestCase test = readTestCase("unique", "0" + i);
			printArray(test.arr);
			int result[] = solution(test.arr.length, test.arr);
			System.out.println("Unique Pair is ");
			printArray(result);
			System.out.println(test.expectedOutput + " --> expected");
		}
	}

	private static int[] solution(int n, int... arr)
	{
		int result[] = getUniquePair(n, arr);
		return result;
	}

	private static int[] getUniquePair(int n, int... arr)
	{
		int uniquePairs[] = new int[2];

		// XOR each element and get XOR of two
		// unique elements(ans)
		int XOR = arr[0];

		for (int i = 1; i < n; i++)
			XOR = XOR ^ arr[i];

		// Now XOR has XOR of two missing elements.
		// Any set bit in it must be set in one
		// missing and unset in other missing number

		// Get a set bit of XOR (We get the
		// rightmost set bit)
		int bit = XOR & ~(XOR - 1);

		// Now divide elements in two sets by
		// comparing rightmost set bit of XOR with
		// bit at same position in each element.
		// Initialize missing numbers
		int x = 0, y = 0;

		for (int i = 0; i < n; i++)
		{
			if ((arr[i] & bit) > 0)

				/* XOR of first set in arr[] */
				x = x ^ arr[i];
			else
				/* XOR of second set in arr[] */
				y = y ^ arr[i];
		}

		uniquePairs[0] = x;
		uniquePairs[1] = y;
		
		return uniquePairs;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.arr = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.expectedOutput = sampleInput[1];

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