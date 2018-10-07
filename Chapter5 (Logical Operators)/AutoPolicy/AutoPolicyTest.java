package Chapter5;

public class AutoPolicyTest {

	public static void main(String[] args) {
		
		AutoPolicy p1 = new AutoPolicy(111111111, "Toyota Camry", "NJ");
		AutoPolicy p2 = new AutoPolicy(111111111, "Honda Accord", "FL");
		
		policyInNoFaultState(p1);
		policyInNoFaultState(p2);
	}

	public static void policyInNoFaultState(AutoPolicy policy) {
		System.out.println("The auto policy:");
		System.out.printf("Account #: %d; Car: %s;%nState %s %s a no fault state%n%n", policy.getAccountNumber(), policy.getMakeAndModel(), policy.getState(), (policy.isNoFaultState() ? "is": "is not"));
	}
}
