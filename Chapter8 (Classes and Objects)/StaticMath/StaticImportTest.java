package Chapter8.StaticMath;
import static java.lang.Math.*;

// Static import of Math class methods
public class StaticImportTest {

	public static void main(String[] args) {
		System.out.printf("sqrt(900.0) = %.1f%n", sqrt(900.0));
		System.out.printf("ceil(-9.8) = %.1f%n", ceil(-9.8));
		System.out.printf("E = %f%n", E);
		System.out.printf("PI = %f%n", PI);
	}

}
