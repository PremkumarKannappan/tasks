package MethodOverriding;

public class OverridingMain {
    public static void main(String[] args) {

        Yamaha yamaha = new Yamaha(80000,2,"petrol");
        yamaha.run();
        yamaha.details();
        System.out.println();


        Hero hero = new Hero(60000,4,"petrol");
        hero.details();
        hero.run();
        System.out.println();

        Engine yamaha1 = new Yamaha(80000,4,"petrol");
        yamaha1.run();
        yamaha1.details();

        Engine.start();
//        int number1 = 10;
//        int number2 = 20;
//        double number3 = 40;
//        double number4 = 50;
//
//        int result1 = Math.max(number1, number2);
//        double result2 = Math.max(number3,number4);
//
//        System.out.println(result1);
//        System.out.println(result2);

    }
}
