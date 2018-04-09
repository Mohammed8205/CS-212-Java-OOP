import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import javax.swing.JFrame;
import java.awt.GridLayout;
/**
 * This class is the DateGue to be used for project1
 * @author Mohammed J Islam
 *DateGue class will print in JFrame in unsorted way and sorted way
 */
public class DateGui {
	//private Date of birth array
    private int dates[];
    //created a constractor with one parameter to call from outside
    public DateGui(int a[]){
        this.dates=a; //Assigning birthdate to datesarray
    }
    //this method is used for sorting array and display the array 
    public void create(){
    	//JFrame obj created with size and location of displaying frame
    	JFrame obj= new JFrame(); 
         obj.setSize(100, 100);
            obj.setLocation(600, 500);
            obj.setResizable(true);
            obj.setTitle("Date of Birth"); //Name of the frame is Date of Birth
            //Setting the inside of the frame how to be displying the input
            Container myContain = obj.getContentPane();
            obj.setLayout(new BorderLayout());
            obj.setLayout(new GridLayout());
            TextArea sorted = new TextArea();
            TextArea unsorted = new TextArea();
            //adding input to display sorted and and unsorted array
            myContain.add(sorted);
            myContain.add(unsorted);
            //just print a message in the frame at west
            unsorted.append("Unsorted Birthdays: "+"\n");
            for(int k=0; k<dates.length; k++){
            	//This loop will print unsorted date of birth array that we get from the texfile
                unsorted.append(dates[k]+"\n");
            }
            //Bottome just sorting array in ascending order by using selection sort
            int min=0;
            for(int k=0;k<dates.length;k++){
                min=k; //this is our selection that will use for sorting 
                for( int j=k+1;j<dates.length;j++){
                    if(dates[j]<dates[min])
                        min=j;
                }
                if(min!=k){
                    int temp=dates[k];
                    dates[k]=dates[min];
                    dates[min]=temp;
                }
            }
            sorted.append("Sorted Birtdays: \n");
            	for(int i=0;i<dates.length;i++){
            		sorted.append(dates[i]+"\n");//Displaying sorting date of birth to East of the JFrame
            	}
           //Setting up East and West Border
            obj.add(unsorted,BorderLayout.WEST);
            obj.add(sorted,BorderLayout.EAST);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.pack();
            obj.setVisible(true);
    	}
        
    }
