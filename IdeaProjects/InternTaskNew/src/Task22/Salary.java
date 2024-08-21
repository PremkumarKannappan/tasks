package Task22;

public class Salary extends Person{
    private double salary;
    private String employerName;
    private String jobTitle;

    public Salary(String name, int age, String dob, String address, String phone, String email, String idProof,String idType,String bank,String employerName, String jobTitle, double salary) {
        super(name, age, dob, address, phone, email, idProof,idType,bank);
        this.employerName = employerName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getEmployerName() {
        return this.employerName;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }
}
