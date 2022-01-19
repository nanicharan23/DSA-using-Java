class Node{
    int data;
    Node leftchild;
    Node rightchild;
    Node(int d)
    {
        data=d;
    }
}
class Tree 
{
    Node root;
    void insert(int d)
    {
        Node newnode=new Node(d);
        newnode.data=d;
        if(root==null)
        {
            root=newnode;
        } 
        else
        {
            Node curr=root;
            Node parent;
            while(true)
            {
                parent=curr;
                if(d<curr.data)
                {
                    curr=curr.leftchild;
                    if(curr==null)
                    {
                        parent.leftchild=newnode;
                        return;
                    }
                }
                else{
                    curr=curr.rightchild;
                    if(curr==null)
                    {
                        parent.rightchild=newnode;
                        return;
                    }
                }
            }
        }
    }
    void inOrder(Node localroot)
    {
            if(localroot!=null)
            {
                inOrder(localroot.leftchild);
                System.out.print(localroot.data+" ");
                inOrder(localroot.rightchild);
            }
        
    }
    int minimum()
    {
        Node curr=root;
        Node parent=root;;
        while(curr!=null)
        {
            parent=curr;
            curr=curr.leftchild;
        }
        return parent.data;
    }
    int maximum()
    {
        Node curr=root;
        Node parent=curr;
        while(curr!=null)
        {
            parent=curr;
            curr=curr.rightchild;
        }
        return parent.data;
    }
    boolean find(int d)
    {
        Node curr=root;
        while(curr!=null)
        {
            if(curr.data==d)
                return true;
            if(d<curr.data)
                curr=curr.leftchild;
            else
                curr=curr.rightchild;
        }
        return false;
    }
    boolean delete(int d)
    {
        Node curr=root;
        Node parent=curr;
        boolean isLeftChild=true;
        while(curr.data!=d)
        {
                parent =curr;
                if(d<curr.data)
                {
                    isLeftChild=true;
                    curr=curr.leftchild;
                }
                else{
                    isLeftChild=false;
                    curr=curr.rightchild;
                }
        }
        if(curr==null)
            return false;
        if(curr.leftchild==null && curr.rightchild==null)
        {
            if(curr==root)
            root=null;
            else if(isLeftChild)
                parent.leftchild=null;
            else
                parent.rightchild=null;
        }
        else if(curr.rightchild==null)
        {
            if(curr==root)
                root=curr.leftchild;
            else if(isLeftChild)
                parent.leftchild=curr.leftchild;
            else 
                parent.rightchild=curr.leftchild;
        }
        else if(curr.leftchild==null)
        {
            if(curr==root)
                root=curr.rightchild;
            else if(isLeftChild)
                parent.leftchild=curr.rightchild;
            else
                parent.rightchild=curr.rightchild;
        }
        else
        {
            Node successor=getSuccesor(curr);
            if(curr==root)
            {
                root=successor;
            }
            else if(isLeftChild)
            {
                parent.leftchild=successor;
            }
            else
            {
                parent.rightchild=successor;
            }
            successor.leftchild=curr.leftchild;
        }
        return true;
    }
    Node getSuccesor(Node delNode)
    {
        Node successorParent=delNode;
        Node successor=delNode;
        Node current=delNode.rightchild;
        while(current!=null)
        {
            successorParent=successor;
            successor=current;
            current=current.leftchild;
        }
        if(successor!=delNode.rightchild)
        {
            successorParent.rightchild=successor.rightchild;
            successor.rightchild=delNode.rightchild;
        }
        return successor;
    }
    void postOrder(Node localRoot)
    {
        if(localRoot!=null)
        {
            postOrder(localRoot.leftchild);
            postOrder(localRoot.rightchild);
            System.out.print(localRoot.data+" ");
        }
    }
    void preOrder(Node localRoot)
    {
        if(localRoot!=null)
        {
            System.out.print(localRoot.data+" ");
            preOrder(localRoot.leftchild);
            preOrder(localRoot.rightchild);
        }
    }
}
    
class TreeApp
{
    public static void main(String[] args) {
        Tree t=new Tree();
        t.insert(10);
        t.insert(20);
        t.insert(30);
        t.insert(5);
        t.insert(32);
        t.insert(33);
        t.inOrder(t.root);
        System.out.println("");
        System.out.println("The minimum is:"+t.minimum());
        System.out.println("The maximum is:"+t.maximum());
        t.delete(5);
        t.inOrder(t.root);
        t.delete(33);
        System.out.println("");
        t.inOrder(t.root);
        t.delete(10);
        System.out.println("");
        t.inOrder(t.root);
    }
}