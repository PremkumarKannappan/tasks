package Task23;

public class Student
{
    private String name,  college, degree, bank;
    private double year, principleAmount, courseCompletion, emi, tenure;
    long regNo;

    Student(String name,long regNo,String college,String degree,String bank,double year,double principleAmount,double cautionDeposit,double tenure)
    {
        this.name = name;
        this.regNo = regNo;
        this.college = college;
        this.degree = degree;
        this.bank = bank;
        this.year = year;
        this.principleAmount = principleAmount;
        this.courseCompletion = cautionDeposit;
        this.tenure = tenure;
        this.emi = calculateEmi(this);

    }

    public String getName(){return this.name;}
    public long getRegNo(){return this.regNo;}
    public String getCollege(){return this.college;}
    public String getDegree(){return this.degree;}
    public String getBank(){return this.bank;}
    public double getYear(){return this.year;}
    public double getPrincipleAmount(){return this.principleAmount;}
    public double getCourseCompletion(){return this.courseCompletion;}
    public double getEmi(){return this.emi;}
    public double getTenure(){return this.tenure;}

    public static double calculateEmi(Student stu)
    {
        double emiCal;
        double loan = stu.principleAmount ;
        double months = stu.tenure * 12 ;
        double interest = 0, cod = stu.courseCompletion *12;
        switch (stu.bank)
        {
            case "IOB":
                IOB iob = new IOB();
                interest = iob.getInterestRate();
                break;
            case "SBI":
                SBI sbi = new SBI();
                interest = sbi.getInterestRate();
                break;
            case "CUB":
                CUB cub = new CUB();
                interest = cub.getInterestRate();
                break;
            case "TMB":
                TMB tmb = new TMB();
                interest = tmb.getInterestRate();
                break;
        }
        double interestCalculation = Math.pow((1+interest),months-cod);
        emiCal = ( loan * interestCalculation * interest ) / ( interestCalculation - 1) ;
        return emiCal;
    }

    public void printData()
    {
        double total = this.emi * (this.tenure - this.courseCompletion)*12 ;
        System.out.println("The principle amount you asked for: "+this.principleAmount);
        System.out.println("The tenure period you applied for repaying the amount is: "+ (this.tenure-this.courseCompletion) );
        System.out.printf("%s","The EMI amount you pay for the period per month: ");
        System.out.printf("%.2f", this.emi);
        System.out.println();
        System.out.printf("%s","The interest you pay for the amount is: ");
        System.out.printf("%.2f",(total - this.principleAmount));
    }
}
