class Stack
{
    int arr[];
    int maxsize;
    int top;
    Stack(int size)
    {
        arr=new int[size];
        maxsize=size;
        top=-1;
    }
    void push(int ele)
    {
        if(!isFull())
            arr[++top]=ele;
        else
            System.out.println("sTACK oVERLOAD!!!!");
    }
    int pop()
    {
        if(!isEmpty())
            return arr[top--];
    }
    int peek()
    {
        return arr[top];
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    boolean isFull()
    {
        return top==maxsize-1;
    }
    int size()
    {
        int temp=top;
        return ++temp;
    }
    public static void main(String args[])
    {
        Stack st=new Stack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println("Top element is:"+st.peek());
        System.out.println("The size is:"+st.size());
        System.out.println("popped :"+st.pop());
        System.out.println("The new size is :"+st.size());
        st.push(60);
        st.push(60);
        st.push(60);
    }
}