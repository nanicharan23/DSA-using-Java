class OrderedArray
{
    int arr[];
    int n;
    OrderedArray(int size)
    {
        arr=new int[size];
        n=0;
    }
    void insert(int ele)
    {
        int i;
       for(i=0;i<n;i++)
       {
           if(arr[i]>ele)
           {
               break;
           }
       }
       for(int j=n;j>i;j--)
       {
           arr[j]=arr[j-1];
       }
       arr[i]=ele;
       n++;
    }
    void delete(int ele)
    {
        for(int i=0;i<n;i++)
        {
            if(arr[i]==ele)
            {
                for(int j=i+1;j<n;j++)
                {
                    arr[j-1]=arr[j];
                }
                n--;
                break;
            }
        }
        System.out.println("Elemented deleted"+" "+ele);
    }
    boolean search(int ele)
    {
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
            if(arr[mid]==ele)
                return true;
            else if(arr[mid]>ele)
                j=mid-1;
            else
                i=mid+1;
        }
        return false;
    }
    void display()
    {
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void main(String args[])
    {
        OrderedArray oa=new OrderedArray(10);
        oa.insert(10);
        oa.insert(30);
        oa.insert(20);
        oa.insert(60);
        oa.insert(50);
        oa.insert(40);
        oa.insert(70);
        oa.display();
        oa.delete(40);
        oa.display();
        System.out.println("The element 40 is present?"+" "+oa.search(40));
    }
}