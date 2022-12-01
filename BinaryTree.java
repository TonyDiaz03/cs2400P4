import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
	private BinaryNode<T> root;
	public BinaryTree()
	{
		root = null;
	}//end default constructor

	public BinaryTree(T rootData)
	{
		root = new BinaryNode<>(rootData);
	}//end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		initializeTree(rootData, leftTree, rightTree);
	}//end constructor

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		initializeTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	}//end setTree

	private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		root = new BinaryNode<>(rootData);
		if(leftTree != null)
		{
			root.setLeftChild(leftTree.root);
		}
		if(rightTree != null)
		{
			root.setRightChild(rightTree.root);
		}
	}//end initializeTree

	public void setRootData(T rootData)
	{
		root.setData(rootData);
	}//end setRootData

	public T getRootData()
	{
		return root.getData();
	}//end setRootData

	public boolean isEmpty()
	{
		return root == null;
	}//end isEmpty

	public void clear()
	{
		root = null;
	}//end clear

	protected void setRootNode(BinaryNode<T> rootNode)
	{
		root = rootNode;
	}//end setRootNode

	protected BinaryNode<T> getRootNode()
	{
		return root;
	}//end getRootNode

	public int getHeight()
	{
		int height = 0;
		if(root != null)
		{
			height = root.getHeight();
		}
		return height;
	}//end getHeight

	public int getNumberOfNodes()
	{
		int numberOfNodes = 0;
		if(root != null)
		{
			numberOfNodes = root.getNumberOfNodes();
		}
		return numberOfNodes;
	}

	public Iterator<T> getPreorderIterator()
	{
		return null;
	}
	public Iterator<T> getPostorderIterator()
	{
		return null;
	}
	public Iterator<T> getInorderIterator()
	{
		return null;
	}
	public Iterator<T> getLevelOrderIterator()
	{
		return null;
	}
}