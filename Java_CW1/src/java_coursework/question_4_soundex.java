package java_coursework; // stating package.

public class question_4_soundex { // declaring public class.
	 
	    public static String soundex_implement(String s) {  // declaring public static method with a string return type of s.
	        
	    	char[] value = s.toUpperCase().toCharArray(); // creating an array that will hold char variables , also ensuring all using toUpperCase and toCharArray to ensure all values are upper case and char variables.
	        
	    	char initial_Letter = value[0]; // Assigning the initial / first letter within the array to a index of 0 within the array value.

	        // below switch/ case statements will be used to convert letters to numeric code also for the soundex code.
	        for (int j = 0; j < value.length; j++) { // loop through the array value whilst j is less than the length of the array, incrementing j on each cycle.
	           
	        	switch (value[j]) { // switch statement with the value of local variable j to determine possible number of possible execution paths.

	        	case 'J': // declaring case statement with char variable of J.
	        	
                case 'Q': // declaring case statement with char variable of Q.
                	
                case 'C': // declaring case statement with char variable of C.
                	
                case 'X': // declaring case statement with char variable of X.
                	
                case 'G': // declaring case statement with char variable of G.
                	
                case 'Z': // declaring case statement with char variable of Z.
                	
                case 'K': // declaring case statement with char variable of K.
                	
                case 'S': // declaring case statement with char variable of S.
	                	
	                      value[j] = '1'; // set value index j to 1.
	                    
	                break; // break out of the case.
	                
		            case 'P':// declaring case statement with char variable of P.
                	
	                case 'V': // declaring case statement with char variable of V.
	                	
	                case 'B': // declaring case statement with char variable of B.
	                	
	                case 'F': // declaring case statement with char variable of F.
	                	
	                      value[j] = '2'; // set value index j to 2.
	                
	                break; // break out of the case.

	                case 'T': // declaring case statement with char variable of T.
	                	
	                case 'D': // declaring case statement with char variable of D.
	                	
	                     value[j] = '3'; // set value index j to 3.
	                    
	                break; // break out of the case.

	                case 'L': // declaring case statement with char variable of L.
	                	
	                    value[j] = '4';  // set value index j to 4.
	                    
	                break; // break out of the case.

	                case 'N': // declaring case statement with char variable of N.
	                	
	                case 'M': // declaring case statement with char variable of M.
	                	
	                    value[j] = '5';  // set value index j to 5.
	                    
	                    break; // break out of the case.

	                case 'R': // declaring case statement with char variable of R.
	                	
	                    value[j] = '6';  // set value index j to 6.
	                    
	                    break; // break out of the case.

	                default: // declaring default case.
	                	
	                    value[j] = '0';  // set value index j to 0.
	                    
	                    break; // break out of the default case.
	                    
	            }// end of switch statement.
	        }// end of for loop.

	        // below loop shall remove duplicates.
	        String output_code = "" + initial_Letter; // declaring output string and assigning value of whitespace along with the initialLetter char variable.
	        for (int l = 1; l < value.length; l++){ // using for loop to loop through the array value and incrementing l on every cycle of loop.
	        	
	            if (value[l] != value[l-l] && value[l] != '0'){ // if the array value has an index of 0 , execute the following code.
	            	
	            	output_code += value[l]; // keep adding the value at index 1 within the value array to the output variable.
	            	
	        }// end of if statement.
	        }//end of for loop.
	        output_code = output_code + "0000"; // pad the output with 0's or truncate output string.
	        
	        return output_code.substring(0, 4); // return the output as a substring with index from 0 to 4.
	    }// end of method.


	    public static void main(String[] args) {// declaring main method.
	        String word_1 = "Hello"; // assigning input string.
	        String word_2 = "World"; // assigning input string.
	        String code_1 = soundex_implement(word_1); // passing the input string through the method.
	        String code_2 = soundex_implement(word_2); // passing the input string through the method.
	        System.out.println(code_1 + "  --->  " + word_1); // printing soundex code along with the original string input.
	        System.out.println(code_2 + "  --->  " + word_2); // printing soundex code along with the original string input.
	    }// end of main method.
	}// end of public class.

/*
Referencing:
   lectures + lecture material for referring to.
   labs + lab material for referring to.
*/