public class PartitionApp {
    static void partitionIt(int arr[],int lb,int ub)
    {
        int pivot=arr[lb];
        int start=lb;
        int end=ub;
        while(start<end)
        {
            while(arr[start]<=pivot)
            {
                start++;
            }
            while(arr[end]>pivot)
            {
                end--;
            }
            if(start<end)
            {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
        }
        int temp=arr[lb];
        arr[lb]=arr[end];
        arr[end]=temp;
    }
    public static void main(String args[])
    {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        } 
        partitionIt(arr,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}