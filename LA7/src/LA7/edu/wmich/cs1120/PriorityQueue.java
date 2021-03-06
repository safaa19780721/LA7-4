package LA7.edu.wmich.cs1120;

public class PriorityQueue<E> {
	private Node<E> head;
	private Node<E> tail;
	
	
	// Determine if the priority queue is empty.
	public boolean isEmpty() {
		return (head==null);
	}
	
	// Add object received to the priority queue taking into consideration the rules governing priority.
	/**
	 * 
	 * @param data passes data of type E as a parameter
	 */
	public void enqueue(E data) {
	
		if (data instanceof Request) {
		Node n = new Node(data);
		if(isEmpty()) {
			head =n;
			tail =head;
		}else {
			
			Node headcopy = head;
			int index = 0;
			while(headcopy != null) {
				if(((Request) data).compareTo(headcopy.getData())== 1||((Request) data).compareTo(headcopy.getData())== 0) {
					break;
				}
				headcopy = headcopy.getNext();
				index++;
				
			}
			if (index == 0) {
				Node newNode = new Node(n.getData(), head);
				head = newNode;
			
			}else {
				Node ref = head;
				for(int i = 0; i <index-1; i++) {
				ref = ref.getNext();
			}
			Node successor = ref.getNext();
			ref.setNext(n);
			n.setNext(successor);
			if(n.getNext() == null) {
				tail = n;
			}
		}
		}
		}
	}
	// Remove the next object to be processed from the priority queue.
	public E dequeue(){
		E ret = head.getData();
		head = head.getNext();
		return ret;
		
	}
	// Print the contents of the queue 
	public void Qprint() {
		System.out.println("<<<<<<<<<<<< Beginning of Queue Contents >>>>>>>>>>>>>>>>>");
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}else {
		Node ref = head;
		while(ref!=null) {
			if(ref.getData() instanceof Request) {
				System.out.println(ref.getData());
				ref=ref.getNext();
			}
		}
	}
		System.out.println("<<<<<<<<<<<< End of Queue Contents >>>>>>>>>>>>>>>>>");
	}


}
