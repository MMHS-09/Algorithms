package knapsack;

import java.io.*;
import java.util.Scanner;


public class Problem_01 {

    public static void main(String[] args) {
        try{
             String address = "C:\\Users\\asus\\Desktop\\knapsack\\Problem_01.txt";
             Scanner sc = new Scanner(new File(address));
             
             //taking first two inputs from text file
             int maxWeight = Integer.parseInt(sc.nextLine());
             int itemCount = Integer.parseInt(sc.nextLine());
             
             //initialize all the variables
             int [] [] v = new int [itemCount+1] [maxWeight+1];
             String [] [] d = new String [itemCount+1] [maxWeight+1];
             int [] weights = new int [itemCount+1];
             int [] benifits = new int [itemCount+1];
             String [] name= new String[itemCount+1];
             String [] position= new String [itemCount+1];
             String [] buy= new String [itemCount+1];
             
             //taking other inputs from text file
             for(int i=1; i<=itemCount; i++){
                 String line = sc.nextLine();
                 String [] temp = line.split(",");
                 name[i]=  temp[0];
                 weights [i] = Integer.parseInt(temp[1]);//sorting weights
                 benifits [i] = Integer.parseInt(temp[2]);//sorting benifits
                 position [i] = temp[3];
                  
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
                             v[i][w] = benifits[i] + v[i-1][w-weights[i]];
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

             System.out.println("Bought Players:");
             int i = itemCount;
             int w = maxWeight;
             int c=0;
             
             //find out the palyers
             while(d[i][w] != null){
                   if(d[i][w].equals("Diagonal")){
                       buy[i]=name[i]; //assign to a new array
                       c=c+benifits[i]; //calculating the benefits
                       w -= weights[i];
                       i--;
                   }else if(d[i][w].equals("Upward")){
                        i--;
                   }
             }
             
             for(i=0; i<=itemCount; i++) {
             if(buy[i]!=null) {
                 System.out.print(buy[i]+"->");
             }
             }
             System.out.println("");
             System.out.println("Maximum summation of form: "+ c);

        
        } catch(Exception e){
             System.out.println("Error: " + e);
        }
    }
    
}
