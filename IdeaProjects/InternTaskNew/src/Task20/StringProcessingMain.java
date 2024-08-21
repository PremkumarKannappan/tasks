package Task20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringProcessingMain
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to be Processed");
        String originalString="" ;
        boolean stringValid ;
        do
        {
            stringValid = false ;
            try
            {
                String tempString = sc.nextLine();
                stringValid = StringProcessing.validateString(tempString);
                if(!stringValid)
                {
                    throw new Exception("Enter the string which contains only characters and white spaces");
                }
                originalString = tempString;
            }
            catch(Exception e)
            {
                if(e instanceof InputMismatchException)
                {
                    System.out.println("Invalid Input : Enter only String");
                }
                else
                {
                    System.out.println("Illegal Input: "+e.getMessage());
                }
            }
        }while(!stringValid);
        int [] countVowels = StringProcessing.countVowels(originalString);
        System.out.println("The count of vowels is: ");
        System.out.print("A : "+countVowels[0]);
        System.out.print("\tE : "+countVowels[1]);
        System.out.print("\tI : "+countVowels[2]);
        System.out.print("\tO : "+countVowels[3]);
        System.out.print("\tU : "+countVowels[4]);
        int totalCountVowels =0;
        for(int i: countVowels)
        {
            totalCountVowels+=i;
        }
        System.out.println("\nThe total number of vowels is: "+totalCountVowels);
        String upperCaseString = StringProcessing.findUppercase(originalString);
        if(!upperCaseString.isEmpty()) {
            System.out.println("The upper case letters in the given string is \n" + upperCaseString);
        }
        else {
            System.out.println("There is no upper case letters in the given string");
        }
        String lowerCaseString = StringProcessing.findLowerCase(originalString);
        if(!lowerCaseString.isEmpty()) {
            System.out.println("The lower case letters in the given string is \n"+lowerCaseString);
        }
        else {
            System.out.println("There is no lower case letters in the given string");
        }
        boolean isSuccess;int choice ;
        do {
            isSuccess = false ;
            char specificChar = '*';
            boolean charValid;
            System.out.println("Enter the Character to find its occurrence");
            do {
                charValid = false;
                try {
                    specificChar = sc.next().charAt(0);
                    if (specificChar == ' ' || !Character.isLetter(specificChar)) {
                        throw new Exception("input does not contain  character");
                    }
                    charValid = true;
                } catch (Exception e) {
                    System.out.println("Invalid Character : " + e.getMessage());
                }
            } while (!charValid);
            int occurrence = StringProcessing.countOfSpecificCharacter(originalString, specificChar);
            if (occurrence != 0) {
                System.out.println("The number of specific characters is: " + occurrence);
            } else {
                System.out.println("There is no occurrence of specific characters in the given string");
            }
            System.out.println("if you want to continue enter 1 or 0");
            boolean choiceValid;
            do {
                choiceValid = false;
                try {
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            isSuccess = false;
                            choiceValid = true;
                            break;
                        case 0:
                            isSuccess = true;
                            choiceValid = true;
                            break;
                        default:
                            isSuccess = false;
                            choiceValid = false;
                            System.out.println("Choice is invalid enter a valid choice");
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid input : " + e.getMessage());
                    isSuccess = false;
                    choiceValid = false;
                    sc.nextLine();
                }
            }while (!choiceValid);
        }while(!isSuccess);
        int countOfSpaces = StringProcessing.countOfSpecificCharacter(originalString, ' ');
        if(countOfSpaces == 0) {
            System.out.println("There is no spaces in the given string");
        }
        else
        {
            System.out.println("The number of spaces in the given string is: " + countOfSpaces);
        }
    }
}
