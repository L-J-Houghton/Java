package java_coursework; // declaring package.


import java.util.ArrayList; // importing ArrayListy library.
import java.util.Collections; // importing collections library.
import java.util.List; // importing List library.
import java.util.Scanner; // importing scanner library.
 
public class question_4_Levenshtein // declaring public class.
{
    public static int distance(String x, String y) // declaring public static integer method that shall return two strings x and y.
    {
        x = x.toLowerCase();// converting x string value all to lower case using toLowerCase method.
        y = y.toLowerCase();// converting x string value all to lower case using toLowerCase method.
        int[] cost = new int[y.length() + 1]; // declaring cost array to an integer object that will store the length within the matrix to measure distance and therefore cost.
        for (int j = 0; j < cost.length; j++){// for loop whilst the statement is true , j should be less than length of the cost array.
        	
            cost[j] = j; // assigning the index within the cost array to the value of j which shall increment everytime the for loop os run.
        }
        for (int i = 1; i <= x.length(); i++){// for loop whilst the statement is true , i should be less than length of x variable.
        	
            cost[0] = i; // setting the first index within the cost array to that of the value i which shall increment everytime the for loop is run.
            
            int nd = i - 1; // setting the variable nd to that of the variable i - 1
            
            for (int j = 1; j <= y.length(); j++){// loop through the matrix column (y) as long as the local variable j is less than the length of the matrix column (y).
            
                int cd = Math.min(1 + Math.min(cost[j], cost[j - 1]) , x.charAt(i - 1) == y.charAt(j - 1) ? nd : nd + 1); // declaring variable cd which will store the minimum cost / distance between two strings using the min.Math method built into java.
                // ternary operator is used to say rather than if statement to complete the math.min arguments.
                nd = cost[j];// Assigning variable nd to the cost index of j , where j increments everytime the loop is run.
                
                cost[j] = cd; // Assigning the variable cd declared above to that of the index within the cost array. 
                
            }// end of for loop.
        }// end of for loop.
        return cost[y.length()]; // return the index of the cost of the distance within the matrix.
    }
 
    public static void main(String[] args){ // declaring main method.
    	
        Scanner scan = new Scanner(System.in); // declaring scanner object.
        String text = "This is to test the levenshtein algorithm implementation in Java"; // string variable to test program.
        System.out.println("Enter the a word to search: "); // user prompt.
        
        String keyword = scan.nextLine(); // takes in the input string from the user.
        
        String[] info = text.split(" "); // taking input from within the program and using split method to ignore whitespace.
        
        List<Integer> lev_dist = new ArrayList<Integer>(); // declaring an arrayList distance to store integers related to the distance.
        
        for (int i = 0; i < info.length; i++){ // loop through the data to find the distance between the user input string and the string within the program.
        	
            lev_dist.add(distance(info[i], keyword)); // adds the keyword inputed into the lev_dist arrayList.
            
        }// end of for loop.
        Collections.sort(lev_dist); // using the collections library to sort the arrayList distance in order.
        
        System.out.print("Closest match: "); // user question message.
        for (int i = 0; i < info.length; i++){// loops through the data array.
        	
            if (distance(info[i], keyword) == lev_dist.get(0)){ // if the distance between the user input string (keyword) and the string within the program is 0 , execute following.
            	
                System.out.print(info[i] + " "); // prints out the string that has a the minimum distance value (first within the arrayList distance).
                
            }// end of if statement.
        }// end of for loop.
        scan.close(); // close the scanner.
    } // end of main method.
}// end of public class.
/*
Referencing:
   lectures + lecture material for referring to.
   labs + lab material for referring to.
*/