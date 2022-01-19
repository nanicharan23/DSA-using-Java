import java.util.*;
class Factorial
{
    static int fact(int n)
    {
        if(n==0)
        return 1;
        else 
        return n* fact(n-1);
    }
    public static void main(String args[])
    {
        int number;
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        System.out.println(fact(number));
    }
}