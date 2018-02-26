package doublyLinkedList;

public class DoublyLinkedList {
	private Node start;
	private Node end;
	private int size;

	public DoublyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void insertAtStart(int val) {
		Node newNode = new Node(val, null, null);
		if (start == null) {
			start = newNode;
			end = start;
		} else {
			start.setLinkPrev(newNode);
			newNode.setLinkNext(start);
			start = newNode;
		}
		size++;
	}

	public void inserAtEnd(int val) {
		Node newNode = new Node(val, null, null);
		if (start == null) {
			start = newNode;
			end = start;
		} else {
			newNode.setLinkPrev(end);
			end.setLinkNext(newNode);
			end = newNode;

		}
		size++;
	}

	public void insertAtPosition(int val, int pos) {
		Node newNode = new Node(val, null, null);

		if (pos == 1) {
			insertAtStart(val);
			return;
		}
		Node newNode1 = start;
		for (int i = 2; i <= size; i++) {
			if (i == pos) {
				
				Node temp= newNode1.getLinkNext();
				newNode1.setLinkNext(newNode);
				newNode.setLinkPrev(newNode1);
				newNode.setLinkNext(temp);
				temp.setLinkPrev(newNode);

			}
			newNode1=newNode1.getLinkNext();
		}
		size++;
	}
	
	public void deleteAtPos(int pos)
	{
		if(pos==1)
		{
			if(size==1)
			{
				start=null;
				end=null;
				size=0;
				return;
			}
			start=start.getLinkNext();
			start.setLinkPrev(null);
			size--;
			return;
		}
		if(pos==size)
		{
			end=end.getLinkPrev();
			end.setLinkNext(null);
			size--;
		}
		
		Node temp=start.getLinkNext();
		for(int i=2; i<+size; i++)
		{
			if(i==pos)
			{
				Node p=temp.getLinkPrev();
				Node n=temp.getLinkNext();
				
				p.setLinkNext(n);
				n.setLinkPrev(p);
				
				size--;
				return;
			}
			temp=temp.getLinkNext();
		}
		
	}
	
	public void display()
	{
		System.out.println("doubly linked list");
		if(size==0)
		{
			System.out.println("list is empty");
			return;
		}
		if(start.getLinkNext()==null)
		{
			System.out.println(start.getData());
			return;
		}
		Node temp=start;
		System.out.print(start.getData()+" <-> ");
		
		temp=start.getLinkNext();
		
		while(temp.getLinkNext()!=null)
		{
			System.out.print(temp.getData()+" <-> ");
			temp=temp.getLinkNext();
		}
		System.out.print(temp.getData()+" <-> ");
		
	}
	

}
