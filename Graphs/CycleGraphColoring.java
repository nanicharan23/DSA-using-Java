import java.util.*;
public class CycleGraphColoring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();// No of Vertices
        System.out.println("No. of colors require is: " + color(n));
    }    
   static int color(int n)
    {
        if(n%2==0)
        return 2;
        else 
        return 3;
    }
}