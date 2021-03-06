
package LCS;

import java.util.*;
import java.io.*;


public class Problem_01 {
    
    
    public static void main(String [] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first String: ");
        String x= sc.next();
        System.out.println("Enter Second String: ");
        String y= sc.next();
        int com;
        float acc;
        int a;
        
        int m=x.length();
//        System.out.println(m);
        int n=y.length();
        
        int [] [] c= new int [m+1] [n+1];
        String [] [] b= new String [m+1] [n+1];
        
        for(int i=1; i<m; i++) {
            c[i] [0] = 0;
        }
        
        for(int j=0; j<n; j++) {
            c[0] [j] =0;
        }
        
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if(x.charAt(i-1)==y.charAt(j-1)) {
                    c[i] [j] = c[i-1] [j-1] +1;
                    b[i] [j] = "DIAGONAL";
                }
                
                else if (c[i-1] [j] > c[i] [j-1]) {
                    c[i] [j] = c[i-1] [j];
                    b[i] [j] ="UP";
                }
                
                else {
                    c[i] [j] =c[i] [j-1];
                    b[i] [j]="LEFT";
                }
            }
        }
//        
//        for (int i=0; i<=m; i++) {
//            for (int j=0; j<=n; j++) {
//                System.out.print(c[i] [j] + " ");
//            }
//            System.out.println();
//        }
        
        com = c[m][n];
        acc=(float)com/m;
//        System.out.println(acc);
        
        Stack<Character> stack = new Stack<Character>();
        int i=m;
        int j=n;
        while(b[i] [j]!=null) {
            if (b[i] [j].equals("DIAGONAL")) {
                stack.push(x.charAt(i-1));
                i--;
                j--;
            }
            else if (b[i][j].equals("LEFT")) {
                j--;
            }
            else if (b[i][j].equals("UP")) {
                i--;
            }
        }
        
        System.out.println("===Solution===");
        while(!stack.isEmpty()) 
            System.out.print(stack.pop()+" ");
            
        System.out.println();
        
        acc = acc*100;
        a=(int)acc;
        if (a>=50) {
//        System.out.println(a);
        System.out.println(a+"%  PASSED");
        }
    }
    
    
}
