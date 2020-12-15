package codility.interview04.bulb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry 
 * @link D:\DEV\workspace\POC\codility\interview_problems\04
 */
public class Solution
{
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 5; i++)
		{
			TestCase test = readTestCase("bulb", "0"+i);
			printArray(test.arr);
			int result = solution(test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}

	private static int solution(int... arr)
	{
		int result = calculateShiningMoments(arr);
		return result;
	}

	private static int calculateShiningMoments(int... arr)
	{
		int moment = 0;
		int last = 0, sum = 0, seqSum = 0;

		for (int i = 0; i < arr.length; i++)
		{
			sum += arr[i];
			if (arr[i] > last) last = arr[i];
			seqSum = (1 + last) * last / 2;
			if (seqSum == sum) moment++;
		}

		return moment;
	}

	public static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.arr = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.n = input.arr.length;
		input.expectedOutput = Integer.valueOf(sampleInput[1]);

		return input;
	}

	public static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}
}