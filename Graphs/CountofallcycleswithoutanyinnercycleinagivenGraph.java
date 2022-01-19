import java.util.*;
public class CountofallcycleswithoutanyinnercycleinagivenGraph {
    static int graph[][]={{0,1,1},
                        {0,0,1},
                        {0,0,0}};
    public static void main(String[] args) {
        int n=graph.length;
        int e=0;
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph.length;j++)
            {
                if(graph[i][j]==1)
                e++;
            }
        }
        System.out.println(e-n+1);
    }
}

/*
Formula is: [(No.of Edges)-(No.of Vertices)+1]
*/