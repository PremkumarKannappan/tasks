package Task23;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EducationalLoan
{
    public static boolean ValidateName(String name) throws Exception {
        boolean flag ;
        if(name == null || name.isEmpty())
        {
            throw new Exception("Name can't be null");
        }
        if(!name.matches("[A-Z][a-zA-Z]*\\s[A-Z]"))
        {
            throw new Exception("Name does not match the pattern");
        }
        else
            flag = true ;
        return flag;
    }

    public static long getValidateRegister() {
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
                scan.nextLine();
            }
        }while(!isSuccess);
        return registerNumber;
    }

    public static void main(String[] args) {
        String name = "",  college, degree = "", bank = "";
        long regNo;
        double year = 0, principleAmount = 0, cautionDeposit, emi = 0, cod = 0,tenure = 0;
        Scanner sc = new Scanner(System.in);

        boolean isNameValid;
        System.out.println("Enter your name: ");
        do {
            isNameValid = false;
            try {
                name = sc.nextLine();
                isNameValid = ValidateName(name);
                if (!isNameValid) {
                    throw new Exception("Something went wrong please try again");
                }
            } catch (Exception e) {
                if (e instanceof IllegalArgumentException) {
                    System.out.println(e.getMessage() + "\nEnter a valid name");
                    sc.nextLine();
                } else {
                    System.out.println(e.getMessage() + "\nEnter a valid name (ex: Premkumar K)");
                }
            }
        } while (!isNameValid);

        System.out.println("Enter your RegisterNumber: ");
        regNo = getValidateRegister();

        System.out.println("Enter your College Name: ");
        college = sc.nextLine();

        System.out.println("Enter your degree from the below list ");
        System.out.println("1.B.E \t 2.B.Sc \t3.B.Tech \n4.M.E \t 5.M.Sc \t 6.M.Tech");
        boolean isChoiceValid;int choice;
        do{
            isChoiceValid =false;
            try{
                choice = sc.nextInt();
                isChoiceValid = switch (choice) {
                    case 1 -> {
                        degree = "B.E";
                        yield true;
                    }
                    case 2 -> {
                        degree = "B.Sc";
                        yield true;
                    }
                    case 3 -> {
                        degree = "B.Tech";
                        yield true;
                    }
                    case 4 -> {
                        degree = "M.E";
                        yield true;
                    }
                    case 5 -> {
                        degree = "M.Sc";
                        yield true;
                    }
                    case 6 -> {
                        degree = "M.Tech";
                        yield true;
                    }
                    default -> throw new Exception("Invalid Choice : please enter a valid choice");
                };
            }
            catch (Exception e) {
                if(e instanceof InputMismatchException)
                {
                    System.out.println(e.getMessage()+"Enter a valid input");
                    sc.nextLine();
                }
                else {
                    System.out.println(e.getMessage());
                }
            }
        }while (!isChoiceValid);

        System.out.println("Enter your bank from the below list");
        System.out.println("1.SBI \t2.IOB \t3.CUB \t4.TMB");
        boolean isBankValid; int bankIndex;
        do{
            isBankValid =false;
            try{
                bankIndex = sc.nextInt();
                isBankValid = switch (bankIndex) {
                    case 1 -> {
                        bank = "SBI";
                        yield true;
                    }
                    case 2 -> {
                        bank = "IOB";
                        yield true;
                    }
                    case 3 -> {
                        bank = "CUB";
                        yield true;
                    }
                    case 4 -> {
                        bank = "TMB";
                        yield true;
                    }
                    default -> throw new Exception("Invalid Choice : please enter a valid choice");
                };
            }
            catch (Exception e) {
                if(e instanceof InputMismatchException)
                {
                    System.out.println(e.getMessage()+" : Enter a valid input");
                    sc.nextLine();
                }
                else {
                    System.out.println(e.getMessage());
                }
            }
        }while (!isBankValid);

        System.out.println("Enter the year of studying");
        boolean isYearValid;
        do{
            isYearValid = false;
            try{
                year = sc.nextDouble();
                switch (degree) {
                    case "B.E","B.Tech":
                        if(year >= 1 && year <= 4) {
                            isYearValid = true;
                            cod = 4 - year;
                        }
                        else
                            throw new Exception("Not a valid year for B.E");
                        break;
                    case "B.Sc":
                        if(year >=1 && year <=3) {
                            isYearValid = true;
                            cod = 3-year ;
                        }
                        else
                            throw new Exception("Not a valid year for B.Sc");
                        break;
                    case "M.E","M.Sc","M.Tech":
                        if(year >= 1 && year <=2) {
                            isYearValid = true;
                            cod = 2 - year;
                        }
                        else
                            throw new Exception("Not a valid year for M.E");
                        break;
                }

            }
            catch (Exception e) {
                if(e instanceof InputMismatchException)
                {
                    System.out.println(e.getMessage()+"Enter a valid year");
                }
                else {
                    System.out.println(e.getMessage()+" : Enter a valid Year");
                }
            }
        }while (!isYearValid);

        System.out.println("Enter the principleAmount");
        boolean paValid;
        do{
            paValid = false;
            try{
                principleAmount = sc.nextDouble();
                if(principleAmount >= 30000 && principleAmount <= 1000000)
                {
                    paValid = true;
                }
                else {
                    throw new Exception("Entered amount is not valid");
                }
            }
            catch (Exception e)
            {
                if(e instanceof InputMismatchException)
                {
                    System.out.println(e.getMessage()+ " Enter a valid amount");
                    sc.nextLine();
                }
                else {
                    System.out.println(e.getMessage());
                }
            }
        }while (!paValid);

        System.out.println("Enter the number of years you want to repay");
        boolean isTenureValid;
        do{
            isTenureValid = false;
            try
            {
                tenure = sc.nextDouble();
                if(tenure == 0 || tenure < 0)
                {
                    throw new Exception("not a valid input");
                }
                isTenureValid = true ;
            }
            catch (Exception e)
            {
                if(e instanceof  InputMismatchException)
                {
                    System.out.println(e.getMessage()+": Enter valid year");
                }
                else {
                    System.out.println(e.getMessage());
                }
            }
        }while (!isTenureValid);
        Student student = new Student(name,regNo,college,degree,bank,year,principleAmount,cod,tenure);

        student.printData();
    }
}
