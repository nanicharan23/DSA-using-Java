import java.util.*;
class TopologicalSort
{
    int graph[][]={{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,1,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{1,0,1,0,0,0}};
    int v=graph.length;
    java.util.Stack<Integer> mainst=new java.util.Stack<>();
    HashSet<Integer> hs=new HashSet<>();
    void topo()
    {
        for(int i=0;i<v;i++)
        {
            if(!hs.contains(i))
                dfs(i);
        }
        while(!mainst.isEmpty())
        {
            System.out.print(mainst.pop()+" ");
        }
    }
    void dfs(int u)
    {
        java.util.Stack<Integer> st=new java.util.Stack<>();
        st.push(u);
        hs.add(u);
        while(!st.isEmpty())
        {
            int v=getAdj(st.peek());
            if(v==-1)
            {
                mainst.push(st.peek());
                st.pop();
            }
            else
            {
                st.push(v);
                hs.add(v);
            }
        }
    }
    int getAdj(int ele)
    {
        for(int i=0;i<v;i++)
        {
            if(graph[ele][i]==1 && !hs.contains(i))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        TopologicalSort t=new TopologicalSort();
        t.topo();
    }
}