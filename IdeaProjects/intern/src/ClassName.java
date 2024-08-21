public class ClassName
{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        ClassName oldObject = new ClassName();
        ClassName newObject = (ClassName) oldObject.clone();
    }
}
<access_modifier> static <return_type> <method_name>( list_of_parameters)
{
    //body
}