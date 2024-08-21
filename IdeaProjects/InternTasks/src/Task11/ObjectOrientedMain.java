package Task11;

public class ObjectOrientedMain {
    public static void main(String[] args) {
        ObjectOriented obj = new ObjectOriented();
        obj.setName("finsurge");
        System.out.println(obj.getName());
        int greatestInTwo = obj.greatestNumber(5,10);
        int greatestInThree = obj.greatestNumber(10,20,30);
        System.out.println(greatestInTwo+"\t"+greatestInThree);
    }
}
