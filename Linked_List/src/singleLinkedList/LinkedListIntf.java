package singleLinkedList;

public interface LinkedListIntf {
	
	void insertAtStart(int data);
	void insertInEnd(int data);
	void insertAtAny(int data, int pos);
	void deleteAtAny(int pos);
	void display();
	boolean isEmpty();
	public int getSize();
	int getElementbyIndex(int pos);
	int searchElement(int data);
	void reverseList();

}
