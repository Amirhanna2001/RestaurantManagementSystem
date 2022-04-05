package plproject;

import java.io.*;
import java.util.*;

public class Employee {
    private static int orID;
    public Employee(){
        //empty constructor
    }
    
    public static int AddCustomer( Integer phone){
        try{
            
        ArrayList <Integer> copy= new ArrayList<>();

        File filepro = new File ("customer.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
          }
           copy.add(phone);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.println(copy.get(i));
    }
         output.close();
         return 1;//file exists

         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
    }
    }
     
     
     public static int DeleteCustomer ( Integer phone  ) {
        ArrayList <Integer> copy= new ArrayList<>();
        
        try{
            
        File filepro = new File ("customer.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
          }    
        copy.remove(phone);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.println(copy.get(i));
         }
         output.close();
         return 1;//file exists
        }
        catch( FileNotFoundException exp){
            return -1;//file not exists

         }
     }

          public static String listCustomer () throws FileNotFoundException
    {
          String list = "Phone number :\n";
        File filepro = new File ("customer.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
              list+=input2.nextInt()+"\n";
        
          return list;
         }
          
          public static String searchCustomer(Integer phone) throws FileNotFoundException{
              ArrayList <Integer> copy= new ArrayList<>();
              File filepro = new File ("customer.txt");
             Scanner input2 =new Scanner(filepro);
               while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
          }
              for (int i = 0; i < copy.size(); i++) {
                  if(copy.get(i).equals(phone)){
                      return "Found";
                  }
              }
              return "Not Fuond";
          }
     
        public static int UpdateCustomer ( Integer oldphone ,Integer newphone) {
        ArrayList <Integer> copy= new ArrayList<>();
        try{
        File filepro = new File ("customer.txt");
        Scanner input2 =new Scanner(filepro);
        while(input2.hasNext())
          {          
            copy.add(input2.nextInt());
          }
        copy.remove(oldphone);
        copy.add(newphone);
         PrintWriter output = new PrintWriter(filepro);
             
         for(int i=0;i<copy.size();i++){
             output.println(copy.get(i));
            }
         output.close();
         return 1;//file exists
         }
        catch( FileNotFoundException exp){
            return -1;//file not exists
          }
          
        }
        public static void order() throws FileNotFoundException {
		File fo = new File("Meals.txt");
		Scanner w = new Scanner(fo);
                File f2 = new File("orders.txt");
		Scanner s = new Scanner(f2);
		Scanner in = new Scanner(System.in);
                ArrayList<Integer > orders = new ArrayList<>();
                while(s.hasNext())
                    orders.add(s.nextInt());
                orders.add(orID++);
                PrintWriter p2 = new PrintWriter(f2);
                for(int i=0;i<orders.size();i++)
                    p2.println(orders.get(i));
                
                s.close();
		int ids[] = new int[10];
		String item[] = new String[10];
		double price[] = new double[10];
		
		int i=0;
		while(w.hasNext()) {
			ids[i]= w.nextInt();
			item[i]=w.next();
			price[i]= w.nextDouble();
			
			System.out.print(ids[i] + " -> " + item[i] + " " + price[i] +  "\n");
			i++;
		}
		w.close();
				
		int q = 1;
		int mealNum;
		double totalPrice=0;
		
		while(q==1) {
		System.out.print("Enter num of meal : ");  mealNum = in.nextInt();
		totalPrice += price[mealNum-1];
		System.out.println("if you wanna buy another meal enter 1 ... enter any num to exit");  q = in.nextInt();
		}
		
		System.out.println("Total price is : "+totalPrice);
		
		
	}
           public static  void cancelOrder(int no) throws IOException ,FileNotFoundException {
		File f = new File("orders.txt");
		Scanner w = new Scanner(f);
		int n[] = new int[10];   // 1- To save line of orders as a string
		
		int i=0;
		int c=0;
		while(w.hasNext()) {
			n[i]= w.nextInt();   // 2- Take the orders from file , to decrease them by 1
			c++;
			i++;
		}
		w.close();
		
		
		PrintWriter p = new PrintWriter(f) ;  // 3- To Put orders into file after decreasing them 1 (Last Order)
		
		for(int k=0; k<c-1; k++) {
                    if(n[k]== no)
                        continue;
                    else
			p.println(n[k]);
		}
		p.close();

	}

}
    