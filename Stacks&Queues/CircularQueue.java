public class CircularQueue {
    int arr[];
    int front;
    int rear;
    int n;
    int maxsize;
    CircularQueue(int size)
    {
        arr=new int[size];
        front=0;
        rear=-1;
        n=0;
        maxsize=size;
    }
    void insert(int ele)
    {
        if(n!=maxsize)
        {
            if(rear==maxsize-1)
                rear=-1;
            arr[++rear]=ele;
            n++; 
        }
        else
        System.out.println("Queue is Full!!!");       
    }
    void delete()
    {
        if(n!=0)
        {
        if(front==maxsize-1)
            front=0;
        else
            front++;
        n--;
        }
        else
            System.out.println("Queue is Empty!!!");
    }
    boolean isEmpty()
    {
        return n==0;
    }
    boolean isFull()
    {
        return n==maxsize;
    }
    int frontpeek()
    {
        return arr[front];
    }
    int size()
    {
        return n;
    }
    void traverse()
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String args[])
    {
        CircularQueue cq=new CircularQueue(5);
        cq.insert(10);
        cq.insert(20);
        cq.insert(30);
        cq.insert(40);
        cq.delete();
        cq.delete();
        cq.delete();
        cq.insert(50);
        cq.insert(60);
        cq.insert(70);
        cq.insert(80);
        cq.traverse();
        System.out.print("\nTraversing from Front to rear:");
        while(!cq.isEmpty())
        {
            System.out.print(cq.frontpeek()+" ");
            cq.delete();
        }

    }
}