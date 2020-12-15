package hackerrank.grd.burgerorders;

import java.util.Comparator;

/**
 * @author Ayman Yosry
 *
 */
class Checker implements Comparator<int[]>
{
	@Override
	public int compare(int[] o1, int[] o2)
	{
		int compare = 1;
		if (o1[1] == 1 && o2[1] == 1)
		{
			compare = Integer.compare(o2[0], o1[0]); 
		}
		else 
		{	
			if(o1[1] == 0) compare = -1;
			if(o2[1] == 0) compare = 1;
		}
			
		return compare;
	}
}
