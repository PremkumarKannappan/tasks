package task7;

import java.util.Scanner;

public class Main extends task7 {


    public static void main(String[] args) {
        task7 obj = new task7();
        Scanner scanner = new Scanner(System.in);
        boolean isSuccess=false;
        int studentCount = 0;
        System.out.println("Enter the  number of students : ");
        do {
            try {
                int n =scanner.nextInt();
                if(n<0)
                {
                    throw new Exception("Invalid input : Negative number");
                }
                if(n == 0)
                {
                    throw new Exception("Invalid input : Zero number");
                }

                studentCount=n;
                isSuccess=true;

            }
            catch (Exception e) {
                System.out.println(e.getMessage()+"\nEnter a valid positive number");
                scanner.nextLine();
            }
        }while(!isSuccess);
        for (int i=0;i<studentCount;i++)
        {
            obj.enterStudentDetails();
        }
//        System.out.println(obj.studentDetailsMap);
//        System.out.println(obj.studentMarksMap);
        System.out.println("Student's Mark sheet");

        obj.printDetails(obj.studentDetailsMap, obj.studentMarksMap);
    }
}
