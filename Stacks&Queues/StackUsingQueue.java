import java.util.*;
class StackUsingQueue
{
    java.util.Queue<Integer> q1=new LinkedList<>();
    java.util.Queue<Integer> q2=new LinkedList<>();
    void solve()
    {
        push(2);
        push(3);
        push(4);
        System.out.println(pop());
        push(5);
        push(6);
        System.out.println(pop());
    }
//Push cheap and pop costly
    void push(int ele)
    {
        q1.add(ele);
    }
    int pop()
    {
        int len=q1.size();
        for(int i=1;i<len;i++)
        {
            q2.add(q1.poll());
        }
        int ans=q1.poll();
        while(q2.size()>0)
        {
            q1.add(q2.poll());
        }
        return ans;
    }

// PUSH costly and pop Cheap
/*
    int pop()
    {
        return q1.poll();
    }
    void push(int ele)
    {
        if(q1.isEmpty())
            q1.add(ele);
            else{
                while(q1.size()>0)
                {
                    q2.add(q1.poll());
                }
                q1.add(ele);
                while(q2.size()>0)
                {
                    q1.add(q2.poll());
                }
            }
    }
    */
    public static void main(String[] args) {
        StackUsingQueue q=new StackUsingQueue();
        q.solve();
    }
}