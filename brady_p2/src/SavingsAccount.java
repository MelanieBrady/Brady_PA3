public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public static void modifyInterestRate(double newValue) {
        annualInterestRate = newValue;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = savingsBalance * (annualInterestRate / 12);
        savingsBalance += monthlyInterest;
    }


    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

}
