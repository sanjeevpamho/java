package code.bind;


public class MiddleInLinkedList {
	Node head;
	
	public void push(int data){
		Node node=new Node(data);
		node.next=head;
		head=node;
	}
	public void printList(){
		Node tmp=head;
		while(tmp!=null){
			System.out.print(tmp.data +"->");
			tmp=tmp.next;
		}
	}
	public void printMiddle(){
	
		Node slow_ptr=head;
		Node fast_ptr=head;
		if(head!=null){
			while(fast_ptr!=null && fast_ptr.next!=null){
				slow_ptr=slow_ptr.next;
				fast_ptr=fast_ptr.next.next;
			}
			 System.out.println("The middle element is [" + slow_ptr.data + "] \n");
                     
		}
	}
	
	public static void main(String[] args) {
		MiddleInLinkedList sll=new MiddleInLinkedList();
		for(int i=5;i>0;i--){
			sll.push(i);
		}
		sll.printList();
		sll.printMiddle();
	}
}
