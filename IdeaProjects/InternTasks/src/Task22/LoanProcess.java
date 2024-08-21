package Task22;

public interface LoanProcess {
    public double calculateEligibleAmount(double salary, double obligations , int years, int bank);
    public void loanProcessing(double loan , double months, double amount,int bank);

    public void printStatement(Salary salary);
}