 class MaxSumSubarray
 {
     public static int maxSum(int arr[],int k)
     {
         int maxSum=Integer.MIN_VALUE;
         int currSum=0;
         for(int i=0;i<arr.length;i++)
         {
            currSum+=arr[i];
            if(i>=k-1){
                maxSum=Math.max(currSum,maxSum);
                currSum-=arr[i-(k-1)];
            }
         }
         return maxSum;
     }
     public static void main(String[] args) {
         int arr[]={4,2,1,7,8,1,2,8,1,0};
         int k=3;
         System.out.println(maxSum(arr, k));
     }
 }