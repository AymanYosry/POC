package codility.lesson02.cyclicrotation;

/**
 * 
 * @author Ayman Yosry
 * @link https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class Solution
{

	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		int A1[] = { 3, 8, 9, 7, 6 };
		int A2[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int A[] = A2;//{ 2, 3, 7 };// A2;// {3,5,2};//A2;
		int d = 18;

		printArray(A);
		printArray(leftRotate(A, d));
		printArray(rightRotate(A, d));
	}

	private static int[] rightRotate(int[] A, int d)
	{
		int n = A.length;
		int i, j, k, temp;

		// Start ==> Special Cases
		if (n == 0 || n == 1 || n == d) return A;
		if (n == 2)
		{
			temp = A[0];
			A[0] = A[1];
			A[1] = temp;
			return A;
		}
		if (n < d)
		{
			if (d % n == 0) return A;
			d %= n;
		}
		// End ==> Special Cases
		
		int gcd = hcf(d, n);
		for (i = n - 1; i > n - 1 - gcd; i--)
		{
			temp = A[i];
			j = i;
			while (true)
			{
				k = j - d;
				if (k < 0) k += n;
				if (k == i) break;
				A[j] = A[k];
				j = k;
			}
			A[j] = temp;
		}

		return A;
	}

	private static int[] leftRotate(int[] A, int d)
	{
		int n = A.length;
		int i, j, k, temp;

		// Start ==> Special Cases
		if (n == 0 || n == 1 || n == d) return A;
		if (n == 2)
		{
			temp = A[0];
			A[0] = A[1];
			A[1] = temp;
			return A;
		}
		if (n < d)
		{
			d %= n;
			if (d == 0) return A;
		}
		// End ==> Special Cases

		int gcd = hcf(d, n);
		for (i = 0; i < gcd; i++)
		{
			temp = A[i];
			j = i;
			while (true)
			{
				k = j + d;
				if (k >= n) k -= n;
				if (k == i) break;
				A[j] = A[k];
				j = k;
			}
			A[j] = temp;
		}
		return A;
	}

	private static int hcf(int a, int b)
	{
		if (b == 0) return a;
		else return hcf(b, a % b);
	}

	private static void printArray(int[] arr)
	{
		for (int a : arr)
			System.out.print(a + " ");
		System.out.print("\n");
	}

	@SuppressWarnings("unused")
	private static int[] rightRotate2(int[] A, int d)
	{
		int n = A.length;
		if (n == 0) return A;
		if (d >= n) d -= n;
		if (d == 0) return A;

		int[] rotA = new int[n];
		for (int i = 0; i < n; i++)
			rotA[i] = (i < d) ? A[n + i - d] : A[i - d];
		return rotA;
	}
}
