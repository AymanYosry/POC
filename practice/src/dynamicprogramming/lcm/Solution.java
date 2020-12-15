/**
 * 
 */
package dynamicprogramming.lcm;

/**
 * @author Ayman Yosry
 * Longest Common Sequence Algorithm
 * @link https://www.youtube.com/watch?v=sSno9rV8Rhg
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String str1 = "longest";
		String str2 = "stone";
		
		System.out.println(logestSequence(str1, str2));
	}

	private static String logestSequence(String str1, String str2)
	{
		int n = str1.length();
		int m = str2.length();
		int LCS[][] = new int[n+1][m+1];
		
		int i,ii,j,jj;
		String common ="";
		int pj = Integer.MIN_VALUE;
		for(i=1; i<=n; i++)
		{
			for(j=1; j<=m; j++)
			{
				ii = i-1;
				jj = j-1;
				
				if(str1.charAt(ii) == str2.charAt(jj))
				{
					LCS[i][j] = 1 + LCS[i-1][j-1];
					//the below condition to detect the chosen character
					if(j > pj)
					{
						common += str1.charAt(ii) +"";
						pj = j;
					}
				}
				else
				{
					LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
				}
			}
		}
		        
		System.out.println(LCS[n][m] + " " + common);
		
		return "";
	}
}
