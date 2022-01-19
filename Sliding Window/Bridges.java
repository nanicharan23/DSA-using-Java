import java.util.Stack;

import javax.lang.model.util.ElementScanner6;

public class Bridges {
    static void findBridges(int graph[][])
    {
        int timer=0;
        int n=graph.length;
        int disc[]=new int[n];
        int low[]=new int[n];
        int parent[]=new int[n];
        HashSet<Integer> hs=new HashSet<>();
        Stack<Integer> st=new Stack<>();
        st.push(0);
        timer++;
        disc[0]=1;
        low[0]=1;
        hs.add(0);
        while(!st.isEmpty())
        {
            int u=st.peek();
            int v=getAdjUnVis(u,hs,graph);
            if(v==-1)
            {
                if(checkBridge(u,parent,disc,low,graph))
                    System.out.println(u+" "+v);
                st.pop();
            }
            else{
                low[v]=dics[v]=++timer;
                hs.add(v);
                parent[v-1]=u;
            }
        }
         
    }
    static boolean checkBridge(int u,int parent[],int disc[],int low[],int graph[][])
    {
        for(int i=0;i<graph.length;i++)
        {
            if(graph[u][i]>0 && parent[u]!=graph[u][i])
            {
                    if(disc[i]<disc[parent[u]])
                    {
                        low[u]=disc[i];
                        return false;
                    }
            }
        }
        return true;
    }
    static int getAdjUnVis(int ele,HashSet<Integer> hs,int graph[][])
    {
        for(int i=0;i<graph.length;i++)
        {
            if(graph[ele][i]>0 && !hs.contains(i))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int graph[][]={{0,0,1,1,0},
                       {1,0,0,0,0},
                       {0,1,0,0,0},
                        {0,0,0,0,1},
                        {0,0,0,0,0}};
                        findBridges(graph);
    }
}