import java.util.*;
class Knapsack
{
    void findKnap(int arr[],int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(target==arr[i])
                return ;

            if(target>=arr[i])
                findKnap(arr,target-arr[i]);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter the no of items:");
        n=sc.nextInt();
        int arr[]=new int[n];
        int t;
        System.out.println("Enter the target:");
        t=sc.nextInt();
        System.out.println("Enter the items:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        findKnap(arr,target);
    }
}