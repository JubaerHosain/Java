package Chapter10.PayableInterface;

// Employee abstract superclass that implements Payable
public abstract class Employee implements Payable{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	
	//Constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	// reutrn first name
	public String getFirstName() {
		return firstName;
	}
	
	// reutnr last name
	public String getLastName() {
		return lastName;
	}
	
	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	// return String representation of Employee object
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(), getLastName(), getSocialSecurityNumber());
	}
	
	// abstract method must be overriden by concrete subclasses
	public abstract double earnings(); 
	
	// implementing getPaymentAmount here enables the entire Employee class hierarchy to be used in an app that processes Payables
	public double getPaymentAmount() {
		return earnings();
	}
}
