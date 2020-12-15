package amazon.hcf;

public class Solution
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int in[] = { 8, 18, 24 };
		int in2[] = { 88, 4 };

//		System.out.println(generalizedGCD(5, in));
		 System.out.println(hcf2(88,44));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int generalizedGCD(int num, int[] arr)
	{
		// WRITE YOUR CODE HERE
		int gcd = 0;
		gcd = hcf2(arr[0], arr[1]);
		for (int i = 2; i < num; i++)
		{
			gcd = hcf(gcd, arr[i]);
		}
		return gcd;
	}

	public static int hcf(int a, int b)
	{
		if (b == 0) return a;
		else return hcf(b, a % b);
	}
	
	public static int lcm(int a, int b)
	{
		int lcm = a*b/hcf(a,b);
		return lcm;
	}

	public static int hcf2(int a, int b)
	{
		if (a != b)
		{
			if (a > b) a = a - b;
			else b = b - a;
			return hcf2(a, b);
		}
		return a;
	}

	public static int hcf3(int[] arr)
	{
		int result = arr[0];
		int i = 1;

		while (i < arr.length)
		{
			if (arr[i] % result == 0) i++;
			else
			{
				result = arr[i] % result;
				i++;
			}
		}
		return result;

	}

	// METHOD SIGNATURE ENDS
}
