/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class level_4 {
    
    static int g[][];
    static int dis [];
    static int visited [];
    static int v;
    static int lina;
    static int start;
    
    static void bfs(int s) {
        dis=new int [v];
        visited=new int [v];
        dis[s]=0;
        visited[s]=1;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(s);
        while(q.isEmpty()!=true) {
            int u=q.remove();
            for (int i=0; i<v; i++) {
                if (g [u][i]==1 && visited[i]==0) {
                    q.add(i);
                    visited[i]=1;
                    dis[i]=dis[u]+1;
                  
                }
            }
        }
    }
    
    public static void main (String[] args) {
        try {
            
            String str;
            String str2;
            int m;

           FileReader fr = new FileReader("C:\\Users\\asus\\Desktop\\Breadth_First_Search\\level_4.txt");
           BufferedReader obj = new BufferedReader (fr);
           str = obj.readLine();
           v = Integer.parseInt (str);
           System.out.print("Number of Different  fixed Positions:  ");
           System.out.println(v);
           
           str2 = obj.readLine();
           m = Integer.parseInt (str2);
           System.out.print("Number of Connections: ");
           System.out.println(m);
           
           g = new int [v][v];
           
           for(int r=0; r<m; r++) {
                //tokenize a,b
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer (str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                g [token1] [token2] =1 ;

           }
//           for (int i =0; i<g.length;i++){
//                for(int j=0; j<g.length;j++){
//                        System.out.print(g[i] [j]);
//                }
//                System.out.println();
//       
//           }
           
           
    }catch(Exception e){
             System.out.println("Error: " + e);
        
        }
        
        for (int i =0; i<g.length;i++){
            int sum=0;
                for(int j=0; j<g.length;j++){
                        sum=sum+ (g[j] [i]);
                }
                if (sum==0) {
                    start=i;
                    break;
                }
                
        }
        System.out.println("*******ANSWER*******");
        System.out.println("Suitable first position for Nora is: "+start);
        
    }
}