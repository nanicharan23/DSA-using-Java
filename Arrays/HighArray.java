class HighArray
{
    int arr[];
    int n;
    HighArray(int size)
    {
        arr=new int[size];
        n=0;
    }
    void insert(int ele)
    {
        arr[n]=ele;
        n++;
    }
    void delete(int ele)
    {
        for(int i=0;i<n;i++)
        {
            if(arr[i]==ele)
            {
                for(int j=i;j<n-1;j++)
                {
                    arr[j]=arr[j+1];
                }
                n--;
            }
        }
    }
    boolean find(int ele)
    {
        for(int i:arr)
        {
            if(i==ele)
            return true;
        }
        return false;
    }
    void display()
    {
        System.out.println("Elements are:");
        for(int i=0;i<n;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void main(String args[])
    {
        HighArray ha=new HighArray(10);
        ha.insert(10);
        ha.insert(20);
        ha.insert(30);
        ha.display();
        if(ha.find(20))
            System.out.println("found!!!!");
        else
            System.out.println("Not found!!!!");
            ha.delete(20);
            ha.display();
    }
}