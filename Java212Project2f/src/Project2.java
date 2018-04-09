import java.io.BufferedReader;
/**
 * Goal is to collect Date of Birth from TextFile in order of YearmonthDate 
 * Send valid Date of Birth to DateGui class to print them in sorted and unsorted way 
 * @author Mohammed J Islam
 *Garbage Data will print in the console that collected from TextFile
 *Also check for Valid date of birth like month can't be "month<0||month>31" 
 *Date also has to be in the range of date. Length of the Date of Birth has to be eight. 
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Project2 {
	//this array method collect Data from file by using file reader and bufferreader and send the array to mainfunction
    public static String []readarray(String file) throws IOException{
        int counter=0;
        try{
            BufferedReader br1= new BufferedReader (new FileReader (file)); // create object to read file 
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
            
            String[] words= new String[counter];
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s=br.readLine();
            int i=0;
            while(s!=null){
                StringTokenizer str= new StringTokenizer(s,",");
            while(str.hasMoreTokens()){
                words[i]=str.nextToken();
                i++;
                }
            s=br.readLine();
            }
            br.close();
            return words; //Returning Data
        }
        catch (FileNotFoundException e){
            System.out.println("Sorry no such a file on this name");// <if file not fount this message will print
        }
        
        return null;
    }
   
    public static void main(String[] args)throws Exception {
        
        int size=0,k=0,l=0;
        int dates[]; //created an array to store Valid DOB from Input file
        String garbage[];//created an array to store garbage value from Input file
        String[] arr=readarray("InputeFile");
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()==8 && isItaNumber(arr[i])&& isitValid(arr[i])){ //checking for validity
                size++;
            }
        }  
        dates=new int[size]; //use this array to store valid DOB 
        garbage= new String[50];
        System.out.println("garbage outputs:");
        for(int i=0; i<arr.length;i++){
        	//to check if the DOB is valid.
            if(arr[i].length()==8  && isItaNumber(arr[i]) && isitValid(arr[i])){//Calling isItNumber and isItValid method to check Validity
                dates[k]=Integer.parseInt(arr[i]); // Passing string to integer to store in date array
                k++; 
            }
            else{    
            garbage[l]=arr[i];//<storing garbage value
            System.out.println(garbage[l]); //<printing garbage value 
            l++;
            }
        }

        //JFrame O = new JFrame();
        DateGUI g = new DateGUI(dates); //create object g for DateGui class
        g.create(); // create method from DateGui
        print(dates);
        Date212 collection[]= new Date212[dates.length];
        DateNode nodes[]= new DateNode[40];
        DateList list= new DateList();
        DateList list2= new DateList();
        for(int i=0;i<collection.length;i++){
        	collection[i]=new Date212(dates[i]);
        	nodes[i]=new DateNode(collection[i]);
        	list.append(nodes[i]);
        	list2.insert(nodes[i]);
        }
        list.print();
        System.out.println();
        list2.print();
    }
    // this is boolean method checking all string is in integer order.
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
    public static void print(int array[]){
    	for(int i=0; i<array.length; i++){
    		System.out.println(array[i]+ " ");
    	}

    }
    
}