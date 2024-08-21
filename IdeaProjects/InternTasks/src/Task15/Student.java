package Task15;

public class Student implements Cloneable {
    private long registerNumber;
    private String name;
    private String dateOfBirth;
    private String department;
    private double[] marks;
    public String [] subjects;
    public double total, percentage;
    public double cgpa;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRegisterNumber(long registerNumber) {
        this.registerNumber = registerNumber;
    }

    public long getRegisterNumber() {
        return this.registerNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setMarks(double[] marks)
    {
        this.marks = marks;
    }

    public double[] getMarks() {
        return this.marks;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
    public Student(long registerNumber1,String name1, String dateOfBirth1, String department1, double[] marks1)
    {
        this.registerNumber = registerNumber1;
        this.name = name1;
        this.dateOfBirth = dateOfBirth1;
        this.department = department1;
        this.marks = marks1;
        this.total = Student.calculateTotal(marks);
        this.percentage = total/marks.length;
        this.cgpa = percentage/9.5f;
    }


    public Student()
    {

    }

    public static double calculateTotal(double[] marks)
    {
        double total = 0;
        for(double mark : marks)
        {
            total += mark;
        }
        return total;
    }
    public void displayHeader(String []subjects)
    {
        int width = subjects.length;
        for (String subject:subjects)
        {
            width += subject.length();
        }
        int totalwidth = 4+12+20+12+10+40+width;
        System.out.println("=".repeat(totalwidth));
        System.out.printf("%-"+4+"s ","S.No");
        System.out.printf("%-"+12+"s ","Reg");
        System.out.printf("%-"+20+"s ","Name");
        System.out.printf("%-"+12+"s ","DateOfBirth");
        System.out.printf("%-"+10+"s ","Department");
        System.out.printf("%-"+width+"s ","Subjects");
        System.out.printf("%-"+5+"s ","Total");
        System.out.printf("%-"+10+"s ","Percentage");
        System.out.printf("%-"+5+"s ","CGPA");
        System.out.println();
        System.out.printf("%-"+62+"s "," ");
        for(String sub : subjects)
        {
            int width1 = sub.length();
            System.out.printf("%-"+width1+"s ",sub);
        }
        System.out.println();
        System.out.println("=".repeat(totalwidth));

    }
    public void displayStudentDetails(long registerNumber,String [] subjects)
    {
        if(this.registerNumber == registerNumber)
        {
            int width = subjects.length-1;
            for (String subject:subjects)
            {
                width += subject.length();
            }
            int totalwidth = 4+12+20+12+10+40+width;
            System.out.printf("%-"+4+"s ",1);
            System.out.printf("%-"+12+"s ",this.registerNumber);
            System.out.printf("%-"+20+"s ",this.name);
            System.out.printf("%-"+12+"s " ,this.dateOfBirth);
            System.out.printf("%-"+10 +"s ", this.department);
            for(int i=0;i<subjects.length;i++)
            {
                int len = subjects[i].length();
                System.out.printf("%-"+len+"s ",this.marks[i]);
            }

            System.out.printf("%-"+5+"s ",this.total);
            System.out.printf("%-"+10+".2f ",this.percentage);
            System.out.printf("%-"+5+".2f ",this.cgpa);

        }

    }
    public void displayStudentDetails(String [] subjects,Student[] student)
    {
        int width = subjects.length-1;
        for (String subject:subjects)
        {
            width += subject.length();
        }
        int totalwidth = 4+12+20+12+10+40+width;
        for(Student stud : student)
        {
            System.out.printf("%-"+4+"s ",1);
            System.out.printf("%-"+12+"s ",stud.registerNumber);
            System.out.printf("%-"+20+"s ",stud.name);
            System.out.printf("%-"+12+"s " ,stud.dateOfBirth);
            System.out.printf("%-"+10 +"s ", stud.department);
            for(int i=0;i<subjects.length;i++)
            {
                System.out.printf("%-"+subjects[i].length()+"s ",stud.marks[i]);
            }
            System.out.printf("%-"+5+"s ",stud.total);
            System.out.printf("%-"+10+".2f",stud.percentage);
            System.out.printf("%-"+5+".2f ",stud.cgpa);
            System.out.println();
            System.out.println("-".repeat(totalwidth));
        }

    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


}
