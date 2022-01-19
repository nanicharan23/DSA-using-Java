import java.util.*;
public class FloydWarshallsAlgo {
   static int INF=Integer.MAX_VALUE;
   static void floydWarshalls(int graph[][],int V)
   {
       int d[][]=new int[V][V];
       d=graph.clone();
       for(int k=0;k<V;k++)
       {
           for(int i=0;i<V;i++)
           {
               for(int j=0;j<V;j++)
               {
                   if(d[i][k]+d[k][j]<d[i][j])
                    d[i][j]=d[i][k]+d[k][j];
               }
           }
       }
       for(int i=0;i<V;i++)
       {
           for(int j=0;j<V;j++)
           {
            if (d[i][j]==INF) 
            System.out.print("INF "); 
        else
            System.out.print(d[i][j]+"   "); 

           }
           System.out.println("");
       }
   }
    public static void main(String[] args) {
        int graph[][]={{0,1,1,INF,INF,INF,INF}, 
       {1,0 ,INF, 1, 1 ,INF ,INF },
        {1, INF, 0, INF ,INF 1, 1 },
        {INF, 1 ,INF ,0 ,INF, INF, INF},
        {INF ,1 ,INF, INF, 0 ,INF, INF },
        {INF INF,1 INF ,INF, 0 ,INF },
        {INF ,INF, 1 ,INF ,INF, INF, 0 }};
      floydWarshalls(graph,graph.length);
    }
}