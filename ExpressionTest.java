public class ExpressionTest 
{
	public static void main(String[] args)
	{
		String[] equation = args[0].split(" ");//read args into 
		ExpressionTree tree = new ExpressionTree(equation);
		

		System.out.println("Expression Tree by T. Diaz\n");
		System.out.println("Input: " + args[0]);
		System.out.println("Value: " + tree.evaluate()+ "\n");
		System.out.println("Postorder Traversal: ");
		tree.postOrder();
	}
}
