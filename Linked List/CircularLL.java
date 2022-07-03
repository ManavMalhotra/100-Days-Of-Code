public class CircularLL{
	class Node{
		Node prev;
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}

	private Node head = null;
	private Node tail = head;
	private int size = 0;

	public void insert(int val) {
		Node newNode = new Node(val);

		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
    	}
    	
    	tail = newNode;
    	tail.next = head;
	}
	public int deleteFirst(){
		if(head == null){
			tail = null;
		}
		int value = head.data;
		head = head.next;
		size--;

		return value;
	}

	public int deleteLast(){
		if (size<=1) {
			deleteFirst();
		}
		Node temp1 = head;

		while(temp1.next!=tail){
			temp1 = temp1.next;
		}
		
		tail = temp1;
		tail.next = null;
		size--;

		return temp1.data;
	}

	public int deleteIndex(int index){
		int size = getSize();
		if (index == 0) {
			deleteFirst();
		}
		if (index == size-1) {
			deleteLast();
		}
		Node temp1 = head;

		for (int i = 0;i<index -1 ;i++ ) {
			temp1 = temp1.next;
		}

		
		temp1.next = (temp1.next).next;

		return temp1.data;

	}
		public int getSize(){
		int count = 0;
		Node temp = head;
		while(temp.next!=head){
			count++;
			temp = temp.next;
		}
		return count;
	}



	public void display() {
		Node temp = head;

    	if (head != null) {
    		while (temp.next != head) {
            	System.out.print(temp.data + " ---> " );
            	temp = temp.next;
       		}
            	System.out.print("END " );
            	System.out.println();
        }
    }


	public static void main(String[] args) {
		CircularLL cll = new CircularLL();

		cll.insert(10);
		cll.insert(11);
		cll.insert(12);
		cll.insert(13);
		cll.insert(14);
		cll.insert(15);
		cll.display();
		cll.deleteIndex(3);
		cll.display();

	}

}
