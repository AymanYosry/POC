package codility.lesson04.forgriverone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 1; i++)
		{
			TestCase test = readTestCase("forgriverone", "0"+i);
			printArray(test.arr);
			int result = solution(test.steps, test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}
	
	private static int solution(int X, int[] A)
	{
		return getEarliestMoment(X,A);
	}
	
	private static int getEarliestMoment(int targetPosition, int[] arr)
	{
		int steps = targetPosition;
		int n = arr.length;
		boolean stepCounter[] = new boolean[steps + 1];
		
		for(int i = 0; i < n; i++)
		{
			if(stepCounter[arr[i]] == false)
			{
				stepCounter[arr[i]] = true;
				steps--;
				if (steps == 0) return i;
			}
		}
		return -1;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/sample" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		input.steps = Integer.valueOf(sampleInput[0]);
		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		input.expectedOutput = Integer.valueOf(sampleInput[2]);

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
