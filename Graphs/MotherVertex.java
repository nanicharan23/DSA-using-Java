import java.util.*;
public class MotherVertex {
    static HashMap<Integer,ArrayList<Integer>> adjlist=new HashMap<>();
    public static void main(String[] args) {
        int n=7;
        addEdge(0, 1); 
        addEdge(0, 2); 
        addEdge(1, 3); 
        addEdge(4, 1); 
        addEdge(6, 4); 
        addEdge(5, 6); 
        addEdge(5, 2); 
        addEdge(6, 0); 
        System.out.println(findMother(n));
    }
    static int findMother(int n)
    {
        HashSet<Integer> hmmain=new HashSet<>();
        int v=0;
        for(int i=0;i<n;i++)
        {
            if(!hmmain.contains(i))
            {
                   dfs(i,hmmain);
                   v=i;
            }
        }
        hmmain.clear();
        dfs(v,hmmain);
        for(int i=0;i<n;i++)
        {
            if(!hmmain.contains(i))
                return -1;
        }
        return v;
    }
    static void dfs(int u,HashSet<Integer> hmmain)
    {
        Stack<Integer> st=new Stack<>();
        HashSet<Integer> hm=new HashSet<>();
        st.push(u);
        hm.contains(u);
        hmmain.add(u);
        while(!st.isEmpty())
        {
            int v=getAdj(st.peek(),hm);
            if(v==-1)
            st.pop();
            else
            {
                st.push(v);
                hm.add(v);
                hmmain.add(v);
            }
        }
    }
    static int getAdj(int ele,HashSet<Integer> hm)
    {
        if(adjlist.containsKey(ele))
        {
            ArrayList<Integer> temp=adjlist.get(ele);
            for(int i=0;i<temp.size();i++)
            {
                if(!hm.contains(temp.get(i)))
                    return temp.get(i);
            }
        }
        return -1;
    }
    static void addEdge(int u,int v)
    {
        if(adjlist.containsKey(u))
        {
            adjlist.get(u).add(v);
        }
        else
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(v);
            adjlist.put(u,temp);
        }
    }
}