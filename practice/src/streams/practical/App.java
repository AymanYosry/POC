package streams.practical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App
{
	static int i = 0;

	public static void main(String[] args) throws IOException
	{
		System.out.println("==============IntStream================");
		IntStream.range(1, 10) // Source
				.forEach((x) -> System.out.print(x)); // Terminal Operation
		System.out.println();
		System.out.println("===============IntStream with Skip===============");

		// IntStream with Skip
		IntStream.range(1, 10) // Source
				.skip(5) // Intermediate Operation (returns stream)
				.forEach((x) -> System.out.print(x)); // Terminal Operation
		System.out.println();

		System.out.println("===============IntStream with Sum===============");
		// IntStream with Sum
		int val = IntStream.range(1, 5) // Source
				.sum(); // Terminal Operation //0+1+2+3+4
		System.out.println(val);

		System.out.println("===============Stream.of, sorted, and findFirst===============");
		// Stream.of, sorted, and findFirst
		Stream.of("Hello", "bottle", "Africa") // Source
				.sorted() // Intermediate Operation
				.findFirst() // Terminal Operation
				.ifPresent((x) -> System.out.println(x));

		System.out.println("===============Stream from Array, sort, and print===============");
		// Stream from Array, sort, and print
		String items[] = { "car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy" };
		Stream.of(items) // Source
				.filter((x) -> x.startsWith("t")) // Intermediate Operation
				.sorted() // Intermediate Operation
				.forEach((x) -> System.out.print(x + ", ")); // Terminal
																// Operation;

		System.out.println("\n===============Average of squares of an int array===============");
		// Average of squares of an int array
		int arr[] = { 2, 4, 6, 8, 10 };
		Arrays.stream(arr).map((x) -> x * x).average().ifPresent(n -> System.out.print(n));

		System.out.println("\n===============Stream from List, map, filter, sort and print===============");
		// Stream from Array, sort, and print
		List<String> listOdfItems = Arrays.asList("Car", "Computer", "Toothpaste", "Box", "Pencil", "Tent", "Door",
				"Toy");
		listOdfItems.stream() // Source
				.map(s -> s.toLowerCase()).filter(s -> s.startsWith("t")) // Intermediate
																			// Operation
				.sorted() // Intermediate Operation
				.forEach(s -> System.out.print(s + ", ")); // Terminal
															// Operation;

		System.out.println("\n==============Stream read File 1================");
		Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
		lines.sorted().filter(line -> line.length() > 6).forEach(line -> {
			i++;
			System.out.println(i + ")" + line);
		});
		lines.close();

		System.out.println("==============Stream read File 2================");
		List<String> words = Files.lines(Paths.get("files/wordFile.txt")).filter(word -> word.contains("th"))
				.collect(Collectors.toList());
		words.forEach(word -> System.out.println(word));

		System.out.println("==============Stream read File 3================");
		int rowCount = (int) Files.lines(Paths.get("files/stockDataCsv.txt")).map(data -> data.split(","))
				.filter(dataArr -> dataArr.length > 3).count();
		System.out.println(rowCount + " good rows.");

		System.out.println("==============Stream read File 4================");
		Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
		rows.map(row -> row.split(",")).filter(rowArr -> rowArr.length > 3)
				.filter(rowArr -> Integer.parseInt(rowArr[1].trim()) > 15).forEach(rowArr -> System.out
						.println(rowArr[0].trim() + " " + rowArr[2].trim() + " " + rowArr[3].trim()));
		rows.close();

		System.out.println("============== TreeSet ================");
		String log = "0:Civic\n" + "1:Accord\n" + "2:Land Cruiser\n" + "3:Corolla\n" + "4:Wrangler\n" + "5:Camry\n"
				+ "6:Sentra\n" + "7:Lancer";
		String logSeparator = "\\r?\\n";
		String logLines[] = log.split(logSeparator);

		 Set<String> test = new TreeSet<String>(new Comparator<String>()
		 {
		 @Override
		 public int compare(String o1, String o2)
		 {
		 return o1.substring(2).compareTo(o2.substring(2));
		 }
		
		 });

		Stream.of(logLines).collect(Collectors.toSet()).forEach(e -> test.add(e));;

		//StringArray test = new StringArray();

//		test.add("0:Civic");
//		test.add("1:Accord");
//		test.add("2:Land Cruiser");
//		test.add("3:Corolla");
//		test.add("4:Wrangler");
//		test.add("5:Camry");
//		test.add("6:Sentra");
//		test.add("7:Lancer");
		System.out.println(test);
		// System.out.println(test2);

		String arr1[] = new String[test.size()];

		test.forEach(r -> {
			String rArr[] = r.split(":");
			arr1[Integer.parseInt(rArr[0])] = rArr[1];
		});
		Stream.of(arr1).forEach(r -> System.out.println(r));
		Integer i = Integer.valueOf(7);
		System.out.println(++i);
	}

}

class StringArray extends TreeSet<String>// implements Comparator<String>
{
	private static final long serialVersionUID = 1L;

	// @Override
	// public int compare(String s1, String s2)
	// {
	// return s1.substring(1).compareTo(s2.substring(1));
	// }

	public StringArray()
	{
		super(new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return o1.substring(2).compareTo(o2.substring(2));
			}
		});

	}

	
	// public static <T, R> Supplier<R> bind(Function<String,StringArray> fn, T
	// val) {
	// return () -> fn.apply(val);
	// }

}