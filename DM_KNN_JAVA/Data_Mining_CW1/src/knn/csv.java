package knn;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csv {

    public static void main(String[] args) {

        String csvFile = "adult.test.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] earns = line.split(cvsSplitBy);

                System.out.println("Earn:" + earns[14]);
                
            }
            if((line = br.readLine()) == null){
            	br.close();
            	System.out.println("End of file");
            	
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
