public class BinaryNode<T>
{
	private T data;
	private BinaryNode<T> leftChild;//reference to left child
	private BinaryNode<T> rightChild;//reference to right child

	public BinaryNode()
	{
		this(null);//call next constructor
	}//end constructor

	public BinaryNode(T dataPortion)
	{
		this(dataPortion, null, null);//call next constructor
	}//end constructor

	public BinaryNode(T dataPortion, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
	{
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}//end constructor

	public T getData()//retrieve the data
	{
		return data;
	}

	public void setData(T newData)//set a new data
	{
		data = newData;
	}//end setData

	public BinaryNode<T> getLeftChild()//return the left child
	{
		return leftChild;
	}//end getLeftChild

	public void setLeftChild(BinaryNode<T> newLeftChild)//set a new left child
	{
		leftChild = newLeftChild;
	}//end setLeftChild

	public boolean hasLeftChild()//check if there is a left child
	{
		return leftChild != null;
	}//end hasLeftChild

	public BinaryNode<T> getRightChild()//return the right child
	{
		return rightChild;
	}//end getRightChild

	public void setRightChild(BinaryNode<T> newRightChild)//set a new right child
	{
		rightChild = newRightChild;
	}//end setRightChild

	public boolean hasRightChild()//check if there is a right child
	{
		return rightChild != null;
	}//end hasRightChild

	public boolean isLeaf()//checks if root node is a leaf
	{
		return (leftChild == null) && (rightChild == null);
	}//end isLeaf

	public int getNumberOfNodes()//get the number of nodes
	{
		int leftNumber = 0;
		int rightNumber = 0;
		if(leftChild != null)
		{
			leftNumber = leftChild.getNumberOfNodes();
		}
		if(rightChild != null)
		{
			rightNumber = rightChild.getNumberOfNodes();
		}
		return 1 + leftNumber + rightNumber;
	}//end getNumberOfNodes

	public int getHeight()//gets the height of the tree
	{
		return getHeight(this);
	}//end getHeight

	private int getHeight(BinaryNode<T> node)//private method used when calling getHeight
	{
		int height = 0;

		if(node != null)
		{
			height = 1 + Math.max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()));
		}
		return height;
	}

	public BinaryNode<T> copy()//copies the subtree rooted at this node
	{
		BinaryNode<T> newRoot = new BinaryNode<>(data);
		if(leftChild != null)
		{
			newRoot.setLeftChild(leftChild.copy());
		}
		if(rightChild != null)
		{
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}//end copy
}