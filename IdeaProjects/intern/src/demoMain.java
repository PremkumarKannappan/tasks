import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class demoMain extends demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        demo1 demo = new demo1();
        String name, addr, dept, phn;
        int age;
        int choice = 0, choice2 = 0,c=0,c1;
        Map map2 = new LinkedHashMap();
        do {
            System.out.println("Enter your choice \n1.Leap year processing \n2.Standard Deviation " +
                    "\n3.User details processing \n4.Static/Final Numbers ");
            c1 = sc.nextInt();
            sc.nextLine();
            switch (c1) {
                case 1:
                    boolean isSuccess ;
                    System.out.println("Enter the year ");
                    do {
                        int year = sc.nextInt();
                        sc.nextLine();
                        if (year < 1000 || year > 10000) {
                            System.out.println("Invalid year\nEnter a valid year");
                            isSuccess = false;
                            continue;
                        }
                        else {
                            demo1 d1 = new demo1();
                            d1.leap(year);
                            isSuccess = true;
                        }
                    }while(!isSuccess);
                    break;
                case 2:
                    System.out.println("Enter the number of data present ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    int [] arr = new int[n];
                    System.out.println("Enter the data set ");
                    for (int i = 0; i < n; i++)
                    {
                        arr[i] = sc.nextInt();
                    }
                    demo1 d1 = new demo1();
                    double stdd  = d1.STDDEV(arr);
                    System.out.println("The standard deviation of the given data set is " + stdd );
                    break;
                case 3:
                    do {
                        Map map1 = new LinkedHashMap();
                        boolean isSuccess1 = false;
                        System.out.println("Enter the Name ");
                        do {
                            name = sc.nextLine();
                            String regex = "^[A-Z][a-z]*\\s+[A-Z]$";
                            if(name.matches(regex))
                            {
                                map1.put("NAME", name);
                                isSuccess1 = true;
                            }
                            else if(!name.matches(regex))
                            {
                                System.out.println("Invalid Name");
                                System.out.println("Enter a valid Name (Ex: PremKumar K)");
                            }
                        }while (!isSuccess1);
                        System.out.println("Enter the Phone Number ");boolean phone = false;
                        do{
                            phn = sc.next();
                            if(phn.length()==10&& phn.matches("^[6-9][0-9]*")) {
                                map1.put("Phone", phn);
                                phone = true;
                            }
                            else
                            {
                                System.out.println("Invalid Phone Number");
                            }
                        }while(!phone);

                        System.out.println("Enter the Address ");
                        addr = sc.next();
                        map1.put("Address", addr);
                        System.out.println("Enter the Department ");
                        boolean isSuccess2=false;
                        do {
                            dept = sc.next();
                            String regex1 = "^([A-Z]\\.)*[A-Z]$";
                            String regex2 = "^[A-Z]+$";
                            if(dept.matches(regex1)||dept.matches(regex2)) {
                                map1.put("Department", dept);
                                isSuccess2 = true;
                            }
                            else
                            {
                                System.out.println("Invalid Department \nEnter a valid Department (Ex: CSE / C.S.E)");
                            }
                        }while (!isSuccess2);
                        System.out.println("Enter the Age ");
                        age = sc.nextInt();
                        map1.put("Age", age);
                        int keyval = 1;
                        if (map2.isEmpty()) {
                            map2.put(keyval, map1);
                            System.out.println("Details Added ,Your ID is:" + keyval);
                        } else {
                            int keys = map2.size();
                            keyval = keys + 1;
                            map2.put(keyval, map1);
                            System.out.println("Details Added ,Your ID is:" + keyval);
                        }
                        System.out.println("If you want to add more enter 1 or 0: ");
                        choice = sc.nextInt();
                    } while (choice == 1);
                    do {
                        System.out.println("Enter the id for printinig the details ");
                        int id = sc.nextInt();
                        demo.Printer(map2, id);
                        System.out.println("If you want to print more enter 1 or 0: ");
                        choice2 = sc.nextInt();
                    } while (choice2 == 1);
                    break;
                case 4:
                    System.out.println("Enter the static number and final number to be set ");
                    demo2 d2 = new demo2();
                    d2.number();
            }
            System.out.println("If you want to continue enter 1 or 0: ");
            c=sc.nextInt();
        }while(c!=0);
    }
}
