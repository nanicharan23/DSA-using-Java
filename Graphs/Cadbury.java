import java.util.*;
class Cadbury
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int minl=sc.nextInt();
        int maxl=sc.nextInt();
        int minb=sc.nextInt();
        int maxb=sc.nextInt();
        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
        for(int i=minl;i<=maxl;i++)
        {
            for(int j=minb;j<=maxb;j++)
            {
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                li.add(temp);
            }
        }
        int count=0;
        for(int i=0;i<li.size();i++)
        {
            ArrayList<Integer> temp=li.get(i);
            int l=temp.get(0);
            int b=temp.get(1);
            while(l!=b)
            {
                int max=Math.max(l,b);
                int min=Math.min(l,b);
                max-=min;
                count++;
                l=Math.max(max,min);
                b=Math.min(max,min);
            }
        }
        System.out.println(count);
    }   
}