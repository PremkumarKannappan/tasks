package Task21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SalarySlip
{
    public static boolean validateNumber(int number)
    {
        boolean flag = false;
        if(number < 0)
        {
            return flag;
        }
        if(number == 0)
        {
            return flag;
        }
        else
        {
            flag = true;
            return flag;
        }
    }

    public static boolean validateName(String name)
    {
        boolean isNameValid = false;
        if (name.matches("[A-Z][a-zA-Z]*\\s[A-Z]")) {
            isNameValid = true;
        } else {
            System.out.println("Invalid Name");
            System.out.println("Enter Valid Name (EX: Premkumar K)");
        }
        return isNameValid;
    }

    public static String generateID(int i)
    {
        String empID = String.format("EMP%04d", i);
        return empID;
    }

    public static boolean validateBasicPay(double basicPay,String designation)
    {
        boolean basicpayValid = false;
        switch(designation)
        {
            case "Manager":
                if(basicPay >= 20000.00 && basicPay <= 30000.00)
                    basicpayValid = true;
                break;
            case "Supervisor", "Team Leader":
                if(basicPay >= 15000.00 && basicPay <= 25000.00)
                    basicpayValid = true;
                break;
            case "Developer":
                if(basicPay >= 10000.00 && basicPay <= 20000.00)
                    basicpayValid = true;
                break;
            case "Designer":
                if(basicPay >= 10000.00 && basicPay <= 15000.00)
                    basicpayValid = true;
                break;
            case "Project Manager":
                if(basicPay >= 20000.00 && basicPay <= 25000.00)
                    basicpayValid = true;
                break;
            case "Human Resource Manager":
                if(basicPay >= 25000.00 && basicPay <= 35000.00)
                    basicpayValid = true;
                break;
        }
        return basicpayValid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salary Slip");

        String [] designations = new String[]{"Manager","Supervisor","Developer","Designer","Project Manager","Team Leader","Human Resource Manager"};
        String [] desID = new String[] {"DES-01","DES-02","DES-03","DES-04","DES-05","DES-06","DES-07"};
        //Getting the number of employees
        System.out.println("Enter the number of employees");
        boolean isNumberValid ; int noOfEmployees=0;
        do{
            isNumberValid = false ;
            try {
                noOfEmployees = sc.nextInt();
                //validating the number
                isNumberValid = validateNumber(noOfEmployees);
                if(!isNumberValid)
                {
                    throw new Exception("Invalid Input: Enter a valid positive Integer");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Enter a valid number");
                sc.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (!isNumberValid);
        Salary[] salary = new Salary[noOfEmployees];
        sc.nextLine();
        //getting details for the given number of employees
        for(int i = 0; i < noOfEmployees; i++)
        {
            boolean isNameValid = false;String name;
            System.out.println("Enter the Employee "+(i+1)+"Name:");
            do {
                name = sc.nextLine();
                isNameValid = validateName(name);
            }while(!isNameValid);

            String empID = generateID(i+1);

            System.out.println("Enter the employee address");
            String address = sc.nextLine();

            System.out.println("Enter the employee designation as the ID");
            for(int j = 0; j < designations.length; j++)
            {
                System.out.print(desID[j]+" "+designations[j]+"\n");
            }

            boolean isDesgValid ; String designationID ;String designation = "";
            do {
                isDesgValid = false ; boolean anyMatch = false;
                try {
                    designationID = sc.nextLine();
                    if(designationID == null)
                    {
                        throw new Exception("Invalid Designation ID : DesignationID Can not be null");
                    }
                    if(!designationID.matches("^DES-[0-9]{2}"))
                    {
                        throw new Exception("Invalid Designation ID : DesignationID not in correct format");
                    }
                    for(int k = 0; k < designations.length; k++)
                    {
                        if(designationID.equals(desID[k]))
                        {
                            designation = designations[k];
                            anyMatch = true;
                            isDesgValid = true;
                            break;
                        }
                    }
                    if(!anyMatch) {
                        throw new Exception("Invalid Designation ID : given designation ID is not exist");
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while(!isDesgValid);

            System.out.println("Enter the employee basic pay");
            boolean isBasicPayValid; double basicPay = 0;
            do{
                isBasicPayValid = false ;
                try{
                    basicPay = sc.nextDouble();
                    if(basicPay<0)
                    {
                        throw new Exception("Basic pay can not be in negative value");
                    }
                    if(basicPay == 0)
                    {
                        throw new Exception("Basic pay can not be zero");
                    }
                    isBasicPayValid = validateBasicPay(basicPay,designation);
                    if(!isBasicPayValid)
                    {
                        throw new Exception("Basic pay is not met the conditions");
                    }

                }
                catch (InputMismatchException e)
                {
                    System.out.println("Illegal Input : Enter a valid basic pay amount");
                    sc.nextLine();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }while(!isBasicPayValid);
            sc.nextLine();
            salary[i] =new Salary(name,empID,address,designation,basicPay);
            System.out.println("Employee "+empID+" has been created");
        }
        boolean isSuccess; String employeeIdToPrint = "";
        do {
            isSuccess = false ;
            System.out.println("Enter your choice to print the SalarySlip");
            System.out.println("1.Print specific SalarySlip \t2.Print all SalarySlips");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Employee ID");
                    boolean isEmployeeIdValid,matchFound = false ; int objIndex ;
                    do {
                        isEmployeeIdValid = false ;
                        try {
                            employeeIdToPrint = sc.nextLine();
                            if(!employeeIdToPrint.matches("^EMP[0-9]{4}"))
                            {
                                throw new Exception("Employee id doesn't match the format");
                            }
                            for(int j = 0; j < salary.length; j++)
                            {
                                if(employeeIdToPrint.equals(salary[j].getEmployeeID()))
                                {
                                    matchFound = true ;
                                    isEmployeeIdValid = true ;
                                    salary[j].displayDetails();
                                    break;
                                }
                            }
                            if(!matchFound)
                            {
                                throw new Exception("Employee id doesn't exist");
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Invalid Input: Enter a valid employee ID");
                            sc.nextLine();
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }while(!isEmployeeIdValid);
                    break;
                case 2:
                    for (Salary sal : salary) {
                        sal.displayDetails();
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("If you want to continue enter 1 or 0");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    isSuccess = false;
                    break;
                case 0:
                    isSuccess = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    isSuccess = false;
                    break;
            }
        }while(!isSuccess);
    }
}
