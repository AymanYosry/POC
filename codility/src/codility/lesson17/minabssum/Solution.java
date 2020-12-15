package codility.lesson17.minabssum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ayosry
 *
 */
public class Solution
{
	private int notCorrect;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 4; i++)
		{
			TestCase test = readTestCase("minabssum", "0" + i);
			printArray(test.arr);
			int result = solution(test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}

	private static int solution(int... A)
	{
		int result = minAbsSum(A);
		return result;
	}

	private static int minAbsSum(int[] arr)
	{
		int n = arr.length;
		if(n == 0) return 0;
		if(n == 1) return Math.abs(arr[0]);
		if(n == 2) return Math.abs(arr[0] - arr[1]);
		int w = 1;
		int sum = Math.abs(arr[0]);
		
		int i = 1;
		do
		{
			w *= -1;
			sum += Math.abs(arr[i]) * w;
			i++;
			if(i == n) break;
			sum = Math.abs(sum) * w;
		} while(true);
		return Math.abs(sum);
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
