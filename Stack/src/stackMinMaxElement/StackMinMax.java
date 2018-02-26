package stackMinMaxElement;

public class StackMinMax
{
	int[] arr;
	int top;
	int min;
	
	public StackMinMax(int n)
	{
		arr=new int[n];
		top=-1;
	}
	
	public void push(int item)
	{
		if(top==-1)
		{
			min=item;
			arr[++top]=item;
		}
		if(item<min)
		{
			arr[++top]=2*item-min;
			min=item;
		}
		else
		{
			arr[++top]=item;
		}
		if(arr.length-1==top)
		{
			int temp[]=new int[arr.length*2];
			System.arraycopy(arr,0, temp,0, arr.length);
			arr=temp;
			arr[++top]=item;
		}
	}
	
	public int pop()
	{
		if(top==-1)
		{
			System.out.println("stack is empty");
		}
		int t=arr[top--];
		if(t<min)
		{
			min=2*min-t;
		}
		else
			return arr[top--];
		return t;
	}
	
	public boolean isEmpty()
	{
		if (top==-1)
			return true;
		else 
			return false;
	}
}
