package hackerrank.grd.burgerorders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author Ayman Yosry 
 * 26/01/2020
 * https://www.hackerrank.com/challenges/jim-and-the-orders/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class Solution
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		TestCase tst = readTestCase("003");
		print2DArray(tst.arr);
		printArray(jimOrders(tst.arr, tst.n));
	}

	private static int[] jimOrders(int[][] orders, int n)
	{
		int serveTime[] = new int[n];
		int delivery[] = new int[n];
		int x;
		int i, j, k;
		// Insertion Sort Algorithm + Binary Search Algorithm
		for (i = 0; i < n; i++)
		{
			x = orders[i][0] + orders[i][1];

			/*
			 * binary search to find position of x for insertion 
			 * shift array right from that position
			 */

			k = Math.abs(Arrays.binarySearch(serveTime, 0, i, x) + 1);
			j = i;
			// Shifting array to one location right
			while (j > k)
			{
				delivery[j] = delivery[j - 1];
				serveTime[j] = serveTime[--j];
			}
			serveTime[k] = x;
			delivery[k] = i + 1;
		}

		return delivery;
	}

	private static TestCase readTestCase(String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/burgers/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.n = Integer.valueOf(sampleInput[0]);
		int arr[][] = new int[input.n][2];

		String record[];
		for (int i = 0; i < input.n; i++)
		{
			record = sampleInput[i + 1].split(" ");
			arr[i][0] = Integer.valueOf(record[0]);
			arr[i][1] = Integer.valueOf(record[1]);
		}
		input.arr = arr;

		return input;
	}

	private static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}

	private static void print2DArray(int arr[][])
	{
		System.out.println("------");
		for (int rec[] : arr)
		{
			System.out.println(rec[0] + " " + rec[1]);
		}
		System.out.println("------");
	}

}
