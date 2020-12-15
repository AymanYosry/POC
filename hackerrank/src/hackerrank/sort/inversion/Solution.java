package hackerrank.sort.inversion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry Sorting
 *         https://www.hackerrank.com/challenges/ctci-merge-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */
public class Solution
{
	/**
	 * @param args
	 * @throws IOException
	 */
	static int simpleComplexity = 0;
	static int mergComplexity = 0;
	static int treeSetComplexity = 0;

	public static void main(String[] args) throws IOException
	{
		TestCase input = readTestCase("001");
		System.out.println("Number of inversions using Bubble count is: " + countInversionsBubble(input.arr));
		System.out.println("Simple Complexity O[sum(n-i), 0<i<n] = " + simpleComplexity);
		System.out.println("-----------");
		System.out.println(
				"Number of inversions using Merj Sort Algorithm count is: " + countInversions(input.arr));
		System.out.println("Merge Complexity O[n * log(n)] = " + mergComplexity);
		System.out.println("-----------");		
		System.out.println("Number of inversions using simple count is: " + countInversionsTreeSet(input.arr));
		System.out.println("Simple Complexity O[n] = " + treeSetComplexity);
	}

	///////////////////////////////////////////////////////////////////////////
	/**
	 * Simple Algorithm O[sum(n-i), 0<i<n]
	 * 
	 * @param arr
	 * @return
	 */
	private static long countInversionsBubble(int[] arr)
	{
		int n = arr.length;
		long invCount = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
			{
				if (arr[i] > arr[j]) invCount++;
				simpleComplexity++;
			}
 		return invCount;
	}

	///////////////////////////////////////////////////////////////////////////
	/**
	 * TreeSet Algorithm O[n * log(n)]
	 * 
	 * @param arr
	 * @return
	 */
	private static long countInversions(int arr[])
	{
		long inv = 0;

		int n = arr.length;
		int m = n / 2;

		if (n == 1)
		{
			mergComplexity++;
			return inv;
		}
		if (n == 2) 
		{
			inv += (arr[0] > arr[1]) ? 1 : 0;
			mergComplexity++;
			return inv;
		}

		// Left sub-array
		int[] left = Arrays.copyOfRange(arr, 0, m);

		// Right sub-array
		int[] right = Arrays.copyOfRange(arr, m, n);

		inv = countInversions(left, right);
		
		mergComplexity++;
		return inv;
	}

	private static long countInversions(int left[], int right[])
	{
		long inv = 0;

		int nL = left.length;
		int nR = right.length;

		inv += countInversions(left);
		inv += countInversions(right);

		Arrays.parallelSort(left);
		Arrays.parallelSort(right);
		int i = 0, j = 0;
		while (i < nL && j < nR)
		{
			if (left[i] <= right[j]) 
				i++;
			else
			{
				inv += nL - i;
				j++;
			}
		}
		return inv;
	}
	///////////////////////////////////////////////////////////////////////////
	/**
	 * TreeSet Algorithm O[n * log(n)]
	 * 
	 * @param arr
	 * @return
	 */
	private static long countInversionsTreeSet(int arr[])
	{
		long inv = 0;
		TreeSet<Integer> arrSet = new TreeSet<Integer>();
		int d = 0;
		for (int e: arr)
		{
			arrSet.add(e);
			if(arrSet.contains(e)) d--;
			d = arrSet.size() - arrSet.headSet(e, true).size();
			inv += d;
			treeSetComplexity++;
		}
		
		return inv;
	}
	///////////////////////////////////////////////////////////////////////////	
	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/inversion/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		return input;
	}
}
