package hackerrank.dyp.knapsack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @Link1 https://www.youtube.com/watch?v=nLmhmB6NzcM
 * @Link2 https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 */
public class Solution2
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("knapsack", "007");
		System.out.println("Capacity: " + test.capacity);
		System.out.print("Profit: ");
		printArray(test.profit);
		System.out.print("Weight: ");
		printArray(test.weight);
		System.out.println(solution(test.capacity, test.weight, test.profit));
	}

	private static int solution(int capacity, int[] weight, int[] profit)
	{
		//return knapSack(capacity, weight, profit, profit.length);
		return knapSack(capacity, weight, profit);
		
	}

	/**
	 * Dynamic Programming Solution:
	 * The formula is:
	 * W[i][w] = max(V1, V2)
	 * V1 = W[i-1][w] 
	 * V2 = W[i-1][w-weight[i-1]] + profit[i-1]
	 * @param capacity
	 * @param weight
	 * @param profit
	 * @return
	 */
	private static int knapSack(int W, int[] weight, int[] profit)
	{
		int n = profit.length;
		int m = W;
		if (n == 0 || m == 0) return 0;

		int KNP[][] = new int[n + 1][m + 1];
		int i, w;
		int V1 , V2;
		for(i = 1; i <= n; i++)
		{
			for(w = 1; w <= m; w++)
			{
				if(w < weight[i-1])
				{
					KNP[i][w] = KNP[i-1][w];
					continue;
				}

				V1 = KNP[i-1][w];
				V2 = KNP[i-1][w-weight[i-1]] + profit[i-1];
				
				KNP[i][w] = Integer.max(V1, V2);
			}
		}
		return KNP[n][m];
	}

	//Recursive Solution
	@SuppressWarnings("unused")
	private static int knapSack(int W, int[] weight, int[] profit, int n)
	{
		int maxSum;

		if (n == 0 || W == 0) 
	        return 0; 
	       
	    if (weight[n-1] > W) 
	       return knapSack(W, weight, profit, n-1); 
	       
		int V1, V2;
		V1 = knapSack(W, weight, profit, n-1); 
		V2 = knapSack(W - weight[n-1], weight, profit, n - 1) + profit[n-1];

		maxSum = Integer.max(V1, V2);
		return maxSum;
	}
	
	private static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.capacity = Integer.valueOf(sampleInput[0]);
		input.profit = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
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
