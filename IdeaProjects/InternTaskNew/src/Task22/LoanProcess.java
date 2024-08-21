package Task22;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public interface LoanProcess {
    public double calculateEligibleAmount(double salary, double obligations , int years, int bank);
    public void loanProcessing(double loan , double months, double amount,int bank);

    public void printStatement(Salary salary);
}


