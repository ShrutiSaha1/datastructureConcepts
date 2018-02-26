package StackImplementation;

public class Stack implements IntStack
{
	int arr[];
	int tos;
	
	Stack(int size)
	{
		arr=new int[size];
		tos=-1;
	}
	
	public void push(int item)
	{
		if(tos==arr.length-1)
		{
			int temp[]=new int[arr.length*2];
			System.arraycopy(arr,0, temp,0, arr.length);
			arr=temp;
			arr[++tos]=item;
			/*for(int i=0; i<arr.length;i++)
			{
				//temp[i]=arr[i];
				
				arr=temp;
				arr[++tos]=item;
			}*/
		}
		else 
			arr[++tos]=item;
	}
	
	public int pop()
	{
		if(tos<1)
		{
			System.out.println("stack is empty");
			return 0;
		}
		else 
			return arr[tos--];
	}
	
	
}
