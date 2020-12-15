package hackerrank.dyp.kadane.arraysubsetsum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
 *
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException
	{
		int arr1[] = {1, 2, 3};
		int arr2[] = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		int arr3[] = {1, 2, 9, 4, 5, 0, 4, 11, 6};
		long arr4[] = readTestCase("08");
		//print1DArray(arr4);
		System.out.println("All Subsets Sum is: "+ subsetSum(arr1));
		System.out.println("-----------------------------");
		System.out.println("Maximum Subset Sum is: "+ subsetMaxSum(arr2));
		System.out.println("-----------------------------");
		System.out.println("Maximum Non Adjacent Subset Sum is: "+ subsetNAMaxSum(arr4));
	}

	/*
	 * arr[] = [1, 2, 3], n = 3 All subarrays : [1], [1, 2], [1, 2, 3], [2],
	 * [2,3], [3] here first element 'arr[0]' appears 3 times second element
	 * 'arr[1]' appears 4 times third element 'arr[2]' appears 3 times
	 * 
	 * Every element arr[i] appears in two types of subsets: 
	 * i) In the beginning of subset. arr[i] exists at the beginning of (n-i) subsets.
	 * 	  For example [2] appears in [2] and [2, 3]. 
	 * ii) In subsets where this element is not first element. there are (n-i)*i subsets
	 * For example [2] appears in [1, 2] and [1, 2, 3].
	 * 
	 * Total of above (i) and (ii) = (n-i) + (n-i)*i = (n-i)(i+1)
	 * 
	 * For arr[] = {1, 2, 3}, sum of subarrays is: 
	 * arr[0] * ( 0 + 1 ) * ( 3 - 0 ) + 
	 * arr[1] * ( 1 + 1 ) * ( 3 - 1 ) + 
	 * arr[2] * ( 2 + 1 ) * ( 3 - 2 )
	 * 
	 * = 1*3 + 2*4 + 3*3 = 20
	 * O(n)
	 */
	private static int subsetSum(int[] arr)
	{
		print1DArray(arr);
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
		{
			sum += arr[i] * (n - i) * (i + 1);
		}
		return sum;
	}
	
	/*
	 * Kadane's algorithm
	 * Find sub array that have max sum and print this array
	 */
	private static int subsetMaxSum(int[] arr)
	{
		print1DArray(arr);
		
		int n = arr.length;
		int sum = 0, maxSum = 0;
		int start = 0, end = 0, search = 0;
		for (int i = 0; i < n; i++)
		{
			sum += arr[i];
			if(sum > maxSum)
			{
				maxSum = sum;
				start = search; 
				end = i;
			}
			if(sum < 0)
			{
				sum = 0;
				search = i + 1;
			}
		}
		print1DArray((getSubArray(arr, start, end)));
		return maxSum;
	}

	/**
	 * Non Adjacent Subset Max Sum
	 * @param arr
	 * @return
	 */
	private static long subsetNAMaxSum(long[] arr)
	{
		long n = arr.length;
		long inclSum = arr[0];
		long exclSum = 0;
		long oldExclSum = 0;
		for(int i = 1; i < n; i++)
		{
			oldExclSum = exclSum;
			exclSum = Long.max(inclSum, exclSum);
			inclSum = arr[i] + oldExclSum;
		}
		return Long.max(inclSum, exclSum);
	}
	
	private static int[] getSubArray(int[] arr, int start, int end)
	{
		int sub[] = new int[end-start+1];
		for(int i = start; i <= end; i++)
			sub[i-start] = arr[i];
		
		return sub;
	}
	
	private static void print1DArray(int[] arr)
	{
		String printStatment ="";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("["+ printStatment +"]");
	}
	
	private static long[] readTestCase(String testCaseNo) throws IOException
	{
		String sampleInput[] = Files.lines(Paths.get("files/na_sum/input"+testCaseNo+".txt")).
				toArray(String[]::new);
		long input[] = Stream.of(sampleInput[1].split(" ")).mapToLong(Long::parseLong).toArray();
		return input;
	}
}
