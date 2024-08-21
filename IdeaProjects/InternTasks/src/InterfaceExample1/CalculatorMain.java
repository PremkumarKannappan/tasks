package InterfaceExample1;

public class CalculatorMain
{
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(calc.add(5,10));
        System.out.println(calc.subtract(15, 10));
        System.out.println(calc.multiply(5,10));
        System.out.println(calc.divide(10,5));
        System.out.println(calc.modulo(10,5));

        System.out.println(calc.andOperation(4,2));
        System.out.println(calc.orOperation(4,2));
        System.out.println(calc.negationOperation(4));

        ShiftOperations shift = (number) -> {
            int number1 = ++number;
            System.out.println(number1);};
        shift.rightShift(10);
    }
}
