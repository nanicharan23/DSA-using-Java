class Link
{
    int data;
    Link next;
    Link(int d)
    {
        data=d;
    }
}
class SortedList 
{
    Link first;
        SortedList()
        {
            first=null;
        }
        void insert(int key)
        {
            Link newLink=new Link(key);
            Link curr=first;
            Link prev=null;
            while(curr!=null && curr.data<key)
            {
                prev=curr;
                curr=curr.next;
            }
            if(prev==null)
            {
                newLink.next=first;
                first=newLink;
            }
            else
            {
                prev.next=newLink;
                newLink.next=curr;
            }
        }
        int delete()
        {
            Link temp=first;
            first=first.next;
            return temp.data;
        }
        boolean isEmpty()
        {
            return first==null;
        }
        void display()
        {
            if(first==null)
            System.out.println("List is Empty!!!");
            else
            {
            Link curr=first;
            while(curr!=null)
            {
                System.out.print(curr.data+"->");
                curr=curr.next;
            }
            System.out.println("");
        }
        }
}
class SortedListApp
{
    public static void main(String[] args)
    {
        SortedList sl=new SortedList();
        sl.insert(10);
        sl.insert(20);
        sl.insert(30);
        sl.insert(40);
        sl.insert(2);
        sl.insert(3);
        sl.display();
    }

}