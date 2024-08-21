package Task21;

public class Employee
{
    private String employeeName;
    private String employeeID;
    private String employeeAddress;
    private String designation;
    private double grossPay;
    private double netPay;
    private double ctc;

    public String getEmployeeName() {
        return this.employeeName;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getEmployeeAddress() {
        return this.employeeAddress;
    }

    public String getDesignation() {
        return this.designation;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public double getNetPay() {
        return this.netPay;
    }

    public double getCtc() {
        return this.ctc;
    }

    public void setGrossPay(double g) {
        this.grossPay =g;
    }

    public void setNetPay(double n) {
        this.netPay =n;
    }

    public void setCtc(double c) {
        this.ctc =c;
    }

    public void Employee(String employeeName, String employeeID, String employeeAddress, String designation)
    {
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeeAddress = employeeAddress;
        this.designation = designation;
    }

}
