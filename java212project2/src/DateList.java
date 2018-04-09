/**
 * This class is the DateList to be used for project2
 * @author Mohammed J Islam
 *this class will create linked to list them as a node
 *this class also will list the node as a sorted by using insert method
 */
public class DateList {
	
	private DateNode head;
	private DateNode tail;
	private int length;
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
	//append function creating linkedlist for node. Adding node one after another to list
	public void append(DateNode n){
		if(head==null){
			head=n;
			tail=head;
			length++;
		}
		tail.next=n;
		tail=n;
		length++;
	}
	
	//insert method inserting the node in sorted way to linkedlist
	
	public void insert(DateNode n){
		DateNode current=head;
		while(current.next!=null && n.data.getYear()>=current.next.data.getYear()){
			if(current.next.data.getYear()==n.data.getYear()){
				if(current.next.data.getMonth()>n.data.getMonth()){
					break;
				}
				else if(current.next.data.getMonth()==n.data.getMonth()){
					if(current.next.data.getDay()>n.data.getDay()){
						break;
					}
				}
			}
			current=current.next;
		}
		n.next=current.next;
		current.next=n;
		length++;
	}
	
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