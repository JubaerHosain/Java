package Chapter9;

// private superclass members cannot be accessed in subclass
public class BasePlusCommissionEmployee extends ComissionEmployee{
	private double baseSalary;
	
	// six-argument constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String ssn, double grossSales,
			double commissionRate, double baseSalary) {
		// explicit call to superclass CommissionEmployee constructor
		super(firstName, lastName, ssn, grossSales, commissionRate);
		
		// if baseSalary is invalid throw exception
		if(baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		
		this.baseSalary = baseSalary;
	}
	
	// set base salary
	public void setBaseSalary(double baseSalary) {
		if(baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		
		this.baseSalary = baseSalary;
	}
	
	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}
	
	// calculate earnings
	@Override // indicates that this method overrides a superclass method
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}
	
	// return String representation of BasePlusCommissionEmployee
	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f", "based-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
