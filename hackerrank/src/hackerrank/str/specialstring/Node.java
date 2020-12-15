package hackerrank.str.specialstring;

public class Node
{
	private int previous = 0;
	private int next = 0;
	private String data;
	public Node(String data)
	{
		this.data = data;
	}
	@Override
	public String toString()
	{
		return "\nNode [previous=" + previous + ", next=" + next + ", data=" + data + "]";
	}
	public Node(int previous, int next, String data)
	{
		super();
		this.previous = previous;
		this.next = next;
		this.data = data;
	}
	public int getPrevious()
	{
		return previous;
	}
	public void setPrevious(int previous)
	{
		this.previous = previous;
	}
	public int getNext()
	{
		return next;
	}
	public void setNext(int next)
	{
		this.next = next;
	}
	public String getData()
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
	
	
}
