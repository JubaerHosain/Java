
public class Account {
	private String name;
	private double balance;
	
	public Account(String name, double balance) {
		//System.out.println("Account Class: " + name);
		this.name = name;
		
		if(balance > 0.0) {
			this.balance = balance;
		}
	}
	
	public void deposit(double depositAmount) {
		if(depositAmount > 0.0) {
			balance = balance + depositAmount;
		}
	}
	
	public double getBalanace(){
		return balance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		//System.out.println("Account Class: " + name);
		return name;
	}
}
