public class MaximumEdgesRequiredToMakeDEStrongConnectedComponents 
{
    static int graph[][]={{0,1,1},
                        {0,0,1},
                        {0,0,0}};
    static int indegree[]=new int[graph.length];
    static int outdegree[]=new int[graph.length];
    static int findMinEdges()
    {
        for(int i=0;i<graph.length;i++)
        {
            if(findIndegree(i,graph)>=1)
                indegree[i]=1;
                else
                indegree[i]=0;
                if(findOutdegree(i,graph)>=1)
                    outdegree[i]=1;
                    else
                        outdegree[i]=0;
        }
        int totalIn=0;
        int totalOut=0;
        for(int i=0;i<graph.length;i++)
        {
            if(indegree[i]==1)
                totalIn++;
                if(outdegree[i]==1)
                    totalOut++;
        }
        int n=graph.length;
        int ans=Math.min(n-totalIn,n-totalOut);
        return ans;
    }
   static int findIndegree(int ele,int graph[][])
    {
        int count=0;
        for(int i=0;i<graph.length;i++)
        {
            if(graph[i][ele]==1)
                count++;
        }
        return count;
    }
    static int findOutdegree(int ele,int graph[][])
    {
        int count=0;
        for(int i=0;i<graph.length;i++)
        {
            if(graph[ele][i]==1)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findMinEdges());
    }
}