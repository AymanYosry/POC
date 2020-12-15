/**
 * 
 */
package hackerrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


/**
 * @author Ayman Yosry
 *
 */
public class Solution
{

	public static void main(String[] args) throws IOException
	{
		TestCase test = readTestCase("001");
		print2DArray(test.arrInt2D);
		printArray(test.arrInt);
		System.out.println(solution(test.arrInt2D));
	}
	
	
	private static char[] solution(int[][] arr)
	{
		// TODO Auto-generated method stub
		return null;
	}

	//read 1d arr int
	public static TestCase readTestCase(String problem, String testCaseNo) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/" + problem + "/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);
		input.n = Integer.valueOf(sampleInput[0]);
		input.arrInt = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		return input;
	}
	
	//read 2d arr int
	private static TestCase readTestCase(String testCaseNo, int...ints) throws IOException
	{
		TestCase input = new TestCase();

		String sampleInput[] = Files.lines(Paths.get("files/maxtoys/input" + testCaseNo + ".txt"))
				.toArray(String[]::new);

		int arr[] = new int[input.n];
		int j = 0;
		for(int i = 0; i < input.n; i++)
		{
			arr = Stream.of(sampleInput[1].split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int num : arr)
			{
				input.arrInt2D[i][j++] = num;
			}
		}
		return input;
	}
	
	public static void printArray(int[] arr)
	{
		String printStatment = "";
		for (int a : arr)
			printStatment += (a + ", ");
		printStatment = printStatment.substring(0, printStatment.lastIndexOf(","));
		System.out.println("[" + printStatment + "]");
	}
	
	public static void print2DArray(int arr[][])
	{
		System.out.println("------");
		for (int rec[] : arr)
		{
			System.out.println(rec[0] + " " + rec[1]);
		}
		System.out.println("------");
	}
	
	private static int [][] convertNestedListTo2DArray(List<List<Integer>> list)
	{
//		Integer arrObj[][] = list.stream().map(row -> row.stream().toArray(Integer[]::new))
//			    .toArray(Integer[][]::new);
//		int i, j,arr[][];
//		for(Integer row: arrObj)
//		{
//			
//		}
		int n = list.size();
		int arr[][] = new int[n][];
		int i = 0, j = 0;
		for (List<Integer> nestedList : list)
			for(Integer num : nestedList)
				arr[i++][j++] = num.intValue();
		return arr;
	}
}
