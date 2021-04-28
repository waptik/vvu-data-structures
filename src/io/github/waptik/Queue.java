package io.github.waptik;


public class Queue
{
	protected int queue[];
	
	
	int size;
	int front;
	int rear;
	
	public Queue() {
		queue = new int[10];
	}
	
	public static void main(String[] args) {
		Queue bull = new Queue();
		bull.enQueue(2);
		bull.enQueue(5);
		bull.show();
		bull.deQueue();
		bull.enQueue(12);
		bull.show();
	}
	
	public void enQueue(int data)
	{
		queue[rear]=data;
		rear=rear+1;
		size=size+1;
	}
	public int deQueue()
	{
		int data=queue[front];
		if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);
		
		size=size-1;
		rear--;
		return data;
	}
	public int getsize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public void show()
	{
		System.out.print("Elements :");
		for(int i=0;i<rear;i++)
		{
			System.out.print(queue[front +i] + " ");
		}
		System.out.println("\n");
	}
}
