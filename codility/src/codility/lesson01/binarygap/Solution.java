package codility.lesson01.binarygap;

/**
 * 
 * @author ayosry
 * @link https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class Solution
{
	public static void main(String[] args)
	{
		System.out.println(solution3(23415) + " - " + Integer.toString(1041, 2));

		System.out.println(solution(1041) + "   " + Integer.toString(1041, 2));
		System.out.println(solution2(1041) + " - " + Integer.toString(1041, 2));
		System.out.println("----------------------");
		System.out.println(solution(2592) + "   " + Integer.toString(2592, 2));
		System.out.println(solution2(2592) + " - " + Integer.toString(2592, 2));
		System.out.println("----------------------");
		System.out.println(solution(1162) + "   " + Integer.toString(1162, 2));
		System.out.println(solution2(1162) + " - " + Integer.toString(1162, 2));
		System.out.println("----------------------");
	}

	public static int solution(int N)
	{
		String binary = Integer.toString(N, 2);
		String b[] = binary.split("1");
		int max = 0, prevMax = 0;

		for (int i = 0; i < b.length - 1; i++)
		{
			if (i + 1 == b.length - 1 && binary.endsWith("0")) break;
			max = (b[i + 1].length() > b[i].length()) ? b[i + 1].length() : b[i].length();
			if (max > prevMax) prevMax = max;
			else max = prevMax;
		}
		return max;
	}

	public static int solution2(int N)
	{
		String binary = Integer.toString(N, 2);
		int last = -1, ans = 0;
		for (int i = 0; i < binary.length(); i++)
		{
//			System.out.println((N >> i) & 1);
			if (((N >> i) & 1) > 0)
			{
				if (last >= 0) ans = Math.max(ans, i - last);
				last = i;
			}
		}
		return --ans;
	}
	
	public static int solution3(int N)
	{
		String binary = Integer.toString(N, 2);
		int last = -1, ans = 0;
		for (int i = 0; i < binary.length(); i++)
		{
			System.out.println((N / Math.pow(5, i)));
			if (((N / Math.pow(5, i)) + 1) > 0)
			{
				if (last >= 0) ans = Math.max(ans, i - last);
				last = i;
			}
		}
		return --ans;
	}
	
	public static void test_main(String[] args)
	{
		// 60 111100
		// 13 1101
		System.out.println(solution(1041) + " " + Integer.toString(1041, 2));
		String n = Integer.toString(1041 >> 4, 2);
		String n2 = Integer.toString((1041 >> 4) & 1, 2);
		;
		//int nn = (int) Math.pow(2, 30);
		System.out.println("  " + n + " " + n2);// 2147483646
		System.out.println(solution(2592) + " " + Integer.toString(2592, 2));

		n = Integer.toString(2592 >> 1, 2);
		System.out.println("  " + n + " " + (2592 / 2));

		System.out.println(solution(1162) + " - " + Integer.toString(1162, 2));
		System.out.println(solution2(1162) + " - " + Integer.toString(1162, 2));

	}
}