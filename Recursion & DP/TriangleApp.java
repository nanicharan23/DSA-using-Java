import java.util.*;
class TriangleApp
{
    static int triangle(int n)
    {
        if(n==1)
            return 1;
        else 
            return n+(triangle(n-1));
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int number;
        number=sc.nextInt();
        System.out.println(triangle(number));
    }
}