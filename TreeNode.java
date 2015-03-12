/* 
* Date: 07 Nov 2013
* Programmer: Joshua Honeycutt
* Name: TreeNode.java (Tree Program, Programming Assignment #2)
* Professor: Jugan
* Class: ITCS 2214-002
* Program: TreeNode class for the Tree Program.
*/

public class TreeNode 
{
	private String words;    // The data in this node.
	private TreeNode left;   // Pointer to the left subtree.
	private TreeNode right;  // Pointer to the right subtree.
   private int index; // number of times that this string has been added to the tree
	
	public TreeNode(String w)
   {
		words = w;
		left = null;
		right = null;
      index = 1;
	}
	
	
	public void add(String value) 
   {

		if (left == null) 
      {
		
			left = new TreeNode(value);
		
		} 
      else if( right == null)
      {
		
			right = new TreeNode(value);
		} 
      else 
      {
         if(countChildren(left) <= countChildren(right))
         {
            left.add(value);
         }
         else
         {
            right.add(value);
         }
      }
	}
   
   //Count the nodes in the tree
   public int countChildren(TreeNode node)
   {
      int count = 0;
      
      if(node.getLeft() != null)
      {
         count += 1 + countChildren(node.getLeft());
      }
      
      if(node.getRight() != null)
      {
         count += 1 + countChildren(node.getRight());
      }
      
      return count;
   }   
      
	public TreeNode getLeft()
   {
		return left;
	}
	
	public TreeNode getRight()
   {
		return right;
	}
	
	public String getWords()
   {
		return words;
	}
   
   public int getIndex()
   {
      return index;
   }
   
   public void updateIndex()
   {
      index = index+1;
   }
	
}