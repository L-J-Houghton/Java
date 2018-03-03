package java_coursework; // Declaring package java_coursework.

import java.util.*; // import Java utilities package.

public class ExamResults{ // declaring public class.
	
	public static void main(String[]args){ // declaring main class.
		Scanner user_input = new Scanner(System.in); // creating scanner object with the name 'input'.
		int totalGrades,Grade,minGrade,maxGrade,sum,highest,lowest; // declaring integer variable totalGrades,Grade,minGrade,maxGrade,sum,highest,lowest.
		Grade = 0; // grade variable set to 0 and shall contain the current grade entered by user.
		totalGrades = 0; // totalGrades set to 0 and shall hold the value of the total grades inputed by user.
		minGrade = 0; // minGrade set to 0 and shall contain the minimum grade out of user input.
		maxGrade = 0; // maxGrade set to 0 and shall contain the minimum grade out of user input.
		sum = 0; // sum set to 0 and shall contain the sum of all grades entered by user input.
		highest = 0; // highest set to 0 and shall be used to measure highest grade entered by user input.
		lowest = 0; // lowest set to 0 and shall be used to measure lowest grade entered by user input.
		double average = 0; // declaring double variable 'average' to calculate average of grades and assigning value of 0.

		
		int A=0; // Assigning value of integer A grade to 0.
		int B=0; // Assigning value of integer B grade to 0.
		int C=0; // Assigning value of integer C grade to 0.
		int D=0; // Assigning value of integer D grade to 0.
		int F=0; // Assigning value of integer F grade to 0.
		
		System.out.println("Please enter grades within a range of 0 to 100, enter a negative value when finished "); // prints out a prompt for the user.
		
		do{ // declare do / while loop statement.
			
			Grade = user_input.nextInt(); // assigns the variable 'Grade' to the input from the scanner object which takes in the integer values from user.
			if(Grade != -1){ // if statement states that if the grade is not negative then add the 'Grade' variable to the 'sum' variable to add total.
				sum = sum + Grade;// Assigning the 'sum' variable with the value of the existing value of 'sum' plus the value of the 'Grade' variable input by the user.
			} // end if statement.
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
			}// end of do statement.
		
		}while(Grade >= 0); // Declaring a while statement that will allow the program to run infinitely as long as the 'Grade' variable value is positive.
		
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
		
	} // end of main class.
	
} // end of public class.
/*
Referencing:
   lectures + lecture material for referring to.
   labs + lab material for referring to.
*/