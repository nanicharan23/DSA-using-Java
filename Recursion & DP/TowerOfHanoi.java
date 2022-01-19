public class TowerOfHanoi {
    static int ndisks;
    public static void main(String args[])
    {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n;
        System.out.println("Enter the no disks:");
        n=sc.nextInt();
        doTowers(n,'A','B','C');
    }
    static void doTowers(int topN,char from,char inter,char to)
    {
        if(topN==1)
            System.out.println("Disk 1 from "+from+" to "+to);
        else
        {
            doTowers(topN-1, from, to, inter);
            System.out.println("Disk "+topN+" from "+from+" to "+to);
            doTowers(topN-1,inter,from,to);
        }
    }
}