package hackerrank.dst.queue;

public class Solution
{

	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(5);
		q.view();
		
		q.dequeue();
		q.view();
	}
	
	

}
