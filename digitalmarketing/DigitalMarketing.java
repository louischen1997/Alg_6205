
package digitalmarketing;


import com.github.javafaker.Faker;
import digitalmarketing.Business.Business;
import digitalmarketing.CustomerManagement.CustomerDirectory;
import digitalmarketing.CustomerManagement.CustomerProfile;
import digitalmarketing.OrderManagement.MasterOrderList;
import digitalmarketing.OrderManagement.Order;
import digitalmarketing.Personnel.Person;
import digitalmarketing.ProductManagement.Product;
import digitalmarketing.ProductManagement.ProductCatalog;
import digitalmarketing.ProductManagement.ProductSummary;
import digitalmarketing.ProductManagement.ProductsReport;
import digitalmarketing.Supplier.Supplier;
import digitalmarketing.Supplier.SupplierDirectory;
import digitalmarketing.MarketModel.Market;
import digitalmarketing.MarketModel.Channel;
import digitalmarketing.MarketModel.MarketChannelAssignment;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DigitalMarketing {
    static ArrayList<String> answers=new ArrayList();
    static ArrayList<String> answer2=new ArrayList();
    static ArrayList<String> answer3=new ArrayList();

    static double channelRev;
  
    public static void main(String[] args) {
        
        Business total = new Business("total");
        DataLoader dataLoader = new DataLoader();
        
        dataLoader.populateBusiness(total);
        
        Market education=new Market("Education",1);
        Market lowrev=new Market("Lowrev",4);
        Market general=new Market("General",2);
        Market highrev=new Market("Highrev",3);
    
        
       Supplier firstSupplier = total.getSupplierDirectory().findSupplierByIndex(0);
       Supplier secondSupplier = total.getSupplierDirectory().findSupplierByIndex(1);
       Supplier thirdSupplier = total.getSupplierDirectory().findSupplierByIndex(2);
      
       
       
       System.out.println("Please enter your name ");
       Scanner cName = new Scanner(System.in); 
       String  customerName= cName.next();
       
       
       dataLoader.populateCustomerDirectory(total.getCustomerDirectory(), 1, customerName);
       
       
       dataLoader.populateCustomerDirectory(total.getCustomerDirectory(), 1, "Louis");
       dataLoader.populateCustomerDirectory(total.getCustomerDirectory(), 1, "Julia");
       
       
       
       CustomerDirectory cd = total.getCustomerDirectory();
       CustomerProfile firstCustomer=cd.findCustomerByIndex(0);
       
       
       System.out.println("Select your job with number below ");
       System.out.println("1.Student 2.Doctor/Lawyer 3.Entrepreneur 4.Other ");
       Scanner cJ = new Scanner(System.in); 
       String  customerJob= cJ.next();
       firstCustomer.setRange(customerJob);
       
       
       if (customerJob.equals("4")){
       System.out.println("Please select your salary range per month with number ");
       System.out.println("1.below 3000 2.between 3000 to 10000 3.above 10000 ");
       Scanner cR = new Scanner(System.in); 
       String  salaryRange= cR.next();
       if(salaryRange.equals("1")){
       firstCustomer.setRange("4");
       }
       else if(salaryRange.equals("2")){
       firstCustomer.setRange("2");
       }
       else if(salaryRange.equals("3")){
       firstCustomer.setRange("3");
       }
       }
       
       //cd.printCustomerNames();
       
       ProductCatalog  electronic = firstSupplier.getProductcatalog();
       ProductCatalog  furniture= secondSupplier.getProductcatalog();
       ProductCatalog  grocery= thirdSupplier.getProductcatalog();
   
        electronic.newProduct(500, 1000, 1000, "macbook","electronic");
        electronic.newProduct(500, 1000, 2000, "mac","electronic");
        electronic.newProduct(500, 1000, 800, "iphone13","electronic");
        electronic.newProduct(500, 1000, 900, "ipad","electronic");
        electronic.newProduct(500, 1000, 100, "airtag","electronic");
        electronic.newProduct(500, 1000, 200, "powerbank","electronic");
        electronic.newProduct(500, 1000, 500, "airpods","electronic");
        electronic.newProduct(500, 1000, 700, "applewatch","electronic");
        
        furniture.newProduct(6, 12, 1000, "bed","furniture");
        furniture.newProduct(6, 12, 1500, "closet","furniture");
        furniture.newProduct(6, 12, 500, "table","furniture");
        furniture.newProduct(6, 12, 300, "chair","furniture");
        furniture.newProduct(6, 12, 100, "lamp","furniture");
        furniture.newProduct(6, 12, 1200, "sofa","furniture");
        furniture.newProduct(6, 12, 200, "cabinet","furniture");
        furniture.newProduct(6, 12, 50, "carpet","furniture");
        
        grocery.newProduct(6, 12, 20, "beef","grocery");
        grocery.newProduct(6, 12, 10, "pork","grocery");
        grocery.newProduct(6, 12, 10, "chicken","grocery");
        grocery.newProduct(6, 12, 10, "lamb","grocery");
        grocery.newProduct(6, 12, 20, "seafood","grocery");
        grocery.newProduct(6, 12, 12, "fruit","grocery");
        grocery.newProduct(6, 12, 8, "vegetable","grocery");
        grocery.newProduct(6, 12, 8, "beverage","grocery");
        
       System.out.println("choose product category ");
       System.out.println("1.electronic devices 2.furniture 3.gorcery ");
       Scanner cC = new Scanner(System.in); 
       String  category= cC.next();
       System.out.println(" ");
       if(category.equals("1")){
       electronic.printDetails();
       System.out.println(" ");
       System.out.println("pick a channel with number");
       System.out.println("electronic devices: 1.Amazon 2.Walmart 3.Apple");
       }
       if(category.equals("2")){
       furniture.printDetails();
       System.out.println(" ");
       System.out.println("pick a channel with number");
       System.out.println("furniture: 4.Amazon 5.Ikea 6.Target");
       }
       if(category.equals("3")){
       grocery.printDetails();
       System.out.println(" ");
       System.out.println("pick a channel with number");
       System.out.println("Grocery: 7.Amazon 8.Wee 9.Walmart");
       }
        
       Scanner select = new Scanner(System.in); 
       String  answer= select.next();
       if(answer.equals("1") ||answer.equals("4") || answer.equals("7") ){
       System.out.println("Thanks for choosing Amazon");  
       System.out.println("*******************************************************");
       System.out.println("*You get 15% discount if you buy three(or over) items!*");
       System.out.println("*******************************************************");
       }
       else if(answer.equals("2")||answer.equals("9") ){
       System.out.println("Thanks for choosing Walmart");
       System.out.println("******************************************************");
       System.out.println("*You get 25% discount if you buy five(or over) items!*");
       System.out.println("******************************************************");
       
       }
       else if(answer.equals("3")){
       System.out.println("Thanks for choosing Apple");
       System.out.println("**************************");
       System.out.println("*You get product warranty*");
       System.out.println("**************************");
       
       }
       else if(answer.equals("5")){
       System.out.println("Thanks for choosing Ikea");  
       System.out.println("**************************");
       System.out.println("*You get product warranty*");
       System.out.println("**************************");
       
       }
       else if(answer.equals("6")){
       System.out.println("Thanks for choosing Target");
       System.out.println("*****************************************************");
       System.out.println("*You get 10% discount if you buy two(or over) items!*");
       System.out.println("*****************************************************");
       
       }
       
       else if(answer.equals("8")){
       System.out.println("Thanks for choosing Wee"); 
       System.out.println("*******************************************************");
       System.out.println("*You get 20% discount if you buy three(or over) items!*");
       System.out.println("*******************************************************");
       
       }
      
       purchase();
       
       System.out.println("----------------------------"); 
       System.out.println("This is your shopping list");
       for(String s:answers){ 
       System.out.println(s);
       }
       System.out.println("------------------------");
       
       
       if (firstCustomer.getRange().equals("1")){
       System.out.println("You get student special discount!");
       double totalPrice=0;
       for(String s:answers){
       double x=education.searchProduct(electronic.search(s),answers.size(),answer);
       double y=education.searchProduct(furniture.search(s),answers.size(),answer);
       double z=education.searchProduct(grocery.search(s),answers.size(),answer);
       totalPrice+=x;
       totalPrice+=y;
       totalPrice+=z;
       }
       System.out.println(" "); 
       System.out.println("This is the total price:"); 
       System.out.println(totalPrice);
       
       education.passTotal(totalPrice,answer);
       
       
       System.out.println("Do you want the purchase?");
       Scanner yesno = new Scanner(System.in); 
       String  yesorno= yesno.next();
       if (yesorno.equals("yes")){
           
           
       Order finalOrder=new Order(firstCustomer);
       finalOrder.newPackage();
       for( String s:answers){
       finalOrder.setNewPack(s, education.getChannel(answer).getSurvice(), firstCustomer.getName(), education.getChannel(answer).getFinalPrice());
       }
       finalOrder.printOrderDetails();
       
       
       
       education.setRev(totalPrice);
       
       education.getChannel(answer).setRev(education.getChannel(answer).getFinalPrice());
       
       
       }
       else{
       System.out.println("See you next time :)");
       }
       
       
       }
       else if(firstCustomer.getRange().equals("2")){
       System.out.println("You get discount!");
       double totalPrice=0;
       for(String s:answers){
       double x=general.searchProduct(electronic.search(s),answers.size(),answer);
       double y=general.searchProduct(furniture.search(s),answers.size(),answer);
       double z=general.searchProduct(grocery.search(s),answers.size(),answer);
       totalPrice+=x;
       totalPrice+=y;
       totalPrice+=z;
       }
       System.out.println(" "); 
       System.out.println("This is the total price:"); 
       System.out.println(totalPrice);
       general.passTotal(totalPrice,answer);
       System.out.println("Do you want the purchase?");
       Scanner yesno = new Scanner(System.in); 
       String  yesorno= yesno.next();
       if (yesorno.equals("yes")){
       Order finalOrder=new Order(firstCustomer);
       finalOrder.newPackage();
       for( String s:answers){
       finalOrder.setNewPack(s, general.getChannel(answer).getSurvice(), firstCustomer.getName(), general.getChannel(answer).getFinalPrice());
       }
       finalOrder.printOrderDetails();
       general.setRev(totalPrice);
       
       general.getChannel(answer).setRev(general.getChannel(answer).getFinalPrice());
       
       
       
       }
       else{
       System.out.println("See you next time :)");
       }

       }
       
       else if(firstCustomer.getRange().equals("3")){
       System.out.println("You get discount!");
       double totalPrice=0;
       for(String s:answers){
       double x=highrev.searchProduct(electronic.search(s),answers.size(),answer);
       double y=highrev.searchProduct(furniture.search(s),answers.size(),answer);
       double z=highrev.searchProduct(grocery.search(s),answers.size(),answer);
       totalPrice+=x;
       totalPrice+=y;
       totalPrice+=z;
       }
       System.out.println(" "); 
       System.out.println("This is the total price:"); 
       System.out.println(totalPrice);
       highrev.passTotal(totalPrice,answer);
       System.out.println("Do you want the purchase?");
       Scanner yesno = new Scanner(System.in); 
       String  yesorno= yesno.next();
       if (yesorno.equals("yes")){
       Order finalOrder=new Order(firstCustomer);
       finalOrder.newPackage();
       for( String s:answers){
       finalOrder.setNewPack(s, highrev.getChannel(answer).getSurvice(), firstCustomer.getName(), highrev.getChannel(answer).getFinalPrice());
       }
       finalOrder.printOrderDetails();
       highrev.setRev(totalPrice);
       highrev.getChannel(answer).setRev(highrev.getChannel(answer).getFinalPrice());
       
       
       
       }
       else{
       System.out.println("See you next time :)");
       }

       }
       else{
       System.out.println("You get discount!");  
       double totalPrice=0;
       for(String s:answers){
       double x=lowrev.searchProduct(electronic.search(s),answers.size(),answer);
       double y=lowrev.searchProduct(furniture.search(s),answers.size(),answer);
       double z=lowrev.searchProduct(grocery.search(s),answers.size(),answer);
       totalPrice+=x;
       totalPrice+=y;
       totalPrice+=z;
       }
       System.out.println(" "); 
       System.out.println("This is the total price:"); 
       System.out.println(totalPrice);
       lowrev.passTotal(totalPrice,answer);
       System.out.println("Do you want the purchase?");
       Scanner yesno = new Scanner(System.in); 
       String  yesorno= yesno.next();
       if (yesorno.equals("yes")){
       Order finalOrder=new Order(firstCustomer);
       finalOrder.newPackage();
       for( String s:answers){
       finalOrder.setNewPack(s, lowrev.getChannel(answer).getSurvice(), firstCustomer.getName(), lowrev.getChannel(answer).getFinalPrice());
       }
       finalOrder.printOrderDetails();
       lowrev.setRev(totalPrice);
       
       lowrev.getChannel(answer).setRev(lowrev.getChannel(answer).getFinalPrice());
       
       
       
       }
       else{
       System.out.println("See you next time :)");
       }

       }
       
       
       
       
       ///////////set other order
       CustomerProfile secondCustomer=cd.findCustomerByIndex(1);
       secondCustomer.setRange("1");
       System.out.println("#Second customer: "+secondCustomer.getName());
       education.passTotal(1000,"3");
       Order secondOrder=new Order(secondCustomer);
       secondOrder.newPackage();
       answer2.add("mac");
       answer2.add("macbook");
       for( String s:answer2){
       secondOrder.setNewPack(s, education.getChannel("3").getSurvice(), secondCustomer.getName(), education.getChannel("3").getFinalPrice());
       }
       secondOrder.printOrderDetails();
       
       education.setRev(1000);
       education.getChannel("3").setRev(education.getChannel("3").getFinalPrice());
       
       ///////////////////////////////////
       
       CustomerProfile thirdCustomer=cd.findCustomerByIndex(2);
       thirdCustomer.setRange("3");
       System.out.println("#Third customer: "+thirdCustomer.getName());
       highrev.passTotal(2000,"5");
       Order thirdOrder=new Order(thirdCustomer);
       thirdOrder.newPackage();
       answer3.add("sofa");
       answer3.add("table");
       answer3.add("chair");
       for( String s:answer3){
       thirdOrder.setNewPack(s, highrev.getChannel("5").getSurvice(), thirdCustomer.getName(), highrev.getChannel("5").getFinalPrice());
       }
       thirdOrder.printOrderDetails();
       
       highrev.setRev(2000);
       highrev.getChannel("5").setRev(highrev.getChannel("5").getFinalPrice());
       
  

       
       for (int i=1;i<10;i++){
       double x=education.getChannel(String.valueOf(i)).getRev();
       double y=general.getChannel(String.valueOf(i)).getRev();
       double z=highrev.getChannel(String.valueOf(i)).getRev();
       double k=lowrev.getChannel(String.valueOf(i)).getRev();
       System.out.println("Channel: "+education.getChannel(String.valueOf(i)).getName());
       
       channelRev=x+y+z+k;
       System.out.println(channelRev);
       }

        
    }
    
    static public void purchase(){
    System.out.println("Enter the product you want to buy ");    
    Scanner ans1 = new Scanner(System.in); 
    String  answer1= ans1.next();
    answers.add(answer1);
    System.out.println("Enter <end> to end selecting, enter any button to keep buying");
    Scanner ans2 = new Scanner(System.in); 
    String  answer2= ans2.next();
    if (answer2.equals("end")){
    System.out.println("End to select items ");
    }
    else{
    purchase();
    }
    }
    
}
