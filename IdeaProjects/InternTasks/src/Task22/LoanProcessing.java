package Task22;

public class LoanProcessing implements LoanProcess
{

    @Override
    public double calculateEligibleAmount(double salary, double obligations , int years , int bank) {
        double amount = 0;
        final double FOIR = 45 ;
        double interestRate = 0;
        double eligibleEmi = (salary * 0.45) - obligations ;
        switch(bank)
        {
            case 1:
                interestRate = 0.005  ;  // 6%
                break;
            case 2:
                interestRate = 0.008 ;     // 10%
                break;
            case 3:
                interestRate =0.007 ;       // 8%
                break;
            case 4:
                interestRate = 0.007;
                break;
            case 5:
                interestRate = 0.008 ;
                break;
            case 6:
                interestRate = 0.01 ;    // 12%
                break;
        }

        double months = years * 6 ;
        double interestCalculation = Math.pow((1 + interestRate),months);

        amount = ( eligibleEmi * ( interestCalculation -1) ) / (interestRate * interestCalculation );

        return amount;
    }

    @Override
    public void loanProcessing(double loan , double months, double amount,int bank)
    {
        double interestRate = 0;
        switch(bank)
        {
            case 1:
                interestRate = 0.005  ;  // 6%
                break;
            case 2:
                interestRate = 0.008 ;     // 10%
                break;
            case 3:
                interestRate =0.007 ;       // 8%
                break;
            case 4:
                interestRate = 0.007;
                break;
            case 5:
                interestRate = 0.008 ;
                break;
            case 6:
                interestRate = 0.01 ;    // 12%
                break;
        }
        double interestCalculations =  Math.pow((1 + interestRate),months);
        double emi = ( loan * interestRate * interestCalculations ) / (interestCalculations - 1 ) ;
        double totalPayment = emi * months ;
        double totalInterest = totalPayment - loan ;

        System.out.printf("%10s","Eligible :");
        System.out.printf("%-15.2f",amount);
        System.out.printf("%-20s"," ");
        System.out.printf("%10s","Applied : ");
        System.out.printf("%-15.2f",loan);
        System.out.println();
        System.out.println("-".repeat(70));
        System.out.printf("%-10s","EMI : ");
        System.out.printf("%-15.2f",emi);
        System.out.printf("%-20s"," ");
        System.out.printf("%15s","Total Months : ");
        System.out.printf("%-15s",months);
        System.out.println();
        System.out.println("-".repeat(70));
        System.out.printf("%20s","Total Amount Payable : ");
        System.out.printf("%-15.2f",totalPayment);
        System.out.printf("%20s","Total interest Payable : ");
        System.out.printf("%-15.2f",totalInterest);
        System.out.println();
        System.out.println("-".repeat(70));
        System.out.println();
    }

    @Override
    public void printStatement ( Salary salary){
        System.out.println("=".repeat(70));
        System.out.println();
        System.out.printf("%-8s","Name : ");
        System.out.printf("%-25s",salary.getName());
        System.out.printf("%-20s"," ");
        System.out.printf("%-7s","DOB :");
        System.out.printf("%-10s",salary.getDob());
        System.out.println();
        System.out.printf("%-10s","Address :");
        System.out.printf("%-42s ",salary.getAddress());
        System.out.printf("%-7s","Age :");
        System.out.printf("%-10s",salary.getAge());
        System.out.println();
        System.out.printf("%-8s","Email : ");
        System.out.printf("%-25s",salary.getEmail());
        System.out.printf("%-20s"," ");
        System.out.printf("%-7s","Phone :");
        System.out.printf("%-10s",salary.getPhone());
        System.out.println();
        System.out.printf("%-15s","Employer Name : ");
        System.out.printf("%-20s",salary.getEmployerName());
        System.out.printf("%-10s"," ");
        System.out.printf("%15s","JobTitle : ");
        System.out.printf("%-10s",salary.getJobTitle());
        System.out.println();
        System.out.printf("%-10s","IdProof : ");
        System.out.printf("%-10s",salary.getIdType());
        System.out.printf("%-12s",salary.getIdProof());
        System.out.printf("%-21s"," ");
        System.out.printf("%-7s","Bank : ");
        System.out.printf("%-10s",salary.getBank());
        System.out.println();
        System.out.println("=".repeat(70));

    }
}
