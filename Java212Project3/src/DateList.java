/**
 * This class is the DateList to be used for project3
 * @author Mohammed J Islam
 *this class is an abstract class with abstract methood of add 
 *this class can be called by sub class
 */
abstract class DateList {
	
	protected DateNode head;
	protected DateNode tail;
	protected int length;
	// constructor for datelist where we assigning head and tail with no parameter 
	public DateList(){
		head=new DateNode();
		tail=head;
		length=0;
	}
	// constructor for datelist where we assigning head and tail from node to list with single parameter
	public DateList(DateNode n ){
		head=n;
		tail=head;
		length++;
	}
	
	public abstract void add(DateNode y); // Abstract method. and it will for sorted and unsorted list
	
	public int getLength(){ //this method will return the length of linked List
		return length;
	}

	public DateNode getHead() { //this method will return the head of linked List
		return head;
	}

	public void setHead(DateNode head) { //this method will set the head of linked List
		this.head = head;
	}
}