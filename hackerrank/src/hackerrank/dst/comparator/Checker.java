package hackerrank.dst.comparator;

import java.util.Comparator;

/**
 * @author Ayman Yosry
 *
 */
class Checker implements Comparator<Player>
{
	@Override
	public int compare(Player o1, Player o2)
	{
		int compareValue;
		Integer score1 = Integer.valueOf(o1.score);
		Integer score2 = Integer.valueOf(o2.score);
		compareValue = score2.compareTo(score1);
		if(o1.score == o2.score)
			compareValue += o1.name.compareTo(o2.name);
		return compareValue;
	}
}
