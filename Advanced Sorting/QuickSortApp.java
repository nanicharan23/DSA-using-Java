import java.util.*;
class QuickSortApp{
    void solve(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    void sort(int arr[],int left, int right)
    {
        if(left>=right)
        return;
        int pivot=arr[(left+right)/2];
        int index=partition(arr,left,right,pivot);
        sort(arr,left,index-1);
        sort(arr,index,right);
    }
    int partition(int arr[],int left, int right , int pivot){
        while(left<=right){
            while(arr[left]<pivot){
                left++;
            }
            while(arr[right]>pivot)
            {
                right--;
            }
            if(left<=right)
            {
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }
    void swap(int arr[],int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
    public static void main(String[] args) {
        QuickSortApp q=new QuickSortApp();
        q.solve();
    }
}