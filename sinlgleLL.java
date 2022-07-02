public class SingleLL{

	//OUR NODE STRUCTURE
	class Node{
		int data;
		Node next;
		public Node(int data ){
			this.data = data;
			this.next = null;
		}
	}

	//THESE ARE VARIABLE DECLARATION
	private Node head;
	private Node tail;
	private int size;


	//INITIALLY SIZE OF OUR LINKED LIST WILL BE ZERO.
	public SingleLL(){
		this.size = 0;
	}

	//I
	public void insertFirst(int data){
		Node node = new Node(data);
		

		node.next = head;
		head = node;
		if(tail==null){
			tail = head;
		}
		size++;

	}
	public void insertLast(int data){
		// Node node = new Node(data);
		if(tail==null){
			insertFirst(data);
			return;
		}
		Node node = new Node(data);
		tail.next = node;
		tail = node;
		size++;

	}

	public void insertIndex(int data, int index){
		int size = getSize();
		Node temp = head;
		Node newNode = new Node(data);

		if(index == size){
			insertLast(data);
		}
		if (index == 0) {
			insertFirst(data);
		}
		for (int i = 0;i<index-1 ;i++ ) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode; 

		size++;

	}

	public int getSize(){
		int count = 0;
		Node temp = head;
		while(temp!=null){
			count++;
			temp = temp.next;
		}
		return count;
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

	public int deleteIndex(int data, int index){
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

	public void searchInsert(int data){

	}


	public void display(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + "  --->  ");
			temp = temp.next;
		}
			System.out.print("END" + "   ");
		System.out.println();
		System.out.println();



	}

	public static void main(String[] args) {
		SingleLL newNode = new SingleLL();
		newNode.insertLast(1);
		newNode.insertLast(2);
		newNode.insertLast(3);
		newNode.insertLast(4);
		newNode.insertLast(5);
		newNode.insertLast(6);
		newNode.insertLast(7);
		System.out.println("Our Single Linked List: ");
		newNode.display();

		System.out.println("Insert First element: ");
		newNode.insertFirst(99);
		newNode.display();	

		System.out.println("Insert Last element: ");
		newNode.insertLast(100);
		newNode.display();	

		System.out.println("Delete First element: ");
		newNode.deleteFirst();
		newNode.display();

		System.out.println("Delete Last element: ");
		newNode.deleteLast();
		newNode.display();	

		System.out.println("Insert After Particular index: ");
		newNode.insertIndex(99,3);
		newNode.display();

		System.out.println("Delete After Particular element: ");
		newNode.deleteIndex(99,3);
		newNode.display();	

	}
}
