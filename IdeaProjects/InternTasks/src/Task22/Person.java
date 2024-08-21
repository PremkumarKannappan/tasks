package Task22;

public class Person
{
    private String name;
    private int age;
    private String dob;
    private String address ;
    private String  phone;
    private String email;
    private String idProof;
    private String idType;
    private String bank;

    public Person(String name, int age, String dob, String address, String  phone, String email, String idProof,String idType,String bank)
    {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.idProof = idProof;
        this.idType = idType;
        this.bank = bank;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDob()
    {
        return this.dob;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAddress()
    {
        return this.address;
    }

    public String getIdProof()
    {
        return this.idProof;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public String getIdType(){return this.idType;}

    public String getBank(){return this.bank;}
}
