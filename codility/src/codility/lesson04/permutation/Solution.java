package codility.lesson04.permutation;

import java.util.Arrays;

/**
 * A permutation is a sequence containing each element from 1 to N once, and
 * only once.
 * 
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
 */
public class Solution
{
	public static void main(String[] args)
	{
		int B[] = { 1, 2, 3, 9, 5, 6, 7, 8, 4, 10 };
		System.out.println(solution(B));
	}

	private static int solution(int[] A)
	{
		int n = A.length;
		switch (n)
		{
		case 1:
			if (A[0] == 1) return 1;
			else return 0;
		case 2:
			if (Integer.min(A[0], A[1]) == 1 && Integer.max(A[0], A[1]) == 2) return 1;
			else return 0;
		}
		return isPermutation(A) ? 1 : 0;
	}

	// 100%
	private static boolean isPermutation(int... arr)
	{
		// int XOR = Arrays.stream(arr).boxed().reduce(0, (x1, x2) -> x1 ^ minValue++ ^ x2);
		// previous line give bad performance
		int XOR = 0;
		for (int i = 1; i <= arr.length; i++)
		{
			XOR ^= i ^ arr[i - 1];
		}
		return (XOR == 0);
	}

	// 80%
	public static boolean isPermutation80Percent(int[] A)
	{
		int sum = 0;
		for (int a : A)
		{
			sum = sum + a;
		}
		int n = A.length - 1;
		Arrays.sort(A);
		int sequenceSum = A[n] * (A[n] + A[0]) / 2;// An(A0 + An)/2

		return (sequenceSum == sum);
	}
}