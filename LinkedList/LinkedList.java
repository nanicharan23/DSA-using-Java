class Link
{
    int data;
    Link next;
    Link(int d)
    {
        data=d;
    }
}
class LinkedList
{
    Link first;
    LinkedList()
    {
        first=null;
    }
    boolean isEmpty()
    {
        return first==null;
    }
    void insertFirst(int d)
    {
        Link newlink=new Link(d);
        newlink.next=first;
        first=newlink;
    }
    void insertLast(int d)
    {
        Link newlink=new Link(d);
        if(first==null)
        {
            first=newlink;
        }
        else
        {
            Link curr=first;
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next=newlink;
        }
    }
    void deleteFirst()
    {
        first=first.next;
    }
    void find(int d)
    {
        Link curr=first;
        boolean found=false;
        while(curr!=null)
        {
            if(curr.data==d)
            {
                found=true;
                System.out.println(d+" Element Found!!!!");
                break;
            }
            curr=curr.next;

        }
        if(!found)
            System.out.println(d+" Not Found!!!!");
    }
    Link deleteElement(int d)
    {
        Link curr=first;
        Link prev=first;
        while(curr.data!=d)
        {
            if(curr.next==null)
                return null;
            prev=curr;
            curr=curr.next;
        }
        if(curr==first)
            first=first.next;
        else
            prev.next=curr.next;
        return curr;

    }
    void display()
    {
       Link curr;
       curr=first;
       while(curr!=null)
       {
           System.out.print(curr.data+"->");
           curr=curr.next;
       }
       System.out.println("");
    }
    public static void main(String args[])
    {
        LinkedList li=new LinkedList();
        li.insertFirst(10);
        li.insertFirst(20);
        li.insertFirst(30);
        li.insertFirst(40);
        li.display();
        li.deleteFirst();
        li.display();
        li.find(20);
        System.out.println("Deleted Item :"+li.deleteElement(30).data);
        li.display();
        li.insertLast(1000);
        li.insertLast(1000);
        li.insertLast(1000);
        li.insertLast(1000);
        li.display();
    }
}
