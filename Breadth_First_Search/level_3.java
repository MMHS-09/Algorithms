package BFS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class level_3 {
    
    static int g[][];
    static int dis [];
    static int visited [];
    static int v;
    static int lina;
    static int participant;
    static int k1;
    static int k2;
    static int k3;
    static int k4;
    static int k5;
    
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
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            int m;

           FileReader fr = new FileReader("C:\\Users\\asus\\Desktop\\Breadth_First_Search\\level_3.txt");
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
                g [token2] [token1] =1 ;
           }
           
//           for (int i =0; i<g.length;i++){
//                for(int j=0; j<g.length;j++){
//                        System.out.print(g[i] [j]);
//                }
//                System.out.println();
//       
//           }
           
           str3 = obj.readLine();
           lina = Integer.parseInt (str3);
           System.out.print("Lina's Position: ");
           System.out.println(lina);
           
           str4 = obj.readLine();
           participant = Integer.parseInt (str4);
           System.out.print("Participants: ");
           System.out.println(participant);
           
           str5 = obj.readLine();
           k1 = Integer.parseInt (str5);
           System.out.print("K1's Position: ");
           System.out.println(k1);
           
           str6 = obj.readLine();
           k2 = Integer.parseInt (str6);
           System.out.print("K2's Position: ");
           System.out.println(k2);
           
           str7 = obj.readLine();
           k3 = Integer.parseInt (str7);
           System.out.print("K3's Position: ");
           System.out.println(k3);
           
           str8 = obj.readLine();
           k4 = Integer.parseInt (str8);
           System.out.print("K4's Position: ");
           System.out.println(k4);
           
           str9 = obj.readLine();
           k5 = Integer.parseInt (str9);
           System.out.print("K5's Position: ");
           System.out.println(k5);
           
           
    }catch(Exception e){
             System.out.println("Error: " + e);
        
        }
        bfs(lina);
        
        int distance [];
        distance = new int [participant+1];
        distance[1]=dis[k1];
        distance[2]=dis[k2];
        distance[3]=dis[k3];
        distance[4]=dis[k4];
        distance[5]=dis[k5];
      
        int minValue= distance[1];
        int index=-1;
        
        for (int i=2; i<distance.length; i++) {
            if (minValue>=distance[i]) {
                minValue=distance[i];
            }
        }
         System.out.println("*******ANSWER*******");
        for( int i=1; i<distance.length; i++) {
            if(distance[i]==minValue) {
                System.out.println("K"+i+" is winner with "+minValue+" moves.");
            }
        }
       
    }
}

