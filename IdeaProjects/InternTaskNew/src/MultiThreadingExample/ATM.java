package MultiThreadingExample;

public class ATM
{

    static double balance = 1000;

    public static void main(String[] args) throws InterruptedException {

        Debit deb = new Debit(200);
        Credit cred = new Credit(4000);

        Thread thread1 = new Thread(deb);
        Thread thread2 = new Thread(cred);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join(3000);

        System.out.println("The Balance amount after all the transaction: "+balance);
    }

}
