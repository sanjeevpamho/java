package code.bind;
public class MergeLinkedList {
	static Node head,first,second;
	Node merged;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
			this.next=null;	
		}
		
	}
	void mergeList(Node first,Node second){
		merged = new Node(0);
		Node head = merged;

          while(first!=null && second !=null){
        	  if(first.data<=second.data){
        		  head.next=first;
        		  first=first.next;
        		  head=head.next;
        	  }
        	  else{
        		  head.next=second;
        		  second=second.next;
        		  head=head.next;
        	  }
        	  
          }
          if(first!=null){
        	  head.next=first;
          }
          if(second!=null){
        	  head.next=second;
          }
          
	}
	void printList()
	{
		Node temp = merged;
		temp=temp.next;
		while (temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}  
		System.out.println();
	}

	public static void main(String[] args) {
		MergeLinkedList list=new MergeLinkedList();
		list.first=new Node(3);
		list.first.next=new Node(6);
		list.first.next.next=new Node(6);
		list.first.next.next.next=new Node(9);
		list.first.next.next.next.next=new Node(15);

		list.second=new Node(4);
		list.second.next=new Node(5);
		list.second.next.next=new Node(10);
		list.second.next.next.next=new Node(12);
		list.second.next.next.next.next=new Node(16);

		list.mergeList(first, second);
		list.printList();
	}
}
