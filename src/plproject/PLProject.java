package plproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static plproject.Employee.*;
import java.util.Scanner;
import static plproject.Adminstrativ.*;

public class PLProject {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int module;
        System.out.println("Welcome!");
        do {
            System.out.println("Please choose your module\n"
                    + "1.Administrative \n2.Employee \n3.Customer \n4.Exit");
            module = input.nextInt();
            switch (module) {
                case 1:
                    adminModule();
                    break;
                case 2:
                    empModule();
                    break;
                case 3:
                    System.out.println("Enter your mobile to register in loyality and reward program");
                    int no = input.nextInt();
                    Customer.MarktingLoyaltyRewardLIST(no);
                    break;
                case 4:
                    System.out.println("ByeBye!!");
                    break;
                default:
                    System.out.println("Invalid input try again");

            }
        } while (module != 4);
    }

    public static void adminModule() throws FileNotFoundException {
        System.out.println("Enter admin username and password");
        String name, pass;
        name = input.next();
        pass = input.next();
        Adminstrativ admin = new Adminstrativ();
        if (admin.isAdmin(name, pass)) {
            int operation;
            do {
                System.out.println("Choose what you want to do \n"
                        + "1.Manage employee \n2.Manage meals \n3.Make queries "
                        + "\n4.Make special offer \n5.Make loyalty \n6.reward program\n7.Exit");
                operation = input.nextInt();
                switch (operation) {
                    case 1:
                        empManage();
                        break;
                    case 2:
                        mealsManage();
                        break;
                    case 3:
                        System.out.println("Enter id number and the repot");
                        int id = input.nextInt();
                        String report = input.next();
                        queries(id, report);
                        break;
                    case 4:
                        System.out.println("Enter the offer");
                        String off = input.next();
                        offers(off);
                        break;
                    case 5:
                    case 6:
                        System.out.println("Enter the reward or loyality");
                        String s = input.next();
                        loyality(s);
                    default:
                        System.out.println("Check your input");
                }
            } while (operation != 7);

        } else {
            System.out.println("Username or password is wrong if you want to try again enter 1 ");
            int repeat = input.nextInt();
            if (repeat == 1) {
                adminModule();
            } else {
                return;
            }
        }

    }

    public static void empModule() throws FileNotFoundException, IOException {
        Integer operation, phone;
        do {
            System.out.println("1.Add customer \n2.Delete customer \n3.Update Customer \n4.List customer\n"
                    + "5.Search about customer \n6.Make order \n7.Cansel Order \n8.Exit");
            operation = input.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter cusomer phone");
                    phone = input.nextInt();
                    AddCustomer(phone);
                    break;
                case 2:
                    System.out.println("Enter cusomer phone");
                    phone = input.nextInt();
                    DeleteCustomer(phone);
                    break;
                case 3:
                    System.out.println("Enter cusomer old phone and new one");
                    phone = input.nextInt();
                    Integer p = input.nextInt();
                    UpdateCustomer(phone, p);
                    break;
                case 4:
                    System.out.println(listCustomer());
                    break;
                case 5:
                    System.out.println("Enter cusomer phone");
                    phone = input.nextInt();
                    System.out.println(searchCustomer(phone));
                    break;
                case 6:
                    Employee.order();
                    break;
                case 7:
                    System.out.println("Enter order number");
                    int no = input.nextInt();
                    cancelOrder(no);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid input");
            }
        } while (operation != 8);
    }

    public static void empManage() throws FileNotFoundException {
        int operation;
        int id;
        String name;
        do {
            System.out.println("Choose operation \n1.Add employee \n2.Delete employee\n"
                    + "3.Update employee \n4.List all employees \n5.Search about employee\n"
                    + "6.Exit");
            operation = input.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter employee ID and name");
                    id = input.nextInt();
                    name = input.next();
                    AddEmployee(id, name);
                    break;
                case 2:
                    System.out.println("Enter employee id");
                    id = input.nextInt();
                    DeleteEmployee(id);
                    break;
                case 3:
                    System.out.println("Enter old id , new id and new name");
                    int old = input.nextInt();
                    id = input.nextInt();
                    name = input.next();
                    UpdateEmployee(old, id, name);
                    break;
                case 4:
                    System.out.println(listEmployee());
                    break;
                case 5:
                    System.out.println("Enter employee id");
                    id = input.nextInt();
                    System.out.println(searchEmployee(id));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid input try again");
            }
        } while (operation != 6);
    }

    public static void mealsManage() throws FileNotFoundException {
        int operation;
        int id;
        String name;
        double price;
        do {
            System.out.println("Choose operation \n1.Add emeal \n2.Delete meal\n"
                    + "3.Update meal \n4.List all meals \n5.Search about meal\n"
                    + "6.Exit");
            operation = input.nextInt();
            switch (operation) {
                case 1:
                    System.out.println("Enter meal ID , name and price");
                    id = input.nextInt();
                    name = input.next();
                    price = input.nextDouble();
                    Adminstrativ.AddMeal(id, name, price);
                    break;
                case 2:
                    System.out.println("Enter meal id");
                    id = input.nextInt();
                    Adminstrativ.DeleteMeal(id);
                    break;
                case 3:
                    System.out.println("Enter old id , new id , name and price");
                    int old = input.nextInt();
                    id = input.nextInt();
                    name = input.next();
                    price = input.nextDouble();
                    Adminstrativ.UpdateMeal(old, id, name, price);
                    break;
                case 4:
                    System.out.println(Adminstrativ.listMeals());
                    break;
                case 5:
                    System.out.println("Enter meal id");
                    id = input.nextInt();
                    System.out.println(Adminstrativ.searchMeal(id));
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid input try again");
            }
        } while (operation != 6);

    }

    public static void queries(int id, String report) throws FileNotFoundException {
        File file = new File("report.txt");
        PrintWriter p = new PrintWriter(file);
        p.println("Id num is : " + id + "\nReport is : \n " + report);
        p.close();
    }
}
