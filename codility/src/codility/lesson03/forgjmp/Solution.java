package codility.lesson03.forgjmp;

/**
 * @author Ayman Yosry
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 */
public class Solution
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int X = 79, Y = 80, D = 30;

		System.out.println(solution(X, Y, D));
	}
	private static int solution(int X, int Y, int D)
	{
		return minForgJump(X, Y, D);
	}
	
	private static int minForgJump(int start, int end, int d)
	{
		double minJumps = (double) (end - start) / (double) d;
		if (minJumps != (int) minJumps)
			minJumps++;
		return (int) minJumps;
	}
}