package Task24;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BillGenerate
{
    static Scanner sc = new  Scanner(System.in);
    public static String generateBillId(int counter) {
        return String.format("INV%04d",counter);
    }

    public static String getValidateName() {
        Scanner sc = new Scanner(System.in);
        String name = "";boolean isNameValid;
        do{
            isNameValid = false;
            try {
                name = sc.nextLine();
                if(name == null || name.isEmpty())
                {
                    throw new Exception("Name can not be null");
                }
                if(!name.matches("[A-Z][a-zA-Z]*\\s[A-Z]"))
                {
                    throw new Exception("Name does not matches the pattern (ex: Premkumar K)");
                }
                isNameValid = true;
            }
            catch(Exception e)
            {
                if(e instanceof InputMismatchException)
                {
                    System.out.println(e.getMessage()+": Invalid input");
                }
                else
                {
                    System.out.println("Invalid Input: Enter valid name");
                }
            }
        }while (!isNameValid);
        return name;
    }

    public static String getValidatePhone(){
        Scanner scan = new Scanner(System.in);
        String phone = "";boolean flag ;
        do {
            flag = false;
            try {
                phone = scan.nextLine();
                if (phone == null || phone.isEmpty()) {
                    throw new Exception("Phone number can't be empty");
                }
                if (!phone.matches("[6-9][0-9]{9}")) {
                    throw new Exception("Phone number does not match the pattern");
                }
                else
                    flag = true;
            }
            catch (Exception e)
            {
                if(e instanceof InputMismatchException)
                    System.out.println(e.getMessage()+": Invalid input enter a valid input");
                else
                    System.out.println(e.getMessage()+": Enter a valid Phone number");
            }
        }while (!flag);
        return phone;
    }

    public static int getValidateNumber(){
        int validNumber=0;
        boolean isSuccess = false;
        do {
            try {
                int num = sc.nextInt();
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
                sc.nextLine();
            }
        }while(!isSuccess);
        return validNumber;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean isSuccess;int counter = 1;
        do{
            isSuccess = false;
            String billId = generateBillId(counter);
            counter++;

            System.out.println("Enter the Customer Name: ");
            String name = getValidateName();
            System.out.println("Enter the customer Phone number:");
            String phone = getValidatePhone();

            System.out.println("Enter the Items purchased:");

            System.out.println("Enter the number of products: ");
            int count = getValidateNumber();

            String [] items = new String[count];
            int [] unit = new int[count];

            BillGenerater bill = new BillGenerater();

            for(int i=0;i<count;i++) {
                System.out.println("Select the item from the list: ");
                System.out.println("S.No\tItem\tItemId");
                for(int j=0;j<bill.items.length;j++) {
                    int serial = j+1;
                    System.out.println(serial+"\t"+bill.items[j]+"\t"+bill.itemId[j]);
                }
                int choice1 = 0;boolean isChoice1Valid;
                do{
                    isChoice1Valid = false;
                    try{
                        choice1 = sc.nextInt();
                        isChoice1Valid = switch (choice1) {
                            case 1, 2, 3, 4, 5, 6 -> true;
                            default -> throw new Exception("Invalid choice: Enter a valid choice");
                        };
                    }
                    catch(Exception e)
                    {
                        if (e instanceof InputMismatchException)
                        {
                            System.out.println(e.getMessage()+": Enter a valid choice");
                            sc.nextLine();
                        }
                        else
                            System.out.println(e.getMessage());
                    }
                }while (!isChoice1Valid);

                System.out.println("Enter the quantity of thee item: ");
                int quantity = getValidateNumber();

                items[i] = bill.items[choice1-1];
                unit[i] = quantity ;
            }

            BillGenerater billing = new BillGenerater(name,phone,billId,unit,items);

            billing.printHeader();
            billing.printData();

            boolean isContinue;int contChoice;
            System.out.println("Do you have another bill enter 1 or 0: ");
            do {
                isContinue = false;
                try{
                    contChoice = sc.nextInt();
                    isSuccess = switch (contChoice) {
                        case 1 -> {
                            isContinue = true;
                            yield false;
                        }
                        case 0 -> {
                            isContinue = true;
                            yield true;
                        }
                        default -> throw new Exception("Invalid Choice : Enter a valid choice");
                    };
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }while (!isContinue);
        }while (!isSuccess);

    }
}
