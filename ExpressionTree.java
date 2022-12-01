import java.util.Stack;


public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface
{

	public ExpressionTree(String[] postfix)
	{
		Stack<BinaryTree<String>> treeStack = new Stack<>();
		for(int i = 0; i < postfix.length; i++)
		{
			if(!postfix[i].equals("/") && !postfix[i].equals("x") && !postfix[i].equals("+") && !postfix[i].equals("-"))
			{
				treeStack.push(new BinaryTree<String>(postfix[i]));
			}
			else
			{
				BinaryTree<String> rhs = treeStack.pop();
				BinaryTree<String> lhs = treeStack.pop();
				treeStack.push(new BinaryTree<String>(postfix[i], lhs, rhs));
			}
		}
		this.setRootNode(treeStack.pop().getRootNode());
	}//end constructor

	public void postOrder()
	{
		postOrder(getRootNode());
	}

	private void postOrder(BinaryNode<String> rootNode)
	{
		BinaryNode<String> leftChild = rootNode.getLeftChild();
		BinaryNode<String> rightChild = rootNode.getRightChild();

		if(leftChild != null)
		{
			postOrder(leftChild);
		}
		if(rightChild != null)
		{
			postOrder(rightChild);
		}
		if(rootNode.hasLeftChild() && rootNode.hasRightChild())
		{
			System.out.println(leftChild.getData() +" : " + rootNode.getData() + " : " + rightChild.getData());
		}
		if(!rootNode.getData().equals("+") && !rootNode.getData().equals("-") && !rootNode.getData().equals("x") && !rootNode.getData().equals("/"))
		{
			System.out.println(rootNode.getData());
		}
	}

	public double evaluate()
	{
		return evaluate(getRootNode());
	}//end evaluate

	private double getValueOf(String variable)
	{
		return Double.parseDouble(variable);
	}//end getValueOf

	private double compute(String operator, double firstOperand, double secondOperand)
	{
		double result = 0;

		switch(operator)
		{
			case "+" :
				result = firstOperand + secondOperand;
				break;
			case "-" :
				result = firstOperand - secondOperand;
				break;
			case "x" :
				result = firstOperand * secondOperand;
				break;
			case "/" : 
				result = firstOperand / secondOperand;
				break;
			default:
				break;			
		}

		return result;
	}//end compute

	private double evaluate(BinaryNode<String> rootNode)
	{
		double result;
		if(rootNode == null)
		{
			result = 0;
		}
		else if(rootNode.isLeaf())
		{
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else
		{
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		}

		return result;
	}//end evaluate
}//end ExpressionTree