
package Dijkstra_BellmanFord;

import java.util.*;
import java.io.*;

public class Problem_01 {

static int [] [] adjMatrix;
static int [] d;
static Object [] parent;
static HashSet<Integer> set;
static PriorityQueue<Integer> queue;
static int vertexCount;
static int edgeCount;
static int mission;
    
    public static void main(String[] args) {
        try{
            //taking input...
            String address="C:\\Users\\asus\\Desktop\\Dijkstra_BellmanFord\\Problem_01.txt";
            Scanner sc=new Scanner(new File (address));
            String line_one=sc.nextLine();
            String [] edgee=line_one.split(" ");
            vertexCount= Integer.parseInt(edgee[0]);
            edgeCount= Integer.parseInt(edgee[1]);
            int hotel= Integer.parseInt(edgee[2]);
            mission=Integer.parseInt(edgee[3]);
            
            adjMatrix= new int[vertexCount+1] [vertexCount+1];
            
            d= new int[vertexCount+1];
            parent= new Object [vertexCount+1];
            
            for (int count=1; count<=edgeCount; count++) {
                String line=sc.nextLine();
                String [] edge=line.split(" ");
                int from= Integer.parseInt(edge[0]);
                int to= Integer.parseInt(edge[1]);
                int weight=Integer.parseInt(edge[2]);
                adjMatrix [from][to]=weight;             
            }
            
            String case_one=sc.nextLine();
            String [] sd1=case_one.split(" ");
            int s1= Integer.parseInt(sd1[0]);
            int d1=Integer.parseInt(sd1[1]);
            
            String case_two=sc.nextLine();
            String [] sd2=case_two.split(" ");
            int s2= Integer.parseInt(sd2[0]);
            int d2=Integer.parseInt(sd2[1]);
            
            //printing adjacency Matrix
//            for(int row=0; row<=vertexCount; row++) {
//                for(int col=0; col<=vertexCount; col++) {
//                    System.out.print(adjMatrix[row][col]+ " ");
//                }
//                System.out.println();
//            }
            
            System.out.println("Case-1:");
            dijkstra(s1);
            int dis1=d[d1];
            if ((int)(parent[d1])==hotel) {
            System.out.println("Form source "+s1+" to destination "+d1+", must via Hotel "+hotel+", Minimum Distance: "+dis1);
            }
            
            System.out.println("Case-2:");
            dijkstra(s2);
            int dis2=d[d2];
            if ((int)(parent[d2])==hotel) {
            System.out.println("Form source "+s2+" to destination "+d2+", must via Hotel "+hotel+", Minimum Distance: "+dis2);
            }

        } catch(Exception e){
             System.out.println("Error: " + e);
        
        }
    }
    
    public static void dijkstra (int s ) {
        set= new HashSet<Integer>();
        queue= new PriorityQueue<Integer>();
        //initializing distance of vertex to infinity
        for(int v=0; v<=vertexCount; v++) {
            d[v]=11223344;
            parent [v]=null;
        }
        
        d[s]=0;
        sortQueue();
        while(!queue.isEmpty()) {
            int minDistance = queue.poll();
            int u= findVertex(minDistance);
            set.add(u);
            for(int v=1; v<=vertexCount; v++) {
                if ((adjMatrix[u][v] !=0) && (!set.contains(v))) {
                    if (d[v]>d[u]+adjMatrix[u][v]) {
                        d[v]=d[u]+adjMatrix[u][v];
                        parent[v]=u;
                    }
                }
            }
            sortQueue();
        }
    }

    private static int findVertex(int minDistance) {
        for(int v=1; v<=vertexCount; v++) {
            if (d[v]==minDistance) 
                return v;
        }
        return -1;
    }

    private static void sortQueue() {
       queue.clear();
       for(int v=1; v<=vertexCount; v++) {
           if (!set.contains(v))
               queue.add(d[v]);
       }
    }  
}
