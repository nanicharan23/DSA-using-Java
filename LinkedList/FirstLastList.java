class Link
{
    int data;
    Link next;
    Link(int d)
    {
        data=d;
    }
}
public class FirstLastList {
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
    void insertFirst(int d)
    {
        Link newlink=new Link(d);
        if(isEmpty())
            last=newlink;
        newlink.next=first;
        first=newlink;
    }
    void insertLast(int d)
    {
        Link newlink=new Link(d);
        if(isEmpty())
        first=newlink;
        else
        last.next=newlink;
        last=newlink;
    }
    void deleteFirst()
    {
        if(first.next==null)
            last=null;
        first=first.next;
    }
    void display()
    {
        Link curr=first;
        while(curr!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("");
    }
    public static void main(String args[])
    {
        FirstLastList li=new FirstLastList();
        li.insertLast(10);
        li.insertLast(20);
        li.insertLast(30);
        li.display();
        li.deleteFirst();
        li.display();

    }

}