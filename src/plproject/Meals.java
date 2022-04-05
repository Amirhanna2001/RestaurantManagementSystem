package plproject;

import java.io.*;
import java.util.*;

public class Meals {
    public static int AddMeal(Integer mealNumber,String name ,double price){
        try{
            
        ArrayList <Double> pr = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList <Integer> numOfMeals = new ArrayList<>();
        File filepro = new File ("Meals.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            numOfMeals.add(input2.nextInt());
            names.add(input2.next());
            pr.add(input2.nextDouble());
          }
          pr.add(price);
          names.add(name);
          numOfMeals.add(mealNumber);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<pr.size();i++){
             output.print(numOfMeals.get(i)+" ");
             output.print(names.get(i)+" ");
             output.println(pr.get(i));
         }
         output.close();
         return 1;//file exists

         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
        }
    }
     
     
     public static int DeleteMeal ( Integer mealNumber  ) {
        try{
            
        ArrayList <Double> pr = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList <Integer> numOfMeals = new ArrayList<>();
        File filepro = new File ("Meals.txt");
        Scanner input2 =new Scanner(filepro);
        int number = 1;
        while(input2.hasNext())
          {          
            numOfMeals.add(input2.nextInt());
            names.add(input2.next());
            pr.add(input2.nextDouble());
            number++;
          }
            for (int i = 0; i < numOfMeals.size(); i++) {
                if(numOfMeals.get(i).equals(mealNumber)){
                    numOfMeals.remove(numOfMeals.get(i));
                    names.remove(names.get(i));
                    pr.remove(pr.get(i));
                }
                
            }
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<pr.size();i++){
             output.print(numOfMeals.get(i)+" ");
             output.print(names.get(i)+" ");
             output.println(pr.get(i));
         }
         output.close();
         return 1;//file exists

         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
        }
     }

    public static String listMeals () throws FileNotFoundException{
        String list = "Meal Info\nnumber :\tName: \tPrice: \n";
        File filepro = new File ("Meals.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext()){
            list+=input2.nextInt()+"\t\t"+input2.next()+"\t\t"+input2.nextDouble()+"\n";
        }
          return list;
         }
          
          public static String searchMeal(Integer mealNumber) throws FileNotFoundException{
              ArrayList <Double> pr = new ArrayList<>();
              ArrayList<String> names = new ArrayList<>();
              ArrayList <Integer> numOfMeals = new ArrayList<>();
              File filepro = new File ("MEals.txt");
             Scanner input2 =new Scanner(filepro);
             while(input2.hasNext()){          
                  numOfMeals.add(input2.nextInt());
                  names.add(input2.next());
                  pr.add(input2.nextDouble());
             }
              for (int i = 0; i < pr.size(); i++) {
                  if(numOfMeals.get(i).equals(mealNumber)){
                      return "Found"+"\nNumber : "+mealNumber+"\tName : "+names.get(i)
                              +"\tPrice : "+pr.get(i);
                  }
              }
              return "Not Fuond";
          }
     
        public static int UpdateMeal ( Integer oldNumber ,Integer nNumber,String nName,Double nPrice) {
        ArrayList <Double> pr = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList <Integer> numOfMeals = new ArrayList<>();
        try{
        File filepro = new File ("Meals.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            numOfMeals.add(input2.nextInt());
            names.add(input2.next());
            pr.add(input2.nextDouble());
          }
            for (int i = 0; i < numOfMeals.size(); i++) {
                if(numOfMeals.get(i).equals(oldNumber)){
                    numOfMeals.remove(oldNumber);
                    pr.remove(pr.get(i));
                    names.remove(names.get(i));
                    break;
                }
            }
            numOfMeals.add(nNumber);
            pr.add(nPrice);
            names.add(nName);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<numOfMeals.size();i++){
             output.print(numOfMeals.get(i)+" ");
             output.print(names.get(i)+" ");
             output.println(pr.get(i));
            }
         output.close();
         return 1;//file exists
         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
          }
        }
}

