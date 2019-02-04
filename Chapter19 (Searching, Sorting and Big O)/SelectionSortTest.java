package Ch19;

import java.security.SecureRandom;
import java.util.Arrays;

// Sorting an array with selection sort
public class SelectionSortTest {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();
		
		// create unordered array of 10 random ints
		int[] data = generator.ints(10, 10, 91).toArray();
		
		System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
		selectionSort(data);
		System.out.printf("%nSorted array: %s%n", Arrays.toString(data));
	}
	
	// sort array using selection sort
	public static void selectionSort(int[] data) {
		// loop over data length - 1 elements
		for(int i=0; i<data.length;i++) {
			// first index of remaining array
			int smallest = i;
			
			// loop to find index of smallest element
			for(int index = i + 1; index < data.length; index++) {
				if(data[index] < data[smallest]) {
					smallest = index;
				}
			}
			
			// swap smallest element into position
			swap(data, i, smallest); 
			//output pass of algorithm
			printPass(data, i+1, smallest);
		}
	}
	
	// helper method to swap values in two elements
	private static void swap(int[] data, int first, int second) {
		// store first in temporary
		int temporary = data[first];
		// replace first with second
		data[first] = data[second];
		// put temporary in second
		data[second] = temporary;
	}
	
	// print a pass of the algorithm
	private static void printPass(int[] data, int pass, int index) {
		System.out.printf("after pass %2d: ", pass);
		
		// output elements till selected item
		for(int i=0; i<index; i++) {
			System.out.printf("%d ", data[i]);
		}
		
		// indicate swap
		System.out.printf("%d* ", data[index]);
		
		// finish outputting array
		for(int i=index+1; i<data.length; i++) {
			System.out.printf("%d  ", data[i]);
		}
		
		System.out.printf("%n               ");  // for alignment
		
		// indicate amount of array that's sorted
		for(int j=0; j<pass; j++) {
			System.out.print("-- ");
		}
		
		System.out.println();
	}
}
