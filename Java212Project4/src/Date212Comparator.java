import java.util.Comparator;
//this classs implemensts the building comparator method 
public class Date212Comparator implements Comparator<Date212>{

	public int compare(Date212 date1, Date212 date2){ //this compare method compring to dates and return them in sorted order
		return date1.compareTO(date2);
	}
}
