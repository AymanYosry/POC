package hackerrank.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly
 * swapping the adjacent elements if they are in wrong order.
 * 
 */
class BubbleSort
{
	static int timeComplexity = 0;
	static int timeComplexityRecursive = 0;

	static void sort(int arr[])
	{
		int n = arr.length;
		int temp;
		boolean swapped;
		int i, j;
		for (i = 0; i < n; i++)
		{
			swapped = false;
			for (j = i + 1; j < n; j++)
			{
				if (arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
				timeComplexity++;
			}
			// IF no two elements were
			// swapped by inner loop, then break
			if (swapped == false) break;
		}
	}
	
	/**
	 * Recursive Sort
	 * @param arr
	 * @param n
	 */
	static void sort(int arr[], int n)
	{
		// Base case 
        if (n == 1) 
            return; 
       
        // One pass of bubble sort. After 
        // this pass, the largest element 
        // is moved (or bubbled) to end. 
        for (int i=0; i<n-1; i++) 
        {
        	if (arr[i] > arr[i+1]) 
            { 
                // swap arr[i], arr[i+1] 
                int temp = arr[i]; 
                arr[i] = arr[i+1]; 
                arr[i+1] = temp; 
            }
        	timeComplexityRecursive++;
        }
        // Largest element is fixed, 
        // recur for remaining array 
        sort(arr, n-1); 
	}
}