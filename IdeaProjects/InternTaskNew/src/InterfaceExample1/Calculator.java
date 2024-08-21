package InterfaceExample1;

public class Calculator implements ArithmeticOperations,LogicalOperations
{

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws ArithmeticException {
        return a / b;
    }

    @Override
    public double modulo(double a, double b) throws ArithmeticException {
        return a % b;
    }

    @Override
    public int andOperation(int a, int b) {
        return a & b;
    }

    @Override
    public int orOperation(int a, int b) {
        return a | b ;
    }

    @Override
    public int negationOperation(int a) {
        return ~a;
    }
}
