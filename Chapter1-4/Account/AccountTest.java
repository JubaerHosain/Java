import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		Account account1 = new Account("Henry Li", 100.01);
		Account account2 = new Account("Emma Weng", 50.02);
		
		System.out.printf("%s's balance: $%.2f%n", account1.getName(), account1.getBalanace());
		System.out.printf("%s's balance: $%.2f%n", account2.getName(), account2.getBalanace());
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter deposit amount for account1: ");
		double depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
		account1.deposit(depositAmount);
		
		System.out.printf("%s's balance: $%.2f%n", account1.getName(), account1.getBalanace());
		System.out.printf("%s's balance: $%.2f%n", account2.getName(), account2.getBalanace());
	}

}