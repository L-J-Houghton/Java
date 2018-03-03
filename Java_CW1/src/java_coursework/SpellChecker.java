package java_coursework; // Stating the following is in java_coursework package.

import java.io.*; // import input/output library.
import java.util.*;// import utilities library.

public class SpellChecker { // declaring public class.

    private static int max_suggestion = 5; // declaring a private static integer variable and assigning it with the value of 5.

    private List<String> words; // declaring a private list of string type.
    private List<String> source;  // declaring a private list of string type.
    private boolean dictionaryLoad; // declaring private boolean variable.
    private boolean sourceLoad; // declaring private boolean variable.

    private List<String> output;  // declaring a private list of string type.

    public SpellChecker() {// declaring a public method.
        words = new ArrayList<String>(); // creating an ArrayList which shall contain strings.
        source = new ArrayList<String>(); // creating an ArrayList which shall contain strings.
        dictionaryLoad = false; // declaring and setting boolean to false.
        sourceLoad = false; // declaring and setting boolean to false.

        output = new ArrayList<String>(); // creating an ArrayList object which shall contain strings.
    }

    public void add_Dictionary(String word) {// declaring public method to add words to the dictionary file with a String (word).
        words.add(word); // using the add attribute to add the string variable word to the array list.
    }// end of method.

    public boolean loadDict(String fileName) {// declaring a public boolean to tell whether the dictionary file has been loaded.

        dictionaryLoad = load_input_file(fileName, words, true); // if the fileName is found and words array list exists and set the boolean value to true.
        return dictionaryLoad; // return the boolean value after the above has been executed if not the boolean will return false.
    } // end of method.

    public boolean loadInput(String fileName) { // declaring a public boolean to tell whether the source file has been loaded.

        source.clear(); //reset
        sourceLoad = load_input_file(fileName, source, false); // if the fileName is found and source array list exists and set the boolean value to true.
        return sourceLoad; // return the boolean value after the above has been executed if not the boolean will return false.
    }// end of method.

    private boolean load_input_file(String fileName, List<String> destinationArr, boolean uniqueOnly) { // declaring a boolean with multiple returns which will check to see if the file has been loaded successfully.

        destinationArr.clear(); //clearing List.
        boolean isLoaded = false; // setting boolean to false until the file has been loaded successfully.

        BufferedReader in = null; // setting the Buffer reader object value to null.
        try { // try statement is used load file into the program.
            in = new BufferedReader(new FileReader(fileName)); // create a BufferedReader object and within that object creating another object that reads/loads the file content.
            String read; // declaring string variable read.
            while ((read = in.readLine()) != null) { // while loop used to execute the following code whilst the file has string data and is not empty / null.
                String[] chunks = read.split("\\s+"); // storing all strings collected from the file into the chunks array and using the split attribute to exclude whitespace.
                Collections.addAll(destinationArr, chunks); // collection.addAll method is used to add all of the specified elements to the specified collection.
            }// end of while loop.

            if (uniqueOnly) { // if statement used to state that if the boolean variable uniqueOnly is true execute the following code.
                //leave unique words in the dictionary only
                Set<String> uniqueWords = new LinkedHashSet<String>(); // Declaring a LinkedHashSet that will contain any string that does not exist in dictionary and is inputed by the input file.
                uniqueWords.addAll(destinationArr); // using the addAll method to add the strings within the List (destinationArr) to the uniqueWordsList set.
                if (uniqueWords.size() < words.size()) { // if statement stating that if the size of the Set  (uniqueWordSet) is less than the amounts of strings within the words List then execute the following.
                    destinationArr.clear(); // clearing List using clear method.
                    destinationArr.addAll(uniqueWords); // using addAll method to add all the unique strings in the set that are not in the dictionary and added them to destinationArr List.
                }// end of if statement.
            }// end of if statement.

            isLoaded = true; // setting boolean variable to true.
        } catch (FileNotFoundException e){ // catch used if file cannot be found and/or if code above in try statement is not executed.
            System.out.println("Error: That file cannot be found."); // printing out error.
            e.printStackTrace();// Throws the error that has occurred in the above code.
        } catch (IOException e) {// catch used if code above in try statement is not executed.
            System.out.println("Error: The file may be locked. It cannot be read from properly.");// printing out error.
            e.printStackTrace();// Throws the error that has occurred in the above code.
        } finally { // finally used to execute the below code whether the an exception error is handled or not.
            try { // try statement executes the below code.
                if (in != null) { // if statement , stating that if the Buffered reader object reaches a null value within the file execute following code.
                    in.close(); // close the Buffered Reader.
                }// end of if statement.
            } catch (Exception e) { // catch exception will throw error if try statement does not work
                e.printStackTrace();// Throws the error that has occurred in the above code.
            }// end of catch statement.
        }// end of finally statement.

        return isLoaded; // return the boolean variable with a true or false value.
    } // end of method.

    public void saveDictionary(String fileName) {// declaring public method that saves new words to the dictionary and has a string type which will be the file name.
        saveFile(fileName, words); // saveFile method used to save the dictionary file as well as the new words added.
    }// end of method

    public void saveSource(String fileName) { // declaring public method that will save the changes made to the outputSource file.
        saveFile(fileName, output); // saving changes to the outputSource (output file).
    }// end of method.

    private void saveFile(String fileName, List<String> sourceArr) { // declaring a private method that will return the String filename and the arrayList that will hold the string data within the input file.

        FileWriter writer = null; // declaring a FileWriter object and assigning a value of null to it.
        try { // try statement used to execute following code.
            writer = new FileWriter(fileName); // assigning the string filename to the FileWriter object created above.
            for (String word: sourceArr) { // for all Strings (word) within the arrayList of sourceArr , execute following code.
                writer.write(word);// write method to write Strings to the output file.
                writer.write(" ");// write method to write whitespace to the output file.
            }// end of for loop.

            writer.close(); // close writer.
        } catch (IOException e) {  // catch exception will throw error if try statement does not work
            System.out.println("Error: unable to save file: " + fileName); // print out error message.
            e.printStackTrace();// Throws the error that has occurred in the above code.
        } finally {// finally used to execute the below code whether the an exception error is handled or not.
            try { // try statement used to execute following code.
                if (writer != null) { // if the writer does not reach a value of null then execute the following code.
                    writer.close(); // close writer.
                }// end if statement.
            } catch (Exception e) {// Throws the error that has occurred in the above code.
                e.printStackTrace();// Throws the error that has occurred in the above code.
            }// end of catch statement.
        }// end of finally statement.
    }// end of method.

    public void processSource() { // declaring public method to process the source file.

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // reads the information taken in from the console.

        output.clear(); //clear the arrayList outputSource.

        try { // declaring try statement , execute following code.
            for (String word : source) { // for all word string variables within the source arrayList , execute following code.
                List<String> suggestions = findClosest(word);
                System.out.println("Testing word `" + word + "`"); // prints out message.
                if (suggestions.isEmpty()) { // if suggestions arrayList is empty , execute the following.
                    System.out.println("That word `" + word + "` is correctly spelled."); // prints out message.
                    output.add(word); // add the string (word) to the ouput arrayList and in turn to the output file.
                } else { // else , execute following.
                    //go through the suggestions and ask user to accept one of them
                    for (int i = 0; i < suggestions.size(); ++i) { // loop through the arrayList suggestions.
                        System.out.println("Did you mean `" + suggestions.get(i) + "`? Press " + i); // prints out user prompt/suggestion.
                    }// end for loop.

                    System.out.print("Press number of suggestion or NO if you don't accept suggestions >> ");// prints out user prompt.

                    String response = input.readLine(); // Assign string variable response to the scanner input from the user input.
                    final String regex = "[0-" + (suggestions.size()-1) + "]"; // 
                    // otherwise, ask the user if they want to add their version of the word to the dictionary.
                    if (response.equalsIgnoreCase("NO")) { // if the user input is NO then execute the following code.
                        System.out.print("Do you want to add this word to the dictionary? YES/NO >> "); // prints out user prompt.
                        response = input.readLine(); // take in user input and assign it to 
                        if (response.equalsIgnoreCase("YES")) {
                            add_Dictionary(word); // add the word read by the reader and add to the dictionary output file by adding it to the arrayList words.
                            output.add(word); // add the word read by the reader and add to the output file by adding it to the arrayList source.
                        } // end of if statement.
                    } else if (response.matches(regex)) { // else if the string response matches that of the regex string , execute the following.
                        //user agreed that they meant the suggestion
                        //we need to write this word in the output result.txt file instead of the "wrong" one
                        String selectedSuggestion = suggestions.get(Integer.parseInt(response)); // takes integer from the user input and parses it to a string which is then assigned to the selectedsuggestion string.
                        System.out.println("User selected `" + selectedSuggestion + "` suggestion! write it to file"); // prints out final message.

                        output.add(selectedSuggestion); // add the suggestion made by the user to the outputSource arrayList and therefore to the output file.
                    }// end of else if statement.
                    
                }// end of else statement.
            }
        } catch (IOException e) { // catch exception will throw error if try statement does not work.
            System.out.println("ERROR: Cannot take keyboard input.");// printing out error.
        }// end of catch statement.
    }// end of method.

    private int findDiff(String inputWord, String testWord) { // declaring private integer with the string return types to return the inputed word and the test word.

        int x, y; // declaring two integers x (input) and y (tester)which shall be used to calculate the cost / distance.
        char word1Holder, word2Holder; // declaring two char variables that will act as word holders within the progam.
        int up, left, diagonal; // declaring three variables which will measure the cost and distance.

        x = inputWord.length(); // assigning variable with the length of the string inputed.
        y = testWord.length(); // assigning variable with the length of the string inputed.

        // if one of the words is empty (a length of zero), the levenshtein distance
        // is simply the length of the input word.
        if (x == 0) { // if statement states that if the input string has a value of 0 then the test word is identical to the test word as the distance is 0.
            return y; // return test integer.
        } // end of if statement.

        if (y == 0) {  // if statement states that if the test string has a value of 0 then the test string is identical to the input word as the distance is 0.
            return x; // return input integer.
        } // end of if statement.

        int[][] Lev_Matrix = new int[x + 1][y + 1]; // creating a new matrix with n columns and m rows.

       
        for (int i = 0; i <= x; i++) { // for loop runs through the matrix.
            Lev_Matrix[i][0] = i;// instantiate the rows with the numbers 0 to n
        } // end of for loop.

        for (int i = 0; i <= y; i++) { // for loop runs through the matrix.
        	Lev_Matrix[0][i] = i; // instantiate the columns with the numbers 0 to n
        } //end of for loop.

        // go through the entire matrix. get the character at i column of the input word and j row of the test word.
        for (int i = 1; i <= x; i++) { // for loop runs through matrix to find the position the char variable.
            word1Holder = inputWord.charAt (i - 1); // assign the position within the input / matrix to the wordholder variable.

            for (int j = 1; j <= y; j++) { // for loop runs through matrix to find the position the char variable.
                word2Holder = testWord.charAt (j - 1); // assign the position within the input / matrix to the wordholder variable.

                // find the values of the cell directly above and to the left of the current cell.
                // add one to each of these variables.
                up = Lev_Matrix[i - 1][j] + 1; // assigning a value to the above variable to store the distance within the matrix.
                left = Lev_Matrix[i][j - 1] + 1; // assigning a value to the left variable to store the distance within the matrix.

                // if the two characters are equal, their cost is zero. find the value of the diagonal.
                if (word1Holder == word2Holder) { // if the  first word holder is equal to that of the second word holder , execute the following.
                    diagonal = Lev_Matrix[i - 1][j - 1];  // assigning a value to the diagonal variable to store the distance within the matrix.
                } else { //  else , execute the following.
                    diagonal = Lev_Matrix[i - 1][j - 1] + 1; // if they are not, the cost is 1. find the value of the diagonal + 1.
                } // end of else statement.

                Lev_Matrix[i][j] = findTheMin(up, left, diagonal); // find the minimum of the three values (above, left, and diagonal.
            } // end of for loop.
        } // end of for loop.
        return Lev_Matrix[x][y]; // return the value of the cell to the bottom right of the matrix. this is the levenshtein distance.
    } // end of method.

    private int findTheMin(int x, int y, int z) { // declaring a private method containing integers a , b and c to find minimum value / distance.

        return Math.min(x, Math.min(y, z)); // return the variable containing the minimum value, using the in built math.min method.
    } // end of method.

    public List<String> findClosest(String inputWord) { // declaring a List containing strings , also returning the string that has been inputed.

        List<String> result = new ArrayList<String>(); // declaring a new arrayList (result) to hold the values (closest matching strings) in the below code.

        int smallestDist = 100; // assigning the smallest distance to value of 100.
   
        for (String word: words) {// going through each word to find the word with the least levenshtein distance.
            int holder = findDiff(inputWord, word); // set the holder variable with the difference between the inputed word and the word within the word arrayList.

            if (holder < smallestDist) { // if the current word in the list has a shorter levenshtein distance than the last minimum, set it to the minimum.
                smallestDist = holder; // setting the smallest distance variable with the value of the holder variable.
                result.add(word); // the word shall be added to the result arrayList.
            } // end of if statement.
        } // end of for loop.


        // if the minimum distance is 0, the word is spelled correctly, so the list should be empty
        if (smallestDist == 0) { // if the smallest distance has a value of 0, execute the following line.
            result.clear(); // clear the strings within the results arrayList.
        } else { // end of else statement.
            Collections.reverse(result); //return the closest matching most relevant words in the list.
            if (result.size() > max_suggestion) {// if the size of the results arrayList is larger than that of the maximum suggestions variable , execute the following.
                result = result.subList(0, max_suggestion); // return first MAXIMUM_SUGGESTIONS_COUNT suggestions only.
            }// end of if statement.
        } // end of else statement.

        return result; // return result variable.
    }// end of method.

    public static void main(String[] args) {// declaring main method.

        SpellChecker levenshtein = new SpellChecker(); // creating new object for spell checker.

        boolean dictLoaded = levenshtein.loadDict("dictionary.txt"); // loading local dictionary file.
        boolean sourceLoaded = levenshtein.loadInput("source.txt"); // loading local input file.

        if (!dictLoaded) { // if dictionary does not load , execute the following.
            System.out.println("Error: unable to load dict file: " + "dict.txt"); // prints out error.
        }// end of if statement.
        if (!sourceLoaded) { // if input file does not load , execute the following.
            System.out.println("Error: unable to load source file: " + "source.txt");// prints out error.
        }// end of if statement.

        if (dictLoaded && sourceLoaded) { // if the dictionary and input file loads , execute the following.
        	levenshtein.processSource(); // call the processSource method.
        	levenshtein.saveDictionary("dictionary_output.txt"); // save/print out to the dictionary output file.
        	levenshtein.saveSource("source2.txt");// save/print out to the output file.
        }// end of if statement.
    }// end of main method.
}// end of public class.
/*
 Referencing:
    lectures + lecture material for referring to.
    labs + lab material for referring to.
 */
