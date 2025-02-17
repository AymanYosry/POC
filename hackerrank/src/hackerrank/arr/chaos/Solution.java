/**
 * 
 */
package hackerrank.arr.chaos;

import java.io.IOException;

import hackerrank.TestCase;

/**
 * @author Ayman Yosry
 * 2020-01-27
 * https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 */
public class Solution extends hackerrank.Solution
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("chaos", "012");
		printArray(tst.arrInt);
		solution(tst.n, tst.arrInt);
	}	

	private static void solution(int n, int arr[])
	{
		final int allowedBribes = 2;
		int minimumBribes = 0;
		int bribes = 0;
		boolean isValid = true;
		for (int i = 0; i < n; i++)
		{
			if(arr[i] > i) 
			{
				bribes = arr[i] - 1 - i;
				if(bribes > allowedBribes) 
				{
					isValid = false;
					break;
				}
				minimumBribes += bribes;
			}
		}
		String printStatment = (isValid)? 
				minimumBribes+"" : 
					"Too chaotic";
		System.out.println(printStatment);
	}
}