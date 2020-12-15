package hackerrank.str.specialstring;

import java.util.ArrayList;

/**
 * @author Ayman Yosry
 *
 */
public class LinkedList extends ArrayList<Node>
{
	private static final long serialVersionUID = 1L;
	private int index = 0;
	
	public boolean add(Node data)
	{
		data.setPrevious(index-1);
		data.setNext(index + 1);
		index++;
		return super.add(data);
	}
	
	public boolean add(Node data, int next, int previous)
	{
		data.setPrevious(previous);
		data.setNext(next);
		index++;
		for(int i= 1; i < next - previous ; i++)
		{
			delete(i);
		}
		return super.add(data);
	}

	public boolean delete(int i)
	{
		index--;
		Node o = get(i);
		return remove(o);
	}

	public boolean add(String data)
	{
		Node node = new Node(data);
		return add(node);
	}
}