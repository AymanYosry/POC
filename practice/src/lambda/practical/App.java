package lambda.practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class App
{

	public static void main(String[] args)
	{
		List<Car> cars = Arrays.asList(
				new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700), 
				new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200), 
				new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300), 
				new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500));
		
//		printCarsPriceRange(cars, 18000, 22000);
//		printCarsByColor(cars, "Red");
		
//		printCars(cars, new CarCondition()
//		{
//			@Override
//			public boolean test(Car c)
//			{
//				return (18000 <= c.getPrice() && 22000 >= c.getPrice());
//			}
//		});
		
		System.out.println("Printing caras between 18000 and 22000");
		printCars(cars, (c) -> 18000 <= c.getPrice() && 22000 >= c.getPrice());
		System.out.println("Print blue cars");
		printCars(cars, (c) -> c.getColor().equals("Blue"));
	}

	public static void printCars(List<Car> cars, Predicate<Car> condition)
	{
		for (Car c : cars)
			if (condition.test(c)) c.printCar();

	}
//	
//	public static void printCarsPriceRange(List<Car> cars, int low, int high)
//	{
//		for (Car c : cars)
//			if (low <= c.getPrice() && high >= c.getPrice()) c.printCar();
//	}
//
//	public static void printCarsByColor(List<Car> cars, String color)
//	{
//		for (Car c : cars)
//			if (c.getColor().equals(color)) c.printCar();
//	}
}

//@FunctionalInterface
//interface Condition<T>
//{
//	boolean test(T t);
//}
