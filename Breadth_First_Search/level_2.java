package BFS;

import java.io.*;
import java.util.*;

public class level_2 {
    
    static int g[][];
    static int dis [];
    static int visited [];
    static int v;
    static int lina;
    static int nora;
    static int lara;
    
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
            int m;
            
           FileReader fr = new FileReader("C:\\Users\\asus\\Desktop\\Breadth_First_Search\\level_2.txt");
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
                str = obj.readLine();
                StringTokenizer st = new StringTokenizer (str, " ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                g [token1] [token2] =1 ;
                g [token2] [token1] =1;
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
           nora = Integer.parseInt (str4);
            System.out.print("Nora's Position: ");
           System.out.println(nora);
           
           str5 = obj.readLine();
           lara = Integer.parseInt (str5);
            System.out.print("Lara's Position: ");
           System.out.println(lara);
           
           
    }catch(Exception e){
             System.out.println("Error: " + e);
        
        }
        
        System.out.println("*******ANSWER*******");
        bfs(nora);
        System.out.println("Minimum number of moves Nora needs to go Lina is : "+dis[lina]);
        int p1=dis[lina];
        
        bfs(lara);
        System.out.println("Minimum number of moves Lara needs to go Lina is : "+dis[lina]);
        int p2=dis[lina];
        
        if (p1<p2) {
            System.out.println("Winner is Nora as she can catch Lina with "+p1+"  moves");
        }
        else {
            System.out.println("Winner is Lara as she can catch Lina with "+p2+"  moves");
            
        }
    }
}

