package InterfaceExample1;

public interface ArithmeticOperations
{
    int add(int a, int b);
    int subtract(int a, int b);
    int multiply(int a, int b);
    double divide(double a, double b) throws ArithmeticException;
    double modulo(double a, double b) throws ArithmeticException;
}
