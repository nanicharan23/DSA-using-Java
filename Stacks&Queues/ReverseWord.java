import java.util.*;
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
}

public class ReverseWord {
    public static void main(String args[])
    {
        String str;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        str=sc.nextLine();
        Stack st=new Stack(str.length());
        char ch[]=str.toCharArray();
        for(char i:ch)
        {
            st.push(i);
        }
        System.out.print("The reversed word is:");
        while(!st.isEmpty())
        {
            System.out.print(st.pop());
        }
    }
}