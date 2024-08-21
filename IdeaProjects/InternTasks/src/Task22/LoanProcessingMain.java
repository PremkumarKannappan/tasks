package Task22;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanProcessingMain
{
    public static boolean nameValid(String name) throws Exception {
        if(name == null || name.isEmpty())
        {
            throw new Exception("Name can't be null");
        }
        if(!name.matches("[A-Z][a-zA-Z]*\\s[A-Z]"))
        {
            throw new Exception("Name does not match the pattern");
        }
        else
            return true;
    }

    public static boolean dateValid(String date) throws Exception {
        if(date == null || date.isEmpty())
        {
            throw new Exception("Date can't be null");
        }
        if(!date.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            throw new Exception("Date does not match the pattern");
        }
        else
            return true;
    }

    public static  int calculateAge(String date)  {
        int age ;
        LocalDate dateOfBirth = LocalDate.parse(date) ;
        int  today = LocalDate.now().getYear() ;
        int birthYear = dateOfBirth.getYear() ;
        age = today - birthYear ;
        return age;
    }

    public static boolean validateAddress(String address) throws Exception {
        if(address == null || address.isEmpty())
        {
            throw new Exception("Address can't be null");
        }
        if(!address.matches("[a-zA-Z0-9\\s/\\-,]+"))
        {
            throw new Exception("Address is not valid special characters are not allowed except '/',',','-' ");
        }
        else
            return true;
    }

    public static boolean validateEmail(String email) throws Exception {
        if(email == null || email.isEmpty())
        {
            throw new Exception("Email can not be empty");
        }
        if(!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
        {
            throw new Exception("Email does not matches the pattern");
        }
        else
            return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) throws Exception {
        if(phoneNumber == null || phoneNumber.isEmpty())
        {
            throw new Exception("Phone number can't be empty");
        }
        if(!phoneNumber.matches("[6-9][0-9]{9}"))
        {
            throw new Exception("Phone number does not match the pattern");
        }
        return true;
    }

    public static boolean validateIdProof(String idProof,String type) throws Exception {
        boolean flag = false;
        switch (type)
        {
            case "aadhaar":
                if(idProof == null || idProof.isEmpty())
                {
                    throw new Exception("Aadhaar number can not be empty");
                }
                if(!idProof.matches("[0-9]{12}"))
                {
                    throw new Exception("Aadhaar number is not valid : enter valid aadhar");
                }
                else
                    return true;
            case "licence":
                if(idProof == null || idProof.isEmpty())
                {
                    throw new Exception("Licence number can not be empty");
                }
                if(!idProof.matches("[A-Z]{2}\\d{2}\\d{4,7}"))
                {
                    throw new Exception("Licence number is not valid : enter valid licence");
                }
                else
                    return true;
            case "pan":
                if(idProof == null || idProof.isEmpty())
                {
                    throw new Exception("PAN number can not be empty");
                }
                if(!idProof.matches("[A-Z]{5}[0-9]{4}[A-Z]"))
                {
                    throw new Exception("PAN number is not valid : enter valid PAN");
                }
                else
                    return true;
            case "pass":
                if(idProof == null || idProof.isEmpty())
                {
                    throw new Exception("Passport number can not be empty");
                }
                if(!idProof.matches("[A-Z]{1,2}[0-9]{6,7}"))
                {
                    throw new Exception("Passport number is not valid : enter valid Passport id");
                }
                else
                    return true;
        }
        return flag;
    }

    public static boolean validateSalary(double salary) throws Exception {
        boolean isSalaryValid = false;
        if(salary == 0)
        {
            throw new Exception("Amount value can not be zero");
        }
        if(salary < 0)
        {
            throw new Exception("Amount value can not be a negative value");
        }
        else if(salary > 0)
        {
            isSalaryValid = true;
        }
        return isSalaryValid;
    }

    public static boolean validateLoanAmount ( double loan, double eligibleLoan) throws Exception
    {
        boolean isLoanValid = false;
        if(loan == 0)
        {
            throw new Exception("Amount value can not be zero");
        }
        if(loan < 0)
        {
            throw new Exception("Amount value can not be a negative value");
        }
        else if(loan > 0)
        {
            if(loan <= eligibleLoan)
                isLoanValid = true;
            else
                throw new Exception("Entered amount is not eligible");
        }
        return isLoanValid;
    }

    public static void main(String[] args) {
        boolean isSuccess;
        do {
            isSuccess = false;
            Scanner sc = new Scanner(System.in);
            String name = "", dob = "", address = "", email = "", idProof = "";
            int age;
            String phone = "";

            boolean isNameValid;
            System.out.println("Enter your name: ");
            do {
                isNameValid = false;
                try {
                    name = sc.nextLine();
                    isNameValid = nameValid(name);
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

            boolean isDobValid = false;
            System.out.println("Enter your DateOfBirth: ");
            do {
                try {
                    dob = sc.nextLine();
                    isDobValid = dateValid(dob);
                    if (!isDobValid) {
                        throw new Exception("Something went wrong please try again");
                    }
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        System.out.println(e.getMessage() + "\nEnter a valid date");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage() + "\nEnter a valid date in the format YYYY-MM-DD");
                    }
                }
            } while (!isDobValid);

            age = calculateAge(dob);

            boolean isAddressValid;
            System.out.println("Enter your Address: ");
            do {
                isAddressValid = false;
                try {
                    address = sc.nextLine();
                    isAddressValid = validateAddress(address);
                    if (!isAddressValid) {
                        throw new Exception("Something went wrong please try again");
                    }
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        System.out.println(e.getMessage() + "\nEnter a valid address");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage() + "\nEnter a valid address in the general format");
                    }
                }
            } while (!isAddressValid);

            boolean isEmailValid;
            System.out.println("Enter your Email");
            do {
                isEmailValid = false;
                try {
                    email = sc.nextLine();
                    isEmailValid = validateEmail(email);
                    if (!isEmailValid) {
                        throw new Exception("Something went wrong please try again");
                    }
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        System.out.println(e.getMessage() + "\nEnter a valid email");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage() + "\nEnter a valid email address in the general format");
                    }
                }
            } while (!isEmailValid);

            boolean isPhoneValid;
            System.out.println("Enter your Phone number");
            do {
                isPhoneValid = false;
                try {
                    phone = sc.nextLine();
                    isPhoneValid = validatePhoneNumber(phone);
                    if (!isPhoneValid) {
                        throw new Exception("Something went wrong please try again");
                    }
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        System.out.println(e.getMessage() + "\nEnter a valid phone");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage() + "\nEnter a valid phone in the format");
                    }
                }
            } while (!isPhoneValid);

            boolean isIdProofValid = false;
            int idProofChoice = 1; String idType = "";
            boolean idProofChoiceValid;
            System.out.println("Enter your type of id proof: ");
            do {
                System.out.println("1.Aadhaar card \t 2.Licence Number \n3.PAN number \t4.Passport Number");
                do {
                    idProofChoiceValid = false;
                    try {
                        idProofChoice = sc.nextInt();
                        idType = switch (idProofChoice) {
                            case 1 -> {
                                idProofChoiceValid = true;
                                yield "Aadhaar";
                            }
                            case 2 -> {
                                idProofChoiceValid = true;
                                yield "Licence";
                            }
                            case 3 -> {
                                idProofChoiceValid = true;
                                yield "PAN";
                            }
                            case 4 -> {
                                idProofChoiceValid = true;
                                yield "Passport";
                            }
                            default -> throw new Exception("Invalid choice");
                        };
                    } catch (Exception e) {
                        if (e instanceof IllegalArgumentException) {
                            System.out.println(e.getMessage() + "\nEnter a valid id choice");
                            sc.nextLine();
                        } else if (e instanceof InputMismatchException) {
                            System.out.println(e.getMessage() + "\nEnter a valid choice");
                            sc.nextLine();
                        } else {
                            System.out.println(e.getMessage());
                        }
                    }
                } while (!idProofChoiceValid);
                sc.nextLine();
                try {
                    switch (idProofChoice) {
                        case 1:
                            System.out.println("Enter your Aadhaar ID in the correct format with 12 digits: ");
                            idProof = sc.nextLine();
                            isIdProofValid = validateIdProof(idProof, "aadhaar");
                            break;
                        case 2:
                            System.out.println("Enter your Licence Number in the correct format of \n two letters for the state code, followed by 2 digits for the RTO code, and 7 digits for the unique number: ");
                            idProof = sc.nextLine();
                            isIdProofValid = validateIdProof(idProof, "licence");
                            break;
                        case 3:
                            System.out.println("""
                                    Enter your Pan card number in the correct format of\s
                                     The first five characters are always letters.
                                     The next four characters are always digits.
                                     The last character is always a letter.:\s""");
                            idProof = sc.nextLine();
                            isIdProofValid = validateIdProof(idProof, "pan");
                            break;
                        case 4:
                            System.out.println("Enter your Passport number in the correct format of\n eight characters long, beginning with one or two letters followed by six or seven digits :");
                            idProof = sc.nextLine();
                            isIdProofValid = validateIdProof(idProof, "pass");
                            break;
                        default:
                            throw new Exception("Invalid choice");
                    }
                } catch (Exception e) {
                    if (e instanceof IllegalArgumentException) {
                        System.out.println(e.getMessage() + "\nEnter a valid id ");
                        sc.nextLine();
                    } else if (e instanceof InputMismatchException) {
                        System.out.println(e.getMessage() + "\nEnter a valid id");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage());
                    }
                }
            } while (!isIdProofValid);

            System.out.println("Enter your Employer Name: ");
            String employerName = sc.nextLine();
            System.out.println("Enter your Job Title: ");
            String jobTitle = sc.nextLine();

            System.out.println("Enter your bank from the below list");
            System.out.print("\n1.IOB \t2.SBI \t3.Indian \n4.CUB \t5.TMB \t6.Canara");
            boolean isBankValid ; int bank = 0; String bankName = "";
            do{
                isBankValid = false;
                try{
                    bank = sc.nextInt();
                    bankName = switch (bank) {
                        case 1 -> {
                            isBankValid = true;
                            yield "Task23.IOB";
                        }
                        case 2 -> {
                            isBankValid = true;
                            yield "SBI";
                        }
                        case 3 -> {
                            isBankValid = true;
                            yield "Indian";
                        }
                        case 4 -> {
                            isBankValid = true;
                            yield "CUB";
                        }
                        case 5 -> {
                            isBankValid = true;
                            yield "TMB";
                        }
                        case 6 -> {
                            isBankValid = true;
                            yield "Canara";
                        }
                        default -> throw new Exception("Invalid choice selected");
                    };
                }
                catch (Exception e)
                {
                    if(e instanceof InputMismatchException)
                    {
                        System.out.println(e.getMessage()+" Enter a Valid choice ");
                        sc.nextLine();
                    }
                    else {
                        System.out.println(e.getMessage());
                    }
                }
            }while (!isBankValid);

            System.out.println("Enter your monthly net salary");
            boolean isSalaryValid;
            double salary = 0;
            do {
                isSalaryValid = false;
                try {
                    salary = sc.nextDouble();
                    isSalaryValid = validateSalary(salary);
                } catch (Exception e) {
                    if (e instanceof InputMismatchException) {
                        System.out.println(e.getMessage() + " : Invalid Input enter positive salary value");
                        sc.nextLine();
                    } else {
                        System.out.println(e.getMessage() + " : Enter a valid amount");
                    }
                }
            } while (!isSalaryValid);

            Salary sal = new Salary(name, age, dob, address, phone, email, idProof,idType,bankName, employerName, jobTitle, salary);

            LoanProcessing loan = new LoanProcessing();

            if (age > 18) {
                System.out.println("Enter how many years do you continue in this role constantly");
                int years = 0;
                boolean yearsValid;
                do {
                    yearsValid = false;
                    try {
                        years = sc.nextInt();
                        if (years < 0 || years == 0) {
                            throw new Exception("Years can not be zero or negative value");
                        }
                        if (age + years > 56) {
                            throw new Exception("Given years are not comes under your service years please enter lower value");
                        } else {
                            yearsValid = true;
                        }
                    } catch (Exception e) {
                        if (e instanceof InputMismatchException) {
                            System.out.println(e.getMessage() + "Enter a valid input");
                        } else {
                            System.out.println(e.getMessage());
                        }
                    }
                } while (!yearsValid);
                System.out.println("Enter your obligations like existing EMIs for any other loans, rent, or any other recurring monthly expenses. Enter the total amount");
                boolean isObligationsValid;
                double obligations = 0;
                do {
                    isObligationsValid = false;
                    try {
                        obligations = sc.nextDouble();
                        if (obligations < 0) {
                            throw new Exception("Amount can not be negative Value");
                        }
                        if (obligations >= salary) {
                            throw new Exception("Not a valid input : obligations greater than salary");
                        }
                        if (obligations < salary) {
                            isObligationsValid = true;
                        }
                    } catch (Exception e) {
                        if (e instanceof InputMismatchException) {
                            System.out.println(e.getMessage() + " :Enter a valid Amount");
                            sc.nextLine();
                        } else {
                            System.out.println(e.getMessage());
                        }
                    }
                } while (!isObligationsValid);

                if (obligations > salary * 0.45) {
                    System.out.println("sorry you can't avail loan ");
                }
                else {
                    double eligibleAmount = loan.calculateEligibleAmount(salary, obligations, years,bank);
                    String eligible = String.format("%.2f",eligibleAmount);
                    boolean isEnough;
                    if (eligibleAmount <= 0) {
                        System.out.println("Sorry you are not eligible to avail loan");
                    }
                    else {
                        System.out.println("You are eligible to avail loan up to : " + eligible +" ( **WITH INTEREST)");
                        do {
                            isEnough = false;
                            System.out.println("Enter the amount you want to avail as loan");
                            double loanAmount = 0;
                            boolean isLoanAmountValid;
                            do {
                                isLoanAmountValid = false;
                                try {
                                    loanAmount = sc.nextDouble();
                                    isLoanAmountValid = validateLoanAmount(loanAmount, eligibleAmount);
                                } catch (Exception e) {
                                    if (e instanceof InputMismatchException) {
                                        System.out.println(e.getMessage() + " :Enter a valid amount");
                                        sc.nextLine();
                                    } else {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            } while (!isLoanAmountValid);
                            double months = years * 6;
                            loan.printStatement(sal);
                            loan.loanProcessing(loanAmount, months, eligibleAmount,bank);
                            System.out.println();
                            System.out.println("If you want to process another amount enter 1 or 0");
                            int choice ;
                            boolean choiceValid ;
                            do{
                                choiceValid = false;
                                try{
                                    choice = sc.nextInt();
                                    switch (choice)
                                    {
                                        case 1:
                                            choiceValid = true;
                                            break;
                                        case 0:
                                            choiceValid = true;
                                            isEnough = true;
                                            break;
                                        default:
                                            System.out.println("Enter a valid choice");
                                    }
                                }
                                catch(Exception e)
                                {
                                    System.out.println("Invalid Input : enter a valid input");
                                    sc.nextLine();
                                }
                            }while(!choiceValid);
                        }while(!isEnough);
                    }
                }
            } else {
                System.out.println("You are not eligible to avail loan : YOU ARE NOT 18 YET");
            }



            System.out.println("If you Want to Continue enter 1 or 0 ");
            boolean choiceValid ; int choice;
            do{
                choiceValid = false;
                try{
                    choice = sc.nextInt();
                    switch (choice)
                    {
                        case 1:
                            choiceValid = true;
                            break;
                        case 0:
                            choiceValid = true;
                            isSuccess = true;
                            break;
                        default:
                            System.out.println("Enter a valid choice");
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input : enter a valid input");
                    sc.nextLine();
                }
            }while(!choiceValid);
        }while (!isSuccess);
    }
}
