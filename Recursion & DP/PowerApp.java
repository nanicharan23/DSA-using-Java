public class PowerApp {
    static int doPower(int x,int y)
    {
        if(y==1)
            return x;
            if(y%2!=0)
                return x*doPower(x*x,y/2);
        return doPower(x*x, y/2);
    }
    public static void main(String args[])
    {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(doPower(x,y));
    }
}
 