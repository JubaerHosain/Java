package Ch17;

import java.util.stream.IntStream;

// Triple the even ints from 2 through 10 then sum them with IntStream
public class StreamFilterMapReduce {
	public static void main(String[] args) {
		// sum the even integers from 2 through 20
		System.out.printf("Sum of the triple of the even integers from 2 through 20 is: %d%n", 
				IntStream.rangeClosed(1, 10)			
						 .filter(x -> x%2 == 0)
						 .map(x -> x*3)
						 .sum());						
	}

}
