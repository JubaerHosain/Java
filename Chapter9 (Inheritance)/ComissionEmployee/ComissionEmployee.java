package Chapter9;

// This class represents an employee paid a percentage of glass sales 
public class ComissionEmployee extends Object{
	private final String firstName;
	private final String lastName;
	private final String ssn;
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage
	
	// Constructor
	public ComissionEmployee(String firstName, String lastName, String ssn, double grossSales, double commissionRate) {
		// implicit call to Object's default constructor occurs here
		
		//if grossSales is invalid throw exception
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		// if commissionRate is invalid throw exception
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and <¢°.0");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	// return first name
	public String getFirstName() {
		return firstName;
	}
	
	// return last name
	public String getLastName() {
		return lastName;
	}
		
	// return ssn name
	public String getSSN() {
		return ssn;
	}
	
	// set gross sales amount
	public void setGrossSales(double grossSales) {
		if(grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		
		this.grossSales = grossSales;
	}
	
	// return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}
	
	// set commission rate
	public void setCommissionRate(double commissionRate) {
		if(commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		
		this.commissionRate = commissionRate;
	}
	
	// return commission rate 
	public double getCommissionRate() {
		return commissionRate;
	}
	
	// calculate earning 
	public double earnings() {
		return commissionRate * grossSales;
	}
	
	// return String representation of CommissionEmployee object
	@Override // indicates that this method overrides a superclass method
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "Commission employee",
				firstName, lastName, "socual security number", ssn, "gross sales", grossSales, "commission rate", commissionRate);
	}
}
