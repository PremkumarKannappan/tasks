package Task20;

public class StringProcessing
{
    public static boolean validateString(String str)
    {
        boolean flag = false;
        String tempString = str.trim();
        tempString = tempString.replaceAll(" ", "");
        if(tempString.isEmpty())
        {
            flag = false;
            return flag;
        }
        if(!tempString.matches("[a-zA-Z]+"))
        {
            flag = false;
            return flag;
        }
        else
        {
            flag = true;
            return flag;
        }
    }
    public static int[] countVowels(String str)
    {
        int[] count = new int[]{0,0,0,0,0};
        int length = str.length();
        str = str.toLowerCase();
        for(int i = 0; i < length; i++)
        {
            switch(str.charAt(i))
            {
                case 'a':
                    count[0]++;
                    break;
                case 'e':
                    count[1]++;
                    break;
                case 'i':
                    count[2]++;
                    break;
                case 'o':
                    count[3]++;
                    break;
                case 'u':
                    count[4]++;
                    break;
            }
        }
        return count;
    }
    public static String findUppercase(String str)
    {
        StringBuilder tempString = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++)
        {

            if(Character.isUpperCase(str.charAt(i)))
            {
                tempString.append(str.charAt(i));
                tempString.append(" ");
            }
        }
        return tempString.toString();
    }
    public static String findLowerCase(String str)
    {
        StringBuilder tempString = new StringBuilder();
        int length = str.length();
        for(int i = 0; i < length; i++)
        {
            if (Character.isLowerCase(str.charAt(i)))
            {
                tempString.append(str.charAt(i));
                tempString.append(" ");
            }
        }
        return tempString.toString();
    }
    public static int countOfSpecificCharacter(String str,char character)
    {
        int count = 0;
        int length = str.length();
        str = str.toLowerCase();
        for(int i = 0; i < length; i++)
        {
            if(str.charAt(i) == character)
                count++;
        }
        return count;
    }
}
