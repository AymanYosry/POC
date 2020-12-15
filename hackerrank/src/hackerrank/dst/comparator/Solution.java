package hackerrank.dst.comparator;

import java.util.Arrays;

/**
 * @author Ayman Yosry
 * https://www.hackerrank.com/challenges/java-comparator/problem
 *
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int n = 5;
		Player[] player = new Player[n];
        Checker checker = new Checker();
        
        player[0] = new Player("amy", 100);
        player[1] = new Player("david", 100);
        player[2] = new Player("heraldo", 50);
        player[3] = new Player("aakansha", 75);
        player[4] = new Player("aleksa", 150);
        
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++)
            System.out.printf("%s %s\n", player[i].name, player[i].score);
	}
}
