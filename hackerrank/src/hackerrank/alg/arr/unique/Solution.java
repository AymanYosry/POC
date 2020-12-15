package hackerrank.alg.arr.unique;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/lonely-integer/problem
 * 2020/02/04
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
			int result = solution(test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}

	private static int solution(int... arr)
	{
		int result = getUniqueElement8(arr);
		return result;
	}

	@SuppressWarnings("unused")
	private static int getUniqueElement(int... arr)
	{
		int n = arr.length;

		int XOR = arr[0];
		for (int i = 1; i < n; i++)
			XOR = XOR ^ arr[i];

		int set_bit_no = XOR & ~(XOR - 1);

		int x = 0;
		for (int i = 0; i < n; i++)
		{
			if ((arr[i] & set_bit_no) > 0) x = x ^ arr[i];
		}

		return x;
	}

	private static int getUniqueElement8(int... arr)
	{
		int XOR = Arrays.stream(arr).boxed().reduce(0, (x1, x2) -> x1 ^ x2);

		// int x = 0;
		// int bit = XOR & ~(XOR - 1);
		// int uniqueElement = Arrays.stream(arr).boxed().filter(num -> (num & bit) > 0).reduce(0, (x1, x2) -> x ^ x1 ^ x2);

		return XOR;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.arr = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.expectedOutput = Integer.valueOf(sampleInput[1]);

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