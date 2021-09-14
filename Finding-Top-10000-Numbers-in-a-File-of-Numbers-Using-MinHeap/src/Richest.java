//Chase Christiansen

/*DESCRIPTION:
This class is the location for the main method and main is the only method here. Main is for creating the output file,  
creating the scanner for the file passed in the parameters, initializing the array of 10000 elements, reading in the 
first 10000 elements from the file into the array, calling the Finder class method heapSort to sort the 10000 elements, 
comparing the rest of the elements in the file to the heap to see if they have a place in it, and printing out the top
10000 elements into the output file called output.txt.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Richest {

	public static void main(String[] args) throws FileNotFoundException {		
		try {
			File file = new File("output.txt");	
		    if(file.createNewFile()) {									//creating a file output.txt to store the top 10000 elements from the input file.
		    	System.out.println("File created: " + file.getName());
		    }
		    else{
		        System.out.println("File already exists.");
		    }
		}
		catch(IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}	
		Scanner scanner = new Scanner(new File(args[0]));				//creating a scanner to read the text file argument provided.
		int[] array = new int[10000];									//initializing an array of size 10000.
		int count = 0;
		while(scanner.hasNextInt() && count < array.length) {			//reading in the first 10000 values in the input file into the array.
			array[count++] = scanner.nextInt();
		}
			
		Finder find = new Finder();										//initializing the Finder class.
		find.heapSort(array, array.length);								//calling the Finder class heapSort method.
			
		while(scanner.hasNextInt()) {
			String nextS = scanner.next();								//while the input file still has values after the first 10000, check them
			int next = Integer.parseInt(nextS);							//one by one with the insert function to see if it larger than the smallest
			find.insert(array, next);									//element currently in the array. Then sort the content of the array and repeat
		}																//for the rest of the values in the input stream.
		
		try {
			FileWriter myWriter = new FileWriter("output.txt");			//creating a FileWriter object to write the 10000 element of the array into the
			int count1 = 0;												//output.txt file. It prints each index of the array of 10000 in descending order.
			while(count1 < 10000) {
		    myWriter.write(array[count1] + "\n");
		    count1++;
			}    
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		} 
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}
}
