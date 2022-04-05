/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plproject;

import java.io.*;
import java.util.*;

/**
 *
 * @author Amir Hanna
 */
public class Customer {
    public static void MarktingLoyaltyRewardLIST(Integer phone) throws FileNotFoundException{
         
         ArrayList <Integer> copy= new ArrayList<>();
        File filepro = new File ("Loyal.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
          }
           copy.add(phone);
             
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.print(copy.get(i));
                output.print("\n");
         
    }
         output.close();
     }
}
