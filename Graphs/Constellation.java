import java.util.*;
public class Constellation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char arr[][]=new char[3][n];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextLine().charAt(0);
            }
        }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.println(arr[i][j]);
            }
            System.out.println("");
        }
    }    
}