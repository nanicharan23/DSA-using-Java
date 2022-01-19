import java.util.Scanner;
public class AnagramApp {
    static int size;
    static int count;
    static char[] arrchar=new char[100];
    public static void main(String args[])
    {
         Scanner sc=new Scanner(System.in);
         String str;
         str=sc.nextLine();
         size=str.length();
         count=0;
         for(int i=0;i<size;i++)
         {
             arrchar[i]=str.charAt(i);
         }
         doAnagram(size);
    }
    public static void doAnagram(int newSize)
    {
        if(newSize==1)
        return;
        for(int i=0;i<newSize;i++)
        {
            doAnagram(newSize-1);
            if(newSize==2)
                displayWord();
            rotate(newSize);
        }
    }
    public static void rotate(int newSize)
    {
        int i;
        int position=size-newSize;
        char temp=arrchar[position];
        for(i=position+1;i<size;i++)
        {
            arrchar[i-1]=arrchar[i];
        }
        arrchar[i-1]=temp;
    }
    public static void displayWord()
    {
        if(count<99)
            System.out.print(" ");
        if(count<9)
            System.out.print(" ");
        System.out.print(++count +" ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arrchar[i]);
        }
        System.out.print("    ");
        System.out.flush();
        if(count%6==0)
            System.out.println(" ");
    }
}