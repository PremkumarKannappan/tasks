package Task17_18;

import java.util.Scanner;

public class WrapperClassMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // primitive Values
        short primitiveShort;
        byte primitiveByte;
        int primitiveInt;
        long primitiveLong;
        float primitiveFloat;
        double primitiveDouble;

        // Getting input values
        System.out.println("Enter a short value:");
        primitiveShort = sc.nextShort();
        System.out.println("Enter a byte value:");
        primitiveByte = sc.nextByte();
        System.out.println("Enter an int value:");
        primitiveInt = sc.nextInt();
        System.out.println("Enter a long value:");
        primitiveLong = sc.nextLong();
        System.out.println("Enter a float value:");
        primitiveFloat = sc.nextFloat();
        System.out.println("Enter a double value:");
        primitiveDouble = sc.nextDouble();
        System.out.println();

        // Auto boxing
        Byte wrapperByte = primitiveByte;
        Short wrapperShort = primitiveShort;
        Integer wrapperInt = primitiveInt;
        Long wrapperLong = new Long(primitiveLong);
        Float wrapperFloat = Float.valueOf(primitiveFloat);
        Double wrapperDouble = primitiveDouble;

        System.out.println("After boxing to wrapper type");
        printPrimitiveValues(wrapperByte, wrapperShort, wrapperInt, wrapperLong, wrapperFloat, wrapperDouble);
        System.out.println();

        // Unboxing
        primitiveByte = wrapperByte.byteValue();
        primitiveShort = wrapperShort;
        primitiveInt = wrapperInt;
        primitiveLong = wrapperLong;
        primitiveFloat = wrapperFloat;
        primitiveDouble = wrapperDouble;

        System.out.println("After unboxing to primitive type");
        printPrimitiveValues(primitiveByte, primitiveShort, primitiveInt, primitiveLong, primitiveFloat, primitiveDouble);
        System.out.println();

        // Wrapper class methods

        // Byte wrapper methods
        System.out.println("Byte Value as UnSigned int: " + Byte.toUnsignedInt(wrapperByte));
        System.out.println("Parsed Byte from String: " + Byte.parseByte("10"));

        // Short wrapper methods
        System.out.println("Short Value in Hex: " + Integer.toHexString(wrapperShort));

        // Integer wrapper methods
        System.out.println("Int Value in Binary: " + Integer.toBinaryString(wrapperInt));
        System.out.println("Parsed Int from String: " + Integer.parseInt("100"));

        // Long wrapper methods
        System.out.println("Long Value in Octal: " + Long.toOctalString(wrapperLong));
        System.out.println("Parsed Long from String: " + Long.parseLong("1000"));

        // Float wrapper methods
        System.out.println("Float Value as Hash code: " + Float.hashCode(wrapperFloat));
        System.out.println("Parsed Float from String: " + Float.parseFloat("10.5"));

        // Double wrapper methods
        System.out.println("Double Value as String: " + Double.toString(wrapperDouble));
        System.out.println("Parsed Double from String: " + Double.parseDouble("20.5"));
    }

    public static void printPrimitiveValues(Byte wrapperByte, Short wrapperShort, Integer wrapperInt, Long wrapperLong, Float wrapperFloat, Double wrapperDouble) {
        System.out.println("Byte Value: " + wrapperByte);
        System.out.println("Short Value: " + wrapperShort);
        System.out.println("Int Value: " + wrapperInt);
        System.out.println("Long Value: " + wrapperLong);
        System.out.println("Float Value: " + wrapperFloat);
        System.out.println("Double Value: " + wrapperDouble);
    }
}
