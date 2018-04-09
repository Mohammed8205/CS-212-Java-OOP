import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextArea;
import javax.swing.JFrame;
import java.awt.GridLayout;
/**
 * This class is the DateGue to be used for project2
 * @author Mohammed J Islam
 *DateGue class will print in JFrame in unsorted way and sorted way
 */
public class DateGUI {
	//private Date of birth 
   
    private DateList list1;
    private DateList list2;
    //created a constractor with two parameter to call from outside
   // Assigning list1 and list2 to l and l2
    public DateGUI(DateList L, DateList L2){
    	list1=L; //unsorded linkedlist
    	list2=L2; // sorded linkedlist
    }
    //This method is used for call and display the Jframe with east and west border
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
            sorted.append("Sorted Birthdays: "+ "\n");
            	//This loop will print unsorted date of birth array that we get from the List
                DateNode current=list1.getHead().next; // assigning head to current value
                while(current!=null){ //loop will continue till its get to null
                	unsorted.append(current.printDate()+"\n"); // Printing unsorted Date by calling printDate method
                	current=current.next; //collecting the next node from Linked list 
                }
                // 
                DateNode tracker = list2.getHead().next;
                while(tracker!=null){
                	sorted.append(tracker.printDate()+"\n"); //this one printing sorted date 
                	tracker=tracker.next;
                }
            
           //Setting up East and West Border
            obj.add(unsorted,BorderLayout.WEST);
            obj.add(sorted,BorderLayout.EAST);
            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.pack();
            obj.setVisible(true);
    	}
        
    }
