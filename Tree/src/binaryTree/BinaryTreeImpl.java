package binaryTree;

public class BinaryTreeImpl implements binaryTreeIntf {

	Node root;

	public void insert(int data) {
		insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;
		} else {
			if (node.getRight() == null)
			{
				node.setRight(new Node(data));
			}
			else if(node.getRight()!=null)
			{
				node.setRight(insert(node.getRight(), data));
			}
			else if(node.getLeft() == null)
			{
				node.setLeft(new Node(data));
			}
			else
			{
				node.setLeft(insert(node.getLeft(), data));
			}
			return node;
		}
	}

}
