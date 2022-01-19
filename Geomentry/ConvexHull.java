import java.util.*;
class ConvexHull
{
    int n;
    Point points[];
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        this.n=n;
        points=new Point[n];
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            points[i]=new Point(x,y);
        }
        System.out.println(convexhullAlgo());
    }
    List<List<Integer>> convexhullAlgo()
    {
        List<List<Integer>> res=new ArrayList<>();
        List<Point> ans=new ArrayList<>();
        if(n<3)
            return res;
        int l=0;
        for(int i=1;i<n;i++)
        {
            if(points[i].x<points[l].x)
                l=i;
        }
        int p=l;
        int q=0;
        do{
            ans.add(points[p]);
            q=(p+1)%n;
            for(int i=0;i<n;i++)
            {
                if(orientation(points[p],points[i],points[q])==2)
                    q=i;
            }
            p=q;
        }
        while(p!=l);
        for(Point po:ans)
        {
            List<Integer> temp=new ArrayList<>();
            temp.add(po.x);
            temp.add(po.y);
            res.add(temp);
        }
        return res;
    }
    int orientation(Point p,Point q,Point r)
    {
        int val=(q.y-p.y)*(r.x-q.x)-(q.x-p.x)*(r.y-q.y);
        if(val==0)
            return 0;
        return val>0?1:2;
    }
    public static void main(String[] args) {
        ConvexHull c=new ConvexHull();
        c.solve();
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
/*
Geomentry->convex hull(Jarvis algorithm)
*/