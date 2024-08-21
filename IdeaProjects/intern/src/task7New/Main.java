package task7New;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int studentCount = 0;
        System.out.println("Enter the  number of students : ");
        studentCount = main.getNumber();
        System.out.println("Enter the number of subjects");
        int numofsubjects = main.getNumber();
        String[] subjects = new String[numofsubjects];
        for (int k = 0; k < numofsubjects; k++) {
            System.out.println("Enter the subject" + (k + 1) + " name");
            subjects[k] = scanner.nextLine();
        }
        StudentDetails[] students = new StudentDetails[studentCount];
        for (int i = 0; i < studentCount; i++) {
            String name = main.getName(i);
            System.out.println("Enter the register number");
            long reg = scanner.nextLong();
            System.out.println("Enter the student DOB : ");
            String dob = main.getDob();
            double[] marks = new double[numofsubjects];
            for (int j = 0; j < numofsubjects; j++) {
                System.out.println("enter the subject" + (j + 1) + " marks : ");
                marks[j] = main.getMarks();
            }
            students[i] = new StudentDetails(name, dob, marks, reg);
        }
        int nameWidth = main.calculateNameWidth(students);
        System.out.println("Name width : " + nameWidth);
        int regWidth = 15;
        int dobWidth = 13;
        int[] subjectWidth = new int[numofsubjects];
        int sum = numofsubjects - 1;
        for (int i = 0; i < numofsubjects; i++) {
            int len = subjects[i].length();
            subjectWidth[i] = len;
            sum += len;
        }
        int totalWidth = 7;
        int count = nameWidth + regWidth + dobWidth + sum + 30;
        System.out.println("=".repeat(count));
        System.out.printf("%-" + 4 + "s ", "S.No");
        System.out.printf("%-" + nameWidth + "s ", "Name");
        System.out.printf("%-" + regWidth + "s ", "Reg.No");
        System.out.printf("%-" + dobWidth + "s ", "DOB");
        System.out.printf("%-" + sum + "s ", "Subjects");
        System.out.printf("%-" + totalWidth + "s ", "Total");
        System.out.printf("%-" + totalWidth + "s ", "Average");
        System.out.printf("%-" + totalWidth + "s ", "Grade");
        System.out.println();
        System.out.printf("%-" + (nameWidth + regWidth + dobWidth + 7) + "s ", " ");
        for (int i = 0; i < numofsubjects; i++) {
            System.out.printf("%-" + subjectWidth[i] + "s ", subjects[i]);
        }
        System.out.println();
        System.out.println("=".repeat(count));
        int sno = 1;
        for (StudentDetails student : students) {
            System.out.printf("%-" + 4 + "s ", sno);
            System.out.printf("%-" + nameWidth + "s ", student.getName());
            System.out.printf("%-" + regWidth + "s ", student.getReg());
            System.out.printf("%-" + dobWidth + "s ", student.getStudentDob());
            double[] marks = student.getStudentMarks();
            for (int k = 0; k < numofsubjects; k++) {
                System.out.printf("%-" + subjectWidth[k] + "s ", marks[k]);
            }
            System.out.printf("%-" + totalWidth + "s ", student.getTotal());
            System.out.printf("%-"+totalWidth+".2f ",student.getAverage());
            System.out.printf("%-" + totalWidth + "s ", student.getGrade());
            sno++;
            System.out.println();
            System.out.println("-".repeat(count));
        }
    }

    public String getName(int i) {
        Scanner scanner = new Scanner(System.in);
        boolean isNameValid = false;
        System.out.println("Enter Student" + (i + 1) + " Name");
        String studentName = "";
        do {
            String name = scanner.nextLine();
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

    public String getDob() {
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

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        boolean isSuccess = false;
        do {
            try {
                int n = scanner.nextInt();
                if (n < 0) {
                    throw new Exception("Invalid input : Negative number");
                }
                if (n == 0) {
                    throw new Exception("Invalid input : Zero number");
                }

                count = n;
                isSuccess = true;

            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nEnter a valid positive number");
                scanner.nextLine();
            }
        } while (!isSuccess);
        return count;
    }

    public int calculateNameWidth(StudentDetails[] students) {
        int nameWidth = 0;
        for (StudentDetails student : students) {
            nameWidth = Math.max(nameWidth, student.getName().length());
        }
        return nameWidth;
    }

    public double getMarks() {
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
}
