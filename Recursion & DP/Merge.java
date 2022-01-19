public class Merge {
    public static void main(String args[])
    {
        //The two array must be sorted
        int arr1[]={1,3,5,7,9,11};
        int arr2[]={2,4,6,8,10};
        int arr3[]=new int[arr1.length+arr2.length];
        mergeIt(arr1,arr1.length,arr2,arr2.length,arr3);
        for(int i=0;i<arr3.length;i++)
        {
            System.out.print(arr3[i]+" ");
        }
    }
    static void mergeIt(int arr1[],int arr1Size,int arr2[],int arr2Size,int arr3[])
    {
        int arr1Ind=0;
        int arr2Ind=0;
        int arr3Ind=0;
        while(arr1Ind<arr1Size && arr2Ind<arr2Size)
        {
            if(arr1[arr1Ind]<arr2[arr2Ind])
                arr3[arr3Ind++]=arr1[arr1Ind++];
            else
                arr3[arr3Ind++]=arr2[arr2Ind++];
        }
        while(arr1Ind<arr1Size)
        {
            arr3[arr3Ind++]=arr1[arr1Ind++];
        }
        while(arr2Ind<arr2Size)
        {
            arr3[arr3Ind++]=arr2[arr2Ind++];
        }
    }
}