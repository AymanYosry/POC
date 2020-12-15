package hackerrank.tree.binarySearchTree;

/**
 * 
 * @author Ayman Yosry
 * @link https://www.hackerrank.com/challenges/is-binary-search-tree/problem
 * Not completed
 */

public class Node 
{
	private int notcompleted;
	private int data;
    private Node left;
    private Node right;

    /* Constructor */
    public Node()
    {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public Node(int data)
    {
		this.data = data;
		left = null;
		right = null;
	}
    
    /* Function to set left node */
    public void setLeft(Node n)
    {
        left = n;
    }
    /* Function to set right node */ 
    public void setRight(Node n)
    {
        right = n;
    }
    /* Function to get left node */
    public Node getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public Node getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }
    
    boolean checkBST(Node root) 
    {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean checkBST(Node node, int min, int max)
    {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        boolean isBST = checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
        return isBST;
    }
    
    public static void main(String args[])
    {
    	
    }
}
