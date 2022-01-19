public class InfixApp {
    public static void main(String args[])
    {
        String str;
        java.util.Scanner sc=new java.util.Scanner(System.in);
        str=sc.nextLine();
        IntoPost ip=new IntoPost(str);
        System.out.println(ip.doTrans());
    }
}
class IntoPost
{
    String input;
    String output="";
    Stack st;
    IntoPost(String str)
    {
        input=str;
        st=new Stack(str.length());
    }
    String doTrans()
    {
        for(int i=0;i<input.length();i++)
        {
            char ch=input.charAt(i);
            if(ch=='+' || ch=='-')
            {
                gotOper(ch,1);
            }
            else if(ch=='*' || ch=='/')
            {
                gotOper(ch,2);
            }
            else if(ch=='(')
            {
                st.push(ch);
            }
            else if(ch==')')
            {
                gotParen(ch);
            }
            else
                output+=ch;
        }
        while(!st.isEmpty())
        {
            output+=st.pop();
        }
        return output;
    }
    void gotOper(char opThis,int prec1)
    {
        while(!st.isEmpty())
        {
            char opTop=st.pop();
            if(opTop=='(')
            {
                st.push(opTop);
                break;
            }
            else
            {
                int prec2;
                if(opTop=='+' || opTop=='-')
                    prec2=1;
                else
                    prec2=2;
                if(prec2<prec1)
                {
                    st.push(opTop);
                    break;
                }
                else
                    output+=opTop;
            }
        }
        st.push(opThis);
    }
    void gotParen(char ch)
    {
        while(!st.isEmpty())
        {
            char chx=st.pop();
            if(chx=='(')
            break;
            else
            output+=chx;
        }
    }
}
class Stack
{
    char arr[];
    int maxsize;
    int top;
    Stack(int size)
    {
        arr=new char[size];
        maxsize=size;
        top=-1;
    }
    void push(char ele)
    {
        if(!isFull())
            arr[++top]=ele;
        else
            System.out.println("sTACK oVERLOAD!!!!");
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
    int size()
    {
        int temp=top;
        return ++temp;
    }

}

//Input: A*(B+C)
//Output: ABC+*