package MultiThreadingExample;

public class Credit extends Thread {
    private final double creditAmount;

    public Credit(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Override
    public void run() {
        synchronized (ATM.class) {
            try {
                if (this.creditAmount < 0) {
                    throw new Exception("The amount is not valid");
                } else {
                    ATM.balance += this.creditAmount;
                    System.out.println("Amount " + creditAmount + " is added and balance is " + ATM.balance);

                    // Notify any waiting threads
                    ATM.class.notifyAll();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
