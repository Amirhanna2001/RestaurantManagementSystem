package plproject;

import java.io.*;
import java.util.*;

public class Adminstrativ {
    private String adminName;
    private String adminPass;//pass may contains letters or special chars

	//Attributes
	//Constructor to take Admins info from file
	Adminstrativ() throws FileNotFoundException {
		File f1 = new File("Admins.txt");
		Scanner s1 = new Scanner( f1);
		while(s1.hasNext()) {
                    adminName = s1.next() ;
	            adminPass = s1.next();
		}
		s1.close();
	}
	
	//-------------------Methods--------------------------------
	// (a) to check 
	public boolean isAdmin(String n,String p) {
		return n.equals(adminName) && p.equals(adminPass);
	}
	
    public static int offers(String off){
        try{
            ArrayList <String> arrString  = new ArrayList<>();
            File file = new File("offers.txt");
            Scanner s = new Scanner(file);
            
            while(s.hasNext()){ //to copy all file items in
                arrString.add(s.nextLine()); // add at end
   
            }
            s.close();
                
            arrString.add(off);
            PrintWriter p = new PrintWriter(file);
            
            int size = arrString.size();
            for(int i=0; i < size ; i++){
                p.println(arrString.get(i));
            }
            p.close();
            return 1;//file exist
        }
        catch(FileNotFoundException exp){
            return -1;//file not exist
        }
    }
	

    void cancelOrder() throws IOException ,FileNotFoundException {
		File f = new File("orders.txt");
		Scanner w = new Scanner(f);
		String n[] = new String[10];   // 1- To save line of orders as a string
		
		int i=0;
		int c=0;
		while(w.hasNext()) {
			n[i]= w.nextLine().toString();   // 2- Take the orders from file , to decrease them by 1
			c++;
			i++;
		}
		w.close();
		
		
		PrintWriter p = new PrintWriter(f) ;  // 3- To Put orders into file after decreasing them 1 (Last Order)
		
		for(int k=0; k<c-1; k++) {
			p.println(n[k]);
		}
		p.close();

	}
       public static int AddEmployee ( Integer ID , String name){
        try{
            
        ArrayList <Integer> copy= new ArrayList<>();
        ArrayList <String> copy2= new ArrayList<>();

        File filepro = new File ("Emp.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
            copy2.add(input2.nextLine());
          }
           copy.add(ID);
           copy2.add(name);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.print(copy.get(i)+" ");
             output.println(copy2.get(i));
    }
         output.close();
         return 1;//file exists

         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
    }
    }
     
     
     public static int DeleteEmployee ( Integer ID  ) {
        ArrayList <Integer> copy= new ArrayList<>();
        ArrayList <String> copy2= new ArrayList<>();
        
        try{
            
        File filepro = new File ("Emp.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
            copy2.add(input2.next());
          }    
        for(int i=0;i<copy.size();i++){
            if(Objects.equals(copy.get(i), ID)){
                copy.remove(copy.get(i));                     
                copy2.remove(copy2.get(i));
                }
        }
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.print(copy.get(i)+" ");
             output.println(copy2.get(i));
         }
         output.close();
         return 1;//file exists
        }
        catch( FileNotFoundException exp){
            return -1;//file not exists

         }
     }

          public static String listEmployee () throws FileNotFoundException
    {
          String list = "Id \t Name\n";
        File filepro = new File ("Emp.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
              list+=input2.nextInt()+"\t "+input2.next()+" \n";
        
          return list;
         }
          
          public static String searchEmployee(Integer ID) throws FileNotFoundException{
              String item;
              ArrayList <Integer> copy= new ArrayList<>();
              ArrayList <String> copy2= new ArrayList<>();
              File filepro = new File ("Emp.txt");
             Scanner input2 =new Scanner(filepro);
               while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
            copy2.add(input2.nextLine());
          }
              for (int i = 0; i < copy.size(); i++) {
                  if(copy.get(i).equals(ID)){
                      item = "Founded\nName: "+copy2.get(i)+"\nId : "+copy.get(i);
                      return item;
                  }
              }
              return "Not Fuond";
          }
     
        public static int UpdateEmployee ( Integer oldID ,Integer newID ,  String newname) {
        ArrayList <Integer> copy= new ArrayList<>();
        ArrayList <String> copy2= new ArrayList<>();
        try{
        File filepro = new File ("Emp.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
            copy2.add(input2.nextLine());
          }
        for (int i = 0; i < copy.size(); i++) {
            if((copy.get(i)).equals(oldID)){
                copy.remove(copy.get(i));
                copy2.remove(copy2.get(i)) ;
                  }
              }
            copy.add(newID);
            copy2.add(newname);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.print(copy.get(i)+" ");
             output.println(copy2.get(i));
            }
         output.close();
         return 1;//file exists
         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
          }
          
}
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
        public static void loyality(String loy) throws FileNotFoundException{
         
         ArrayList <String> copy= new ArrayList<>();
        File filepro = new File ("loyalityAd.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.next());
          }
           copy.add(loy);
             
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.print(copy.get(i));
                output.print("\n");
         
    }
         output.close();
     }
}
