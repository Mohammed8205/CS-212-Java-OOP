
public class SortedDateList extends DateList {// this is a sorted list class of Datelist Class
	public void add(DateNode n){
		if(head==null){
			head=n;
			return;
		}
		DateNode current=head; //this add Method is used for sorting the Date by using different method of Datelist class
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
}
