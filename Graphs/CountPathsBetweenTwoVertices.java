import java.util.*;
//Directed graph
class CountPathsBetweenTwoVertices 
{
    int count=0;
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    void findPaths(int u,int d)
    {
       if(u==d)
       {
            count++;
            return;
       }
       for(int v:adj.get(u))
       {
           findPaths(v, d);
       }
    }
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.get(u).add(v);
        }
        findPaths(0, 3);
        System.out.println(count);
    }
        public static void main(String[] args) {
        CountPathsBetweenTwoVertices c=new CountPathsBetweenTwoVertices();
        c.solve();
    }
}