class StackUsingLinkedlist
{
	Node head;
	class Node
	{
		int data;
		Node next; 
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		else
			return false;
	}
	public void push(int newData)
	{
		Node newNode = new Node(newData);
		//newNode.next = null;
		//If Linkedlist is empty
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			Node last = head;
			while(last.next != null)
			{
				last = last.next;
			}
			last.next = newNode;
		}
	}
	public int top()
	{
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			return 0;
		}
                Node last = head;
		while(last.next != null)
		{
			last = last.next;
		}
		return last.data;
	}
	public void pop()
	{
		Node last = head;
		Node prev = null;
		if(isEmpty())
		{
			System.out.println("Stack Underflow");
			return;
		}
		while(last.next != null)
		{
			prev = last;
			last = last.next;
		}
		prev.next = null;
	}
	public void printStack()
	{
		Node n = head;
		System.out.print("[ ");
		while(n != null)
		{
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println("]");
	}
	public static void main(String[] args)
	{
		StackUsingLinkedlist sll = new StackUsingLinkedlist();
		sll.pop();
		System.out.println("Is Empty : " + sll.isEmpty());

		sll.push(1);sll.push(2);sll.push(3);sll.push(4);sll.push(5);

		System.out.println("After PUSH");
		System.out.print("Stack Elements : ");
		sll.printStack();

		System.out.println("Is Empty : " + sll.isEmpty());

		System.out.println("Top Element : " + sll.top());

		sll.pop();
		System.out.print("After POP : ");
		sll.printStack();

		System.out.println("Top Element : " + sll.top());
		
		sll.push(10);
		System.out.print("After PUSH : ");
		sll.printStack();
		
	}
}