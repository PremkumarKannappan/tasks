package Task31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class ListExample
{
    List<Integer> list = new ArrayList<>();
    public void  addElements()
    {
        list = asList(10,11,15,20,10,19);
    }
    public void printStreamList()
    {
        System.out.println("Printing the elements using foreach ");
        list.forEach(System.out::println);
        List<Integer> sortedStream = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Printing the elements sorted");
        sortedStream.forEach(System.out::println);
        System.out.println("Printing the elements without duplicates");
        sortedStream.stream().distinct().forEach(System.out::println);
        System.out.println("Printing the elements by a filter");
        sortedStream.stream().filter(element -> element<15).forEach(System.out::println);
        System.out.println("Printing the elements of list by skipping alternate elements and at most 4 elements");
        sortedStream.stream().skip(1).limit(4).forEach(System.out::println);
    }

}
