package Task31;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample
{
    Set<String> exampleSet = new LinkedHashSet<>();
    public void addElements()
    {
        exampleSet.add("SampleString");
        exampleSet.add("PremKumar");
        exampleSet.add("Himalayan");
        exampleSet.add("setExample");
        exampleSet.add("Instagram");
        exampleSet.add("Premkumar");
    }
    public void printSetStream()
    {
        System.out.println("Printing the elements in the set:");
        exampleSet.forEach(System.out::println);
        System.out.println("Printing the elements in sorted order");
        exampleSet.stream().sorted().forEach(System.out::println);
        System.out.println("Removed duplicates from the set");
        exampleSet.stream().distinct().forEach(System.out::println);
        System.out.println("Filtering the collection");
        exampleSet.stream().filter(setElement -> setElement.startsWith("s")).forEach(System.out::println);
        System.out.println("applying limit and skipping the elements");
        exampleSet.stream().limit(5).skip(1).forEach(System.out::println);
    }
}
