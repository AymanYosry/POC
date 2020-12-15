package codility.lesson03.equilibrium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 * O(n)
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
		for (int i = 1; i <= 5; i++)
		{
			TestCase test = readTestCase("equilibrium", "0" + i);
			printArray(test.arr);
			int result = solution(test.arr);
			System.out.println(result + " expected " + test.expectedOutput + " --> " + (result == test.expectedOutput));
		}
	}

	private static int solution(int... arr)
	{
		return minEquilibriumDifference(arr);
	}

	private static int minEquilibriumDifference(int... nums)
	{
		int n = nums.length;
		if (n == 2)
			return Math.abs(nums[0]-nums[1]);
		
		int incLeftSum = 0, decLeftSum = 0;
		int incRightSum = 0, decRightSum = 0;
		int minDiff = Integer.MAX_VALUE;

		int diff;
		for(int i = 0, j = n-1; i < n-1 && j >= 1 ; i++, j--)
		{
			incLeftSum += nums[i];
			incRightSum+= nums[j];
			if(i < j)
			{
				decLeftSum = incLeftSum;
				decRightSum = incRightSum;
				if(j - i == 1)
				{
					diff = Math.abs(incLeftSum - decRightSum);
					if (diff < minDiff) 
						minDiff = diff;
				}
			}
			else
			{
				decLeftSum -= nums[j];
				decRightSum -= nums[i];
				if(j == i)
				{
					decLeftSum += nums[j];
					decRightSum += nums[i];
				}
				
				diff = Math.abs(incLeftSum - decRightSum);
				if (diff < minDiff) 
					minDiff = diff;
				diff = Math.abs(incRightSum - decLeftSum);
				if (diff < minDiff) 
					minDiff = diff;
			}
		}
		return minDiff;
	}

	@SuppressWarnings("unused")
	private static int minEquilibriumDifferenceTimeOUT(int... nums)
	{
		int n = nums.length;
		if (n == 2)
			return Math.abs(nums[0]-nums[1]);
		
		int leftSum = nums[0];
		int rightSum = sum(nums) - nums[0];
		int minDiff = Math.abs(leftSum - rightSum);

		int diff;
		for (int i = 1; i < n; i++)
		{
			diff = Math.abs(leftSum - rightSum);
			if (diff < minDiff) 
				minDiff = diff;
			leftSum += nums[i];
			rightSum -= nums[i];
		}
		return minDiff;
	}

	private static int sum(int[] nums)
	{
		int sum = 0, leftSum = 0, rightSum = 0;
		int n = nums.length;
		sum = Arrays.stream(nums).sum();
		for(int i = 0, j = n-1; i < j ; i++, j--)
		{
			leftSum += nums[i];
			rightSum+= nums[j];
		}
		sum = leftSum + rightSum;
		return sum;
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