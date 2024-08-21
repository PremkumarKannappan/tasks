package Task15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMain {
    public static int getValidateNumber()
    {
        Scanner scan = new Scanner(System.in);
        int validNumber=0;
        boolean isSuccess = false;
        do {
            try {
                int num = scan.nextInt();
                if (num < 0) {
                    throw new Exception("Invalid number : Negative input");
                }
                if (num == 0) {
                    throw new Exception("Invalid input : Zero value");
                }
                validNumber = num;
                isSuccess = true;
            } catch (Exception e) {
                if(e instanceof InputMismatchException)
                {
                    System.out.println("Invalid input: input is not a number");
                }
                System.out.println(e.getMessage() + "\nEnter a valid number");
                scan.nextLine();
            }
        }while(!isSuccess);
        return validNumber;
    }

    public static long getValidateRegister()
    {
        Scanner scan = new Scanner(System.in);
        long register,registerNumber = 0;
        boolean isSuccess = false;
        do{
            try{
                register = scan.nextLong();
                if (register < 0) {
                    throw new Exception("Invalid Register Number : Negative Number");
                }
                if (register == 0) {
                    throw new Exception("Invalid Register NUmber : zero number");
                }
                String registerString = String.valueOf(register);
                if(!registerString.matches("^9628[0-9]{8}"))
                {
                    throw new Exception("Invalid Register NUmber : Not a valid register");
                }
                registerNumber = register;
                isSuccess = true;
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + "\nEnter a valid Register number");
            }
        }while(!isSuccess);
        return registerNumber;
    }

    public static String getValidateName()
    {
        Scanner scan = new Scanner(System.in);
        boolean isNameValid = false;
        String studentName = "";
        do {
            String name = scan.nextLine();
            if (name.matches("[A-Z][a-zA-Z]*\\s[A-Z]")) {
                isNameValid = true;
                studentName = name;
            } else {
                System.out.println("Invalid Name");
                System.out.println("Enter Valid Name (EX: Premkumar K)");
            }
        } while (!isNameValid);
        return studentName;
    }

    public static String getValidateDob()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Date of Birth in the format yyyy-mm-dd");
        boolean isDateValid = false;
        String dob = " ";
        do {
            String dateOfBirth = scanner.next();
            if (dateOfBirth.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])")) {
                dob = dateOfBirth;
                isDateValid = true;
            } else {
                System.out.println("Invalid Date of Birth");
                System.out.println("Enter Valid Date of Birth (EX: 1990-01-01)");
            }
        } while (!isDateValid);
        return dob;
    }

    public static String[] getSubjects(int number)
    {
        Scanner scan = new Scanner(System.in);
        String [] subjects = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Subject " + (i + 1) + "Name:  ");
            subjects[i] = scan.nextLine();
        }
        return subjects;
    }

    public static double getValidMarks()
    {
        Scanner scanner = new Scanner(System.in);
        double mark;
        boolean markValid = false;
        do {
            mark = scanner.nextDouble();
            if (mark < 0) {
                System.out.println("Invalid mark: Negative number");
            }
            if (mark > 100) {
                System.out.println("Invalid mark : Not valid more than 100");
            } else if (mark > 0 && mark <= 100) {
                markValid = true;
            }
        } while (!markValid);
        return mark;
    }

    public static void getDetails(int noOfStudents,String [] subjects,Student [] student)
    {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < noOfStudents; i++) {
            System.out.println("Enter the student"+(i+1)+"RegisterNumber");
            long registerNumber = getValidateRegister();
            System.out.println("Enter Student" + (i + 1) + " Name");
            String studentName = getValidateName();
            System.out.println("Enter Student"+(i+1)+" Date of Birth");
            String dateOfBirth = getValidateDob();
            System.out.println("Enter Student"+(i+1)+" Department");
            String department = scan.nextLine();
            double [] marks = new double[subjects.length];
            for(int j=0;j<subjects.length;j++)
            {
                System.out.println("Enter the marks for "+subjects[j]);
                marks[j] = getValidMarks();
            }
            student[i] = new Student(registerNumber,studentName,dateOfBirth,department,marks);

        }


    }
    public static void main(String[] args) throws CloneNotSupportedException {
        long registerNumber;
        String name,department,dateOfBirth;
        double [] marks;
        int noOfStudents,noOfSubjects;
        String []subjects;
        boolean isSuccess = false;

        Student student1 = new Student();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        noOfStudents = getValidateNumber();
        System.out.println("Enter the number of subjects: ");
        noOfSubjects = getValidateNumber();
        subjects = getSubjects(noOfSubjects);

        Student[] student = new Student[noOfStudents];
        getDetails(noOfStudents,subjects,student);

//        for(Student stu: student)
//        {
//            System.out.println(stu.getName()+" "+stu.getDepartment()+" "+stu.getRegisterNumber()+" "+stu.getDateOfBirth());
//        }

        do{
            System.out.println("Enter your Choice from the below options:");
            System.out.println("1.Display specific Student Information \t2.Display all Student Information");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:
                    boolean isFound = false;
                    System.out.println("Enter the Student register number");
                    do{

                        long register = getValidateRegister();
                        for(Student stu: student)
                        {
                            if(stu.getRegisterNumber() == register)
                            {
                                isFound = true;
                                stu.displayHeader(subjects);
                                stu.displayStudentDetails(register,subjects);
                                break;
                            }
                        }
                        if(!isFound)
                        {
                            System.out.println("No student found with this register Number");
                        }
                    }while(!isFound);
                    break;
                case 2:
                    student1.displayHeader(subjects);
                    student1.displayStudentDetails(subjects,student);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }
            System.out.println();
            System.out.println("if you want to continue enter 'Yes' or 'No'");
            scan.nextLine();
            boolean isCont = false;
            do {
                String cont = scan.nextLine();
                if (cont.equals("Yes") || cont.equals("yes")||cont.equals("YES")) {
                    isSuccess = false;
                    isCont = true;
                }
                if (cont.equals("No") || cont.equals("no")||cont.equals("NO")) {
                    isSuccess = true;
                    isCont = true;
                }
                if(!isCont) {
                    System.out.println("Invalid option please enter a valid option");
                }
            }while(!isCont);
        }while(!isSuccess );
        Student stu = new Student();
        stu.setName("PremKumar");
        stu.setDepartment("CSE");
        stu.setDateOfBirth("2003-02-24");
        stu.setRegisterNumber(962820104059L);
        stu.setMarks(new double []{100, 85, 95, 78});

        Student stu2 = (Student) stu.clone();
        stu2.setName("PremKumar K");

        System.out.println(stu.getName()+stu.getDepartment()+stu.getDateOfBirth()+stu.getRegisterNumber());

        System.out.println(stu2.getName()+stu2.getDepartment()+stu2.getDateOfBirth()+stu2.getRegisterNumber());
    }
}
