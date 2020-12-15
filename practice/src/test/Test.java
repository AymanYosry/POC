package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test
{
	private static char getUpperCase(char c)
	{
		return (char) (c - 32);
	}

	public static void main(String[] args)
	{
		TreeSet<Integer> arr = new TreeSet<>();

		arr.add(2);
		arr.add(7);
		arr.add(5);
		arr.add(1);
		arr.add(3);
		arr.add(1);
		arr.forEach(e -> System.out.println(e));

		System.out.println(arr.size() - arr.headSet(5, true).size());

	}

	public static void main1(String[] args)
	{
		StringBuilder s = new StringBuilder("test");
		s.append('A');
		System.out.println(s.toString());
		System.out.println(s.deleteCharAt(s.length() - 1).toString());

		System.out.println((getUpperCase('a') == 65));
		// A < AA
		// AAz < Az
		System.out.println("AAz".compareTo("Az"));
		System.out.println("".substring(2));
	}

	public static void main2(String[] args)
	{
		// System.out.println(Long.toString((3*10000+8*1000+9*100+7*10+6*1),
		// 10));
		// System.out.println(Long.parseLong(
		// Long.toBinaryString(3)+
		// Long.toBinaryString(8)+
		// Long.toBinaryString(9)+
		// Long.toBinaryString(7)+
		// Long.toBinaryString(6),2)>>8);
		// System.out.println(76389F/452F);
		char a = 'a';

		int c1 = '{';
		int c2 = '}';
		System.out.println(c1 + " " + c2);

		int c11 = '(';
		int c22 = ')';
		System.out.println(c11 + " " + c22);

		int c111 = '[';
		int c222 = ']';
		System.out.println(c111 + " " + c222);

		int c1111 = '<';
		int c2222 = '>';
		System.out.println(c1111 + " " + c2222);

		List<String> fruits = Arrays.asList("apple", "mango", "pomo", "banana", "orange", "apple");
		Map<String, String> collectedFruits = fruits.stream().collect(Collectors.toMap(eachFruit -> eachFruit, // KeyMapper
				eachFruit -> eachFruit + "m", // Value Mapper
				(first, second) -> first, LinkedHashMap::new)); // LinkedHashMap
		collectedFruits.forEach((key, value) -> {
			System.out.println("(" + key + "," + value + ")");
		});
		// , //Merge function
		// LinkedHashMap::new

		List<Integer> al = new ArrayList<>();
		al.add(3);
		al.add(2);
		al.add(1);
		al.add(4);
		al.add(5);
		al.add(6);
		al.add(6);
		al.forEach(e -> System.out.println(e));
		System.out.println();
		Set<Integer> s = new LinkedHashSet<>();
		s.add(3);
		s.add(2);
		s.add(1);
		s.add(4);
		s.add(5);
		s.add(6);
		s.add(6);
		s.add(5);
		s.forEach(e -> System.out.println(e));

		System.out.println();

		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>()
		{

			@Override
			public int compare(Integer o1, Integer o2)
			{
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});
		ts.add(3);
		ts.add(2);
		ts.add(1);
		ts.add(4);
		ts.add(5);
		ts.add(6);
		ts.add(6);
		ts.forEach(e -> System.out.println(e));

		Set<String> test = new TreeSet<String>(new Comparator<String>()
		{
			@Override
			public int compare(String o1, String o2)
			{
				return o1.substring(2).compareTo(o2.substring(2));
			}

		});
		test.add("0:Civic");
		test.add("1:Accord");
		test.add("2:Land Cruiser");
		test.add("3:Corolla");
		test.add("4:Wrangler");
		test.add("5:Camry");
		test.add("6:Sentra");
		test.add("7:Lancer");
		System.out.println(test);

		String arr[] = new String[test.size()];

		test.forEach(r -> {
			String rArr[] = r.split(":");
			arr[Integer.parseInt(rArr[0])] = rArr[1];
		});
		Stream.of(arr).forEach(r -> System.out.println(r));
		// System.out.println(Stream.of(test).sorted());

		String str = "Lorem adipising ipsum dolor sit Lorem amet Consectetur adipising elit Lorem ipsum dolor";

		List<String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
				.collect(Collectors.toList());

		Map<String, Integer> wordCounter = list.stream()
				.collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

		System.out.println(wordCounter);

		String ss[][] = { { "1", "a" }, { "2", "b" }, { "3", "c" } };
		// new ArrayList<String>(4);
		// ss.add(2, "t2");
		// ss.add(0, "t0");
		// ss.add(3, "t3");
		// ss.add(1, "t1");
		List ll = Stream.of(ss).map(r -> r[0] + r[1]).collect(Collectors.toList());

		System.out.println(ll);

		String sss = "asdf";
		String aaa[] = sss.split("(?!^)");
		for (String c : aaa)
			System.out.println(c);

		String t = "AbCd";
		StringBuffer tb = new StringBuffer(t);
		tb.delete(3, 4);
		System.out.println(tb.toString());
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

}