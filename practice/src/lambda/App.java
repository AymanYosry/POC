package lambda;

public class App
{

	public static void main(String[] args)
	{
		Human tom = new Human();
		tom.walk();

		Robot wale = new Robot();
		wale.walk();

		walker(() -> System.out.println("Custom Object Walking ..."));

		walker(() -> {
			System.out.println("--------------------------------");
			System.out.println("Custom Object Walking ...");
			System.out.println("the object tripped ...");
		});

		Walkable alockOfCode = () -> {
			System.out.println("--------------------------------");
			System.out.println("Custom Object Walking ...");
			System.out.println("the object tripped ...");
		};

		walker(alockOfCode);

		ALambdaInterface helloVar = () -> System.out.println("Hello There");
		Calculate sumVar = (a, b) -> a + b;
		
		//void method
		helloVar.someMethod(); 
		
		System.out.println(sumVar.compute(4, 5));
		
		Calculate nonZeroDivid = (a, b) -> 
		{
			if(a ==0) return 0;
			return a/b;
		};
		
		System.out.println(nonZeroDivid.compute(10, 5));

		MyGenericInteface<String> reverser = (s) -> 
		{
			String result = "";
			for(int i = s.length()-1; i>=0; i--)
				result +=s.charAt(i);
			return result;
		};
		
		System.out.println(reverser.work("Vehicle"));

		MyGenericInteface<Integer> computedNumber = (n) ->
		{
			int result =1;
			for(int i=1; i<=n; i++)
				result*=i;
			return result;
		};
		
		System.out.println(computedNumber.work(10));
	}

	public static void walker(Walkable w)
	{
		w.walk();
	}
}

interface Calculate
{
	int compute(int arg1, int arg2);
}
/*
interface NumberWorker
{
	int compute(int arg1);
}

interface StringWorker
{
	String work(String str);
}
*/

interface MyGenericInteface<T>
{
	T work(T t);
}