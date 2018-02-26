package StackImplementation;

import java.util.Scanner;

public class StackArrListMain 
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int option;
		char ch;
		
		StackArrayList myStack=new StackArrayList();
		do
		{
		System.out.println("press 1  to insert into the stack");
		System.out.println("press 2 to pop the stack and display");
		option=sc.nextInt();
		
		switch(option)
		{
		
		case 1: System.out.println("enter the number you wish to push");
				int i=sc.nextInt();
				myStack.push(i);
				break;
		case 2: System.out.println("last number you entered: ");
				System.out.println(myStack.pop());
				break;
		default: System.out.println("please enter a valid option");
		}
		
		System.out.println("do wish to continue:(y/n) ");
		ch=sc.next().charAt(0);
		
		
		}
		while(ch=='y');
	}
}
