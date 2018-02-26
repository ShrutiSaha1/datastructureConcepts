package doublyLinkedList;

import java.util.Scanner;

public class MainClass 
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		
		DoublyLinkedList obj= new DoublyLinkedList();
		
		char ch;
		
		do{
			
			 System.out.println("press 1 to insert at begining");
			 System.out.println("press 2 to insert in the end");
			 System.out.println("press 3 to insert at position");
			 System.out.println("press 4 to delete at position");
			 System.out.println("press 5 to check if empty");
			 System.out.println("press 6 to get size");
			 
			 int n=sc.nextInt();
			 
			 switch(n)
			 {
			 case 1: System.out.println("enter integer element to insert: ");
			 		 obj.insertAtStart(sc.nextInt());
			 		 break;
			 case 2: System.out.println("enter integer element to insert: ");
			  		 obj.inserAtEnd(sc.nextInt());
			  		 break;
			 case 3: System.out.println("enter integer value to insert: ");
			 		 int num= sc.nextInt();
			 		 System.out.println("enter position to insert: ");
			 		 int pos=sc.nextInt();
			 		 if(pos<1 || pos>obj.size())
			 			 System.out.println("invalid position");
			 		 else
			 			 obj.insertAtPosition(num, pos);
			 		 break;
			 case 4: System.out.println("enter position");
			  		 int pos1= sc.nextInt();
			  		 if(pos1<1||pos1>obj.size())
			  			 System.out.println("invalid position");
			  		 else
			  			 obj.deleteAtPos(pos1);
			  		 break;
			 case 5: System.out.println("empty status="+obj.isEmpty());
			 		 break;
			 case 6: System.out.println("size="+obj.size());
			 		 break;
			 default: System.out.println("invalid option");
			 		  break;
			 }
			 
			 obj.display();
			 System.out.println("\n do you want to continue?(y/n)");
			 ch=sc.next().charAt(0);
			 
		}while(ch=='y'||ch=='Y');
		sc.close();	
	}

}
