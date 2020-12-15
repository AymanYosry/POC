/**
 * 
 */
package amazon.prediction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ayosry
 *
 */
public class Solution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		List<String> repository = new ArrayList<String>();
		repository.add("bags");
		repository.add("baggage");
		repository.add("banner");
		repository.add("box");
		repository.add("cloths");
		
		String customerQuery = "bags";
//		System.out.println(customerQuery.substring(3,4));
		List<List<String>> result = threeProductSuggestions(5,repository, customerQuery);
		for (List<String> list : result)
		{
			System.out.println();
			for (String s : list)
			{
				System.out.print(s + ", ");
			}

			
		}
	}
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<String> > threeProductSuggestions(int numProducts, 
                                                List<String> repository, 
                                                String customerQuery)
    {
    	Collections.sort(repository);
    	int n=1;
    	String temp="";
    	String ch[] = new String[customerQuery.length()];//customerQuery.toCharArray();
    	List<List<String>> allResult = new ArrayList<List<String>>();
		List<String> result = new ArrayList<String>();
		for(int i=0;i<ch.length;i++)
    	{
    		ch[i]=customerQuery.substring(i, i+1);
    	}
    	temp += ch[0];
    	for(int j=1 ;j<ch.length ; j++)
    	{
    		result = new ArrayList<String>();
    		n=1;
    		temp += ch[j];
    		for(String product: repository)
    		{
    			if(product.startsWith(temp)) 
    			{
    				if(n>3) break;
    				result.add(product);
    				n++;
    			}
    		}
    		allResult.add(result);
    	}
		return allResult;
    }
}
