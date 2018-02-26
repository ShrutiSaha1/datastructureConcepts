package StackImplementation;

import java.util.ArrayList;

public class StackArrayList implements IntStack
{
	
	ArrayList<Integer> arr=new ArrayList<Integer>();

	@Override
	public void push(int item) 
	{
		arr.add(item);
	}

	@Override
	public int pop() 
	{
		if(arr.size()<1)
			return 0;
		else
			return arr.remove(arr.size()-1);
	}
}
