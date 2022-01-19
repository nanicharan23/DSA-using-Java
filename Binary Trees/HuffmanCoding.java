import java.util.*;
class Huffman{
    char c;
    int freq;
    Huffman left;
    Huffman right;
}
class Mycomparator implements Comparator<Huffman>
{
    public int compare(Huffman h1,Huffman h2)
    {
        //return h1.freq-h2.freq;
        if(h1.freq>h2.freq)
            return +1;
            else if(h1.freq<h2.freq)
                return -1;
                else  return 0;
    }
}
public class HuffmanCoding {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] freq = { 5, 9, 12, 13, 16, 45 }; 
        PriorityQueue<Huffman> p=new PriorityQueue<>(new Mycomparator());
        for(int i=0;i<ch.length;i++)
        {
            Huffman h=new Huffman();
            h.c=ch[i];
            h.freq=freq[i];
            h.left=null;
            h.right=null;
            p.add(h);
        }
        Huffman root=null;
        while(p.size()>1)
        {
            Huffman x=p.peek();
            p.poll();
            Huffman y=p.peek();
            p.poll();
            Huffman f=new Huffman();
            f.freq=x.freq+y.freq;
            f.c='-';
            f.left=x;
            f.right=y;
            root=f;
            p.add(f);

        }
      printCode(root,"");
    }
    static void printCode(Huffman root,String s)
    {
        if(root.left==null && root.right==null && Character.isLetter(root.c))
        {
            System.out.println(root.c+"  "+s);
            return ;
        }
        printCode(root.left, s+"0");
        printCode(root.right, s+"1");
    }
}