import java.util.*;
class Stack
{
    int top;
    int maxsize;
    int arr[];
    Stack(int size)
    {
        maxsize=size;
        top=-1;
        arr=new int[maxsize];
    }
    void push(int n)
    {
        arr[++top]=n;
    }
    int pop()
    {
        return arr[top--];
    }
    boolean isEmpty()
    {
        return top==-1;
    }
    boolean isFull()
    {
        return top+1==maxsize;
    }
}
class StackTriangle {
   static int doTriangle(int n)
    {
        Stack st=new Stack(100);
        int ans=0;
        while(n>0)
        {
            st.push(n);
            n--;
        }
        while(!st.isEmpty())
        {
            ans=ans+st.pop();
        }
        return ans;

    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(doTriangle(n));
    }
}