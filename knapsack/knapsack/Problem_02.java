package knapsack;

import java.io.*;
import java.util.Scanner;

public class Problem_02 {

    public static void main(String[] args) {
        try{
             String address = "C:\\Users\\asus\\Desktop\\knapsack\\Problem_02.txt";
             Scanner sc = new Scanner(new File(address));
             
             //taking first two inputs from the text file
             int maxWeight = Integer.parseInt(sc.nextLine());
             int itemCount = Integer.parseInt(sc.nextLine());
             
             //initialize and declaring the variables
             int [] [] v = new int [itemCount+1] [maxWeight+1];
             String [] [] d = new String [itemCount+1] [maxWeight+1];
             int [] weights = new int [itemCount+1];
             float [] benifits = new float [itemCount+1];
             String [] trophy= new String[itemCount+1];
             String [] club= new String [itemCount+1];
             String [] sell= new String [itemCount+1];
             
             //taking further inputs from text file
             for(int i=1; i<=itemCount; i++){
                 String line = sc.nextLine();
                 String [] temp = line.split(",");
                 club[i]=  temp[0];
                 weights [i] = Integer.parseInt(temp[1]);//sorting weights
                 benifits [i] = Float.parseFloat(temp[2]);//sorting benifits
                 trophy [i] = temp[3];
                  
             }
             
             //assigning 0 s to first column
             for(int i=1; i<=itemCount; i++){
                  v[i][0] = 0;
                  d[i][0] = null;
             }
             
             //assigning 0 s to first row
             for(int w=0; w<=maxWeight; w++){
                  v[0][w] = 0;
                   d[0][w] = null;
             }
             
             //performing knapstack algorithm
             for(int i=1; i<=itemCount; i++){
                  for(int w=1; w<=maxWeight; w++){
                      if(weights[i] <= w){
                          if(benifits[i] + v[i-1] [w-weights[i]] > v[i-1][w]){
                             v[i][w] = (int) (benifits[i] + v[i-1][w-weights[i]]);
                             d[i][w] ="Diagonal";
                          }else{
                                v[i][w] = v[i-1][w];
                                d[i][w] ="Upward";
                          }      
                      }
                      else{
                             v[i][w] = v[i-1][w]; // w< weights[i]
                             d[i][w] ="Upward";
                      }
                  }
             }
             
               //print the knapsack matrix
//             for(int i=0; i<=itemCount; i++){
//                  for(int w=0; w<=maxWeight; w++)
//                       System.out.print(v[i][w]+" ");
//                  System.out.println();
//             }

             System.out.println("Name of clubs whose trophies were sold:");
             int i = itemCount;
             int w = maxWeight;
             float c=0;
             
             while(d[i][w] != null){
                   if(d[i][w].equals("Diagonal")){
                       sell[i]=club[i];
                       c=c+benifits[i];
                       w -= weights[i];
                       i--;
                   }else if(d[i][w].equals("Upward")){
                        i--;
                   }
             }
             
             for(i=0; i<=itemCount; i++) {
             if(sell[i]!=null) {
                 System.out.print(sell[i]+"->");
                }
             }
             System.out.println("");
             System.out.println("Maximum money he earned:  "+ c +" Million");

        
        } catch(Exception e){
             System.out.println("Error: " + e);
        }
    }
    
}
