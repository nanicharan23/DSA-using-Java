class Link{
    int data;
    Link next;
    Link(int d)
    {
        data=d;
        next=null;
    }
}
class LinkedList
{
    Link first;
    LinkedList()
    {
        first=null;
    }
    void insertFirst(int d)
    {
        Link newlink=new Link(d);
        newlink.next=first;
        first=newlink;
    }
    int deleteFirst()
    {
        Link temp=first;
        first=first.next;
        return temp.data;
    }
    boolean isEmpty()
    {
        return first==null;
    }
    void displayList()
    {
        Link curr=first;
        while(curr!=null)
        {
            System.out.println(curr.data+" ");
            curr=curr.next;
        }
    }
}
class LinkStack{
    LinkedList li;
    LinkStack()
    {
        li=new LinkedList();
    }   
    void push(int d)
    {
        li.insertFirst(d);
    }
    int pop()
    {
        return li.deleteFirst();
    }
    boolean isEmpty()
    {
        return li.isEmpty();
    }
    void display()
    {
        li.displayList();
    }
}

public class LinkStackApp {
    public static void main(String args[])
    {
        LinkStack ls=new LinkStack();
        ls.push(10);
        ls.push(20);
        ls.push(30);
        ls.push(40);
        ls.display();
        System.out.println("The element deleted is:"+ls.pop());
        ls.display();
    }
}