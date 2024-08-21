package task7New;

import java.util.Scanner;

public class StudentDetails {
    private Long studentRegister;
    private String studentName;
    private String studentDob;
    private double[] studentMarks ;
    private double average=0.00f;
    private double total;
    private char grade;
    public StudentDetails(String studentName, String studentDob, double[] studentMarks,Long registerNumber)
    {
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.studentMarks = studentMarks;
        this.studentRegister= registerNumber;
        this.total = calculateTotal(this.studentMarks);
        this.average = this.total/studentMarks.length;
        this.grade = calculateGrade(this.average);
    }


    public double calculateTotal(double [] marks) {
        double sum = 0;
        for (double temp :marks)
        {
            sum += temp;
        }
        return sum;
    }
    public char calculateGrade(double total1) {
        char grade1=' ';
        if(total1 > 90 && total1 < 100)
            grade1 = 'O';
        else if(total1 > 80 && total1 <= 90)
            grade1 = 'A';
        else if(total1 > 70 && total1 <= 80)
            grade1 = 'B';
        else if(total1 > 60 && total1 <= 70)
            grade1 = 'C';
        else if(total1 > 50 && total1 <= 60)
            grade1 = 'D';
        else if(total1 < 50)
            grade1 = 'U';
        return grade1;
    }
    public String getName()
    {
        return studentName;
    }
    public void setName(String name)
    {
        this.studentName = name;
    }
    public Long getReg()
    {
        return this.studentRegister;
    }
    public void setReg(Long reg)
    {
        this.studentRegister = reg;
    }
    public String getStudentDob()
    {
        return this.studentDob;
    }
    public void setStudentDob(String dob)
    {
        this.studentDob = dob;
    }
    public double[] getStudentMarks()
    {
        return this.studentMarks;
    }
    public void setStudentMarks(double[] marks)
    {
        this.studentMarks = marks;
    }
    public double getAverage()
    {

        return this.average;
    }
    public void setAverage(double average)
    {
        this.average = average;
    }
    public double getTotal()
    {
        return this.total;
    }
    public void setTotal(double total1)
    {
        this.total = total1;
    }
    public char getGrade()
    {
        return this.grade;
    }
    public void setGrade(char grade2)
    {
        this.grade = grade2;
    }
}
