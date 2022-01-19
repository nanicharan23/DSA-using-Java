import java.util.*;
class Vertex{
    char label;
    boolean wasVisited;
    Vertex(char lab)
    {
        label=lab;
        wasVisited=false;
    }
}
class Graph
{
    int maxVerts=20;
    int adjMat[][];
    Vertex vertexList[];
    int nVerts;
    LinkedList<Integer> li;
    Graph()
    {
        li=new LinkedList<>();
        nVerts=0;
        adjMat=new int[maxVerts][maxVerts];
        vertexList=new Vertex[maxVerts];
    }
    void addVertex(char lab)
    {
        vertexList[nVerts++]=new Vertex(lab);
    }
    void addEdge(int start,int end)
    {
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }
    void displayVertex(int v)
    {
        System.out.print(vertexList[v].label+" ");
    }
    void bfs()
    {
        vertexList[0].wasVisited=true;
        displayVertex(0);
        li.addLast(0);
        int v2;
        while(li.size()!=0)
        {
            int v1=li.remove();
            while((v2=getAdjUnvisitedVertex(v1))!=-1)
            {
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                li.addLast(v2);
            }
        }
        for(int i=0;i<nVerts;i++)
        {
            vertexList[i].wasVisited=false;
        }
    }
    int getAdjUnvisitedVertex(int v)
    {
        for(int i=0;i<nVerts;i++)
        {
            if(adjMat[v][i]==1 && vertexList[i].wasVisited==false)
                return i;
        }
        return -1;
    }
}

public class BFS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Graph g=new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.bfs();

    }
}