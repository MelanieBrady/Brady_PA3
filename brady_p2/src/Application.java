public class Application {

    private static final int MONTHS_OF_SAVINGS = 12;

    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);

        SavingsAccount.modifyInterestRate(.04);

        for (int i = 1; i < MONTHS_OF_SAVINGS + 1; i++ ) {
            System.out.printf("\n\nMonth %d with 4%% interest", i);

            saver1.calculateMonthlyInterest();
            System.out.printf("\nSaver1 Balance: $%.2f", saver1.getSavingsBalance());

            saver2.calculateMonthlyInterest();
            System.out.printf("\nSaver2 Balance: $%.2f", saver2.getSavingsBalance());
        }

        System.out.print("\n\nAfter first year with 4%% interest");
        System.out.printf("\nSaver1 Balance: $%.2f", saver1.getSavingsBalance());
        System.out.printf("\nSaver2 Balance: $%.2f", saver2.getSavingsBalance());


        SavingsAccount.modifyInterestRate(.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.print("\n\nNext month at 5%% interest");
        System.out.printf("\nSaver1 Balance: $%.2f", saver1.getSavingsBalance());
        System.out.printf("\nSaver2 Balance: $%.2f", saver2.getSavingsBalance());


    }

}
