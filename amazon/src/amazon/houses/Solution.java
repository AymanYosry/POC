package amazon.houses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int in[] = { 1, 0, 0, 0, 0, 1, 0, 0 };
		int in[] = { 1, 1, 1, 0, 1, 1, 1, 1 };
		for (Integer n : cellCompete(in, 2)) {
			System.out.println(n);
		}
	}

	public static List<Integer> cellCompete(int[] states, int days) {
		// WRITE YOUR CODE HERE
		List<Integer> currentState = new ArrayList<Integer>();
		int temp[] = states; // new int[states.length];
		for (int i = 0; i < days; i++) {
			currentState = new ArrayList<Integer>();
			for (int j = 0; j < states.length; j++) {
				if (j == 0) 
					currentState.add(temp[j + 1]);
				else if (j == states.length - 1) 
					currentState.add(temp[j - 1]);
				else 
					currentState.add((temp[j - 1] + temp[j + 1]) % 2);
			}
			temp = currentState.stream().mapToInt(k->k).toArray();					
		}
		return currentState;
	}
}
