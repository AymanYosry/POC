package hackerrank.arr.leftrotation;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/array-left-rotation/problem
 */
public class Solution 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Scanner in = new Scanner(System.in);
        int n = 5;//in.nextInt();
        int k = 2;//in.nextInt();
        int a[] = {1,2,3,4,5};//new int[n];
        //a[] = {};
//        for(int a_i=0; a_i < n; a_i++)
//        {
//            a[a_i] = in.nextInt();
//        }
        for(int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
	}
	
	public static int[] arrayRightRotation(int[] a, int n, int k) 
	{
		int output[] = new int[n];
		for (int i = 0; i<n; i++)
		{
			if(i+k<n)
			{
				output[i+k] = a[i];
			}
			else
			{
				output[i+k-n] = a[i];
			}
		}
		return output;  
    }
	
	public static int[] arrayLeftRotation(int[] a, int n, int k) 
	{
		int output[] = new int[n], index=0;
		
		for (int i = 0; i<n; i++)
		{
			index = i-k;
			if(index>=0)
			{
				output[index] = a[i];
			}
			else
			{
				output[n+index] = a[i];
			}
		}
		return output;  
    }
}
