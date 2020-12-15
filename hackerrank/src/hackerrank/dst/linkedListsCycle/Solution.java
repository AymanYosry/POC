package hackerrank.dst.linkedListsCycle;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author ayosry
 * @link https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */
public class Solution 
{
	public class Node 
	{
        int data;
        Node next;
    }
	
	Set<Node> seen = new HashSet<>();
	boolean hasCycleBest(Node node) 
	{	
		if (node == null) return false; 
		seen.add(node);
		if (node.next == null) return false;
		if (seen.contains(node.next)) return true;
		return hasCycleBest(node.next);
	}
	
	boolean hasCycle2(Node node) 
	{	
		if (node == null) return false; 
		Node slow = node;
		Node fast = node.next;
		while(slow != fast)
		{
			if(fast == null || fast.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;			
		}
		return true;
	}
	
	public boolean hasCycle3(Node head) 
	{
		boolean hasCycle = false;
		int count = 0;
        if(head != null)
        {
        	HashSet<Node> visitedNodes = new HashSet<>();
        	Node current = head;
        	count+=1;

        	while(current.next != null && count <= 100)
        	{
        		visitedNodes.add(current);
        		current = current.next;
        		count+=1;
        		if(visitedNodes.contains(current))
        		{
        			hasCycle = true;
        			break;
        		}
        	}
        }
        return hasCycle;
	}

	public static void main(String[] args) 
	{
		Solution s = new Solution();
		Solution.Node node1 = s.new Node(); 
		Solution.Node node2 = s.new Node(); 
		Solution.Node node3 = s.new Node(); 
		Solution.Node node4 = s.new Node(); 
		
		//node1.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		System.out.println(s.hasCycleBest(node1));
		System.out.println(s.hasCycle3(node1));
	}
}
