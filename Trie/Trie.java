import java.util.*;
class Trie
{
    Node root=new Node();
    void solve()
    {
        Scanner sc=new Scanner(System.in);
        insert("charan");
        insert("charana");
        insert("sricharan");
        insert("charansai");
        System.out.println(search("charan"));
        System.out.println(search("charansai"));
        System.out.println(search("charanaa"));

    }
    void insert(String s)
    {
        int level;
        int len=s.length();
        int index;
        Node curr=root;
        for(level=0;level<len;level++)
        {
            index=s.charAt(level)-'a';
            if(curr.children[index]==null)
                curr.children[index]=new Node();
            curr=curr.children[index];
        }
        curr.isEnd=true;
    }
    boolean search(String s)
    {
        int level;
        int len=s.length();
        int index;
        Node curr=root;
        for(level=0;level<len;level++)
        {
            index=s.charAt(level)-'a';
            if(curr.children[index]==null)
                return false;
            curr=curr.children[index];
        }
        return (curr!=null && curr.isEnd);
    }
    public static void main(String[] args) {
        Trie t=new Trie();
        t.solve();
    }
}
class Node 
{
    Node children[];
    boolean isEnd;
    Node()
    {
        children=new Node[26];
        for(int i=0;i<26;i++)
            children[i]=null;
        isEnd=false;
    }
}