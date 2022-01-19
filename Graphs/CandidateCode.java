/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
public class CandidateCode {
   public static void main(String args[] ) throws Exception {

	//Write code here   
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0)
    {
        int n=sc.nextInt();
        int v[]=new int[n];
        int p[]=new int[n];
        for(int i=0;i<n;++)
        {
            v[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
            p[i]=sc.nextInt();
            Arrays.sort(v);
            Arrays.sort(p);
            boolean loose=false;
            for(int i=0;i<n;i++)
            {
                if(p[i]<v[i])
                {
                    loose=true;
                }
            }
            System.out.println(loose==true?"LOSE":"WIN");
    }

   }
}
