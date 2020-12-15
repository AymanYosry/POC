package test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GFG
{
	public static void main(String[] args)
	{

		// Create a String with repeated keys
		Stream<String[]> str = Stream
				.of(new String[][] { { "GFG", "GeeksForGeeks" }, { "g", "geeks" }, { "GFG", "geeksforgeeks" } });

		// Get Map from String
		// using toMap() method
		Map<String, String> map = str.collect(
				Collectors.toMap(p -> p[0], p -> p[1], 
						 		 (s, a) -> s + ", " + a));
		
		//below code get error for duplicate keys
//		 Map<String, String> map2 = str.collect( 
//				 Collectors.toMap(p -> p[0], p -> p[1])); 

		// Print the Map
		System.out.println("Map:" + map);
	}
}