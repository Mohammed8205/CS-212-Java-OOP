import java.util.Comparator;

public class MyDates implements Comparator<Date212>{

	@Override
	public int compare(Date212 o1, Date212 o2) {
		if(o1.getYear()>o2.getYear())
			return 1;
		else
			return -1;
	}

}
