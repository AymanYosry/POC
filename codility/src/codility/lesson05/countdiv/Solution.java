package codility.lesson05.countdiv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		for (int i = 1; i <= 5; i++)
		{
			TestCase test = readTestCase("countdiv", "0"+i);
			printArray(test.arr);
			int result = solution(test.arr[0], test.arr[1], test.arr[2]);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}
	
	private static int solution(int A, int B, int K)
	{
		if(A == 0 && B == 0) return 1;
		if(A == B && A == K) return 1;
		if(K > B) return 0;
		
		return countDivisible(A, B, K);
	}
	
	private static int countDivisible(int X, int Y, int K)
	{
		int firstDiv = (X % K == 0)? X : X + (K - X % K);
		int lastDiv  = Y - Y % K;
		int divisibles = (lastDiv - firstDiv) / K + 1;
		
		return divisibles;
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
