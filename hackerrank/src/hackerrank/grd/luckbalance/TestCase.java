/**
 * 
 */
package hackerrank.grd.luckbalance;

/**
 * @author Ayman Yosry
 *
 */
class TestCase
{
	int n; // number of contests
	int k; // number of important contests
	int[][] contests;

	public void setContests(int i, int[] contest)
	{
		if (contests == null) contests = new int[n][2];
		contests[i] = contest;
	}
}
