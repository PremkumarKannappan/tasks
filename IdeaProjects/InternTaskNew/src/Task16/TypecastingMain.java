package Task16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TypecastingMain
{
    public static void main(String[] args)  {
        byte byteValue ;        //byte value ranges between -128 to 127 these are the signed 8 bits
        short shortValue ;      //short value ranges between -32768 to 32767
        int integerNumber ;     //integer value ranges between -2147483648 to 2147483647
        float floatValue ;
        long longValue ;
        double doubleValue ;
        boolean isSuccess1,isSuccess,isIntegerValid;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your choice from the following list \n1.Byte casting \t2.Short casting \t3.Integer casting " +
                    "\n4.Long casting \t5.Float casting \t6.Double casting");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    do {
                        isSuccess = false;
                        System.out.println("Enter a byte value");
                        try {
                            byteValue = scanner.nextByte();
                            if (byteValue >= 127 || byteValue <= -128) {
                                throw new Exception();
                            }
                            isSuccess = true;
                            System.out.println("Original byte value:" + byteValue);
                            int byteToInt = byteValue;          //widening casting smaller byte value transformed to integer value
                            long byteToLong = byteValue;        //widening casting smaller byte value transformed to long value
                            float byteToFloat = byteValue;      //widening casting smaller byte value transformed to float value
                            double byteToDouble = byteValue;    //widening casting smaller byte value transformed to double value
                            short byteToShort = byteValue;      //widening casting smaller byte value transformed to short value

                            System.out.println("Byte to Short:" + byteToShort);
                            System.out.println("Byte to Integer:" + byteToInt);
                            System.out.println("Byte to Long:" + byteToLong);
                            System.out.println("Byte to Float:" + byteToFloat);
                            System.out.println("Byte to Double:" + byteToDouble);
                        }
                        catch (Exception e) {
                            if (e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else
                            {
                                System.out.println("Something went wrong:"+e.getMessage());
                            }
                        }
                    } while (!isSuccess);
                    break;
                case 2:
                    boolean isShortValid;
                    do{
                        isShortValid = false;
                        System.out.println("Enter a short value");
                        try{
                            shortValue = scanner.nextShort();
                            if(shortValue >= Short.MAX_VALUE || shortValue <= Short.MIN_VALUE) {
                                throw new Exception();
                            }
                            isShortValid = true;
                            System.out.println("Original short value:" + shortValue);
                            //widening casting smaller short value transformed to higher values
                            int shortToInt = shortValue;
                            long shortToLong = shortValue;
                            float shortToFloat = shortValue;
                            double shortToDouble = shortValue;
                            System.out.println("Short to Integer :" + shortToInt);
                            System.out.println("Short to Long:" + shortToLong);
                            System.out.println("Short to Float:" + shortToFloat);
                            System.out.println("Short to Double:" + shortToDouble);

                            //Narrow casting higher short value transformed to lower values
                            byte shortToByte = (byte)shortValue ;
                            System.out.println("Byte to Short:" + shortToByte);
                        }
                        catch (Exception e) {
                            if(e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else {
                                System.out.println("Something went wrong:"+e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    }while (!isShortValid);
                    break;
                case 3:
                    do {
                        System.out.println("Enter a integer value");
                        isIntegerValid = false;
                        try {
                            integerNumber = scanner.nextInt();
                            if (integerNumber >= Integer.MAX_VALUE || integerNumber <= Integer.MIN_VALUE) {
                                throw new Exception();
                            }
                            isIntegerValid = true;
                            System.out.println("original integer value:" + integerNumber);
                            long integerToLong = integerNumber;             //widening casting smaller integer type value transformed to long value
                            float integerToFloat = integerNumber;           //widening casting smaller integer type value transformed to float value
                            double integerToDouble = integerNumber;         //widening casting smaller integer type value transformed to double value
                            short integerToShort = (short)integerNumber;

                            System.out.println("Integer to long:" + integerToLong);
                            System.out.println("Integer to float:" + integerToFloat);
                            System.out.println("Integer to Double:" + integerToDouble);

                            //narrow casting of integer values into smaller values
                            byte integerToByte = (byte)integerNumber;
                            System.out.println("Integer to short:" + integerToShort);
                            System.out.println("Integer to byte:" + integerToByte);
                        }
                        catch (Exception e) {
                            if (e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else
                            {
                                System.out.println("Something went wrong:"+e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    } while (!isIntegerValid);
                    break;
                case 4:
                    boolean isLongValid ;
                    do{
                        isLongValid = false;
                        System.out.println("Enter a long value");
                        try
                        {
                            longValue = scanner.nextLong();
                            if(longValue >= Long.MAX_VALUE || longValue <= Long.MIN_VALUE) {
                                throw new Exception();
                            }
                            isLongValid = true;
                            System.out.println("original long value:" + longValue);

                            //widening casting smaller integer type value transformed to long value
                            float longToFloat = longValue;
                            double longToDouble = longValue;
                            System.out.println("Long to Float:" + longToFloat);
                            System.out.println("Long to Double:" + longToDouble);

                            //narrow casting of long values into smaller values

                            int longToInt = (int) longValue;
                            short longToShort = (short)longValue;
                            byte longToByte = (byte)longValue;
                            System.out.println("Long to Integer:" + longToInt);
                            System.out.println("Long to Short:" + longToShort);
                            System.out.println("Long to Byte:" + longToByte);
                        }
                        catch (Exception e)
                        {
                            if (e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else {
                                System.out.println("Something went wrong:"+e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    }while (!isLongValid);
                    break;
                case 5:
                    boolean isFloatValid ;
                    do {
                        isFloatValid = false;
                        System.out.println("Enter a float value");
                        try
                        {
                            floatValue = scanner.nextFloat();
                            if(floatValue >= Float.MAX_VALUE || floatValue <= Float.MIN_VALUE) {
                                throw new Exception();
                            }
                            isFloatValid = true;
                            System.out.println("original float value:" + floatValue);
                            //widening casting smaller float type value transformed to long value
                            double floatToDouble = floatValue;
                            System.out.println("Float to Double:" + floatToDouble);

                            //narrow casting of integer values into smaller values

                            long floatToLong = (long)floatValue;
                            int floatToInt = (int) floatValue;
                            short floatToShort = (short) floatValue ;
                            byte floatToByte = (byte) floatValue ;
                            System.out.println("Float to long: "+floatToLong);
                            System.out.println("Float to Integer: "+floatToInt);
                            System.out.println("Float to Short: "+floatToShort);
                            System.out.println("Float to Byte: "+floatToByte);
                        }
                        catch (Exception e)
                        {
                            if (e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else
                            {
                                System.out.println("Something went wrong:"+e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    }while(!isFloatValid);
                    break;
                case 6:
                    boolean isDoubleValid ;
                    do{
                        isDoubleValid = false;
                        System.out.println("Enter a double value");
                        try{
                            doubleValue = scanner.nextDouble();
                            if(doubleValue >= Double.MAX_VALUE || doubleValue <= Double.MIN_VALUE) {
                                throw new Exception();
                            }
                            isDoubleValid = true;
                            System.out.println("original double value:" + doubleValue);

                            //narrow casting of double
                            // values into smaller values

                            float doubleToFloat = (float) doubleValue;
                            long doubleToLong = (long) doubleValue;
                            int doubleToInteger = (int) doubleValue;
                            short doubleToShort = (short) doubleValue;
                            byte doubleToByte = (byte) doubleValue;
                            System.out.println("Double to Float:"+doubleToFloat);
                            System.out.println("Double to Long:"+ doubleToLong);
                            System.out.println("Double to int:"+doubleToInteger);
                            System.out.println("Double to Short:"+doubleToShort);
                            System.out.println("Double to Byte:"+doubleToByte);
                        }
                        catch (Exception e)
                        {
                            if (e instanceof InputMismatchException) {
                                System.out.println("Input mismatch exception:Please enter a valid input");
                                scanner.nextLine();
                            }
                            else {
                                System.out.println("Something went wrong:"+e.getMessage());
                                scanner.nextLine();
                            }
                        }
                    }while(!isDoubleValid);
                    break;
            }
            System.out.println("if you want to continue enter 1 or 0");
            boolean isContinue;
            do {
                int choiceOfUser = scanner.nextInt();
                switch (choiceOfUser) {
                    case 1:
                        isSuccess1 = false;
                        isContinue = false;
                        break;
                    case 0:
                        isSuccess1 = true;
                        isContinue = false;
                        break;
                    default:
                        isSuccess1 = false;
                        System.out.println("enter a valid choice");
                        isContinue = true;
                }
            }while(isContinue);
        }while (!isSuccess1);
    }
}
