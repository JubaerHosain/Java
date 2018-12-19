import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {
	public static void main(String[] args) {
		
		String[] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};
		
		// display original strings
		System.out.printf("Original strings: %s%n", Arrays.asList(strings));
		
		// string in uppercase
		System.out.printf("strings in uppercase: %s%n", Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList()));
		
		// string less than "n" (case insensitive) sorted ascending
		System.out.printf("strings less than n sorted ascending: %s%n", Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0).collect(Collectors.toList()));
		
		// string less than "n" (case insensitive) sorted descending
		System.out.printf("string less than n sorted descending: %s%n", Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") < 0).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList()));
		
		// string greater than "n" (case insensitive) sorted 
		System.out.printf("strings greater than n sorted: %s%n", Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("n") > 0).collect(Collectors.toList()));

	}

}
