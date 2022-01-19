class ShellSortApp
{
    static void shellsort(int arr[],int n)
    {
        for(int gap=n/2;gap>0;gap=gap/2)
        {
            for(int j=gap;j<n;j++)
            {
                for(int i=j-gap;i>=0;i=i-gap)
                {
                    if(arr[i+gap]>arr[i])
                        break;
                    else
                    {
                        int temp=arr[i+gap];
                        arr[i+gap]=arr[i];
                        arr[i]=temp;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) //O(n)
        {
            arr[i]=sc.nextInt();
        }
        shellsort(arr,n);
        for(int i=0;i<n;i++)  //O(n)
        {
            System.out.print(arr[i]+" ");
        }
    }
}