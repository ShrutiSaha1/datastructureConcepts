package singleLinkedList;

import java.util.Scanner;

class Node
{
	int data;
	Node next;
	
	public Node()
	{
		next=null;
		data=0;
	}
	public Node(int data, Node next)
	{
		this.data=data;
		this.next=next;
	}
	public void setLinktoNextNode(Node n)
	{
		next=n;
	}
	public Node getLink()
	{
		return next;
	}
	public int getData()
	{
		return data;
	}
}
class LinkedList implements LinkedListIntf
{
	Node start;
	Node end;
	int size;
	
	public LinkedList()
	{
		start=null;
		end=null;
		size=0;
	}
	public boolean isEmpty()
	{
		return start==null;
	}
	public int getSize()
	{
		return size;
	}
	
	public void insertAtStart(int val)
	{
		Node newNode= new Node(val,null);
		size++;
		if(start==null)
		{
			start=newNode;
			end=start;
		}
		else
		{
			newNode.setLinktoNextNode(start);
			start=newNode;
		}
	}
	
	public void insertInEnd(int val)
	{
		Node newNode=new Node(val,null);
		size++;
		if(start==null)
		{
			start=newNode;
			end=start;
		}
		else
		{
			end.setLinktoNextNode(newNode);
			end=newNode;
		}
	}
	
	public void insertAtAny(int val, int pos)
	{
		Node newNode= new Node(val,null);
		Node ptr=start;
		pos=pos-1;
		for(int i=1;i<=size;i++)
		{
			if(i==pos)
			{
				Node temp=ptr.getLink();
				ptr.setLinktoNextNode(newNode);
				newNode.setLinktoNextNode(temp);
				break;
				
			}
			size++;
		}
	}
	
	public void deleteAtAny(int pos)
	{
		if(pos==1)
		{
			start= start.getLink();
			size--;
			return;
		}
		if(pos==size)
		{
			Node s=start;
			Node t=start;
			while(s!=end)
			{
				t=s;
				s=s.getLink();
			}
			end=t;
			end.setLinktoNextNode(null);
			size--;
			return;
		}
		
		Node ptr= start;
		pos=pos-1;
		for (int i=1; i<size-1;i++)
		{
			if(i==pos)
			{
				Node tmp= ptr.getLink();
				tmp=tmp.getLink();
				ptr.setLinktoNextNode(tmp);
				break;
			}
			ptr=ptr.getLink();
		}
		size--;
	}
	
	public void display()
	{
		System.out.println("Singly Linked List");
		if(size==0)
		{
			System.out.println("empty list");
			return;
		}
		if(start.getLink()==null)
		{
			System.out.println(start.getData());
			return;
		}
		Node ptr=start;
		System.out.print(start.getData()+" -> ");
		ptr=start.getLink();
		while(ptr.getLink()!=null)
		{
			System.out.print(ptr.getData()+" -> ");
			ptr=ptr.getLink();
		}
		System.out.println(ptr.getData());
	}
	
	public int getElementbyIndex(int pos)
	{
		int count=1;
		Node ptr=start;
		while(ptr!=null)
		{
			if(count==pos)
			{
				return ptr.data;
			}
			count++;
			ptr=ptr.next;
		}
		return 0;
	}
	
	public int searchElement(int data)
	{
		Node ptr=start;
		int count=1;
		while(ptr!=null)
		{
			if(ptr.getData()==data)
			{
				return count;
			}
			++count;
			ptr=ptr.next;
		}
		return 0;
	}
	
	public void reverseList()
	{
		Node ptr = null;
		Node current = start;
		while (current != null) {
		    Node next = current.next;
		    current.next = ptr;
		    ptr = current;
		    current = next;
		}
		start = ptr;
	}
}


public class SinglyLinkedList {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedListIntf list = new LinkedList();
		char ch;
		
		do
		{
			System.out.println("Singly LinkedList operations");
			System.out.println("1. insert at begining");
			System.out.println("2. insert at end");
			System.out.println("3. insert at position");
			System.out.println("4. Delete at position");
			System.out.println("5. check empty");
			System.out.println("6. get size");
			System.out.println("7. display list");
			System.out.println("8. Get an element by index");
			System.out.println("9. Search for an element");
			System.out.println("10. Reverse the linked list");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1: System.out.println("enter integer element to insert at start");
						list.insertAtStart(sc.nextInt());
						break;
				case 2: System.out.println("enter integr element to insert in end");
						list.insertInEnd(sc.nextInt());
						break;
				case 3: System.out.println("enter integer element to insert");
						int num=sc.nextInt();
						System.out.println("enter position to insert");
						int pos=sc.nextInt();
						if(pos<=1 || pos>list.getSize())
						{
							System.out.println("invalid position");
						}
						else
							list.insertAtAny(num, pos);
						break;
				case 4: if(list.getSize()==0)
						{
							System.out.println("empty list...insert elements first");
							break;
						}
						else
						System.out.println("enter position");
						int n=sc.nextInt();
						if(n<1 || n>list.getSize())
						{
							System.out.println("invalid position");
						}
						else
							list.deleteAtAny(n);
						break;
				case 5: System.out.println(list.isEmpty());
						break;
				case 6: System.out.println("list size is: "+list.getSize());
						break;
				case 7: list.display();
						break;
				case 8: System.out.println("enter the index number for which you want to get data: ");
						int index=sc.nextInt();
						System.out.println("data at index"+index+" is="+list.getElementbyIndex(index));
						break;
				case 9: System.out.println("enter the value of data element you want to search");
						int val=sc.nextInt();
						int ind=list.searchElement(val);
						if(ind!=0)
						{
							System.out.println(val+" is found at the index="+ind);
						}
						else
						{
							System.out.println(val+" not found in the linked list");
							list.display();
						}
						break;
				case 10: System.out.println("original list:");
						 list.display();
						 list.reverseList();
						 System.out.println("list after reverse:");
						 list.display();
						 break;
				default:System.out.println("wrong entry");
						break;	
			}
			System.out.println("do you wish to continue?(y/n)");
			ch=sc.next().charAt(0);
		} while(ch=='y'||ch=='Y'); 
		sc.close();
	}

}
