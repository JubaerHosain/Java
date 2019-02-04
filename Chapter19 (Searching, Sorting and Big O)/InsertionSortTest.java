package Ch19;

import java.security.SecureRandom;
import java.util.Arrays;

// Sorting an array with insertion sort.
public class InsertionSortTest {

	public static void main(String[] args) {
		SecureRandom generator = new SecureRandom();
		
		// create unordered array of 10 random ints
		int[] data = generator.ints(10, 10, 91).toArray();
		
		System.out.printf("Unsorted array: %s%n%n", Arrays.toString(data));
		insertionSort(data); // sort array
		System.out.printf("%nSorted array: %s%n", Arrays.toString(data));
	}
	
	// sort array using insertion sort
	public static void insertionSort(int[] data) {
		// loop over data.length - 1 elements
		for(int next=1; next<data.length; next++) {
			int insert = data[next]; // value to insert
			int moveItem = next; // location to place element
			
			// search for place to put current element
			while(moveItem > 0 && data[moveItem -1] > insert) {
				// shift element right one slot
				data[moveItem] = data[moveItem -1];
				moveItem--;
			}
			
			// place inserted element
			data[moveItem] = insert; 
			// output pass of algorithm
			printPass(data, next, moveItem);
		}
	}
	
	// print a pass of the algorithm
	public static void printPass(int[] data, int pass, int index) {
		System.out.printf("after pass %2d: ", pass);
		
		// output elements till swapped item
		for(int i=0; i<index; i++) {
			System.out.printf("%d ", data[i]);
		}
		
		// indicate swap
		System.out.printf("%d* ", data[index]);
		
		// finish outputting array
		for(int i=index+1; i<data.length; i++) {
			System.out.printf("%d ", data[i]);
		}
		
		// for alignment
		System.out.printf("%n               ");
		
		System.out.println();
	}

}
