
package Dijkstra_BellmanFord;

import java.util.*;
import java.io.*;

public class Problem_02 {

static int [] [] adjMatrix;
static int [] d;
static Object [] parent;
static HashSet<Integer> set;
static HashSet<Integer> set2;
static PriorityQueue<Integer> queue;
//static PriorityQueue<Integer> queue2;
static Stack<Integer> stack = new Stack<Integer>();
static int vertexCount;
static int edgeCount;
static int s;
static int des;
static int c;
    
    public static void main(String[] args) {
        try{
            //taking input...
            String address="C:\\Users\\asus\\Desktop\\Dijkstra_BellmanFord\\Problem_02.txt";
            Scanner sc=new Scanner(new File (address));
            vertexCount= Integer.parseInt(sc.nextLine());
            edgeCount= Integer.parseInt(sc.nextLine());
            adjMatrix= new int[vertexCount] [vertexCount];
            d= new int[vertexCount];
            parent= new Object [vertexCount];
            for (int count=0; count<edgeCount; count++) {
                String line=sc.nextLine();
                String [] edge=line.split(",");
                int from= Integer.parseInt(edge[0]);
                int to= Integer.parseInt(edge[1]);
                int weight=Integer.parseInt(edge[2]);
                adjMatrix [from][to]=weight;            
            }
    
            s= Integer.parseInt(sc.nextLine());
//            System.out.println(s);
            des= Integer.parseInt(sc.nextLine());
//            System.out.println(des);
            
            String linee=sc.nextLine();
            String [] edgee=linee.split(",");
            int x= Integer.parseInt(edgee[0]);
            int y=Integer.parseInt(edgee[1]);
            int z=Integer.parseInt(edgee[2]);
            int t=Integer.parseInt(edgee[3]);
            set2 = new HashSet<Integer>();
            set2.add(x);
            set2.add(y);
            set2.add(z);
            set2.add(t);
            
            //printing adjacency Matrix
//            for(int row=0; row<vertexCount; row++) {
//                for(int col=0; col<vertexCount; col++) {
//                    System.out.print(adjMatrix[row][col]+ " ");
//                }
//                System.out.println();
//            }
            
            String [] place = {"Mouchak","Panthapath","Rampura","Shahahbagh","Dhanmondi","Lalmatia","Badda","Hatirjheel","Nilkhet","TSC","Dhaka University","BUET"};
            bellmanFord(s);

            
            int [] path=new int [11];
            path[0]=des;
            c=1;
            int p=(int)parent[des];
            path[c]=p;
            do {
                    p=(int)parent[p];
                    c++;
                    path[c]=p;
                   } while (p!=s);
            
            for(int count=c; count>=0; count--) {
                
                System.out.print(place[path[c]]+">>");
                c--;
                
            }
            System.out.println("||Path Cost "+d[des]);

            
//            for(int v=0; v<vertexCount; v++) {
//                System.out.println("Vertex "+v+" shorest path "+d[v]+" Parent: "+parent[v]);
            
        } catch(FileNotFoundException | NumberFormatException e){
             System.out.println("Error: " + e);
        
        }
    }
    
    public static void bellmanFord (int s ) {
        for(int v=0; v<vertexCount; v++) {
            d[v]=99999;
            parent[v]=null;
        }
        
        d[s]=0;
        
        for(int count=0; count<vertexCount-1; count++) {
            for(int u=0; u<vertexCount; u++) {
                for(int v=0; v<vertexCount; v++) {
                    
                    if(adjMatrix [u][v]!=0 && !set2.contains(v) && !set2.contains(u)) {
                        if (d[u] + adjMatrix[u][v]<d[v]) {
                            d[v]=d[u]+adjMatrix[u][v];
                            parent[v]=u;
                        }
                    }
                    
                }
            }
        }
        
        //detecting negative edge cycle
        boolean neg_cycle = false;
        for (int u=0; u<vertexCount; u++) {
            for(int v=0; v<vertexCount; v++) {
                if( adjMatrix[u][v]!=0) {
                    if(d[u]+adjMatrix[u][v]<d[v]) {
                        neg_cycle=true;
                    }
                }
            }
        }    
//        if(neg_cycle)
//            System.out.println("A negative Edge cycle exists in the Graph!!!");
    }
    

    private static int findVertex(int minDistance) {
        for(int v=0; v<vertexCount; v++) {
            if (d[v]==minDistance) 
                return v;
        }
        return -1;
    }

    private static void sortQueue() {
       queue.clear();
       for(int v=0; v<vertexCount; v++) {
           if (!set.contains(v))
               queue.add(d[v]);
       }
    }
    
}