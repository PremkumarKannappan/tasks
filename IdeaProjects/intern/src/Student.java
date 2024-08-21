import java.util.*;

public class Student
{
    static Map StudentMap = new LinkedHashMap<>();
    static Map CollegeMap = new LinkedHashMap<>();
    public void userDetails() {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        Map map1 = new LinkedHashMap();
        System.out.println("Enter Student ID");
        String id = sc.next();
        sc.nextLine();

        System.out.println("Enter Student Gender");
        String gender = sc.next();
        System.out.println("Enter Student Blood group");
        String bloodGroup = sc.next();
        System.out.println("Enter Student Date of Birth in the format yyyy-mm-dd");
        boolean isDate = false;
        Date dob ;
        do {
            String dateOfBirth = sc.next();
            if(dateOfBirth.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])"))
            {
                map1.put("dateOfBirth",dateOfBirth);
                isDate = true;
            }
            else
            {
                System.out.println("Invalid Date of Birth");
                System.out.println("Enter Valid Date of Birth (EX: 1990-01-01)");
            }
        }while (!isDate);
        System.out.println("Enter Student Age");
        int age= sc.nextInt();
        System.out.println("Enter Student Address");
        String address = sc.next();
        System.out.println("Enter Student Phone");
        boolean isPhoneValid=false;
        do {
            String phone = sc.next();
            if (phone.matches("[6-9][0-9]{9}")) {
                map1.put("phone", phone);
                isPhoneValid = true;
            }
            else
            {
                System.out.println("Invalid Phone");
                System.out.println("Enter Valid Phone Number");
            }
        } while (!isPhoneValid);
        System.out.println("Enter Student Email");
        boolean isEmailValid = false;
        do{
            String email = sc.next();
            if(email.matches("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+"))
            {
                map1.put("email", email);
                isEmailValid = true;
            }
            else
            {
                System.out.println("Invalid Email");
                System.out.println("Enter Valid Email");
            }
        }while (!isEmailValid);
        System.out.println("Enter Student Password");
        boolean isPasswordValid = false;
        do {
            String password = sc.next();
            if(password.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}"))
            {
                map1.put("password", password);
                isPasswordValid = true;
            }
            else
            {
                System.out.println("Invalid Password");
                System.out.println("Enter Valid Password that contains atleast one uppercase letter, one lowercase letter, one digit and one special character" +
                        "and the length must be more than or equal to 8");
            }
        }while(!isPasswordValid);
        System.out.println("Enter Student Confirm Password");
        boolean isConfirm = false;
        do {
            String confirmPassword = sc.next();
            if(confirmPassword.equals(map1.get("password").toString()))
            {
                isConfirm = true;
                map1.put("confirmPassword", confirmPassword);
            }
            else
            {
                System.out.println("Invalid Confirm Password doesn't match with the Password");
                System.out.println("Confirm Password");
            }
        }while (!isConfirm);
        map1.put("id", id);
        map1.put("gender", gender);
        map1.put("age", age);
        map1.put("bloodGroup", bloodGroup);
        map1.put("address", address);
        StudentMap.put(id, map1);
        System.out.println("Student details are stored in file");
        student.collegeDetails(id);
    }
    public void collegeDetails(String id)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter College Name");
        String name = sc.nextLine();
        System.out.println("Enter College code");
        String code = sc.next();
        System.out.println("Enter Course Name");
        String courseName = sc.next();
        System.out.println("Enter Branch Name");
        String branchName = sc.next();
        System.out.println("Enter current year");
        int year = sc.nextInt();
        Map map1 = new LinkedHashMap();
        map1.put("College name", name);
        map1.put("College code", code);
        map1.put("Course", courseName);
        map1.put("Branch", branchName);
        map1.put("Year", year);
        CollegeMap.put(id, map1);
        System.out.println("College details are stored in file");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        char choice; int choice1,choice2=0;
        System.out.println("Student Management System");
        do {
            System.out.println("Enter Your choice from the below mentioned\n");
            System.out.print("1.Add new Student\n2.Print Student Details\n3.Print all student Details");
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    do {
                    student.userDetails();
                    System.out.println("If you want to add more students type y or n");
                    choice = sc.next().charAt(0);
                    sc.nextLine();
                    } while (choice == 'Y' || choice == 'y');
                    break;
                case 2:
                    System.out.println("Enter the Student id:");
                    String sid = sc.next();
                    Map stuDetails = new LinkedHashMap();
                    stuDetails = (Map) StudentMap.get(sid);
                    if(!stuDetails.isEmpty()) {
                        System.out.println("Enter the Password");
                        String pass = sc.next();
                        if (pass.equals(stuDetails.get("password").toString())) {
                            Map colDetails = new LinkedHashMap();
                            colDetails = (Map) CollegeMap.get(sid);
                            System.out.println("***********************************************************************************");
                            System.out.println("Student Name:\t" + stuDetails.get("name") + "\t\t\t\t\tStudent ID:\t" + stuDetails.get("id"));
                            System.out.println("DOB:         \t" + stuDetails.get("dateOfBirth") + "\t\t\t\t\tEmail:\t" + stuDetails.get("email"));
                            System.out.println("Age:         \t" + stuDetails.get("age"));
                            System.out.println("Gender:      \t" + stuDetails.get("gender"));
                            System.out.println("Blood group: \t" + stuDetails.get("bloodGroup"));
                            System.out.println("Address:     \t" + stuDetails.get("address"));
                            System.out.println("Phone:       \t" + stuDetails.get("phone"));
                            System.out.println("***********************************************************************************");
                            System.out.println("College Name:\t" + colDetails.get("College name"));
                            System.out.println("College Code:\t" + colDetails.get("College code"));
                            System.out.println("Course:      \t" + colDetails.get("Course"));
                            System.out.println("Branch:      \t" + colDetails.get("Branch"));
                            System.out.println("Year:        \t" + colDetails.get("Year"));
                            System.out.println("***********************************************************************************");
                        } else {
                            System.out.println("Password is incorrect");
                        }
                        break;
                    }
                    else
                    {
                        System.out.println("No Student Found");
                    }
                    break;
                case 3:
                    Student student2 = new Student();
                    int nameWidth = student2.calculateWidthStudent(StudentMap,"name");
                    int idWidth = student2.calculateWidthStudent(StudentMap,"id");
                    int ageWidth = student2.calculateWidthStudent(StudentMap,"age");
                    int genderWidth = student2.calculateWidthStudent(StudentMap,"gender");
                    int bloodGroupWidth = student2.calculateWidthStudent(StudentMap,"bloodGroup");
                    int addressWidth = student2.calculateWidthStudent(StudentMap,"address");
                    int phoneWidth = student2.calculateWidthStudent(StudentMap,"phone");
                    int emailWidth = student2.calculateWidthStudent(StudentMap,"email");
                    int dateWidth = student2.calculateWidthStudent(StudentMap,"dateOfBirth");
                    int CollegeNameWidth = student2.calculateWidthCollege(CollegeMap,"College name");
                    int CollegeCodeWidth = student2.calculateWidthCollege(CollegeMap,"College code");
                    int CourseWidth = student2.calculateWidthCollege(CollegeMap,"Course");
                    int BranchWidth = student2.calculateWidthCollege(CollegeMap,"Branch");
                    int YearWidth = student2.calculateWidthCollege(CollegeMap,"Year");
                    int count = nameWidth+idWidth+ageWidth+genderWidth+bloodGroupWidth+addressWidth+phoneWidth+emailWidth+dateWidth+CollegeNameWidth+CollegeCodeWidth+CourseWidth+BranchWidth+YearWidth+20;
                    System.out.println("*".repeat(count));
                    System.out.printf("%-"+nameWidth+"s ","Name");
                    System.out.printf("%-"+idWidth+"s ","ID");
                    System.out.printf("%-"+ageWidth+"s ","Age");
                    System.out.printf("%-"+genderWidth+"s ","Gender");
                    System.out.printf("%-"+bloodGroupWidth+"s ","BloodGroup");
                    System.out.printf("%-"+addressWidth+"s ","Address");
                    System.out.printf("%-"+phoneWidth+"s ","Phone");
                    System.out.printf("%-"+emailWidth+"s ","Email");
                    System.out.printf("%-"+dateWidth+"s ","DateofBirth");
                    System.out.printf("%-"+CollegeNameWidth+"s ","CollegeName");
                    System.out.printf("%-"+CollegeCodeWidth+"s ","CollegeCode");
                    System.out.printf("%-"+CourseWidth+"s ","Course");
                    System.out.printf("%-"+BranchWidth+"s ","Branch");
                    System.out.printf("%-"+YearWidth+"s ","CurrentYear");
                    System.out.println();
                    System.out.println("*".repeat(count));
                    String [] arr = new String[StudentMap.size()];
                    StudentMap.keySet().toArray(arr);
                    Arrays.sort(arr);
                    Student student1= new Student();
                    for (String s : arr) {
                        System.out.printf("%-"+nameWidth+"s ",student1.printDetails(StudentMap,s,"name"));
                        System.out.printf("%-"+idWidth+"s ",student1.printDetails(StudentMap,s,"id"));
                        System.out.printf("%-"+ageWidth+"s ",student1.printDetails(StudentMap,s,"age"));
                        System.out.printf("%-"+genderWidth+"s ",student1.printDetails(StudentMap,s,"gender"));
                        System.out.printf("%-"+bloodGroupWidth+"s ",student1.printDetails(StudentMap,s,"bloodGroup"));
                        System.out.printf("%-"+addressWidth+"s ",student1.printDetails(StudentMap,s,"address"));
                        System.out.printf("%-"+phoneWidth+"s ",student1.printDetails(StudentMap,s,"phone"));
                        System.out.printf("%-"+emailWidth+"s ",student1.printDetails(StudentMap,s,"email"));
                        System.out.printf("%-"+dateWidth+"s ",student1.printDetails(StudentMap,s,"dateOfBirth"));
                        System.out.printf("%-"+CollegeNameWidth+"s ",student1.printDetails(CollegeMap,s,"College name"));
                        System.out.printf("%-"+CollegeCodeWidth+"s ",student1.printDetails(CollegeMap,s,"College code"));
                        System.out.printf("%-"+CourseWidth+"s",student1.printDetails(CollegeMap,s,"Course"));
                        System.out.printf("%-"+BranchWidth+"s ",student1.printDetails(CollegeMap,s,"Branch"));
                        System.out.printf("%-"+YearWidth+"s ",student1.printDetails(CollegeMap,s,"Year"));
                        System.out.println();
                    }
            }
            System.out.println("Enter 1 if you want to continue else 0:");
            choice2 = sc.nextInt();
        }while (choice2!=0);
    }
    public int calculateWidthStudent (Map StudentDetails,String keyPass)
    {
        int width =keyPass.length();
        String [] arr = new String[StudentDetails.size()];
        StudentDetails.keySet().toArray(arr);
        for (String key : arr)
        {
            Map map1 = new LinkedHashMap();
            map1 = (Map) StudentDetails.get(key);
            int len = map1.get(keyPass).toString().length();
            width = Math.max(width,len);
        }
        return width;
    }
    public int calculateWidthCollege(Map collegeMap,String keyPass)
    {
        int width =keyPass.length();
        String [] arr = new String[collegeMap.size()];
        collegeMap.keySet().toArray(arr);
        for(String key : arr)
        {
            Map map1 = new LinkedHashMap();
            map1 = (Map) collegeMap.get(key);
            int len = map1.get(keyPass).toString().length();
            width = Math.max(width,len);
        }
        return width;
    }
    public String printDetails (Map StudentDetails,String keyOut,String keyIn)
    {
        Map details = (Map) StudentDetails.get(keyOut);
        String str = details.get(keyIn).toString();
        return str;
    }
}
