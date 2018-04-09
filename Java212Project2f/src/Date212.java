
public class Date212 {
	private int day;
	private int month;
	private int year;
	
	public Date212(int x){
		day=x%100;
		int temp=(x/100);
		month=temp%100;
		temp=(temp/100);
		year=temp;
	}
	
	public Date212(int d, int m,int y){
		day=d;
		month=m;
		year=y;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
