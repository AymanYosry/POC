package hackerrank.sort.bubblesort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Sorting
 * 
 * @author Ayman Yosry
 *         https://www.hackerrank.com/challenges/ctci-bubble-sort/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 */
public class Solution
{
	static int bubbleComplexity;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase input = readTestCase("002");
		countSwaps(input.arr);
	}

	private static void countSwaps(int[] arr) 
	{
		int n = arr.length;
		long swaps = 0;
		int temp;
		for (int i = 0; i < n; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				if (arr[i] > arr[j]) 
				{
					temp = arr[i]; 
                    arr[i] = arr[j]; 
                    arr[j] = temp;  
					swaps++;
				}
				bubbleComplexity++;
			}
		}
		
		System.out.printf("Array is sorted in %d swaps.\n"
				+ "First Element: %d\n"
				+ "Last Element: %d", swaps, arr[0], arr[n-1]);
    }
	
	///////////////////////////////////////////////////////////////////////////
	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/bub/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		return input;
	}
}
