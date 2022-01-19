import java.util.*;
public class EulerCircuit {
    int nVerts;
    HashMap<Integer,ArrayList<Integer>> adjList;
    HashMap<Integer,ArrayList<Integer>> rAdjList;
    int in[]=new int[nVerts];
    int newin[]=new int[nVerts];
    EulerCircuit(int n)
    {
        nVerts=n;
        in=new int[nVerts];
        newin=new int[nVerts];
        adjList=new HashMap<>();
        rAdjList=new HashMap<>();
    }
    void addEdge(int u,int v)
    {
        if(adjList.containsKey(u))
        {
            adjList.get(u).add(v);
            in[v]++;
        }
        else
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(v);
            in[v]++;
            adjList.put(u,temp);
        }
    }
    boolean sc()
    {
        boolean visited[]=new boolean[nVerts];
        dfs(0,visited,adjList);
        for(int i=0;i<nVerts;i++)
        {
            if(!visited[i])
                return false;
        }
        System.out.println("Before:"+adjList);
        transpose();
        System.out.println("After:"+rAdjList);
        Arrays.fill(visited,false);
        dfs(0,visited,rAdjList);
        for(int i=0;i<nVerts;i++)
        {
            if(!visited[i])
                return false;
        }
        return true;
    }
    void transpose()
    {
        for(int i=0;i<nVerts;i++)
        {
            if(adjList.containsKey(i))
            {
                ArrayList<Integer> temp=adjList.get(i);
                for(int j=0;j<temp.size();j++)
                {
                    if(rAdjList.containsKey(temp.get(j)))
                    {
                        rAdjList.get(temp.get(j)).add(i);
                        newin[i]++;
                    }
                    else
                    {
                        ArrayList<Integer> t=new ArrayList<>();
                        t.add(i);
                        newin[i]++;
                        rAdjList.put(temp.get(j),t);
                    }
                }
            }
        }
    }
    void dfs(int u,boolean visited[],HashMap<Integer,ArrayList<Integer>> adjList)
    {
        java.util.Stack<Integer> st=new java.util.Stack<>();
        st.push(u);
        visited[u]=true;
        while(!st.isEmpty())
        {
            int v=getAdj(st.peek(),visited,adjList);
            if(v==-1)
            {
                st.pop();
            }
            else{
                st.push(v);
                visited[v]=true;
            }
        }
    }
    int getAdj(int u,boolean visited[],HashMap<Integer,ArrayList<Integer>> adjList)
    {
        ArrayList<Integer> temp=adjList.get(u);
        for(int i=0;i<temp.size();i++)
        {
            if(visited[temp.get(i)]==false)
            return temp.get(i);
        }
        return -1;
    }
    boolean isEuler()
    {
        if(!sc())
            return false;
            for(int i=0;i<nVerts;i++)
            {
                if(adjList.get(i).size()!=in[i])
                    return false;
            }
            return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        EulerCircuit e=new EulerCircuit(5);
        int ed=sc.nextInt();
        for(int i=0;i<ed;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            e.addEdge(u,v);
        }
        if(e.isEuler())
            System.out.println("Yes is has!!");
            else
            System.out.println("No it doesnt have!!!");
    }
}