package hackerrank.arr.arraymanipulation;

/**
 * @author Ayman Yosry
 *
 */
class TestCase
{
	// n -> array size
	private int n;
	public int getN()
	{
		return n;
	}

	// m -> number of queries 
	private int m;
	
	public int getM()
	{
		return m;
	}

	private int[][] Q;

	public void setN(int n)
	{
		this.n = n;
	}

	public void setM(int m)
	{
		this.m = m;
	}

	public int[][] getQ()
	{
		return Q;
	}

	public void setQ(int i, int[] query)
	{
		if (Q == null) Q = new int[m][3];
		Q[i] = query;
	}
}
