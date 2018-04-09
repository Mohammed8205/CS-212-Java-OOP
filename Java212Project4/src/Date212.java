/**
 * This class is the Date212 to be used for project2
 * @author Mohammed J Islam
 *Date212 will convert string data to integer data and return them  and set them as a month,date,year 
 */
public class Date212{

	private int day;
	private int month;
	private int year;
	
	//three parameter constructor assinging them into day year and month
	public Date212(int y, int m, int d){
		day=y;
		month=m;
		year=d;
	}
	public Date212(String s)throws IllegalDate212Exception{ //this method converting string to integer 
		this(Integer.parseInt(s.substring(6,8)), Integer.parseInt(s.substring(4,6 )), Integer.parseInt(s.substring(0,4)));
	}

	public int getDay() { //this method will return the day for datenode
		return day;
	}

	public void setDay(int day) { //this method will set the day for datenode
		this.day = day;
	}

	public int getMonth() { //this method will return month
		return month;
	}

	public void setMonth(int month) {//this method will set month
		this.month = month;
	}

	public int getYear() {//this method will return year
		return year;
	}

	public void setYear(int year) {//this method will set year
		this.year = year;
	}
	
	public String getDate(){
		String S = day+"/"+month+"/"+year; //creating Date in string
		return S;
	}
	
	public int compareTO(Date212 date1){ //comparing to dates and return them into tree map
		if(this.year!=date1.year)
		return(this.year)-(date1.year);
		else if(this.month!=date1.month && this.year==date1.year)
			return (this.month)-(date1.month);
		else
			return (this.day)-(date1.day);
	}
	
}
