package hackerrank.arr.arrayandsimplequeries;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/array-and-simple-queries/problem
 */
public class Solution
{
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
//		organaizedMain();
		optimizedMain();
	}

	private static void optimizedMain() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n , m:");
		int nm[] = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.mapToInt(Integer::parseInt).toArray();
		int n = nm[0];
		int m = nm[1];

		System.out.println("Enter values of A:");
		int A[] = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.mapToInt(Integer::parseInt).toArray();

		System.out.println("Enter values of Q:");
		int[][] Q = new int[m][3];
		for (int i = 0; i < n; i++)
		{	
			Q[i] = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
					.mapToInt(Integer::parseInt).toArray();
			if (Q[i][0] == 1) A = moveFront(Q[i], A);
			else A = moveEnd(Q[i], A);
			// printArray(query);
			 printArray(A);
		}
		bufferedReader.close();
	}

	private static void organaizedMain()
	{
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));
/*
		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		int arr[] = new int[n];
		int[][] queries = new int[m][3];

		arr = read1DArray(n);
		queries = read2DArray(m, 3);
*/
		 int A[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// int A2[]= {2,3,4,1,5,6,7,8};

		 int Q[][] = { { 1, 2, 4 }, { 2, 3, 5 }, { 1, 4, 7 }, { 2, 1, 4 } };
		// int Q[][] = {{2,3,5}};

		//applyQueries(queries, arr);
		applyQueries(Q, A);

	}

	private static void applyQueries(int[][] Q, int[] A)
	{
		// printArray(A);
		// System.out.println("____________________");

		for (int query[] : Q)
		{
			if (query[0] == 1) A = moveFront(query, A);
			else A = moveEnd(query, A);
			// printArray(query);
			 printArray(A);
			// System.out.println("''''''''''''''''''''");
		}
		System.out.println(Math.abs(A[0] - A[A.length - 1]));
		printArray(A);
	}

	private static int[] moveFront(int[] query, int[] A)
	{
		int start = query[1] - 1, end = query[2] - 1;
		int replace[] = Arrays.copyOfRange(A, start, end + 1);
		int original[] = Arrays.copyOfRange(A, 0, start);
		for (int i = 0; i < replace.length; i++)
		{
			A[i] = replace[i];
			if (i < original.length) A[replace.length + i] = original[i];
		}
		return A;
	}

//	private static int[] applyQuery11(int[] query, int[] A)
//	{
//		int x = 0, y = A.length - 1, n = 0;
//		int start = query[1] - 1, end = query[2];
//		// int start = query[1] - 1, end = query[2] - 1;
//		int replace[] = Arrays.copyOfRange(A, start, end + 1);
//		// int original[] = Arrays.copyOfRange(A, 0, start);
//		for (int i = A.length - 1; i >= 0; i++)
//		{
//			if (start <= i && i < end)
//			{
//				replace[x++] = A[i];
//			}
//			else
//			{
//				A[y++] = A[i];
//			}
//			A[i] = replace[i];
//			if (i < original.length) A[replace.length + i] = original[i];
//		}
//		return A;
//	}

	private static int[] moveEnd(int[] query, int[] A)
	{
		int n = query[2] - query[1];
		int temp[] = new int[n + 1];

		for (int i = 0; i <= n; i++)
		{
			temp[i] = A[query[2] + i];
			A[query[2] + i] = A[query[1] - 1 + i];
			A[query[1] - 1 + i] = temp[i];
		}
		return A;
	}

	private static int[] read1DArray(int n)
	{
		int arr1D[] = new int[n];
		String[] arItems = scanner.nextLine().split(" ");
		for (int i = 0; i < n; i++)
		{
			int arItem = Integer.parseInt(arItems[i].trim());
			arr1D[i] = arItem;
		}
		return arr1D;
	}

	private static int[][] read2DArray1(int n, int m)
	{
		int[][] arr2D = new int[n][m];
		for (int i = 0; i < n; i++)
		{
			String[] rowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < m; j++)
			{
				int rowItem = Integer.parseInt(rowItems[j].trim());
				arr2D[i][j] = rowItem;
			}
		}
		return arr2D;
	}
	private static int[][] read2DArray2(int n, int m) throws IOException 
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr2D = new int[n][m];
        for (int i = 0; i < n; i++)
        {
            int[] rowItems = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++)
            {
               arr2D[i][j] = rowItems[j];
            }
        }
        bufferedReader.close();
        return arr2D;
    }
	
	private static List<List<Integer>> read2DArray (int... dim) throws IOException
	{
		int n = dim[0];
		int m = dim[1];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        IntStream.range(0, n).forEach(i -> 
        {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

		return arr;
	}

	private static void printArray(int[] arr)
	{
		for (int num : arr)
		{
			System.out.print(num + " ");
		}
		System.out.print("\n");
	}
}
