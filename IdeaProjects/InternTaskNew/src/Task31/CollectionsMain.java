package Task31;

import java.util.Scanner;

public class CollectionsMain
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("List Elements :");

        ListExample listObj = new ListExample();
        listObj.addElements();
        listObj.printStreamList();

        SetExample setObj = new SetExample();
        setObj.addElements();
        setObj.printSetStream();

        MapExample mapObj = new MapExample();
        mapObj.addElements();
        mapObj.printSetStream();
    }
}

