package hackerrank.dyp.lcs.ransomnote;

/**
 * 
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String magazine = "This is Ayman code to test LCM in Java";
		String ronsom = "Ayman code test LCM";
		System.out.println(isMagazineReplica(magazine, ronsom)?"YES":"NO");
	}

	private static boolean isMagazineReplica(String magazine, String note)
	{
		String regex = "[ ]"; 
		String magazineWords[] = magazine.split(regex); 
		String noteWords[] = note.split(regex);
		int m = magazineWords.length;		
		int n = noteWords.length;
		int i, j;
		
		int LCS[][] = new int[m+1][n+1];
		
		for (i = 1; i <= m; i++)
		{
			for (j = 1; j <= n; j++)
			{
				if (magazineWords[i - 1].equals(noteWords[j - 1]))
				{
					LCS[i][j] = 1 + LCS[i - 1][j - 1];
				}
				else
				{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		return (LCS[m][n] == n);
	}
}
