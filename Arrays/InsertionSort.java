public class InsertionSort {
    public static void sort(int arr[])
    {
        for(int i=1;i<arr.length;i++)
        {
            int temp=arr[i];
            int j=i;
            while(j>0 && arr[j-1]>=temp)
            {
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }
    public static void main(String args[])
    {
        int arr[]=new int[10];
        java.util.Scanner sc=new java.util.Scanner(System.in);
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
            
        }  
    }
}