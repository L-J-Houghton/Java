package java_coursework; // Stating the following is in java_coursework package.
import java.util.Scanner; // importing Scanner library.
import java.io.File; // importing File library.
import java.io.FileNotFoundException; // importing file not found library.
import java.util.Arrays; // importing Arrays library.

public class question_2{ // declaring public class.
	
	final static String filename = "Marks.txt"; // Declaring a final static string called filename which is used within the input/output File library and assigning value of "Marks.txt" which will be the input file.

	   public static void main(String[] args) { // declaring main class.

	      Scanner scan = null; // Assigning the scanner object to null.
			int totalGrades = 0; // declaring integer variable 'totalGrades' and assigning value of 0.
			int Grade = 0; // declaring integer variable 'Grade' and assigning value of 0.
			int minGrade = 0; // declaring integer variable 'minGrade' and assigning value of 0.
			int maxGrade = 0; // declaring integer variable 'maxGrade' and assigning value of 0.
			double average = 0; // declaring double variable 'average' to calculate average of grades and assigning value of 0.
			int sum = 0; // declaring integer variable 'sum' to add the total score together and assigning value of 0.
			int highest = 0; // declaring integer variable 'highest' to determine the highest grade and assigning value of 0.
			int lowest = 0; // declaring integer variable 'lowest' to determine the lowest grade and assigning value of 0.
			// declaring integer variables A to F which will be used to hold the number of grades achieved.
			int A=0; // Assigning value of integer A grade to 0.
			int B=0; // Assigning value of integer B grade to 0.
			int C=0; // Assigning value of integer C grade to 0.
			int D=0; // Assigning value of integer D grade to 0.
			int F=0; // Assigning value of integer F grade to 0.
	      File input_file = new File(filename); // Creating a new File object using the String variable assigned above and therefore allows "Marks.txt" to be stored within the object.
	      try { // try block start.
	         scan = new Scanner(input_file); // assigning the scanner object with that of the File object containing "Marks.txt" declared above.
	      } catch (FileNotFoundException e) { // file not found exception will be used if the file is not found and code below shall be executed.
	         System.out.println("File not found, try again."); // prints out message to user "File not found".
	         System.exit(0); // exit and end program if file is not found.
	      }

	      int total = 0; // Assigning total integer to value of 0.
	      boolean found_Integers = false; //flag to see if there are any integers if there are the boolean will be set to true.

	      while (scan.hasNextLine()) { // while the file the scanner object is scanning has strings the code below shall be executed. 
	         String currentLine = scan.nextLine(); // assigning the string variable currentLine with the value of the strings on each line within text file Marks.txt.
	         String names[] = currentLine.split(" "); // storing all the strings within an array 'words' and ignoring any blank spaces by using the split method built into java.

	         
	         for(String strings : names) { //For each string value in the array (line) words, execute the following code.
	            try { // try statement used to execute the following for each string within the array 'words'.
	               int num = Integer.parseInt(strings); // declare and assign an integer variable num and assign parsed integer values within the strings allowing only integers to be assigned to 'num' variable.
	               Grade = num; // assign Grade variable to the num variable collected in above line of code.
	               found_Integers = true; // once the above code has been executed successfully the foundInts boolean will be set to true.
	               
	    			if(Grade != -1){  // if statement states that if the grade is not negative then add the 'Grade' variable to the 'sum' variable to add total.
	    				sum = sum + Grade; // Assigning the 'sum' variable with the value of the existing value of 'sum' plus the value of the 'Grade' variable input by the user.
	    			} //end if statement.
	    			if(Grade >= 0){ // if statement that allows 'totalGrades' to increment by value of 1 every time the user inputs a positive integer.
	    				totalGrades++; // increments 'totalGrades' by value of 1.
	    				
	    			if(Grade >= 70 && Grade <= 100){ // if statement used to distinguish if the 'Grade' integer inputed by user is between 70 and 100 the value of integer 'A' will increment by 1.
	    				 A++; // increment 'A' integer by value of 1.
	    			} // end of statement.
	    			if(Grade >= 60 && Grade <= 69){ // if statement used to distinguish if the 'Grade' integer inputed by user is between 60 and 69 the value of integer 'B' will increment by 1.
	    				 B++; // increment 'B' integer by value of 1.
	    			} // end of statement.
	    			if(Grade >= 50 && Grade <= 59){ // if statement used to distinguish if the 'Grade' integer inputed by user is between 50 and 59 the value of integer 'C' will increment by 1.
	    				 C++; // increment 'C' integer by value of 1.
	    			} // end of statement.
	    			if(Grade >= 40 && Grade <= 49){ // if statement used to distinguish if the 'Grade' integer inputed by user is between 40 and 49 the value of integer 'D' will increment by 1.
	    				 D++; // increment 'D' integer by value of 1.
	    			} // end of statement.
	    			else if(Grade >= 0 && Grade <= 39){ // else if statement used to distinguish if the 'Grade' integer inputed by user is between 0 and 39 the value of integer 'F' will increment by 1.
	    				 F++; // increment 'F' integer by value of 1.
	    			} // end of statement.
	    			if(Grade < lowest){ // if statement states that if the 'Grade' variable / value is less than the 'lowest' variable the 'lowest' variable will assigned to the lowest 'Grade' variable inputed.
	    				lowest = Grade; // assigns 'lowest' variable to the lowest 'Grade' variable value.
	    			} // end if statement.
	    			if(Grade > highest){ // if statement states that if the 'Grade' variable / value is more than the 'highest' variable the 'highest' variable will assigned to the highest 'Grade' variable inputed.
	    				highest = Grade; // assigns 'highest' variable to the highest 'Grade' variable value.
	    			} // end of if statement.
	    			}

	            }catch(NumberFormatException nfe) { }; //if the word is not an integer, do nothing.
	         }
	      } //end of while loop.

	      if(!found_Integers)
	         System.out.println("No numbers have been found."); // if the boolean foundInts remains to be false by the end of program then this message shall appear.
	      else
	  		average = sum / totalGrades; // Assigning the 'average' variable to that of the 'sum' variable divided by 'totalGrades' to calculate the average of the grades.
			System.out.println("Number of grades entered:"+ totalGrades+"\n"); // Print out the total number of grades inputed by user.
			System.out.println("Number of A grades:"+ A +"\n"); // prints out the number of A grades inputed by user.
			System.out.println("Number of B grades:"+ B +"\n"); // prints out the number of B grades inputed by user.
			System.out.println("Number of C grades:"+ C +"\n"); // prints out the number of C grades inputed by user.
			System.out.println("Number of D grades:"+ D +"\n"); // prints out the number of D grades inputed by user.
			System.out.println("Number of F grades:"+ F +"\n"); // prints out the number of F grades inputed by user.
			System.out.println("Highest Grade:"+ highest +"\n"); // prints out the highest value inputed by the user.
			System.out.println("Average Grade:"+ average +"\n"); // prints out the average of all the values inputed by the user.
			System.out.println("Lowest Grade:"+ lowest); // prints out the lowest value inputed by the user.

	      
	      scan.close();// close the scanner object 'scan'
	   } // end main class.
}// end public class.
/*
Referencing:
   lectures + lecture material for referring to.
   labs + lab material for referring to.
*/