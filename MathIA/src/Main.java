import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

public class Main{
    static char[] possibleCharacter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5','6','8','9','0','!','*','?'};

    public static boolean passwordFound = false;

    public static String generateRandomPassword(int passwordLength)
    {
        StringBuilder password = new StringBuilder();
        Random run = new Random();
        for(int i = 0; i<passwordLength;i++)
        {
            int x = run.nextInt(possibleCharacter.length);
            password.append(possibleCharacter[x]);
        }
        return password.toString();
    }

    static void FindAllCombination(String userPassword, String prefix, int n, int k)
    {

        if (k == 0)
        {
            return ;
        }

        for (int i = 0; i < n; ++i)
        {

            String newPrefix = prefix + possibleCharacter[i];
            if ( userPassword.equals(newPrefix))
            {
                passwordFound = true;
                return;
            }
            FindAllCombination(userPassword,newPrefix, n, k - 1);
        }
    }

    public static void findPassword(String userPassword)
    {
        int maxLength = 8;
        int n = possibleCharacter.length;
        long startTime = System.currentTimeMillis();
        for (int i = 1 ; i < maxLength+1 ; i++)
        {
            if (passwordFound)
                break;
            FindAllCombination(userPassword,"", n, i);
        }
        long endTime = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Password found in " + formatter.format((endTime - startTime)) + " milliseconds");

    }


    public static void main(String[] args) {

        while(true) {
            passwordFound = false;
            Scanner sc = new Scanner(System.in);
            System.out.println("\nPLease enter your password length");
            int userPassword = sc.nextInt();
            if(userPassword == -1)
                break;
            String randomPassword = generateRandomPassword(userPassword);
            System.out.println(randomPassword);
            findPassword(randomPassword);
        }

    }
}