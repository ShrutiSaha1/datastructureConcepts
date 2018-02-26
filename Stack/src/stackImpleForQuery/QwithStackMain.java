package stackImpleForQuery;

import java.util.Scanner;

public class QwithStackMain 
{
	public static void main(String[] args)
	{
	@SuppressWarnings("resource")
	Scanner sc= new Scanner(System.in);
	char ch;
	int option;
	System.out.println("enter the initial size of the queue...u can add more later");
	int n=sc.nextInt();
	QwithStack q1=new QwithStack(n);
	QwithStack q2=new QwithStack(n);
	
	do
	{
	System.out.println("press 1  to enqueue element");
	System.out.println("press 2 to dequeue element");
	option=sc.nextInt();
	
	switch(option)
	{
	
	case 1: System.out.println("enter the number you wish to enqueue");
			int i=sc.nextInt();
			q1.push(i);
			break;
			
	case 2:	if(q1.isEmpty() && q2.isEmpty())
			{
				System.out.println("queue is empty");
			}
			if(q2.isEmpty())
			{
				while(q1.tos>-1)
				{
					int x=q1.pop();
					//System.out.println("x: "+x);
					q2.push(x);
				}
			}
			System.out.println("first element to enqueue: ");
			System.out.println(q2.pop());
			break;
			
	default: System.out.println("please enter a valid option");
	}
	
	System.out.println("do wish to continue:(y/n) ");
	ch=sc.next().charAt(0);
	
	
	}
	while(ch=='y');
	}
	
}
