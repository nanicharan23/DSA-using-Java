import java.util.*;
class MergeSort {
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        sort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    void sort(int arr[],int l,int r)
    {
        if(l<r)
        {
            int m=l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    void merge(int arr[],int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++)
        {
            L[i]=arr[l+i];
        }
        for(int j=0;j<n2;j++)
        {
            R[j]=arr[m+1+j];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2)
        {
            if(L[i]<=R[j])
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            arr[k]=L[i];
            k++;
            i++;
        }
        while(j<n2)
        {
            arr[k]=R[j];
            j++;k++;
        }
    }
    public static void main(String[] args) {
        MergeSort m=new MergeSort();
        m.solve();
    }    
}
