import java.util.*;
public class QueueUsingStack {
    java.util.Stack<Integer> s1=new java.util.Stack<>();
    java.util.Stack<Integer> s2=new java.util.Stack<>();
    void solve()
    {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        System.out.println(remove());
        insert(5);
        insert(6);
        System.out.println(remove());
    }
//Insert cheap and remove costly
    void insert(int ele)
    {
        s1.push(ele);
    }
    int remove()
    {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        int ans=s2.pop();
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
        return ans;
    }   
// Insert costly and remove cheap
/*
    void insert(int ele)
    {
        if(s1.isEmpty())
        {
            s1.push(ele);
        }
        else{
            while(!s1.isEmpty())
            {
                s2.push(s1.pop());
            }
            s1.push(ele);
            while(!s2.isEmpty())
            {
                s1.push(s2.pop());
            }
        }
    }
    int remove()
    {
        return s1.pop();
    }*/
    public static void main(String[] args) {
        QueueUsingStack s=new QueueUsingStack();
        s.solve();
    }
}
