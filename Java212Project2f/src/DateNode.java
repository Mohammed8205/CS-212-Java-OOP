
public class DateNode {
	protected Date212 data;
	protected DateNode next;
	
	public DateNode(Date212 d){
		data=d;
		next=null;
	}
	public DateNode(){
		data=new Date212(-99);
		next=null;
	}
}
