package codility.interview06.pairs.identical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
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
			TestCase test = readTestCase("identical", "0" + i);
			printArray(test.arr);
			int result = solution(test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}

	private static int solution(int... arr)
	{
		int result = countIdenticalPairs(arr);
		return result;
	}

	private static int countIdenticalPairs(int... nums)
	{
		int pairs = 0;
		int maxPairs = 1000000000;
//		System.out.println(maxPairs);
		Map<Integer, Integer> numFreq = getFrequency(nums);
		pairs = numFreq.values().stream().mapToInt(v -> v * (v - 1) / 2).reduce(0, Integer::sum);
		// pairs = numFreq.values().stream().mapToInt(v -> v * (v - 1) / 2).reduce(0, (x, y) -> x + y);
		return (pairs < maxPairs)? pairs : maxPairs;
	}

	private static Map<Integer, Integer> getFrequency(int[] nums)
	{
		Map<Integer, Integer> freq = Arrays.stream(nums).boxed()
				.collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum));
		// above like below
		// Arrays.stream(nums).boxed().collect(Collectors.toMap(x -> x, i -> 1,
		// Integer::sum));
		return freq;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.arr = Stream.of(sampleInput[0].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.n = input.arr.length;
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