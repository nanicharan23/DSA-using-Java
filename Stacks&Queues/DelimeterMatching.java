class Stack
{
    char arr[];
    int top;
    int maxsize;
    Stack(int size)
    {
        arr=new char[size];
        maxsize=size;
        top=-1;
    }
    void push(char ele)
    {
        arr[++top]=ele;
    }
    char pop()
    {
        return arr[top--];
    }
    char peek()
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
}

public class DelimeterMatching {
    static boolean check(String str)
    {
        Stack st=new Stack(str.length());
        char ch[]=str.toCharArray();
        
        for(char i:ch)
        {
            if(!Character.isLetter(i))
            {
                if(i=='(' || i=='{' || i=='[')
                    st.push(i);
                else if(st.peek()=='(' && i==')' && !st.isEmpty())
                    st.pop();
                else if(st.peek()=='{' && i=='}' && !st.isEmpty())
                    st.pop();
                else if(st.peek()=='[' && i==']' && !st.isEmpty())
                    st.pop();
            }
        }
        return st.top==-1;
    }
    public static void main(String args[])
    {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        String str;
        str=sc.nextLine();
        System.out.println(check(str)?"Yes it is balanced":"No its not!!!");
    }
}