class PriorityQueue
{
    int arr[];
    int maxsize;
    int n;
    PriorityQueue(int size)
    {
        maxsize=size;
        n=0;
        arr=new int[size];
    
    }
    void insert(int ele)
    {
        if(n==maxsize)
        System.out.println("Queue is Full!!!");
        else if(n==0)
            arr[n++]=ele;
        else
        {
            int i;
            for(i=n-1;i>=0;i--)
            {
                if(ele>arr[i])
                    arr[i+1]=arr[i];
                else
                {
                    break;
                }
            }
            arr[i+1]=ele;
                    n++;
        }
    }
    void delete()
    {
        n--;
    }
    int peek()
    {
        return arr[n-1];
    }
    void traverse()
    {
        for(int i=n-1;i>=0;i--)
        {
            System.out.println(arr[i]);
        }
    }
    boolean isFull()
    {
       return n==maxsize;
    }
    boolean isEmpty()
    {
        return n==0;
    }
    public static void main(String args[])
    {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(841);
        pq.insert(320);
        pq.insert(632);
        pq.insert(43);
        pq.insert(109);
        pq.insert(500);
        pq.traverse();
        pq.delete();
        pq.traverse();
    }
}