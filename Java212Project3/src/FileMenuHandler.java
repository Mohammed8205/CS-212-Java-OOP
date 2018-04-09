/**
 * File Menu Handler is used to handle the Gui and the menu bar.
 * Goal is to collect Date from TextFile in order of YearmonthDate 
 * Send valid Date of Birth to FileMenu handler and it prints in sorted and unsorted way by uisng JFrame 
 * @author Mohammed J Islam
 * this classs called node and LinkedList class to store date
 * 
 * Also check for Valid date of birth like month can't be "month<0||month>31" 
 * Date also has to be in the range of date. Length of the Date of Birth has to be eight. 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class FileMenuHandler implements ActionListener { // Action Listener helps to handle action of the event
   JFrame jframe;
   public FileMenuHandler (JFrame jf) {
      jframe = jf;
   }
   public void actionPerformed(ActionEvent event) { //Action performed helps to performed as File Menu Handler was setup for.
      String  menuName;
      menuName = event.getActionCommand();
      if (menuName.equals("Open"))// when user choice equel to open then it called openFile methood
		try {
			openFile( );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else if (menuName.equals("Quit"))// if user choose quite then program terminated
         System.exit(0);
   } //actionPerformed

    private void openFile( ) throws IOException {
       JFileChooser chooser;
       int          status;
       chooser = new JFileChooser( );
       status = chooser.showOpenDialog(null);
       if (status == JFileChooser.APPROVE_OPTION) 
          readSource(chooser.getSelectedFile());//calling readSource file
       else 
          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    } //openFile
  
    private void readSource(File chosenFile) throws IOException {
       //String chosenFileName = chosenFile.getName();
       //String input;
       Container myContentPane = jframe.getContentPane();
       TextArea sorted = new TextArea();
       TextArea unsorted = new TextArea();
       sorted.append("Sorted BirthDays: "+"\n");// display message in the gui
       unsorted.append("Unsorted BirthDays: "+"\n");
       myContentPane.add(sorted, BorderLayout.EAST); // setteng up direction of the border
       myContentPane.add(unsorted, BorderLayout.WEST);
       int counter=0;
       String arr[]=null;
       try{
           BufferedReader br1= new BufferedReader (new FileReader ("InputeFile")); // create object to read file 
           String s1=br1.readLine();
           while(s1!=null){// it will read  file till s1 not = null
               StringTokenizer comma = new StringTokenizer(s1,", "); //StringTokenizer will separate the string by looking , 
               while(comma.hasMoreTokens()){ //it will continue run till has more token
                   counter++;
                   comma.nextToken();
               }    
               s1=br1.readLine(); //readingline and put it to s1
           }
           br1.close(); // its just close the file extract from everything
           
           arr= new String[counter];
           BufferedReader br = new BufferedReader(new FileReader("InputeFile"));
           String s=br.readLine();
           int i=0;
           while(s!=null){
               StringTokenizer str= new StringTokenizer(s,",");
           while(str.hasMoreTokens()){
               arr[i]=str.nextToken();
               i++;
               }
           s=br.readLine();
           }
           br.close();
            //Returning Data
       }
       catch (FileNotFoundException e){
        System.out.println("Sorry no such a file on this name");// <if file not fount this message will print
       
   }    
       int size=0,k=0,l=0;
       int dates[]; //created an array to store Valid DOB from Input file
       String garbage[];//created an array to store garbage value from Input file
       
       for(int i=0; i<arr.length; i++){
           if(arr[i].length()==8 && isItaNumber(arr[i])&& isitValid(arr[i])){ //checking for validity
               size++;
           }
       }  
       dates=new int[size]; //use this array to store valid DOB 
       garbage= new String[50];
      // System.out.println("garbage outputs:");
       for(int i=0; i<arr.length;i++){
       	//to check if the DOB is valid.
           if(arr[i].length()==8  && isItaNumber(arr[i]) && isitValid(arr[i])){//Calling isItNumber and isItValid method to check Validity
               dates[k]=Integer.parseInt(arr[i]); // Passing string to integer to store in date array
               k++; 
           }
           else{    
           garbage[l]=arr[i];//<storing garbage value
           
           l++;
           }
       }
       Date212 collection[]= new Date212[dates.length]; // Collection is a object of class Date212
       DateNode nodes[]= new DateNode[collection.length]; // Creating nodes object  
       DateNode nodes2[] = new DateNode[nodes.length]; // Creating nodes2 object
       String valid[]= new String [dates.length]; // Creating array for Valid date 
       for(int i=0 ; i<valid.length; i++){
       	StringBuilder s = new StringBuilder();
       	s.append(dates[i]);
       	valid[i]=s.toString(); // Storing for valid date to string
       
       }
       UnsortedDateList list= new UnsortedDateList();  // Creating a object list of datelist 
       SortedDateList list2= new SortedDateList(); // Creating a object list2 of datelist  
       for(int i=0;i<collection.length;i++){
       	collection[i]=new Date212(valid[i]); // Collecting year from Date212 
       	 
       }
       for(int i=0;i<nodes.length;i++){
       	nodes[i]= new DateNode(collection[i]);  // creating new nodes 
       	nodes2[i]= new DateNode(collection[i]); // creating new nodes2
       	//System.out.println("From Nodes: "+nodes[i].data.getYear());
       }
       for(int i=0;i<nodes.length;i++){
       	list.add(nodes[i]); // adding nodes to linkedlist
       }
       for(int i=0;i<nodes.length;i++){
       	list2.add(nodes2[i]); //adding nodes2 to linkedlies after sort
       }
       DateNode current=list.getHead().next; // assigning head to current value
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
       
     jframe.setVisible(true);  
    }
    public static boolean isItaNumber(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9')//checking integer of char
                return false;
        }

        return true;
    }
    //this is a boolean method that check every DOB is in order, if it is, it returns to true to store data in the date array. 
    public static boolean isitValid(String s){
    	// Creating character array
        char check[]= new char[s.length()];
        for(int i=0 ;i<check.length;i++){
            check[i]=s.charAt(i); //assigning every index in the character array 
        }
        String year =""; //Create string for year by using loop.
        for(int i=0; i<4;i++){
            year+=check[i];
        }
        // This check if year is greater than 2016 or less then 2016 then it return false
        if(Integer.parseInt(year)>2016 || Integer.parseInt(year)<0)return false;
        String month=""; //this string for month doing samething as it did for year
        for(int i=4;i<6;i++)
            month+=check[i];
        if(Integer.parseInt(month)<0 || Integer.parseInt(month)>12)return false;
        String days="";
        for(int i=6;i<8;i++)
            days+=check[i];
        if(Integer.parseInt(days)<0 || Integer.parseInt(days)>31)return false;
        
        return true;
               }

}