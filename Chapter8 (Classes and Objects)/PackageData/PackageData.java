package Chapter8.PackageData;

// class with package access instance variables
public class PackageData {
	int number = 0; // package-access instance variable
	String string = "Hello"; // package-access instance variable
	
	//return PackageData object String representation
	public String toString() {
		return String.format("number: %d; string: %s", number, string);
	}
}
