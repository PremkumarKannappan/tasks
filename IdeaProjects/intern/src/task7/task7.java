package task7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task7 {
    Map studentDetailsMap = new HashMap();
    Map studentMarksMap = new HashMap();
    public void enterStudentDetails()
    {
        Map tempMap = new HashMap();
        boolean isSuccess1= false;
        Scanner scanner=new Scanner(System.in);
        Long registerNumber = 0L;
        System.out.println("Enter the student register number : ");
        do {
            try {
                registerNumber = scanner.nextLong();
                if (registerNumber < 0) {
                    throw new Exception("Invalid input : Negative number");
                }
                if (registerNumber == 0) {
                    throw new Exception("Invalid input : Zero number");
                }
                if (!String.valueOf(registerNumber).matches("^9628[0-9]{8}")) {
                    throw new Exception("Invalid input : Invalid format\n Please enter in the format");
                }
                isSuccess1=true;

            } catch (Exception e) {
                System.out.println(e.getMessage() + "\nEnter a valid register number");
                scanner.nextLine();
            }
        }while (!isSuccess1);
        scanner.nextLine();
        boolean isNameValid = false;
        System.out.println("Enter Student Name");
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
        System.out.println("Enter the Course Name");
        String course = scanner.nextLine();
        System.out.println("Enter Branch name");
        String branch = scanner.nextLine();
        System.out.println("Enter Current year");
        int year = scanner.nextInt();
        System.out.println("Enter Current semester");
        int semester = scanner.nextInt();
        tempMap.put("reg",registerNumber);
        tempMap.put("name",studentName);
        tempMap.put("course",course);
        tempMap.put("branch",branch);
        tempMap.put("year",year);
        tempMap.put("semester",semester);
        studentDetailsMap.put(registerNumber,tempMap);
        task7 obj = new task7();
        Map tempMap2 = obj.markEntry(registerNumber);
        studentMarksMap.put(registerNumber,tempMap2);
        System.out.println(studentMarksMap);

    }
    public String[] subjectEntry()
    {
        Scanner scanner=new Scanner(System.in);
        int numberOfSubjects = 0;boolean isSuccess = false;
        System.out.println("Enter the number of subjects ");
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

                numberOfSubjects=n;
                isSuccess=true;

            }
            catch (Exception e) {
                System.out.println(e.getMessage()+"\nEnter a valid positive number");
                scanner.nextLine();
            }
        }while(!isSuccess);
        String [] subjects = new String[numberOfSubjects];
        for(int i=0;i<numberOfSubjects;i++)
        {
            System.out.println("Enter the Subject Name ");
        }
        return subjects;
    }
    public Map markEntry(Long registerNumber)
    {
        Scanner scanner=new Scanner(System.in);
        Map tempMap = new HashMap();
        char grade;

//        for(int i=0;i<numberOfSubjects;i++) {
//            scanner.nextLine();
//            System.out.println("Enter the Subject Name");
//            String subject = scanner.nextLine();
//            System.out.println("Enter the Mark");boolean markValid = false;double mark = 0;
//            do{
//                 mark = scanner.nextDouble();
//                 if(mark<0)
//                 {
//                     System.out.println("Invalid mark: Negative number");
//                 }
//                 if(mark > 100)
//                 {
//                     System.out.println("Invalid mark : Not valid more than 100");
//                 }
//                 else if (mark > 0 && mark <= 100)
//                 {
//                     markValid = true;
//                 }
//            }while(!markValid);
//
//            tempMap.put(subject,mark);
//        }
        return tempMap;
    }
    public char calculateGrade(double mark)
    {
        char grade;
        if(mark>=90 && mark<100)
            grade='O';
        else if(mark>=80 && mark<90)
            grade='A';
        else if(mark>=70 && mark<80)
            grade='B';
        else if(mark>=60 && mark<70)
            grade='C';
        else if(mark>=50 && mark<60)
            grade='D';
        else
            grade='U';
        return grade;
    }
    public void printDetails(Map studentDetailsMap1, Map studentMarksMap1)
    {
        task7 obj = new task7();
        Long [] registerNumber = new Long[studentDetailsMap1.size()];
        studentDetailsMap1.keySet().toArray(registerNumber);
        for(int i=0 ;i< registerNumber.length;i++)
        {
            for(int j=1 ;j< registerNumber.length;j++)
            if(registerNumber[i]>registerNumber[j])
            {
                long temp = registerNumber[i];
                registerNumber[i] = registerNumber[j];
                registerNumber[j] = temp;
            }
        }
        for(int i=0;i<registerNumber.length;i++)
        {
            int nameWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"name");
            int courseWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"course");
            int branchWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"branch");
            int yearWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"year");
            int semesterWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"semester");
            int regWidth = obj.calculateWidth(studentDetailsMap1,registerNumber[i],"reg");
            int width = nameWidth+courseWidth+branchWidth+yearWidth+semesterWidth+regWidth+20;
            System.out.println("=".repeat(width));
            System.out.printf("%-"+regWidth+"s ","REG");
            System.out.printf("%-"+nameWidth+"s ","NAME");
            System.out.printf("%-"+courseWidth+"s ","COURSE");
            System.out.printf("%-"+branchWidth+"s ","BRANCH");
            System.out.printf("%-"+yearWidth+"s ","YEAR");
            System.out.printf("%-"+semesterWidth+"s ","SEMESTER");
            System.out.println();
            System.out.println("=".repeat(width));
            Map details = (Map)studentMarksMap1.get(registerNumber[i]);
            System.out.printf("%-"+regWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"reg"));
            System.out.printf("%-"+nameWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"name"));
            System.out.printf("%-"+courseWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"course"));
            System.out.printf("%-"+branchWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"branch"));
            System.out.printf("%-"+yearWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"year"));
            System.out.printf("%-"+semesterWidth+"s ",printData(studentDetailsMap1,registerNumber[i],"semester"));
            System.out.println();
            System.out.println("-".repeat(width));
            int subjectWidth = obj.calculateWidthMarks(studentMarksMap1,registerNumber[i],"subject");
            int markWidth = 5;
            System.out.printf("%-"+subjectWidth+"s ","Subject");
            System.out.printf("%-"+markWidth+"s ","Marks");
            System.out.printf("%-"+markWidth+"s ","Grade");
            System.out.println();
            System.out.println("-".repeat(width));
            printMarkData(studentMarksMap1,registerNumber[i],subjectWidth,markWidth);
            System.out.println("-".repeat(width));

        }
    }
    public int calculateWidth (Map studentDetailsMap2,Long registerNumber,String key)
    {
        int width = key.length();
        Map details = (Map) studentDetailsMap2.get(registerNumber);
        int dataWidth = details.get(key).toString().length();
        width=Math.max(width,dataWidth);
        return width;
    }
    public String printData(Map studentDetailsMap1,Long registerNumber,String key)
    {
        String data = "";
        Map details = (Map) studentDetailsMap1.get(registerNumber);
        data=details.get(key).toString();
        return data;
    }
    public int calculateWidthMarks (Map studentMarksMap1,Long registerNumber,String key)
    {
        int width = key.length();
        Map markDetails = (Map) studentMarksMap1.get(registerNumber);
        String[] subjects = new String[markDetails.keySet().size()];
        markDetails.keySet().toArray(subjects);
        for (String subject : subjects) {
          width=Math.max(width,subject.length());
        }
       return width;
    }
    public void printMarkData (Map studentMarksMap3,Long registerNumber,int width1,int width2)
    {
        Map subjectDetails = (Map) studentMarksMap3.get(registerNumber);
        String [] subjectNames = new String[subjectDetails.keySet().size()];
        subjectDetails.keySet().toArray(subjectNames);
        for (String subjectName : subjectNames) {
            System.out.printf("%-"+width1+"s ",subjectName);
            System.out.printf("%-"+width2+"s ",subjectDetails.get(subjectName));
            double mark = (double) subjectDetails.get(subjectName);
            char grade = calculateGrade(mark);
            System.out.printf("%-"+width2+"s ",grade);
            System.out.println();
        }
    }
}
