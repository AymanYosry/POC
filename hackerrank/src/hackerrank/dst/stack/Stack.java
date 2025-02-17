package hackerrank.dst.stack;

import java.util.ArrayList;
import java.util.stream.Collectors;

class Stack<T> extends ArrayList<T>
{
	private static final long serialVersionUID = 1L;
	private int top;

	public Stack()
	{
		top = -1;
	}
	
	public Stack(T[] arr)
	{
		this();
		for(T obj: arr)
			push(obj);
	}


	public void push(T obj)
	{
		top++;
		add(obj);
	}

	public T pop()
	{
		T obj = peak();
		remove(top);
		top--;
		return obj;
	}

	public T peak()
	{
		return get(top);
	}
	
	public void view()
	{
		System.out.println("[" + this.stream().map(Object::toString).collect(Collectors.joining(" ")) + "]");
	}
}