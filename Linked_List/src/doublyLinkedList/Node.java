package doublyLinkedList;

public class Node 
{
	int data;
	Node next;
	Node prev;
	
	Node(int data, Node next, Node prev)
	{
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
	Node()
	{
		data=0;
		prev=null;
		next=null;
	}
	
	public void setLinkNext(Node n)
	{
		next=n;
	}
	
	public void setLinkPrev(Node n)
	{
		prev=n;
	}
	public Node getLinkNext()
	{
		return next;
	}
	
	public Node getLinkPrev()
	{
		return prev;
	}

	public void setData(int d)
	{
		data=d;
	}
	public int getData()
	{
		return data;
	}
	
}
