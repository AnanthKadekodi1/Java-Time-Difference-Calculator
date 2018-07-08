/*************************************************
Java Assignment 1 Part 2
Author - Ananth Kadekodi
Date - 12/9/2016
File Name - JavaAssignmentq2.java
Purpose - To calculate the difference of two inputted times
Assumptions - 1) Input is entered in a proper format (i.e. hh:mm a/pm)
*             2) Output is presented in a difference of minutes
*             3) The time entered is in a 12 hour format with hours (1-2 digits), colon, minutes (2 digits) and then the string am or pm
*             4) The minutes entered should be less than 60 (cannot be 12.75 pm)
*             5) The time is to be entered in 1 line
*****************************************************/
package javaassignmentq2; 
import java.util.Scanner; // Import scanner class

public class JavaAssignmentq2 {

    public static void main(String[] args) {
        
        JavaAssignmentq2 object = new JavaAssignmentq2(); // Create a new object
        
        // List of objects
        object.studentInfo();
        System.out.println("");
        object.getInfo();
            
    } // End of main
    
    
    public void studentInfo(){ /// Function to print out student information
        System.out.println("Student Name: Ananth Kadekodi");
        System.out.println("Student Number: 32920719");
        System.out.println("Mode of Enrolment: External");
        System.out.println("Tutor Name: Dr. Mark Abernethy");
        System.out.println("Tutorial Attendance: External"); 
    } // End of studentInfo
    
    public void getInfo(){
        
        Scanner keyboard = new Scanner(System.in); //Keyboard created as scanner class

        // Declare variables
        String time1;
        String time2;
        String substrhr1 = "";
        String substrmin1 = "";
        String substrhr2 = "";
        String substrmin2 = "";
        char chrOption = '0';
        char chrInput = '0';
        int intHrs1;
        int intMin1;
        int intHrs2;
        int intMin2;
        int intHrsValue1;
        int intMinValue1;
        int intHrsValue2;
        int IntMinValue2;
        int timeDifference;
        int result;

        // Do-while loop to ensure that the program proceeds with correct choice
        do {
            System.out.println("Enter first time (hh:mma/pm: ");
            time1 = keyboard.nextLine(); // Read in first time
            System.out.println("");

            System.out.println("Enter second time (hh:mma/pm): ");
            time2 = keyboard.nextLine(); // Read in second time

            /// Convert string input to lower case
            String Str1 = time1;
            String Str2 = time2;
            String lower1 = Str1.toLowerCase();
            String lower2 = Str2.toLowerCase();


            // If-else loop for converting substring
            if((lower1.indexOf(":") == 1) && (lower2.indexOf(":") == 2))
            {
                substrhr1 = lower1.substring(0,1);
                substrmin1 = lower1.substring(2,4);
                substrhr2 = lower2.substring(0,2);
                substrmin2 = lower2.substring(3,5);
            } else if((lower1.indexOf(":") == 2) && (lower2.indexOf(":") == 1))
                {
                    substrhr1 = lower1.substring(0,2);
                    substrmin1 = lower1.substring(3,5);
                    substrhr2 = lower2.substring(0,1);
                    substrmin2 = lower2.substring(2,4);
                } else if((lower1.indexOf(":") == 1) && (lower2.indexOf(":") == 1))
                    {
                        substrhr1 = lower1.substring(0,1);
                        substrmin1 = lower1.substring(2,4);
                        substrhr2 = lower2.substring(0,1);
                        substrmin2 = lower2.substring(2,4);     
                    } else
                        {
                            substrhr1 = lower1.substring(0,2);
                            substrmin1 = lower1.substring(3,5);
                            substrhr2 = lower2.substring(0,2);
                            substrmin2 = lower2.substring(3,5);
                        }

            // Convert substring to integers      
            intHrs1 = Integer.parseInt(substrhr1);
            intMin1 = Integer.parseInt(substrmin1);
            intHrs2 = Integer.parseInt(substrhr2);
            intMin2 = Integer.parseInt(substrmin2);
            
            result = substrhr1.compareToIgnoreCase(substrhr2);
            
            
            

            // If-else statements to calculate the total time difference
             if((lower1.indexOf('a') == -1) && (lower2.indexOf('a') == -1) && (intMin1 <= 60) && (intMin2 <= 60) && (result < 0) && (intHrs1 >=0 && intHrs1 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12)){
                timeDifference = Math.abs((((intHrs1+12)*60)+intMin1) - (((intHrs2+12)*60)+intMin2));
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if((lower1.indexOf('a') != -1) && (lower2.indexOf('a') == -1) && (intMin1 <= 60) && (intMin2 <= 60) && (result < 0) && (intHrs1 >= 0 && intHrs1 <= 12) && (intHrs2 >=0 && intHrs2 <= 12)) {
                timeDifference = Math.abs((720-((intHrs1*60)+intMin1)) + ((intHrs2*60)+intMin1));         
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if(((lower1.indexOf('a') != -1) && (lower2.indexOf('a') != -1) && (intMin1 <= 60) && (intMin2 <= 60) && (result > 0) && (intHrs1 >= 0 && intHrs1 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12))){
                timeDifference = Math.abs(((intHrs2*60)+intMin1) - ((intHrs1*60)+intMin2));
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if((lower1.indexOf('a') == -1) && (lower2.indexOf('a') != -1) && (intMin1 <= 60) && (intMin2 <= 60) && (intHrs1 >= 0 && intHrs1 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12)){
                timeDifference = Math.abs((((24-(intHrs1+12))*60)+intMin1) - ((intHrs2*60)+intMin2));   
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if (((lower1.indexOf('a') != -1) && (lower2.indexOf('a') != -1) && (intMin1 <= 60) && (intMin2 <= 60)) && (result < 0) && (intHrs1 >= 0 && intHrs1 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12)) {
                timeDifference = Math.abs((((24-intHrs1)*60)+intMin1) + ((intHrs2*60)+intMin2));
                System.out.println("The time difference is " + timeDifference + " minutes"); 
            } else if((lower1.indexOf('a') == -1) && (lower2.indexOf('a') == -1) && (intMin1 <= 60) && (intMin2 <= 60) && (result > 0) && (intHrs1 >= 0 && intHrs1 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12)) {
                timeDifference = Math.abs((720-((intHrs1*60)+intMin1)) + (((intHrs2*60)+intMin2)+720));
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if((lower1.indexOf('a') != -1) && (lower2.indexOf('a') == -1) && (intMin1 <= 60) && (intMin2 <= 60) && (result > 0) && (intHrs1 >= 0 && intHrs2 <= 12) && (intHrs2 >= 0 && intHrs2 <= 12)) {
                timeDifference = Math.abs((((intHrs2*60))+intMin2) - ((intHrs1*60)+intMin1));         
                System.out.println("The time difference is " + timeDifference + " minutes");
            } else if(intMin1 >= 60){
                 System.out.println("Error: The First time is invalid");
            } else {
                System.out.println("Error: The second time is invalid");
            }

            System.out.println("Do you wish to continue (Y/N)");
            chrInput = keyboard.next().charAt(0); /// 
            chrOption = Character.toUpperCase(chrInput); //Convert all inputed characters to upper case
            keyboard.nextLine(); //Clear the keyboard input
        } while (chrOption == 'Y'); // End of do-while loop
        
    } // End of function
   
}// End of class