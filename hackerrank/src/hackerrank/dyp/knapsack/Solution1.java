package hackerrank.dyp.knapsack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @Link https://www.hackerrank.com/challenges/unbounded-knapsack/problem
 */
public class Solution1
{
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("knapsack", "006");
		System.out.println("Target Sum: " + test.capacity);
		System.out.print("Weight: ");
		printArray(test.weight);
		System.out.println(solution(test.capacity, test.weight));
	}

	private static int solution(int capacity, int[] weight)
	{
		int n = weight.length;
		return knapSack(capacity, weight, n);
	}
			
	private static int knapSack(int targetSum, int[] val, int n)
	{
		int maxSum;
		if (n == 0 || targetSum == 0) 
			return 0;
		if(val[n-1] > targetSum)
			return knapSack(targetSum, val, n - 1);
		
		int V1, V2;
		V1 = knapSack(targetSum, val, n - 1);
		V2 = knapSack(targetSum - val[n-1], val, n) + val[n-1];
		
		maxSum = Integer.max(V1, V2);
		return maxSum;
	}

	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.capacity = Integer.valueOf(sampleInput[0]);
		input.weight = Stream.of(sampleInput[2].split(" ")).mapToInt(Integer::parseInt).toArray();

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
