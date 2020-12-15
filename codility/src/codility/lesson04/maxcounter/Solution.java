package codility.lesson04.maxcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 6; i++)
		{
			TestCase test = readTestCase("maxcounter", "0" + i);
			printArray(test.arr);
			int result[] = solution(test.N, test.arr);
			printArray(result);
			printArray(test.expectedOutput);
			System.out.println("---");
		}
	}

	private static int[] solution(int N, int[] A)
	{
		return getMaxCounterArr(N, A);
	}

	private static int[] getMaxCounterArr(int max, int[] arr)
	{
		int n = arr.length;
		int maxCounter = 0, minCounter = 0;
		int counter[] = new int[max], pos = 0;
		int i;
		for (i = 0; i < n; i++)
		{
			pos = arr[i] - 1;
			if (arr[i] == max + 1)
			{
				minCounter = maxCounter;
				continue;
			}
			if (counter[pos] < minCounter) counter[pos] = minCounter;
			counter[pos]++;
			if (counter[pos] > maxCounter) maxCounter = counter[pos];
		}

		for (i = 0; i < max; i++)
		{
			if (counter[i] < minCounter) counter[i] = minCounter;
		}

		return counter;
	}

	@SuppressWarnings("unused")
	private static int[] getMaxCounterArr2(int max, int[] arr)
	{
		int n = arr.length;
		int maxCounter = 0, lastMaxCounter = 0;
		int counter[] = new int[max], count = 0;
		int i;
		for (i = 0; i < n; i++)
		{
			count = arr[i] - 1;
			if (count < max)
			{
				counter[count]++;
				if (counter[count] > maxCounter) maxCounter = counter[count];
			}
			else
			{
				counter = new int[max];
				lastMaxCounter = maxCounter;
				maxCounter = 0;
			}
		}

		for (i = 0; i < counter.length; i++)
		{
			counter[i] += lastMaxCounter;
		}
		return counter;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.N = Integer.valueOf(sampleInput[0]);
		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.expectedOutput = Stream.of(sampleInput[2].split(" ")).mapToInt(Integer::parseInt).toArray();

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
