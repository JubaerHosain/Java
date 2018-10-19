package Chapter9;

// CommissionEmployee class test program.
public class ComissionEmployeeTest {
	public static void main(String[] args) {
		// instantiate CommissionEmployee object
		ComissionEmployee employee = new ComissionEmployee("Sue", "Jones", "222-22-2222", 1000, .06);
		
		// get commission employee data
		System.out.println("Employee information obtained by get methods:");
		System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee.getLastName());
		System.out.printf("%s %s%n", "Social security number is", employee.getSSN());
		System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
		
		employee.setGrossSales(5000);
		employee.setCommissionRate(.1);
		System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
	}

}
