package java_coursework; // Stating the following is in java_coursework package.

import java.util.ArrayList; // importing Array List library.
import java.util.List; // importing List library.
import java.util.Scanner; // importing Scanner library.

public class question_3 { // declaring public class.

    private String moduleName; // declaring private string integer - moduleName.
    private int size; // declaring private integer - size.
    private int Marks[]; // declaring private integer array - Marks.

    public question_3(String ModuleName) { // declaring public method with a String return type (ModuleName).
        this.moduleName = ModuleName; // Referencing to the current object moduleName and assigning it to the String value ModuleName.
        this.size = 0;// Referencing to the current object size and assigning it's value to 0.
        this.Marks = null; // Referencing tom the current object Marks and assigning it to a value of null.
    }// end of method.

    public String toString() { // declaring public String method (toString).
        return "Module Name: " + moduleName; // returning a string (Exam Result:) along with the moduleName string variable.
    }// end of method.

    public void readMarks() { // declaring public void readMarks.

        System.out.println("Please enter grades within a range of 0 to 100");// Printing out prompt message.
        System.out.println("Enter a negative value to exit");// Printing out prompt message.
        Scanner user_in = new Scanner(System.in); // creating scanner object (scan).

        size = 0; // declaring integer (size) and assigning a value of 0.

        List<Integer> inputList = new ArrayList<Integer>(); // Declaring and creating a new Array list carrying integer objects.
        boolean running = true; // declaring and setting the boolean variable running to true.
        do { // declaring do while loop.
            int grade = user_in.nextInt(); // declaring an integer variable (grade) and assigning the value of the integers inputed into program via the scanner object.
            if (grade < 0) { // if statement states that if the integer inputed into the program is negative then the following code will be executed.
                running = false; // setting running boolean to false.
                break; // breaking out of the do while loop.
            }

            inputList.add(grade); // adding integer values (grades) into the List (inputList) using the .add attribute built into Java. 
        } while (running); // While the running boolean is true the following do while loop shall continue to run infinitely.

        Marks = new int[inputList.size()]; // Assigning new integer objects from values inputed into the List (inputList) into the Marks array.
        for (int i = 0; i < inputList.size(); i++) { // using a for loop to loop through the List and take values by their indices.
            Marks[i] = inputList.get(i); // Storing the values collected from the List (inputList) by their indices and storing those values into the Marks array.
            size++; // incrementing the size variable by 1.
        }// end of for loop. 
    }// end of method.

    public String getModuleName() {// declaring string method.
        return moduleName; // returning the string variable (moduleName).
    }// end string method.

    public int getMin() { // declaring a public integer method (getMin) to get the lowest grade inputed by the user.
        if (Marks != null && size > 0) { // if statement is used to say if the Marks array is not empty and the number of grades (size) is larger than 0 execute the following code.
            int minValue = Marks[0]; // declaring an integer variable (minValue) and assigning it to the first index within the array Marks.
            for (int i = 1; i < Marks.length; i++) { // for loop looping through the length of Marks array to find the lowest value inputed into the array.
                if (Marks[i] < minValue) { // if statement stating that if the Marks index i is less than the minValue integer the following line of code will be executed.
                    minValue = Marks[i]; // setting the minValue variable to the Marks index i if the grade inputed by user is lower than a previous grade inputed.
                }// end of if statement.
            }// end of for loop.
            return minValue;
        }// end of if statement.

        return -1; // returning -1 value.
    }// end of method.

    public int getMax() { // declaring a public integer method (getMax) to get the highest grade inputed by the user.

        if (Marks != null && size > 0) { // if statement is used to say if the Marks array is not empty and the number of grades (size) is larger than 0 execute the following code.
            int maxValue = Marks[0];// declaring an integer variable (maxValue) and assigning it to the first index within the array Marks.
            for (int i = 1; i < Marks.length; i++) {// for loop looping through the length of Marks array to find the highest value inputed into the array.
                if (Marks[i] > maxValue) {// if statement stating that if the Marks index i is more than the maxValue integer the following line of code will be executed.
                    maxValue = Marks[i]; // setting the maxValue variable to the Marks index i if the grade inputed by user is higher than a previous grade inputed.
                }// end of if statement.
            }// end of for loop.
            return maxValue; // returning maxValue integer.
        }// end of if statement.

        return -1; // return -1.
    } // end of method.

    public int numberOfGradeA() { // declaring public integer method (numberOfGradeA).

        int count = 0; // declaring integer variable count and assigning value of 0.
        if (Marks != null && size > 0) { // if statement stating that if Marks array is empty (has no values) and the size of grades inputed is larger than 0 , execute the following.
            for (int mark: Marks) { // for loop used to loop through all of the integer values inputed into the Marks array.
                if (mark >= 70 && mark <= 100) { // if statement stating that if the mark integer variable is between 70 and 100 the following code shall be executed.
                    count++; // incrementing count variable by 1 and therefore incrementing number of A grades.
                }// end of if statement.
            }// end of for loop.
        }// end of if statement.

        return count; // return count variable.
    }// end of method.

    public int numberOfGradeB() { // declaring public integer method (numberOfGradeB).

        int count = 0;// declaring integer variable count and assigning value of 0.
        if (Marks != null && size > 0) { // if statement stating that if Marks array is empty (has no values) and the number of grades inputed is larger than 0 , execute the following.
            for (int mark: Marks) {// for loop used to loop through all of the integer values inputed into the Marks array.
                if (mark >= 60 && mark <= 69) { // if statement stating that if the mark integer variable is between 60 and 69 the following code shall be executed.
                    count++; // incrementing count variable by 1 and therefore incrementing number of B grades.
                }// end of if statement.
            }// end of for loop.
        }// end of if statement.

        return count;// return count variable.
    }// end of method.

    public int numberOfGradeC() { // declaring public integer method (numberOfGradeC).

        int count = 0; // declaring integer variable count and assigning value of 0.
        if (Marks != null && size > 0) {  // if statement stating that if Marks array is empty (has no values) and the number of grades inputed is larger than 0 , execute the following.
            for (int mark: Marks) {// for loop used to loop through all of the integer values inputed into the Marks array.
                if (mark >= 50 && mark <= 59) {// if statement stating that if the mark integer variable is between 50 and 59 the following code shall be executed.
                    count++; // incrementing count variable by 1 and therefore incrementing number of C grades.
                }// end of if statement.
            }// end of for loop.
        }// end of if statement.

        return count;// return count variable.
    }// end of method.

    public int numberOfGradeD() { // declaring public integer method (numberOfGradeD).

        int count = 0;// declaring integer variable count and assigning value of 0.
        if (Marks != null && size > 0) {// if statement stating that if Marks array is empty (has no values) and the number of grades inputed is larger than 0 , execute the following.
            for (int mark: Marks) { // for loop used to loop through all of the integer values inputed into the Marks array.
                if (mark >= 40 && mark <= 49) {// if statement stating that if the mark integer variable is between 40 and 49 the following code shall be executed.
                    count++;// incrementing count variable by 1 and therefore incrementing number of D grades.
                }// end of if statement.
            }// end of for loop.
        }// end of if statement.

        return count; // return count variable.
    }// end of method.

    public int numberOfGradeF() { // declaring public integer method (numberOfGradeF).

        int count = 0;// declaring integer variable count and assigning value of 0.
        if (Marks != null && size > 0) {// if statement stating that if Marks array is empty (has no values) and the number of grades inputed is larger than 0 , execute the following.
            for (int mark: Marks) {// for loop used to loop through all of the integer values inputed into the Marks array.
                if (mark >= 0 && mark <= 39) { // if statement stating that if the mark integer variable is between 40 and 49 the following code shall be executed.
                    count++;// incrementing count variable by 1 and therefore incrementing number of F grades.
                }// end of if statement.
            }// end of for loop.
        }// end of if statement.

        return count;// return count variable.
    }// end of method.

    public void printReport() { // declaring a public method (printReport).

        if (size > 0) {// if statement stating that if the size of grades inputed is larger than 0 the following code shall be executed.
            System.out.println(toString());
        	System.out.println("Number of A grades: " + numberOfGradeA()); // printing out the number of A grades.
            System.out.println("Number of B grades: " + numberOfGradeB()); // printing out the number of B grades.
            System.out.println("Number of C grades: " + numberOfGradeC()); // printing out the number of C grades.
            System.out.println("Number of D grades: " + numberOfGradeD()); // printing out the number of D grades.
            System.out.println("Number of F grades: " + numberOfGradeF()); // printing out the number of F grades.

            System.out.println("Lowest Grade:" + getMin()); // printing out the lowest grade inputed.
            System.out.println("Highest Grade:" + getMax());// printing out the highest grade inputed.
        } else { // else statement used to execute the following.
            System.out.println("No correct data entered");// print out error message.
        }// end of else statement.
    }// end of method.

    public static void main(String[] args) {// declaring main class.
        
        question_3 examResult = new question_3("Computer Science"); // creating a new ExamResult object with the moduleName as Computer Science.
        try { // try statement used to execute following.
            examResult.readMarks(); // readMarks from the examResult class.
            examResult.printReport();// printReport from the examResult class.
        } catch (Exception e) { // if the try does not work then use catch to throw an error message.
            System.out.println(e.getMessage()); // printing error message.
        }// end of catch statement.
    }// end of main class.
}// end of public class.
/*
Referencing:
   lectures + lecture material for referring to.
   labs + lab material for referring to.
*/