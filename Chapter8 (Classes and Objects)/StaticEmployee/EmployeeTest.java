package Chapter8.StaticEmployee;

// static number demonstration
public class EmployeeTest {

	public static void main(String[] args) {
		// show that count is 0 before creating Employee
		System.out.printf("Employees before instantiation: %d%n", Employee.getCount());
		
		// create two Employees; count should be 2
		Employee e1 = new Employee("Susan", "Baker");
		Employee e2 = new Employee("Bob", "blue");
		
		// show that count is 2 after creating two Employees
		System.out.printf("%nEmployee after instatiation:%n");
		System.out.printf("via el.getCount(): %d%n",e1.getCount());
		System.out.printf("via e2.getCount(): %d%n", e2.getCount());
		System.out.printf("via Employee.getCount(): %d%n", Employee.getCount());
		
		// get names of Employees
		System.out.printf("%nEmployee 1: %s %s%nEmployee 2: %s %s%n",e1.getFirstName(), e1.getLastName(), e2.getFirstName(), e2.getLastName());
	}

}
