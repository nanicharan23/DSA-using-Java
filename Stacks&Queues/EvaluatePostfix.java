import java.util.*;
class EvaluatePostfix
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String str;
        str=sc.nextLine();
        Evaluate e=new Evaluate(str);
        System.out.println(e.doEvaluate());
    }
}
class Evaluate{
    Stack st;
    String input;
    Evaluate(String str)
    {
        input=str;
    }
    int doEvaluate()
    {
        st=new Stack(20);
        char ch;
        int num1,num2;
        for(int i=0;i<input.length();i++)
        {
            ch=input.charAt(i);
            if(ch>='0'&&ch<='9')
            {
                st.push((int)(ch-'0'));
            }
            else
            {
                num2=st.pop();
                num1=st.pop();
                if(ch=='+')
                    st.push(num1+num2);
                else if(ch=='-')
                st.push(num1-num2);
                else if(ch=='*')
                st.push(num1*num2);
                else if(ch=='/')
                st.push(num1/num2);
            }
        }
        return st.pop();
    }
}
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
            arr[++top]=ele;
    }
    int pop()
    {
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

}