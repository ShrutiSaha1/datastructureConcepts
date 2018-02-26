package stackImpleForQuery;

public class QwithStack 
{
	int arr[];
	int tos;
	
	public QwithStack(int size)
	{
		arr=new int[size];
		tos=-1;
	}
	/*public QwithStack() {
	
		tos=-1;
		arr=new int[];
	}*/
	
	public void push(int item)
	{
		if(tos==arr.length-1)
		{
			int temp[]=new int[arr.length*2];
			System.arraycopy(arr,0, temp,0, arr.length);
			arr=temp;
			arr[++tos]=item;
		}
		else 
			arr[++tos]=item;
	}
	
	public int pop()
	{
		if(tos<0)
		{
			System.out.println("stack is empty");
			return 0;
		}
		else 
			return arr[tos--];
	}
	 public boolean isEmpty(){
	        return tos==-1;
	    }
	int qsize()
	{
		if(arr.length==0)
			return 0;
		else
			return arr.length;
	}
}
