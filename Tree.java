/* 
* Date: 07 Nov 2013
* Programmer: Joshua Honeycutt
* Program: The purpose of this program is to create a binary tree 
*          that uses the TreeDemo.java file that has been provided. 
*/

public class Tree 
{
	private TreeNode root;
	
	public Tree()
   {
      root = null;
	}
   
	public boolean isEmpty()// checks to see if the tree is empty
   {
		return root == null;
	}
   
	public void insert(String value)// method used to insert words
   {
		if(isEmpty())
      {
			root = new TreeNode(value);
		}
      else
      {
			TreeNode temp = searchNode(root, value);
         if(temp == null)
         {
            root.add(value);
         }
         else
         {
            temp.updateIndex();
         }
		}
	}
   
   public void search(String value)// method used to search for items
   {
      TreeNode temp;
      if((temp = searchNode(root, value)) == null)
      {
          System.out.println("-- "+ value + "was not found!--");
      }
      else
      {
         System.out.println("-- The following string(" + temp.getWords() + ") was found " + temp.getIndex()+"--");
      }
   }
	public TreeNode getRoot()
   {
		return root;
	}
   
   /* The method below Returns node in the tree with the
      given string or null if the string isn't in the tree */
   public TreeNode searchNode (TreeNode currentNode, String compare)
   {
      /* if currentNode catins the searech string return 
         it, otherwise create temporary node   */
      TreeNode temp = new TreeNode(compare);
      if (currentNode.getWords().equals(compare))
      {
         return currentNode;
      }
      else // search the left side of the tree
      {
         if(currentNode.getLeft() != null)
         {
            temp = searchNode(currentNode.getLeft(),compare);
            if(temp != null) return temp;
         }
          if (currentNode.getRight() != null)// if not found on left search right
         {
            temp = searchNode(currentNode.getRight(),compare);
            if(temp != null) return temp;
         }
      }
      return null;
   }
   
   public void preOrder(TreeNode currentNode)
   {
      if(currentNode != null)
      {
         System.out.print(currentNode.getWords() + " ");
         preOrder(currentNode.getLeft());
         preOrder(currentNode.getRight());
      }
   }
   
   public void printPreOrder()
   {
      preOrder(root);
   }
   
   public void inOrder(TreeNode currentNode)
   {
      if(currentNode != null)
      {
         inOrder(currentNode.getLeft());
         System.out.print(currentNode.getWords() + " ");
         inOrder(currentNode.getRight());
      }
   }
   
   public void printInOrder()
   {
      System.out.println("\n");
      inOrder(root);
   }
   
   public void postOrder(TreeNode currentNode)
   {
      if(currentNode != null)
      {
         postOrder(currentNode.getLeft());
         postOrder(currentNode.getRight());
         System.out.print(currentNode.getWords() + " ");
      }
   }
   
   public void printPostOrder()
   {
      System.out.println("\n");
      postOrder(root);
   }
}
