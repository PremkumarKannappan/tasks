package Task24;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public interface Bill
{
    public double discountFormula(double amount);
}

class BillGenerater implements Bill{
    private String customerName;
    private String customerPhone;
    private String billId;
    private double discount;
    public final String [] items = new String[] {"Phant","Shirt","Saree","Salvar","T-Shirt","Shorts"};
    public final String [] itemId = new String[] {"Red-01","Red-02","Red-03","Tex-04","Red-04","Red-05"};
    public final double [] rate = new double[] {600,450,1000,500,350,200};
    private int[] units ;
    private double amount ;
    private String[] itemsOrdered ;
    private double [] individualRate ;

    BillGenerater(String customerName1, String customerPhone1, String billId1, int[] units1,String [] itemNames)
    {
        this.customerName = customerName1;
        this.customerPhone = customerPhone1;
        this.billId = billId1;
        this.units = units1;
        this.itemsOrdered = itemNames;
        this.individualRate = calculateIndividualAmount(itemsOrdered);
        this.amount = this.calculateAmount(itemsOrdered);
        this.discount = discountFormula(amount) / 100;
    }

    public BillGenerater() {

    }

    public double[] calculateIndividualAmount(String [] itemsOrd) {
        double [] indAmount = new double[itemsOrd.length];
        int quan;double rateOf;
        for(int i=0;i<itemsOrd.length;i++)
        {
            quan = this.units[i];
            for(int j=0;j<this.items.length;j++)
            {
                if(itemsOrd[i].equals(this.items[j]))
                {
                    rateOf = this.rate[j];
                    indAmount[i] =  (quan * rateOf) ;
                }
            }
        }
        return indAmount;
    }

    public  double calculateAmount(String[] itemsOrd) {
        double amount1 = 0;double quantity = 0, rateOf = 0,rate = 0;
        for(int i=0;i<itemsOrd.length;i++)
        {
            quantity = this.units[i];
            rateOf = this.individualRate[i];
            rate = quantity * rateOf ;
            amount1 = amount1 + rate + (rate * 0.03);
        }

        return amount1;
    }

    @Override
    public double discountFormula(double amount) {
        if(amount <= 3000)
            return 5;
        else if (amount >3000 && amount <= 5000)
            return 8;
        else if (amount > 5000 && amount  <= 10000)
            return 10;
        else if (amount > 10000 && amount <= 25000)
            return 15;
        else if (amount > 25000 && amount <=50000)
            return 20;
        else if (amount > 50000 && amount <= 100000 )
            return 25;
        else if (amount > 100000 && amount <= 250000)
            return 30;
        else if (amount > 250000)
            return 50;
        else
            return 0;
    }

    public void printHeader(){
        System.out.println("=".repeat(80));
        System.out.printf("%-30s"," ");
        System.out.printf("%s","NEW COTTON TEXTILES");
        System.out.println();
        System.out.printf("%-31s"," ");
        System.out.printf("%s","INVOICE - "+this.billId);
        System.out.println();
        System.out.println("=".repeat(80));
        System.out.printf("%-15s","CustomerName : ");
        System.out.printf("%-25s",this.customerName);
        System.out.printf("%-20s"," ");
        System.out.printf("%-5s","Date :");
        System.out.printf("%-15s", LocalDate.now());
        System.out.println();
        System.out.printf("%-15s","CustomerPhone :");
        System.out.printf("%-15s",this.customerPhone);
        System.out.printf("%-30s"," ");
        System.out.printf("%-5s","Time :");
        System.out.printf("%-15s", LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        System.out.println();
        System.out.println("=".repeat(80));
        System.out.printf("%-5s","S.No");
        System.out.printf("%-15s","Item Name");
        System.out.printf("%-10s","Item ID");
        System.out.printf("%-10s","Units");
        System.out.printf("%-10s","Rate");
        System.out.printf("%-10s","Tax");
        System.out.printf("%-10s","Taxable");
        System.out.printf("%-10s","Amount");
        System.out.println();
        System.out.println("-".repeat(80));
    }

    public void printData() {
        System.out.println();
        int counter =1;
        String[] itemIdOrdered = new String[itemsOrdered.length];
        double[] rateOrdered = new double[itemsOrdered.length];
        for(int i=0;i<itemsOrdered.length;i++) {
            for(int j=0;j<items.length;j++)
            {
                if(itemsOrdered[i].equals(items[j]))
                {
                    itemIdOrdered[i] = itemId[j];
                    rateOrdered[i] = rate[j];
                }
            }
        }
        for(int i=0;i<this.itemsOrdered.length;i++)
        {
            System.out.printf("%-5s",counter);
            System.out.printf("%-15s",itemsOrdered[i]);
            System.out.printf("%-10s",itemIdOrdered[i]);
            System.out.printf("%-10s",this.units[i]);
            System.out.printf("%-10.2f",rateOrdered[i]);
            System.out.printf("%-10s","3%");
            System.out.printf("%-10.2f",individualRate[i]);
            System.out.printf("%-10.2f",(individualRate[i] + individualRate[i]*0.03));
            System.out.println();
            System.out.println("-".repeat(80));
            counter++;
        }
        System.out.printf("%-60s"," ");
        System.out.printf("%-10s","SUB TOTAL:");
        System.out.printf("%-10.2f",amount);
        System.out.println();
        System.out.println("-".repeat(80));
        System.out.printf("%-20s","Discount");
        System.out.printf("%-10.2f",discount);
        System.out.printf("%-30s"," ");
        System.out.printf("%-10s","Dis-Price:");
        System.out.printf("%-10.2f",(amount * discount ));
        System.out.println();
        System.out.println("-".repeat(80));
        System.out.printf("%-60s"," ");
        System.out.printf("%-10s","Total");
        System.out.printf("%-10.2f",(amount- amount * discount ));
        System.out.println();
        System.out.println("-".repeat(80));
        System.out.println();

    }
}
