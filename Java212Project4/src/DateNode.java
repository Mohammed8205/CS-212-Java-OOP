
/**
 * This class is the DateNode to be used for project2
 * @author Mohammed J Islam
 *this class will create node and print function to print them in gui
 */
public class DateNode {
	protected Date212 data; // Data for Date212
	protected DateNode next; // next data
	
	public DateNode(Date212 d){ //Create constracter type with date212 
		data=d;
		next=null;
	}
	public DateNode(){
		data= new Date212(0000, 00 , 00); //formating data for year month date
		next=null;
	};
	
	public String printDate(){ //print method for displaying sorted and unsorted date by month/date/year
		StringBuilder s = new StringBuilder();
		s.append(data.getMonth()).append("/").append(data.getDay()).append("/").append(data.getYear());
		return s.toString();
	}

}
