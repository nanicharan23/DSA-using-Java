import java.util.*;
public class Lengthoflongestconnected {
    int grid[][] = {{1,1,1},
{1,1,1},
{1,1,1}};
    HashSet<String> hs=new HashSet<>();
    void solve()
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1 && !hs.contains(i+" "+j))
                {
                    max=Math.max(max,bfs(i,j));
                }
            }
        }
        System.out.println(max);
    }
    int bfs(int x,int y)
    {
        Queue<Pos> q=new LinkedList<>();
        q.add(new Pos(x,y,1));
        hs.add(x+" "+y);
        int count=0;
        while(q.size()>0)
        {
            Pos p=q.poll();
            count=p.count;
            if(p.x-1>=0 && grid[p.x-1][p.y]==1)
            {
                int i=p.x-1;
                int j=p.y;
                if(!hs.contains(i+" "+j))
                    {
                        q.add(new Pos(i,j,count+1));
                        hs.add(i+" "+j);
                    }
            }
            if(p.y-1>=0 && grid[p.x][p.y-1]==1)
            {
                int i=p.x;
                int j=p.y-1;
                if(!hs.contains(i+" "+j))
                {
                    q.add(new Pos(i,j,count+1));
                    hs.add(i+" "+j);
                }
            }
            if(p.x+1<grid.length && grid[p.x+1][p.y]==1)
            {
                int i=p.x+1;
                int j=p.y;
                if(!hs.contains(i+" "+j))
                    {
                        q.add(new Pos(i,j,count+1));
                        hs.add(i+" "+j);
                    }
            }
            if(p.y+1<grid[p.x].length && grid[p.x][p.y+1]=='1')
            {
                int i=p.x;
                int j=p.y+1;
                if(!hs.contains(i+" "+j))
                {
                    q.add(new Pos(i,j,count+1));
                    hs.add(i+" "+j);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Lengthoflongestconnected l=new Lengthoflongestconnected();
        l.solve();
    }
}
class Pos
{
    int x;
    int y;
    int count;
    Pos(int x,int y,int count)
    {
        this.x=x;
        this.y=y;
        this.count=count;
    }
}