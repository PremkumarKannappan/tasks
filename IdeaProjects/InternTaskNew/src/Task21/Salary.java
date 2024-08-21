package Task21;

public class Salary extends Employee{
    private double basicPay;
    private double housingAllowance;
    private double dearAllowanace;
    private double otherAllowance ;
    private double pf;
    private double tax;
    private double ctc ;


    public Salary(String employeeName1, String employeeID1, String employeeAddress1, String designation1,double basicPay1)
    {
        super.Employee(employeeName1, employeeID1, employeeAddress1, designation1);
        this.basicPay = basicPay1;
        double gross = this.calculateGross(basicPay);
        this.setGrossPay(gross);
        double net = this.calculateNetPay(basicPay,gross) ;
        this.setNetPay(net);
        double ctc = gross + this.pf;
        this.setCtc(ctc);
    }

    public double calculateGross(double basicPay1)
    {
        double gross ;
        this.housingAllowance = basicPay * 0.40 ;
        this.dearAllowanace = basicPay * 0.10 ;
        this.otherAllowance = basicPay * 0.20 ;
        gross = basicPay1 + housingAllowance + dearAllowanace + otherAllowance ;
        return gross*12;
    }

    public double calculateNetPay(double basicPay1,double gross)
    {
        double netPay  ;
        double standardDeduction = 50000;
        this.pf = basicPay1 * 0.12 * 12 ;
        double taxable = gross - (this.housingAllowance*12) - standardDeduction ;
        if(taxable <= 250000)
            this.tax = 0;
        if(taxable >= 250001 && taxable <= 500000 )
            this.tax = taxable * 0.05 ;
        if(taxable >= 500001 )
            this.tax = ( taxable * 0.05 ) + ( ( taxable - 500000) * 0.20 ) ;
        double totalDeduction = tax + pf ;
        netPay = gross - totalDeduction ;
        return netPay;
    }

    public double getHousingAllowance() {
        return this.housingAllowance;
    }

    public double getDearAllowanace() {
        return this.dearAllowanace;
    }

    public double getOtherAllowance() {
        return this.otherAllowance;
    }
    public void displayDetails()
    {
        int addressWidth = this.getEmployeeAddress().length();
        int totalWidth = 45 + this.getEmployeeName().length() + this.getEmployeeID().length() + addressWidth ;
        int headWidth = totalWidth/3;
        System.out.printf("%-"+headWidth+"s "," ");
        System.out.printf("FINSURGE PVT LTD");
        System.out.println();
        System.out.printf("%-"+(headWidth+5)+"s "," ");
        System.out.printf("PAYSLIP");
        System.out.println();
        System.out.println("=".repeat(totalWidth));
        System.out.printf("Employee Name: %-"+this.getEmployeeName().length() +"s ", this.getEmployeeName());
        System.out.printf("%-"+addressWidth+"s "," ");
        System.out.printf("Employee ID: %-"+this.getEmployeeID().length() +"s ", this.getEmployeeID());
        System.out.println();
        System.out.printf("Employee Address: %-"+60 +"s ", this.getEmployeeAddress());
        System.out.println();
        System.out.printf("Designation: %-"+this.getDesignation().length() +"s ", this.getDesignation());
        System.out.println();
        System.out.println("=".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Earnings");
        System.out.printf("%-"+10+"s ","Amount");
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","Deductions");
        System.out.printf("%-"+10+"s ","Amount");
        System.out.println();
        System.out.println("-".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Basic Pay");
        System.out.printf("%-"+11+".2f",this.basicPay);
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","PF");
        System.out.printf("%-"+10+".2f",this.pf);
        System.out.println();
        System.out.println("-".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Housing Allowance");
        System.out.printf("%-"+11+".2f",this.housingAllowance);
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","TAX");
        System.out.printf("%-"+10+".2f",this.tax);
        System.out.println();
        System.out.println("-".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Dear Allowance");
        System.out.printf("%-"+11+".2f",this.dearAllowanace);
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","Other");
        System.out.printf("%-"+10+".2f",00.00);
        System.out.println();
        System.out.println("-".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Other Allowance");
        System.out.printf("%-"+11+".2f",this.otherAllowance);
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","CTC");
        System.out.printf("%-"+10+".2f",this.getCtc());
        System.out.println();
        System.out.println("-".repeat(totalWidth));
        System.out.printf("%-"+20+"s ","Gross Salary");
        System.out.printf("%-"+11+".2f",this.getGrossPay());
        System.out.printf("%-"+totalWidth/5+"s "," ");
        System.out.printf("%-"+20+"s ","Net Salary");
        System.out.printf("%-"+10+".2f",this.getNetPay());
        System.out.println();
        System.out.println("=".repeat(totalWidth));
        System.out.println();
        System.out.println();
    }
}
