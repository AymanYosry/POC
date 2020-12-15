package codility.interview00.seatallocation;

public class Solution 
{
	public static void main(String[] args) 
	{
		System.out.print(solution(2, "1A 2F 1C"));
	}

	public static int solution(int N, String S) 
	{
		boolean first[] = new boolean [N];
		boolean second[] = new boolean [N];
		boolean third[] = new boolean [N];

		String seats[] = S.split(" ");
		//for(boolean b : first)System.out.print(b);
		int n=0;
		for (String s: seats)
		{
			n = Integer.parseInt(s.replaceAll("[^0-9]", "").trim());
			if(s.endsWith("A")||s.endsWith("B")||s.endsWith("C")) 
			{
				first[n-1]=true;
			}
			if(s.endsWith("E")||s.endsWith("F")) 
			{
				second[n-1]=true;
			}
			if(s.endsWith("H")||s.endsWith("J")||s.endsWith("K")) 
			{
				third[n-1]=true;
			}
		}

		int max = count(first) + count(second) + count(third);
		return max;
	}
	
	private static int count(boolean[] bArr) 
	{
		int counter=0;
		for(boolean b:bArr) if(!b) counter++;
		return counter;
	}
}