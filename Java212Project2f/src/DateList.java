
public class DateList {
	private DateNode head;
	private DateNode tail;
	private int length;
	
	public DateList(){
		head=new DateNode();
		tail=head;
		length=0;
	}
	
	public DateList(DateNode n ){
		head=n;
		tail=n;
		length++;
	}
	
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
	
	public void print(){
		DateNode current=head.next;
		while(current!=null){
			System.out.println("List info: "+ current.data.getDay()+ "/"+current.data.getMonth()+"/"+current.data.getYear());
			current=current.next;
		}
	}
	public void insert(DateNode n){
		DateNode spot=findLocation(n);
		n.next=spot.next;
		spot.next=n;
	}
	public DateNode findLocation(DateNode Jahir){
		DateNode current=head;
		while(current.next!=null && current.next.data.getYear()<Jahir.data.getYear()){
		current=current.next;
		}
		return current;
	}

}
