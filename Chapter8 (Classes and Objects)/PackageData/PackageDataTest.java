package Chapter8.PackageData;


// Package-access members of a class are accessible by other classes
// in the same package.
public class PackageDataTest {

	public static void main(String[] args) {
		PackageData packageData = new PackageData();
		
		// output String representation of packageData
		System.out.printf("After instanitation:%n%s%n", packageData);
		
		// change package access data in packageData Object
		packageData.number = 77;
		packageData.string = "Good Bye";
		
		// output Strng representation of packageData
		System.out.printf("%nAfter changing value:%n%s%n", packageData);

	}

}
