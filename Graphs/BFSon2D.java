import java.util.*;
class BFSon2D {
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
                    bfs(i,j);
                }
            }
        }
        System.out.println("NO of componets are:"+count);
    }
    void bfs(int x,int y)
    {
        vis[x][y]=true;
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(x,y));
        while(q.size()!=0)
        {
            Point u=q.poll();
            int i=u.x;
            int j=u.y;
            System.out.println(i+" "+j);
            for(int k=0;k<4;k++)
            {
                int p=i+dx[k];
                int r=j+dy[k];
                if(valid(p,r))
                {
                    q.add(new Point(p,r));
                    vis[p][r]=true;
                }
            }
        }
    }
    boolean valid(int i,int j)
    {
        return i>=0 && j>=0 && i<n && j<m && !vis[i][j] && arr[i][j]==1;
    }
    public static void main(String[] args) {
        BFSon2D b=new BFSon2D();
        b.solve();
    }
}
class Point
{
    int x,y;
    Point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}