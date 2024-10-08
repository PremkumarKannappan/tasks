package Task7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDetailsMain {

    public static double validateMarks() {
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

    public static boolean validateDob(String dob) {
        boolean isDateValid = false;
        if (dob.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])")) {
            isDateValid = true;
        } else {
            System.out.println("Invalid Date of Birth");
            System.out.println("Enter Valid Date of Birth (EX: 1990-01-01)");
        }

        return isDateValid;
    }

    public static boolean validateNumber(int number) {
        boolean isSuccess = false;
        try {
            if (number < 0) {
                throw new Exception("Invalid input : Negative number");
            }
            if (number == 0) {
                throw new Exception("Invalid input : Zero number");
            }
            isSuccess = true;

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\nEnter a valid positive number");
        }
        return isSuccess;
    }

    public static boolean validateName(String name) {
        boolean isNameValid = false;
        if (name.matches("[A-Z][a-zA-Z]*\\s[A-Z]")) {
            isNameValid = true;
        } else {
            System.out.println("Invalid Name");
            System.out.println("Enter Valid Name (EX: Premkumar K)");
        }
        return isNameValid;
    }

    public static int calculateNameWidth(Student[] students) {
        int nameWidth = 0;
        for (Student student : students) {
            nameWidth = Math.max(nameWidth, student.getName().length());
        }
        return nameWidth;
    }

    public static boolean validateRegisterNumber(long registerNumber) {
        boolean isValid = false;
        try
        {
            if (registerNumber < 0) {
                throw new Exception("Invalid Number : Negative number");
            }
            if(registerNumber == 0) {
                throw new Exception("Invalid Number: Zero Number");
            }
            String register = String.valueOf(registerNumber);
            if(register.matches("^9628[0-9]{8}")) {
                isValid = true;
            }
            else
            {
                throw new Exception("Invalid Register Number:Pattern doesn't match");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()+"\nEnter Valid Number");
        }
        return isValid;
    }

    public static boolean validateSubjectName(String subjectName)
    {
        boolean isSubjectNameValid =false;
        try
        {
            if(subjectName.matches("[A-za-z]*[0-9]?"))
            {
                isSubjectNameValid=true;
            }
            else
            {
                throw new Exception("Invalid Subject name: only String accepted");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage()+"enter a valid subject name");
        }
        return isSubjectNameValid;
    }

    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int studentCount = 0;
        boolean isNumberValid ;
        System.out.println("Enter the  number of students : ");

        do{
            studentCount = scanner.nextInt();
            isNumberValid = validateNumber(studentCount);
        }while(!isNumberValid);


        boolean isNoOfSubjectsValid = false;
        int numOfSubjects;
        System.out.println("Enter the number of subjects");

        do {
            numOfSubjects = scanner.nextInt();
            isNoOfSubjectsValid=validateNumber(numOfSubjects);
        }while(!isNoOfSubjectsValid);

        scanner.nextLine();
        String[] subjects = new String[numOfSubjects];

        for (int k = 0; k < numOfSubjects; k++) {
            boolean isSubjectValid = false; String subjectName = "";
            System.out.println("Enter the subject" + (k + 1) + " name");
            do{
                subjectName = scanner.nextLine();
                isSubjectValid = validateSubjectName(subjectName);
            }while (!isSubjectValid);
            subjects[k] = subjectName;
        }

        Student[] students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            boolean isNameValid = false;String name;
            System.out.println("Enter the student "+(i+1)+"Name:");
            do {
                name = scanner.nextLine();
                isNameValid = validateName(name);
            }while(!isNameValid);


            boolean isRegisterNumberValid ;
            long reg;
            System.out.println("Enter the register number");
            do {
                reg = scanner.nextLong();
                isRegisterNumberValid = validateRegisterNumber(reg);
            }while(!isRegisterNumberValid);

            System.out.println("Enter the student DOB : ");
            boolean isDobVallid = false; String dob;
            do{
                dob = scanner.next();
                isDobVallid = validateDob(dob);
            }while (!isDobVallid);

            double[] marks = new double[numOfSubjects];
            for (int j = 0; j < numOfSubjects; j++) {
                System.out.println("enter the subject" + (j + 1) + " marks : ");
                marks[j] = validateMarks();
            }

            students[i] = new Student(name, dob, marks, reg);
        }
        int nameWidth = calculateNameWidth(students);
        int regWidth = 15;
        int dobWidth = 13;
        int[] subjectWidth = new int[numOfSubjects];
        int sum = numOfSubjects - 1;
        for (int i = 0; i < numOfSubjects; i++) {
            int len = subjects[i].length();
            subjectWidth[i] = len;
            sum += len;
        }
        int totalWidth = 7;
        int count = nameWidth + regWidth + dobWidth + sum + 30;
        Student stu = new Student();
        stu.printHeader(nameWidth,regWidth,dobWidth,sum,subjectWidth,subjects);
        stu.printData(students,nameWidth,regWidth,dobWidth,sum,subjectWidth);
    }










}
