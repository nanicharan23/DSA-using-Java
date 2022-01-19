public class Queue {
    int arr[];
    int front;
    int rear;
    int n;
    int maxsize;
    Queue(int size)
    {
        arr=new int[size];
        maxsize=size;
        front=0;
        rear=-1;
        n=0;
    }
    void insert(int ele)
    {
        if(rear+1==maxsize)
            System.out.println("Queue is Full!!!");
            else
                arr[++rear]=ele;
        
    }
    void delete()
    {
        if(!isEmpty())
        {
        for(int i=0;i<rear;i++)
        {
            arr[i]=arr[i+1];
        }
        rear--;
    }
    else
    System.out.println("Queue is Empty");
    }
    void traverse() {
        for(int i=front;i<=rear;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    boolean isEmpty()
    {
        if(rear==-1)
            return true;
            return false;
    }
    boolean isFull()
    {
        return rear==maxsize-1;
    }
    public static void main(String args[])
    {
        Queue q=new Queue(5);
        q.insert(10);
        q.insert(20);
        q.insert(30);
        q.insert(40);
        q.insert(50);
        q.insert(60);
        q.traverse();
        q.delete();
        q.delete();
        System.out.println("");
        q.traverse();
        q.insert(60);
        System.out.println("");
        q.traverse();
        q.delete();
        q.delete();
        q.delete();
        q.delete();
        q.delete();
        q.delete();
    }
}
 