public class DoublyLL{

	class Node{
		Node prev;
		int data;
		Node next;
		public Node(int data){
			this.data = data;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public DoublyLL(){
		this.size = 0;
	}

	public void insertFirst(int val){
		Node node = new Node(val);
		node.next = head;
		node.prev = null;
		if(head != null ){
			head.prev = null;
		}
		head = node;
		size++;
	}

	public void insertLast(int val){
		Node node = new Node(val);
		Node temp = head;
		if (head == null) {
			node.prev =null;
			head = node;
			return;
		}
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = node;
		node.next = null;
		node.prev = temp;
		tail = node;
			
	}

	public Node find(int value) {
		Node node = head;
        while (node != null) {
            if (node.data == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


	public void insert(int after, int val) {
		Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }


	public void display(){
		Node temp = head;
		while(temp!=null){
            System.out.print(temp.data + "---> " );
			temp = temp.next;
		}
            System.out.print("END" );
			System.out.println();
			System.out.println();
			System.out.println("Reversed List");

			Node temp2 = tail;
			while(temp2!=null){
            System.out.print(temp2.data + "---> " );
			temp2 = temp2.prev;
		}
            System.out.print("START" );
			System.out.println();
			System.out.println();
            
	}



	public static void main(String[] args) {
		DoublyLL dll = new DoublyLL();

		dll.insertLast(10);
		dll.insertLast(11);
		dll.insertLast(12);
		dll.insertLast(13);
		dll.insertLast(14);
		dll.insertLast(15);
		dll.display();

		dll.insert(13,99);
		dll.display();
		


	}
}
