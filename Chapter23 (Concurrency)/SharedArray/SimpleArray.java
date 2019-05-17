package CH23.SharedArray;

import java.security.SecureRandom;
import java.util.Arrays;

// Class that manages an integer array to be shared by multiple threads.
public class SimpleArray {  // Warning: Not thread safe!
	private static final SecureRandom generator = new SecureRandom();
	private final int[] array; // the shared integer array
	private int writeIndex = 0; // shared indext of next element to write
	
	// construct a SimpleArray of a given size
	public SimpleArray(int size) {
		array = new int[size];
	}
	
	// add a value to the shared array
	public void add(int value) {
		int position = writeIndex; // store the write index
		
		try {
			// put thread to sleep for 0-499 ms
			Thread.sleep(generator.nextInt(500));
		}
		catch (InterruptedException ex) {
			Thread.currentThread().interrupt();  // re-interrupt the thread
		}
		
		// put value in the appropriate element
		array[position] = value;
		System.out.printf("%s write %2d to element %d.%n", Thread.currentThread().getName(), value, position);
		
		++writeIndex;  // increment index of element to be written next
		System.out.printf("Next write index: %d%n", writeIndex);
	}
	
	// used for outputting the contents of the shared integer array
	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}
