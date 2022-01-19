import java.util.*;
class DFSon2D {
    int n,m;
    int dx[]={-1,0,1,0};
    int dy[]={0,1,0,-1};
    boolean vis[][];
    int arr[][];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        this.n=n;
        this.m=m;
        vis=new boolean[n][m];
       arr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && arr[i][j]==1)
                {
                    count++;
                    dfs(i,j);
                }
            }
        }
        System.out.println("NO of componets are:"+count);
    }
    void dfs(int x,int y)
    {
        System.out.println(x+" "+y);
        vis[x][y]=true;
        for(int i=0;i<4;i++)
        {
            int u=x+dx[i];
            int v=y+dy[i];
            if(valid(u,v))
                dfs(u,v);
        }
    }
    boolean valid(int i,int j)
    {
        return i>=0 && j>=0 && i<n && j<m && !vis[i][j] && arr[i][j]==1;
    }
    public static void main(String[] args) {
        DFSon2D d=new DFSon2D();
        d.solve();
    }
}