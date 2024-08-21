package MultiThreadingExample;

public class Debit extends Thread {
    private final double debitAmount;

    public Debit(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    @Override
    public void run() {
        synchronized (ATM.class) {
            try {
                // Wait until balance is greater than 2000
                while (ATM.balance <= 2000) {
                    System.out.println("Waiting for balance to be greater than 2000. Current balance: " + ATM.balance);
                    ATM.class.wait();
                }

                if (this.debitAmount > ATM.balance) {
                    throw new Exception("The amount cannot be debited: insufficient balance");
                } else {
                    ATM.balance -= this.debitAmount;
                    System.out.println("Amount " + debitAmount + " is debited from the account and balance is " + ATM.balance);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
