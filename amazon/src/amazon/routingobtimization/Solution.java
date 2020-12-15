/**
 * 
 */
package amazon.routingobtimization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayman Yosry
 *
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Example 1
		List<List<Integer>> forwardRoutes1 = new ArrayList<>();
		List<List<Integer>> returnRoutes1 = new ArrayList<>();
		
		List<Integer> rout = new ArrayList<Integer>();
		rout.add(1);
		rout.add(2000);
		forwardRoutes1.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(2);
		rout.add(4000);
		forwardRoutes1.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(3);
		rout.add(6000);
		forwardRoutes1.add(rout);
		
		rout = new ArrayList<Integer>();
		rout.add(1);
		rout.add(2000);
		returnRoutes1.add(rout);

		//Example 2
		List<List<Integer>> forwardRoutes2 = new ArrayList<>();
		List<List<Integer>> returnRoutes2 = new ArrayList<>();

		rout = new ArrayList<Integer>();
		rout.add(1);
		rout.add(3000);
		forwardRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(2);
		rout.add(5000);
		forwardRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(3);
		rout.add(7000);
		forwardRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(4);
		rout.add(10000);
		forwardRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(1);
		rout.add(2000);
		returnRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(2);
		rout.add(3000);
		returnRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(3);
		rout.add(4000);
		returnRoutes2.add(rout);

		rout = new ArrayList<Integer>();
		rout.add(4);
		rout.add(5000);
		returnRoutes2.add(rout);

		///////////////////////////
//		List<List<Integer>> result = optimizeAircraftRoutes(10000, forwardRoutes2, returnRoutes2);
		List<List<Integer>> result = optimizeAircraftRoutes(7000, forwardRoutes1, returnRoutes1);
		for (List<Integer> list : result)
		{
			System.out.println(list.get(0) + ", " + list.get(1));
		}

	}

	private static List<List<Integer>> optimizeAircraftRoutes(int maxTravelDistance, List<List<Integer>> forwardRoutes,
			List<List<Integer>> returnRoutes)
	{
		List<List<Integer>> allResult = new ArrayList<List<Integer>>();
		List<Integer> result = null;
		int prev = 1, curr;
		for (List<Integer> froute : forwardRoutes)
		{
			for (List<Integer> rroute : returnRoutes)
			{
				result = new ArrayList<Integer>();
				curr = froute.get(1) + rroute.get(1);
				if (curr > maxTravelDistance) continue;
				if (curr == maxTravelDistance) prev--;
				if (curr < maxTravelDistance && prev > 0 && curr > prev) prev = curr;

				if (curr == maxTravelDistance || prev == curr)
				{
					if (prev >=0) 
						allResult.removeAll(allResult);

					result.add(froute.get(0));
					result.add(rroute.get(0));
					allResult.add(result);
					if (prev == curr) prev = 1;
				}
			}
		}
		// forwardRoutes.stream().map(fr -> returnRoutes.stream().map(rr ->
		// fr.get(1)+rr.get(1))).filter(k-> k<10).count();//mapToInt(Integer);
		return allResult;
	}
}
