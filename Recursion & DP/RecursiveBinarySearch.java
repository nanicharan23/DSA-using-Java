public class RecursiveBinarySearch {
    static int binarySearch(int arr[],int key,int l,int u)
    {
        int mid=(l+u)/2;
        if(l>u)
            return -1;
        if(arr[mid]==key)
            return mid;
        else if(arr[mid]>key)
           return binarySearch(arr, key,l, mid-1);
        else if(arr[mid]<key)
           return binarySearch(arr, key, mid+1, u);
        return 0;
    }
    public static void main(String args[])
    {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr,3,0,arr.length-1));
    }
}