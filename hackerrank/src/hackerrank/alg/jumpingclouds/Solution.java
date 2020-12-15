package hackerrank.alg.jumpingclouds;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */
public class Solution {
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int n = 7;
		int c[] = {0, 0, 1, 0, 0, 1, 0};
		int n1=6;
		int c1[] = {0, 0, 0, 0, 1, 0};
		int n2=6;
		int c2[] = {0, 0, 0, 1, 0, 0};

		
		int result = jumpingOnClouds(c);
		
		System.out.println("Min No. of Jumping are: " + result);
	}

	static int jumpingOnClouds(int[] c) {
		int jump = 0;
		int n = c.length;
		for(int i=0; i<n-1; i++)
		{
			if((i+2)<n && c[i+2]==0) i++;
			jump++;
		}
		return jump;
    }
}
