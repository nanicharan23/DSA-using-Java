public class MergeSortApp {
      public static void main(String args[]){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int n;
        System.out.println("Enter the size of array:");
        n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        mergeSort(arr,0,n-1);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    static void mergeSort(int arr[],int lb,int ub)
    {
        if(lb<ub)
        {
            int mid=(lb+ub)/2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid+1, ub);
            merge(arr,lb,mid,ub);
        }
    }
    static void merge(int arr[],int lb,int mid,int ub)
    {
       int leftStart=lb;
       int leftEnd=mid;
       int rightStart=leftEnd+1;
       int rightEnd=ub;
       int n=ub-lb+1;
       int temp[]=new int[arr.length];
       int index=leftStart;
       while(leftStart<=leftEnd && rightStart<=rightEnd)
       {
           if(arr[leftStart]<=arr[rightStart])
                temp[index++]=arr[leftStart++];
            else
                temp[index++]=arr[rightStart++];
       }
       while(leftStart<=leftEnd)
       {
           temp[index++]=arr[leftStart++];
       }
       while(rightStart<=rightEnd)
       {
           temp[index++]=arr[rightStart++];
       }
       for(int i=lb;i<index;i++)
       {
           arr[i]=temp[i];
       }
    }
}