package hackerrank.dst.queue;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Queue<T> extends ArrayList<T>
{
	private static final long serialVersionUID = 1L;
	private int front; 

	public Queue()
	{
		front = 0;
	}
	
	public Queue(T[] arr)
	{
		this();
		for(T obj: arr)
			enqueue(obj);
	}

	public void enqueue(T obj)
	{
		add(obj);
	}

	public T dequeue()
	{ 
		T obj = peekFront(); 
		remove(front);
		return obj;
	}

	public T peekFront()
	{
		return get(front);
	}
		
	public void view()
	{
		System.out.println("[" + this.stream().map(Object::toString).collect(Collectors.joining(" ")) + "]");
	}
}
