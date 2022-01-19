class Link
{
    int data;
    Link next;
    Link(int d)
    {
        data=d;
    }
}
class FirstLastList
{
    Link first;
    Link last;
    FirstLastList()
    {
        first=null;
        last=null;
    }
    boolean isEmpty()
    {
        return first==null;
    }
    void insertLast(int d)
    {
        Link newlink=new Link(d);
        if(first==null)
            first=newlink;
        else
            last.next=newlink;
        last=newlink;   
        
    }
    int deleteFirst()
    {
        Link temp=first;
        if(first.next==null)
            last=null;
        first=first.next;
        return temp.data;
    }
    void displayList()
    {
        Link curr=first;
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println("");
    }
}
class QueueList
{
    FirstLastList li;
    QueueList()
    {
        li=new FirstLastList();
    }
    void insert(int d)
    {
        li.insertLast(d);
    }
    int delete()
    {
       return li.deleteFirst(); 
    }
    void display()
    {
        li.displayList();
    }
}
public class LinkQueueApp {
    public static void main(String args[])
    {
        QueueList ql=new QueueList();
        ql.insert(10);
        ql.insert(20);
        ql.insert(30);
        ql.insert(40);
        ql.display();
        ql.delete();
        ql.display();

    }
}